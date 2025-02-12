package sample;


import PlayerProperties.player;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import util.ListOfPlayer;
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    private Main main;
    private Stage stage=new Stage();
    private NetworkUtil networkUtil;
    private  List<player>PlayerList=new ArrayList<>();
    private List<player>sellPlayerList=new ArrayList<>();
    public boolean isImp=false;
    public boolean isMyPlayerOpen=false;
    private MyPlayerController myPlayerController=null;

    public Stage getStage() {
        return stage;
    }

    public NetworkUtil getNetworkUtil() {
        return networkUtil;
    }

    public List<player> getPlayerList() { return PlayerList;}
    public void setPlayerList(List<player> playerList) {
        PlayerList = playerList;
    }

    public List<player>getSellPlayerList() { return sellPlayerList; }
    public void setSellPlayerList(List<player>list){ this.sellPlayerList=list; }


    @Override
    public void start(Stage primaryStage) throws Exception{
        //stage = primaryStage;
        connectToServer();
        showLoginPage();
    }

    private void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 33333;
        networkUtil = new NetworkUtil(serverAddress, serverPort);
        new ReadThread(this);
    }

    public void showLoginPage() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLs/login.fxml"));
        Parent root = loader.load();

        LoginController controller = loader.getController();
        controller.setMain(this);

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credentials");
        alert.setHeaderText("Incorrect Credentials");
        alert.setContentText("The username or password you provided is incorrect.");
        alert.showAndWait();
    }

    public void showMenuPage(String clubName) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLs/menu.fxml"));
        Parent root = loader.load();

        MenuController controller = loader.getController();
        controller.setMain(this);
        controller.init(clubName);

        stage.setScene(new Scene(root));
        isMyPlayerOpen=false;
        stage.show();
    }

    public void showMyPlayerPage() throws Exception {
        PlayerList = null;
        networkUtil.write("player_list");
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLs/MyPlayer.fxml"));
        Parent root = loader.load();

        if(PlayerList.size()!=0){
        Platform.runLater(()-> {
            myPlayerController = loader.getController();
            myPlayerController.setMain(this);
            myPlayerController.init(PlayerList);


            stage.setScene(new Scene(root));
            isMyPlayerOpen = true;
            stage.show();
        });
        }
    }

    public void sellPlayer(player p)
    {
        try {
            networkUtil.write(p);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showSearchPlayerPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLs/searchPlayer.fxml"));
        Parent root = loader.load();

        searchPlayerController controller=loader.getController();
        controller.init(PlayerList);
        controller.setMain(this);

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showSearchClubPage() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLs/searchClub.fxml"));
        Parent root = loader.load();

        SearchClubController controller = loader.getController();
        controller.init(PlayerList);
        controller.setMain(this);

        stage.setScene(new Scene(root));
        stage.show();
    }

    public void showBuyPlayerPage(String clubname) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXMLs/BuyPlayers.fxml"));
        Parent root = loader.load();

        BuyPlayerController controller = loader.getController();
        controller.setMain(this);

        Stage buyStage=new Stage();
        controller.init(sellPlayerList, buyStage,clubname);

        buyStage.setScene(new Scene(root));
        buyStage.show();
    }

    synchronized public void BuyPlayer(player P, AnchorPane pane,BuyPlayerController controller,Stage stage)
    {
        try {
            networkUtil.write(P);
            PlayerList = null;
            sellPlayerList=null;
            isImp=true;
            networkUtil.write("player_list");
            networkUtil.write("BuyPlayerList");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(true){
            if(PlayerList!=null && sellPlayerList!=null){
                if(PlayerList.size()!=0 && sellPlayerList.size()!=0){
                    isImp=false;
                    for(int i=0;i<sellPlayerList.size();i++){
                        if(sellPlayerList.get(i).getName().equalsIgnoreCase(P.getName())) {
                            sellPlayerList.remove(i);
                        }
                    }
                    P.setClub(PlayerList.get(0).getClub());
                    PlayerList.add(P);

                    pane.getChildren().clear();

                    controller.setSellPlayerList(sellPlayerList);
                    controller.show();

                    if(isMyPlayerOpen && stage.isShowing() && myPlayerController!=null){
                        myPlayerController.setPlayerList(PlayerList);
                        myPlayerController.Add(P);
                    }
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}

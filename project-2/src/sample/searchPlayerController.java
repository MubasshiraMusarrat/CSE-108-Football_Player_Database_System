package sample;

import PlayerProperties.player;
import PlayerProperties.searchPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import sample.Main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class searchPlayerController {

    private Main main;
    public void setMain(Main main) {
        this.main = main;
    }
    private List<player>playerList=new ArrayList<>();
    private PlayerProperties.searchPlayer SP=new searchPlayer();

    @FXML
    private Button BackButton;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    @FXML
    private Button reset;

    @FXML
    private TextField searchText;

    @FXML
    private Button searchPlayer;

    @FXML
    private Button searchClub;

    @FXML
    private Button searchPosition;

    @FXML
    private Button searchSalary;

    @FXML
    private Button playerCount;

    @FXML
    private Label countShow;

    public void init(List<player>playerList)
    {
        this.playerList = ImageAccord.accord(playerList);
    }
    @FXML
    void BackButtonPressed(ActionEvent event) {
        try {
            main.showMenuPage(playerList.get(0).getClub());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void resetPressed(ActionEvent event) {
            searchText.setText(null);
            countShow.setText(null);
    }

    @FXML
    void searchClubPressed(ActionEvent event) {
        String s=searchText.getText();
        String[] tokens = s.split(",");
        List<player>localList=new ArrayList<>();
        for(int i=0;i< tokens.length;i++)
        {
            try {
                List<player>localList2=SP.searchByClubAndCountry(playerList,tokens[i]);
                if(localList2.size()==0)
                    showAlert();
                else
                    localList.addAll(localList2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        show(localList);
    }

    @FXML
    void searchPlayerPressed(ActionEvent event) {
        String s=searchText.getText();
        String[] tokens = s.split(",");
        List<player>localList=new ArrayList<>();
        for(int i=0;i< tokens.length;i++)
        {
            try {
               player P=SP.searchByName(playerList,tokens[i]);
               if(P==null)
                   showAlert();
               else
               localList.add(P);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        show(localList);
    }

    @FXML
    void searchPositionPressed(ActionEvent event) {
        String s=searchText.getText();
        String[] tokens = s.split(",");
        List<player>localList=new ArrayList<>();
        for(int i=0;i< tokens.length;i++)
        {
            try {
                List<player>localList2=SP.searchByPosition(playerList,tokens[i]);
                if(localList2.size()==0)
                    showAlert();
                else
                    localList.addAll(localList2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        show(localList);
    }

    @FXML
    void searchSalaryPressed(ActionEvent event) {
        String s=searchText.getText();
        String[] tokens = s.split("-");
        double lowerRange, upperRange;
        lowerRange=Double.parseDouble(tokens[0]);
        upperRange=Double.parseDouble(tokens[1]);
        List<player>localList=new ArrayList<>();
            try {
                localList=SP.searchBySalary(playerList,lowerRange, upperRange);
                if(localList.size()==0)
                    showAlert();
            } catch (Exception e) {
                e.printStackTrace();
            }
        show(localList);
    }

    @FXML
    void playerCountPressed(ActionEvent event) {
        String s=searchText.getText();
        int Count=0;
            try {
                Count=SP.Count(playerList,s);
                if(Count==0)
                    countShow.setText("0");
                else
                    countShow.setText(String.valueOf(Count));
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    private void show(List<player> localplayerList) {
        grid.getChildren().clear();
        int column=0;
        int row=1;
        try {
            for (int i = 0; i < localplayerList.size(); i++) {

                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/FXMLs/PlayerDetail.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                PlayerDetailController PDC = fxmlLoader.getController();
                PDC.setData(localplayerList.get(i));
                if(column==2) {
                    column=0;
                    row++;
                }
                grid.add(anchorPane,column++,row);
                GridPane.setMargin(anchorPane, new Insets(10));
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showAlert()
    {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Input");
        alert.setHeaderText("Void search.");
        alert.setContentText("No player with this search was found.");
        alert.showAndWait();
    }

}


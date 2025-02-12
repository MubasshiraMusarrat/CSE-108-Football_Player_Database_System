package sample;

import PlayerProperties.player;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BuyPlayerController {

    private Main main;
    public void setMain(Main main) {
        this.main = main;
    }

    private List<player> sellPlayerList = new ArrayList<>();
    private String Club;
    private Stage buyStage;

    @FXML
    private GridPane grid;

    @FXML
    private ImageView clubImage;

    public void setSellPlayerList(List<player> sellPlayerList) {
        this.sellPlayerList = sellPlayerList;
    }

    public void init(List<player> playerList, Stage stage, String club) {
        this.sellPlayerList = ImageAccord.accord(playerList);
        this.buyStage = stage;
        this.Club=club;
        show();
    }

    public void show() {
        if(Club.equalsIgnoreCase("Manchester United")){
            Image image=new Image(getClass().getResourceAsStream("/Images/MU.jpg"));
            clubImage.setImage(image);}
        else if(Club.equalsIgnoreCase("Manchester City")){
            Image image=new Image(getClass().getResourceAsStream("/Images/man city.png"));
            clubImage.setImage(image);}
        else if(Club.equalsIgnoreCase("Chelsea")){
            Image image=new Image(getClass().getResourceAsStream("/Images/chelsea.jpg"));
            clubImage.setImage(image);}
        else if(Club.equalsIgnoreCase("Arsenal")){
            Image image=new Image(getClass().getResourceAsStream("/Images/arsenal.jpg"));
            clubImage.setImage(image);}
        else if(Club.equalsIgnoreCase("Liverpool")){
            Image image=new Image(getClass().getResourceAsStream("/Images/liverpool.png"));
            clubImage.setImage(image);}

        grid.getChildren().clear();
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < sellPlayerList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/FXMLs/PlayerShow.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                PlayerShowController PDC = fxmlLoader.getController();
                PDC.setMain(main);
                PDC.setStage(buyStage);
                PDC.setController(this);
                PDC.setData(sellPlayerList.get(i));
                grid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


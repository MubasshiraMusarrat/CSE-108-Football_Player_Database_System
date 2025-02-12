package sample;



import PlayerProperties.player;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import sample.Main;
import util.NetworkUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MyPlayerController {

    private Main main;
    public void setMain(Main main) {
        this.main = main;
    }
    boolean showButton=false;
    int Column,Row;

    private List<player> playerList = new ArrayList<>();

    public void setPlayerList(List<player> playerList) {
        this.playerList = playerList;
    }

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

    @FXML
    private Button BackButton;

    @FXML
    private RadioButton sell;


    @FXML
    void sellPressed(ActionEvent event) {
        showButton=!showButton;
        show();
    }


    @FXML
    void BackButtonPressed(ActionEvent event) {
        try {
            main.isMyPlayerOpen=false;
            main.showMenuPage(playerList.get(0).getClub());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void init(List<player> playerList) {
        this.playerList = ImageAccord.accord(playerList);
        show();
    }

    public void show() {
        grid.getChildren().clear();
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < playerList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/FXMLs/PlayerDetail.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                PlayerDetailController PDC = fxmlLoader.getController();
                PDC.setMain(main,showButton);
                PDC.setData(playerList.get(i));
                if (column == 3) {
                    column = 0;
                    row++;
                }
                grid.add(anchorPane, column++, row);
                GridPane.setMargin(anchorPane, new Insets(10));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        Column=column;
        Row=row;
    }
    
    public void Add(player Added)
    {
        try {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/FXMLs/PlayerDetail.fxml"));
        AnchorPane anchorPane = fxmlLoader.load();

        PlayerDetailController PDC = fxmlLoader.getController();
        PDC.setMain(main,showButton);
        PDC.setData(Added);
        if (Column == 3) {
            Column = 0;
            Row++;
        }
        grid.add(anchorPane, Column++, Row);
        GridPane.setMargin(anchorPane, new Insets(10));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
package sample;

import PlayerProperties.SearchClub;
import PlayerProperties.player;
import PlayerProperties.searchPlayer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchClubController {
    private Main main;
    public void setMain(Main main) {
        this.main = main;
    }
    private List<player> playerList=new ArrayList<>();
    private PlayerProperties.SearchClub SC =new SearchClub();

    @FXML
    private Button BackButton;

    @FXML
    private Button maxSalary;

    @FXML
    private Button maxAge;

    @FXML
    private Button maxHeight;

    @FXML
    private Button total;

    @FXML
    private Label salaryShow;

    @FXML
    private ScrollPane scroll;

    @FXML
    private GridPane grid;

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
    void maxAgePressed(ActionEvent event) {
        List<player>localList=new ArrayList<>();
        try {
            localList=SC.maxAge(playerList);
            show(localList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void maxHeightPressed(ActionEvent event) {
        List<player>localList=new ArrayList<>();
        try {
            localList=SC.maxHeight(playerList);
            show(localList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void maxSalaryPressed(ActionEvent event) {
        List<player>localList=new ArrayList<>();
        try {
            localList=SC.maxSalary(playerList);
            show(localList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void totalPressed(ActionEvent event) {
        try {
            double d=SC.totalSalary(playerList);
            salaryShow.setText(String.valueOf(d));
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
}

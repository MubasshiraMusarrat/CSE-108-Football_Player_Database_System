package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Main;
import util.NetworkUtil;

import java.io.IOException;

public class MenuController {
    private Main main;
    public void setMain(Main main) {
        this.main = main;
    }
    double rotation=0.0;

    @FXML
    private Button MyPlayers;

    @FXML
    private Button BuyPlayers;

    @FXML
    private Button exit;

    @FXML
    private Button LogOut;

    @FXML
    private Button SearchPlayers;

    @FXML
    private Button SearchClubs;

    @FXML
    private ImageView img;

    public void init(String clubname) {
        if(clubname.equalsIgnoreCase("Manchester United")){
            Image image=new Image(getClass().getResourceAsStream("/Images/MU.jpg"));
            img.setImage(image);}
        else if(clubname.equalsIgnoreCase("Manchester City")){
            Image image=new Image(getClass().getResourceAsStream("/Images/man city.png"));
            img.setImage(image);}
        else if(clubname.equalsIgnoreCase("Chelsea")){
            Image image=new Image(getClass().getResourceAsStream("/Images/chelsea.jpg"));
            img.setImage(image);}
        else if(clubname.equalsIgnoreCase("Arsenal")){
        Image image=new Image(getClass().getResourceAsStream("/Images/arsenal.jpg"));
        img.setImage(image);}
        else if(clubname.equalsIgnoreCase("Liverpool")){
            Image image=new Image(getClass().getResourceAsStream("/Images/liverpool.png"));
            img.setImage(image);}
        rotate();
    }

    private void rotate() {
        Point3D point = new Point3D(0, 90, 0);
        img.setRotationAxis(point);
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                rotation += 5;
                img.setRotate(rotation);
            }
        }.start();
    }

    @FXML
    void LogOutPressed(ActionEvent event) {
        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void BuyPlayersPressed(ActionEvent event) {
        try {
            main.getNetworkUtil().write("BuyPlayerList");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void ExitPressed(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void MyPlayersPressed(ActionEvent event) {
        try {
            main.showMyPlayerPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void SearchClubsPressed(ActionEvent event) {
        try {
            main.showSearchClubPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void SearchPlayersPressed(ActionEvent event) {
        try {
            main.showSearchPlayerPage();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}


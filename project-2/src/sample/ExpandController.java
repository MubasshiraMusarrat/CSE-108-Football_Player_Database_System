package sample;

import PlayerProperties.player;
import javafx.animation.AnimationTimer;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import util.NetworkUtil;

public class ExpandController {
    private player Player;
    double rotation=0.0,opacity=0;
    @FXML
    private AnchorPane pane;

    @FXML
    private Label name1;

    @FXML
    private ImageView playerImg;

    @FXML
    private ImageView clubimage;

    @FXML
    private ImageView flag;

    @FXML
    private Label age1;

    @FXML
    private Label height1;

    @FXML
    private Label position1;

    @FXML
    private Label number1;

    @FXML
    private Label salary1;


    public void setData(player p) {
        this.Player=p;
        name1.setText(p.getName());
        age1.setText(String.valueOf(p.getAge()));
        height1.setText(String.valueOf(p.getHeight()));
        position1.setText(p.getPosition());
        number1.setText(String.valueOf(p.getNumber()));
        salary1.setText(String.valueOf(p.getWeeklySalary()));
        Image image = new Image(getClass().getResourceAsStream(p.getImgSrc()));
        playerImg.setImage(image);
        ImageSetting();
        rotate();
    }

    private void ImageSetting(){
        {
            if (Player.getClub().equalsIgnoreCase("Manchester United")) {
                Image imageclub = new Image(getClass().getResourceAsStream("/Images/MU.jpg"));
                clubimage.setImage(imageclub);
            } else if (Player.getClub().equalsIgnoreCase("Manchester City")) {
                Image imageclub = new Image(getClass().getResourceAsStream("/Images/man city.png"));
                clubimage.setImage(imageclub);
            } else if (Player.getClub().equalsIgnoreCase("Chelsea")) {
                Image imageclub = new Image(getClass().getResourceAsStream("/Images/chelsea.jpg"));
                clubimage.setImage(imageclub);
            } else if (Player.getClub().equalsIgnoreCase("Arsenal")) {
                Image imageclub = new Image(getClass().getResourceAsStream("/Images/arsenal.jpg"));
                clubimage.setImage(imageclub);
            } else if (Player.getClub().equalsIgnoreCase("Liverpool")) {
                Image imageclub = new Image(getClass().getResourceAsStream("/Images/liverpool.png"));
                clubimage.setImage(imageclub);
            }
        }
        {
            if (Player.getCountry().equalsIgnoreCase("spain")) {
                Image Flag = new Image(getClass().getResourceAsStream("/flagImage/spain.png"));
                flag.setImage(Flag);
            } else if (Player.getCountry().equalsIgnoreCase("england")) {
                Image Flag = new Image(getClass().getResourceAsStream("/flagImage/england.jpg"));
                flag.setImage(Flag);
            } else if (Player.getCountry().equalsIgnoreCase("france")) {
                Image Flag = new Image(getClass().getResourceAsStream("/flagImage/france.png"));
                flag.setImage(Flag);
            } else if (Player.getCountry().equalsIgnoreCase("portugal")) {
                Image Flag = new Image(getClass().getResourceAsStream("/flagImage/portugal.jpg"));
                flag.setImage(Flag);
            } else if (Player.getCountry().equalsIgnoreCase("Uruguay")) {
                Image Flag = new Image(getClass().getResourceAsStream("/flagImage/uruguay.png"));
                flag.setImage(Flag);
            } else if (Player.getCountry().equalsIgnoreCase("brazil")) {
                Image Flag = new Image(getClass().getResourceAsStream("/flagImage/brazil.png"));
                flag.setImage(Flag);
            }else if (Player.getCountry().equalsIgnoreCase("belgium")) {
                Image Flag = new Image(getClass().getResourceAsStream("/flagImage/belgium.png"));
                flag.setImage(Flag);
            }else if (Player.getCountry().equalsIgnoreCase("germany")) {
                Image Flag = new Image(getClass().getResourceAsStream("/flagImage/germany.png"));
                flag.setImage(Flag);
            }else if (Player.getCountry().equalsIgnoreCase("senegal")) {
                Image Flag = new Image(getClass().getResourceAsStream("/flagImage/senegal.jpg"));
                flag.setImage(Flag);
            }else if (Player.getCountry().equalsIgnoreCase("italy")) {
                Image Flag = new Image(getClass().getResourceAsStream("/flagImage/italy.jpg"));
                flag.setImage(Flag);
            }else if (Player.getCountry().equalsIgnoreCase("Netherlands")) {
                Image Flag = new Image(getClass().getResourceAsStream("/flagImage/netherlands.jpg"));
                flag.setImage(Flag);
            }else if (Player.getCountry().equalsIgnoreCase("egypt")) {
                Image Flag = new Image(getClass().getResourceAsStream("/flagImage/egypt.jpg"));
                flag.setImage(Flag);
            }else if (Player.getCountry().equalsIgnoreCase("Switzerland")) {
                Image Flag = new Image(getClass().getResourceAsStream("/flagImage/swiss.png"));
                flag.setImage(Flag);
            }else if (Player.getCountry().equalsIgnoreCase("ghana")) {
                Image Flag = new Image(getClass().getResourceAsStream("/flagImage/ghana.jpg"));
                flag.setImage(Flag);
            }else if (Player.getCountry().equalsIgnoreCase("Gabon")) {
                Image Flag = new Image(getClass().getResourceAsStream("/flagImage/gabon.png"));
                flag.setImage(Flag);
            }
        }
    }

    private void rotate() {
        Point3D point = new Point3D(0, 90, 0);
        playerImg.setRotationAxis(point);
        clubimage.setRotationAxis(point);
        flag.setRotationAxis(point);
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                opacity+=.01;
                clubimage.setOpacity(opacity);
                flag.setOpacity(opacity);
                playerImg.setOpacity(opacity);
                rotation += 3;
                playerImg.setRotate(rotation);
            }
        }.start();
    }
}


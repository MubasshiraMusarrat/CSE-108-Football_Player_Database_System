package sample;

import PlayerProperties.player;
import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Point3D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.SwipeEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PlayerShowController {
    private Main main;
    private Stage stage;
    private BuyPlayerController controller;

    public void setController(BuyPlayerController controller) {
        this.controller = controller;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setMain(Main main) {
        this.main = main;
    }
    private player Player;
    double rotation=0.0;

    @FXML
    private AnchorPane pane;

    @FXML
    private ImageView image;

    @FXML
    private Label club;

    @FXML
    private Label country;

    @FXML
    private Label age;

    @FXML
    private Label height;

    @FXML
    private Label position;

    @FXML
    private Label number;

    @FXML
    private Label name;

    @FXML
    private Label price;

    @FXML
    private Button buy;

    @FXML
    void buyPressed(ActionEvent event) {
        Platform.runLater(()->{
            try {
                main.BuyPlayer(Player,pane,controller,stage);
            }catch (Exception e){
                e.printStackTrace();
            }
        });
    }

    public void setData(player p)
    {
        this.Player=p;
        name.setText(p.getName());
        country.setText(p.getCountry());
        age.setText(String.valueOf(p.getAge()));
        height.setText(String.valueOf(p.getHeight()));
        club.setText(p.getClub());
        position.setText(p.getPosition());
        number.setText(String.valueOf(p.getNumber()));
        Image img= new Image(getClass().getResourceAsStream(p.getImgSrc()));
        image.setImage(img);
        price.setText(p.getPrice()+"$");
        rotate();
    }

    private void rotate() {
        Point3D point = new Point3D(0, 90, 0);
        image.setRotationAxis(point);
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                rotation += 2;
                image.setRotate(rotation);
            }
        }.start();
    }
}


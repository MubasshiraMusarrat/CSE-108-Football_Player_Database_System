package sample;

import PlayerProperties.player;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import util.NetworkUtil;

import java.io.IOException;

public class PlayerDetailController {
    private player P;
    boolean showSell=false;
    private Main main;
    public void setMain(Main main, boolean showSell) {
        this.main=main;
        this.showSell=showSell;
    }

    @FXML
    private AnchorPane pane;

    @FXML
    private Label name1;

    @FXML
    private ImageView playerImg;

    @FXML
    private Label country1;

    @FXML
    private Label age1;

    @FXML
    private Label height1;

    @FXML
    private Label club1;

    @FXML
    private Label position1;

    @FXML
    private Label number1;

    @FXML
    private Label salary1;

    @FXML
    private Button zoom;

    @FXML
    private Button sell;

    @FXML
    private TextField price;

    @FXML
    void sellPressed(ActionEvent event) {
            int s=Integer.parseInt(price.getText());
            P.setPrice(s);
            Platform.runLater(() -> {
                main.sellPlayer(P);
            });
    }

    @FXML
    void zoomPressed(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("/FXMLs/Expanded.fxml"));
        try {
            pane = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ExpandController EC=fxmlLoader.getController();
        EC.setData(P);

        Stage stage = new Stage();
        stage.setScene(new Scene(pane));
        stage.show();
    }



    public void setData(player p)
    {
        this.P=p;
        name1.setText(p.getName());
        country1.setText(p.getCountry());
        age1.setText(String.valueOf(p.getAge()));
        height1.setText(String.valueOf(p.getHeight()));
        club1.setText(p.getClub());
        position1.setText(p.getPosition());
        number1.setText(String.valueOf(p.getNumber()));
        salary1.setText(String.valueOf(p.getWeeklySalary()));
        Image image= new Image(getClass().getResourceAsStream(p.getImgSrc()));
        playerImg.setImage(image);
        Sell();
    }

    private void Sell(){
        if(showSell){
            price.setVisible(true);
            sell.setVisible(true);
        }
        else {
            price.setVisible(false);
            sell.setVisible(false);
        }
    }

}


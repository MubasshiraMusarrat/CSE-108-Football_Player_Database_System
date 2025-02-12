package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import sample.Main;
import util.LoginDTO;

import java.io.IOException;

public class LoginController {
    private Main main;
    public void setMain(Main main) {
        this.main = main;
    }

    @FXML
    private TextField ClubName;

    @FXML
    private PasswordField Password;

    @FXML
    private Button ResetButton;

    @FXML
    private Button LoginButton;



    @FXML
    void LoginButtonPressed(ActionEvent event) {
        String Name = ClubName.getText();
        String word = Password.getText();
        Integer password = Integer.parseInt(word);
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setClubName(Name);
        loginDTO.setPassword(password);
        try {
            main.getNetworkUtil().write(loginDTO);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @FXML
    void ResetButtonPressed(ActionEvent event) {
        ClubName.setText(null);
        Password.setText(null);
    }
}

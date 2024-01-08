package lk.ijse.tea.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import lk.ijse.tea.model.UserModel;
import lk.ijse.tea.util.Navigation;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

public class LoginFormController {

    @FXML
    private AnchorPane changeingPane;

    @FXML
    private Button checkpasswordbtn1;

    @FXML
    private TextField checkpasswordfield;

    @FXML
    private Button invisiblebtn;

    @FXML
    private PasswordField passwordfield1;

    @FXML
    private Hyperlink txtCreteAccount;

    @FXML
    private Hyperlink txtForgetPassword;

    @FXML
    private TextField usernametxt;

    private FXMLLoader fxmlLoader;

    public static String username;
    @FXML
    void btnOnActionLogin(ActionEvent event) throws RuntimeException, IOException {
        if (UserModel.verifyCredential(usernametxt.getText(), passwordfield1.getText())) {
            username = usernametxt.getText();
            Navigation.switchNavigation("dashboard_form.fxml", changeingPane);
        }
    }

    @FXML
    void hyperCreateAccOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/signup_form.fxml"));

        Scene scene = new Scene(rootNode);
        changeingPane.getChildren().clear();
        Stage primaryStage = (Stage) changeingPane.getScene().getWindow();
        primaryStage.centerOnScreen();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Sign up");
        primaryStage.centerOnScreen();

    }
    @FXML
    void btnOnActionLogHistory(ActionEvent event) {

    }

    @FXML
    void hyperFogotPasswordOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/fogotPassword_form.fxml"));

        Scene scene = new Scene(rootNode);
        changeingPane.getChildren().clear();
        Stage primaryStage = (Stage) changeingPane.getScene().getWindow();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Fogot Password");
        primaryStage.centerOnScreen();

    }

    @FXML
    void btninvisiblebtnonaction(ActionEvent event) {

    }

    public void btncheckpasswordbtnonaction(ActionEvent actionEvent) {

    }

    public void txtPasswordOnAction(ActionEvent actionEvent) throws IOException {
          btnOnActionLogin(actionEvent);


    }
}

package lk.ijse.tea.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tea.model.UserModel;
import lk.ijse.tea.util.Navigation;
import java.io.IOException;

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

    @FXML
    void btnOnActionLogin(ActionEvent event) throws RuntimeException, IOException {

        if (UserModel.verifyCredential(usernametxt.getText(),passwordfield1.getText())) {
            Navigation.switchNavigation("dashboard_form.fxml",changeingPane);
        }
    }

    @FXML
    void btncheckpasswordbtnonaction(ActionEvent event) {

    }

    @FXML
    void btninvisiblebtnonaction(ActionEvent event) {

    }

}

package lk.ijse.tea.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.tea.model.UserModel;
import lk.ijse.tea.util.Navigation;

import java.sql.SQLException;

public class ResetPasswordController {

    @FXML
    private Button btnLogin;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtConfirmPassword;

    @FXML
    private TextField txtPassword;

    @FXML
    void btnOnActionLogin(ActionEvent event) {
        btnLogin.getScene().getWindow().hide();
        Navigation.changeStage("/view/login_form.fxml","Login Form");

    }

    @FXML
    void btnOnActionResetPassword(ActionEvent event)  {
        UserModel userModel = new UserModel();
        if(txtPassword.getText().equals(txtConfirmPassword.getText())) {
            boolean isUpdated = false;
            try {
                isUpdated = userModel.updatePassword(FogotPasswordFormController.username, txtPassword.getText());
                if (isUpdated) {
                    new Alert(Alert.AlertType.CONFIRMATION,"OK").show();
                }
            } catch (SQLException e) {
                new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            }
        }else {
            new Alert(Alert.AlertType.ERROR,"CONFIRMATION NOT MATCHED!").show();
            //System.out.println("CONFIRMATION NOT MATCHED!");
        }
/*
    @FXML
    void btnOnActionResetPassword(ActionEvent event) throws SQLException {
        UserModel userModel = new UserModel();
        if(txtPassword.getText().equals(txtConfirmPassword.getText())) {
            boolean isUpdated = userModel.updatePassword(FogotPasswordFormController.username, txtPassword.getText());
            if (isUpdated) {
                System.out.println("OK");
            } else {
                System.out.println("WRONG");
            }
        }else {
            System.out.println("CONFIRMATION NOT MATCHED!");
        */

    }

}

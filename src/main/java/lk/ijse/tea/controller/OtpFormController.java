package lk.ijse.tea.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tea.util.Navigation;

import java.io.IOException;

public class OtpFormController {

    private int otp;

    @FXML
    private AnchorPane OtpForm;
    @FXML
    private Button btnBack;

    @FXML
    private Button btnVerify;

    @FXML
    private TextField txtOtp;

    @FXML
    void btnOnActionBack(ActionEvent event) {
        btnBack.getScene().getWindow().hide();
        Navigation.changeStage("/view/login_form.fxml","Login Form");
    }

    @FXML
    void btnOnActionVerify(ActionEvent event) throws IOException {
        System.out.println(FogotPasswordFormController.otp);
        if(String.valueOf(otp).equals(txtOtp.getText())){
            btnVerify.getScene().getWindow().hide();
            Navigation.changeStage("/view/ResetPassword_form.fxml","Reset Password Form");
            //btnVerify.getScene().getWindow().hide();
            //Navigation.switchNavigation("/view/ResetPassword_form.fxml",OtpForm);
            //Navigation.changeStage("/view/resetPasswordForm.fxml","RESET PASSWORD FORM");
        }else{
            new Alert(Alert.AlertType.ERROR,"OTP WRONG");
        }
    }
    public void initialize(){
        System.out.println(FogotPasswordFormController.otp);
        this.otp = FogotPasswordFormController.otp;
    }
}
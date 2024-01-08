package lk.ijse.tea.controller;

import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tea.dto.UserDto;
import lk.ijse.tea.model.UserModel;
import lk.ijse.tea.util.Navigation;

import javax.mail.MessagingException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;


public class FogotPasswordFormController {

    static String username;

    static int otp;

    @FXML
    private ProgressBar progressLoad;

    @FXML
    private AnchorPane FogotPane;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnReset;

    @FXML
    private TextField txtUsername;
/*
    @FXML
    void btnOnActionReset(ActionEvent event) throws SQLException, MessagingException, IOException {
        username = txtUsername.getText();
        UserModel userModel = new UserModel();
        Random random = new Random();
        otp = random.nextInt(9000);
        otp += 1000;
        UserDto userDto = userModel.getEmail(username);
        System.out.println(userDto.getEmail());
        EmailController.sendEmail(userDto.getEmail(), "cafe au lait verification", otp + "");

        //btnReset.getScene().getWindow().hide();
        //Navigation.switchNavigation("/view/otp_form.fxml",FogotPane);
        btnReset.getScene().getWindow().hide();
        Navigation.changeStage("/view/otp_form.fxml","OTP Form");
        //Navigation.switchNavigation("factory_form.fxml",FogotPane);
    }*/
@FXML
void btnOnActionReset(ActionEvent event) throws SQLException, MessagingException, IOException {
    username = txtUsername.getText();
    UserModel userModel = new UserModel();
    Random random = new Random();
    otp = random.nextInt(9000);
    otp += 1000;
    UserDto userDto = userModel.getEmail(username);
    System.out.println(userDto.getEmail());

    // Create a Task for the transition with a progress bar
    Task<Void> task = new Task<Void>() {
        @Override
        protected Void call() throws Exception {
            // Simulate some work before transitioning
            EmailController.sendEmail(userDto.getEmail(), "Growers choice tea verification", otp + "");

            // Simulate additional work (adjust the sleep duration as needed)
            for (int i = 0; i < 100; i++) {
                updateProgress(i, 100);
                Thread.sleep(10);
            }

            return null;
        }
    };

    task.setOnSucceeded(workerStateEvent -> {
        // Transition to the next pane after the task is completed
        btnReset.getScene().getWindow().hide();
        Navigation.changeStage("/view/otp_form.fxml", "OTP Form");
    });

    progressLoad.progressProperty().bind(task.progressProperty());

    // Start the task
    new Thread(task).start();
}

    @FXML
    void btnOnActionBack(ActionEvent event) {
        btnBack.getScene().getWindow().hide();
        Navigation.changeStage("/view/login_form.fxml","Login Form");
    }

}

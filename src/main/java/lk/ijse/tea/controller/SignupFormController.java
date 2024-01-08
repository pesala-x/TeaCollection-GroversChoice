package lk.ijse.tea.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.tea.dto.EmployeeDto;
import lk.ijse.tea.dto.UserDto;
import lk.ijse.tea.model.EmployeeModel;
import lk.ijse.tea.model.UserModel;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class SignupFormController {

    @FXML
    private TextField txtPassword;

    @FXML
    private AnchorPane changingPane;

    @FXML
    private TextField checkpasswordfield;

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPasswordConfirmation;

    @FXML
    private TextField usernametxt;

    @FXML
    void btnOnActionSignIn(ActionEvent event) {

        boolean isCustomer = validateCustomer();
    }

    private boolean validateCustomer() {

        //match to the Username Like --> Pesala
        boolean matches = Pattern.compile("[A-Za-z .]{3,}").matcher(usernametxt.getText()).matches();
            String usernametxtText = usernametxt.getText();
            if (!matches) {
                new Alert(Alert.AlertType.ERROR, "Oops...Invalid User Name,try to Input Username Like --> Pesala ").show();
                usernametxt.requestFocus();

                return false;
        }

        //match to the Password Like --> Pesala12
        matches = Pattern.compile("[A-Za-z\\d!@#$%^&*()-_+=]{8,}").matcher(txtPassword.getText()).matches();

                String txtPasswordText = txtPassword.getText();
        if (!matches) {
            new Alert(Alert.AlertType.ERROR, "Oops...Invalid Password,try to Build Strong 8 Digit Password Using Symbols,letters and numbers ").show();
            txtPassword.requestFocus();

            return false;
        }

        matches = Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}").matcher(txtEmail.getText()).matches();
        String txtEmailText = txtEmail.getText();
        if (!matches) {
            new Alert(Alert.AlertType.ERROR, "Oops...Invalid Password,try to enter valid Email. ").show();
            txtPassword.requestFocus();

            return false;
        }

        UserModel userModel = new UserModel();
        UserDto dto = new UserDto(usernametxtText,txtPasswordText,txtEmailText);

        try {
            boolean isSigned = userModel.signUser(dto);
            if (isSigned){
                new Alert(Alert.AlertType.CONFIRMATION," New user Added Successfully ").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
//        boolean matches = Pattern.compile("([C]\\d{3,})").matcher(txtId.getText()).matches();
//        if (!matches) {
//            new Alert(Alert.AlertType.ERROR, "Invalid Customer ID").show();
//            txtId.requestFocus();
//            return false;

        return false;
    }


    /*
       public void btnSaveOnAction(ActionEvent actionEvent) {
       boolean isCustomer = validateCustomer();

    }
    private boolean validateCustomer(){

         boolean matches = Pattern.compile("([C]\\d{3,})").matcher(txtId.getText()).matches();
         if (!matches) {
             new Alert(Alert.AlertType.ERROR, "Invalid Customer ID").show();
             txtId.requestFocus();
            return false;
         }
         //   matches=false;
         //validate title with mr,mrs,miss
         matches = Pattern.compile("mr|mrs|miss|Mr|Mrs|Miss").matcher(txtTitle.getText()).matches();

         if (!matches) {
         new Alert(Alert.AlertType.ERROR, "Invalid Title").show();
         txtId.requestFocus();
         return false;
         }
*/
    @FXML
    void hyperLoginHereOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/login_form.fxml"));

        Scene scene = new Scene(rootNode);
        changingPane.getChildren().clear();
        Stage primaryStage = (Stage) changingPane.getScene().getWindow();

        primaryStage.setScene(scene);
        primaryStage.setTitle("Sign in");

    }
}

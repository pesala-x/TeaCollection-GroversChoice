package lk.ijse.tea.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.tea.util.Navigation;

import java.io.IOException;

public class DashboardFormController {

    @FXML
    private AnchorPane paneGloble;
    private AnchorPane changeingPane;

    @FXML
    void brnHomeMouseOnExited(MouseEvent event) {

    }

    @FXML
    void btnEmpMannageOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("EmployeeMannage_form.fxml",paneGloble);
    }

    @FXML
    void btnFactoryMannageOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("factory_form.fxml",paneGloble);

    }

    @FXML
    void btnHomeOnAction(ActionEvent event) throws IOException {
        //Navigation.switchNavigation("dashboard_form.fxml",paneGloble);
        Navigation.switchNavigation("dashboard_form.fxml",changeingPane);
    }

    @FXML
    void btnHomeOnMouseOnEntered(MouseEvent event) {

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        //Navigation.switchNavigation("login_form.fxml",paneGloble);
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/login_form.fxml"));
        Stage stage = (Stage) anchorPane.getScene().getWindow();

        stage.setScene(new Scene(anchorPane));
        stage.setTitle("Dashboard");
        stage.centerOnScreen();
    }


    @FXML
    void btnRegisterOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("register_form.fxml",paneGloble);
    }

    @FXML
    void btnReportsOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("report_form.fxml",paneGloble);
    }

    @FXML
    void btnTeaProducerMannageOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("teaProducerMannage_form.fxml",paneGloble);
    }

}


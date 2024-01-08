package lk.ijse.tea.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.tea.util.Navigation;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
//
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.util.Duration;


public class DashboardFormController {

    public void initialize() {
        setDate();
        initializeTimeUpdater();
        //setTime();
    }
    private void setDate() {
        String date = String.valueOf(LocalDate.now());
        lblToday.setText(date);
    }
    private Timeline timeline;
    private void initializeTimeUpdater() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), this::updateTime));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateTime(ActionEvent event) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String timeWithAmPm = LocalTime.now().format(formatter);
        lblTime.setText(timeWithAmPm);
    }
    /*
    private  void setTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String timeWithAmPm = LocalTime.now().format(formatter);
        lblTime.setText(timeWithAmPm);
    }
    */

    @FXML
    private Label lblTime;

    @FXML
    private Label lblToday;
    @FXML
    private AnchorPane paneGloble;

    @FXML
    private AnchorPane paneHome;

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
        try {
            Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));

            Scene scene = new Scene(rootNode);
            paneHome.getChildren().clear();
            Stage primaryStage = (Stage) paneHome.getScene().getWindow();

            primaryStage.setScene(scene);
            primaryStage.setTitle(" Dashboard ");
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void btnHomeOnMouseOnEntered(MouseEvent event) {

    }

    @FXML
    void btnLogoutOnAction(ActionEvent event) throws IOException {
        Navigation.switchNavigation("login_form.fxml",paneHome);//to be continued...

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
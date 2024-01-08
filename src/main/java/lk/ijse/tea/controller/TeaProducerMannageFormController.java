package lk.ijse.tea.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;
import lk.ijse.tea.dto.EmployeeDto;
import lk.ijse.tea.dto.TeaDetailDto;
import lk.ijse.tea.dto.TeaProducerDto;
import lk.ijse.tea.model.AttendenceModel;
import lk.ijse.tea.model.EmployeeModel;
import lk.ijse.tea.model.TeaDetailModel;
import lk.ijse.tea.model.TeaProducerModel;
import lk.ijse.tea.util.Navigation;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class TeaProducerMannageFormController {

    @FXML
    private Button btnPaymentOnAction;
    @FXML
    private Button btnAddFertilizer;

    @FXML
    private Button btnAddTeaOnAction;

    @FXML
    private Button btnSetOnAction;

    @FXML
    private ComboBox<?> cmbProducerID;

    @FXML
    private ComboBox<?> cmbProducerTeaID;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colTeaDetailID;

    @FXML
    private TableColumn<?, ?> colTeaRate;

    @FXML
    private TableColumn<?, ?> colTeaType;

    @FXML
    private TableColumn<?, ?> colTeaWeight;

    @FXML
    private TableColumn<?, ?> colTotalTeaWeight;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblProducerID;

    @FXML
    private Label lblTeaDetailID;

    @FXML
    private Label lblTeaRate;

    @FXML
    private Label lblTeaWeight;

    @FXML
    private TableView<?> tblProducerUpdate;

    @FXML
    private AnchorPane paneHome;
    public void initialize() {
        generateNextTeaDedailId();
        setDate();
        loadAllTeaDetails();
        setCellValueFactory();
        //setTime();
    }

    private void loadAllTeaDetails() {

    }

    private void setCellValueFactory() {

    }

    private void generateNextTeaDedailId() {

    }

    private void setDate() {
        String date = String.valueOf(LocalDate.now());
        lblDate.setText(date);
    }
    @FXML
    void btnAddFertilizerOnAction(ActionEvent event) {
        try {
            Navigation.popUpPane(paneHome, "fertilizer&equipments_form.fxml");
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnAddTeaOnAction(ActionEvent event) {
        try {
            Navigation.popUpPane(paneHome, "tea_form.fxml");
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }
    @FXML
    void btnPaymentOnAction(ActionEvent event) {
        try {
            Navigation.popUpPane(paneHome, "payment_form.fxml");
        } catch (IOException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSetOnAction(ActionEvent event) {

    }

    @FXML
    void cmbProducerIDOnActon(ActionEvent event) throws SQLException {
        String idValue = cmbProducerTeaID.getId();
        TeaProducerDto dto = TeaProducerModel.searchEmployee(idValue);

        lblProducerID.setText(dto.getProducer_id());
    }

    @FXML
    void cmbProducerTeaIDOnActon(ActionEvent event) throws SQLException {
        String idValue = cmbProducerID.getId();
        EmployeeDto dto = EmployeeModel.searchEmployee(idValue);

        lblProducerID.setText(dto.getFirst_name());
    }

}

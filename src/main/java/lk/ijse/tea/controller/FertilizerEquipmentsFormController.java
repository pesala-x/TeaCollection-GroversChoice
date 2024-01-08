package lk.ijse.tea.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tea.dto.AttendanceDto;
import lk.ijse.tea.dto.EmployeeDto;
import lk.ijse.tea.dto.FertilizerEquipmentDto;
import lk.ijse.tea.model.AttendenceModel;
import lk.ijse.tea.model.EmployeeModel;
import lk.ijse.tea.model.FertilizerEquipmentModel;
import lk.ijse.tea.model.TeaModel;

import java.sql.SQLException;
import java.time.LocalDate;

public class FertilizerEquipmentsFormController {

    @FXML
    private AnchorPane FertilizerPane;

    @FXML
    private Button btnRemoveOnAction1;

    @FXML
    private Button btnSetOnAction;

    @FXML
    private ComboBox<?> cmbPaymentID;

    @FXML
    private ComboBox<?> cmbProducer;

    @FXML
    private TableColumn<?, ?> colDESC;

    @FXML
    private TableColumn<?, ?> colFertID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colPayID;

    @FXML
    private TableColumn<?, ?> colUnitprice;

    @FXML
    private TableColumn<?, ?> colUser;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblProducerNAme;

    @FXML
    private Label lblFertID;

    @FXML
    private TableView<?> tblFertilizer;

    @FXML
    private TextField txtDesc;

    @FXML
    private TextField txtEquipmentName;

    @FXML
    private TextField txtUnitprice;

    public void initialize() {
        generateNextFertilizerID();
        setDate();
    }

    private void generateNextFertilizerID(){
        try {
            String FertId = new FertilizerEquipmentModel().generateNextFertilizerId();
            lblFertID.setText(FertId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void setDate() {
        String date = String.valueOf(LocalDate.now());
        lblDate.setText(date);
    }

    @FXML
    void btnRemoveOnAction(ActionEvent event) {

    }

    @FXML
    void btnSetOnAction(ActionEvent event) {
        String fertIDText = lblFertID.getText();
        String username = LoginFormController.username;
        String paymentIDId = cmbPaymentID.getId();
        String equipmentNameText = txtEquipmentName.getText();
        String descText = txtDesc.getText();
        String unitpriceText = txtUnitprice.getText();

        FertilizerEquipmentModel fertilizerEquipmentModel = new FertilizerEquipmentModel();
        FertilizerEquipmentDto dto =new FertilizerEquipmentDto(fertIDText,username,paymentIDId,equipmentNameText,descText,unitpriceText);

        try {
            boolean isSaved = FertilizerEquipmentModel.saveFertilizer(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION,"").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();

        }
    }

}

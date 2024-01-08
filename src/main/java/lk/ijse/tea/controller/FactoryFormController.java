package lk.ijse.tea.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class FactoryFormController {

    @FXML
    private Button btnSetOnAction;

    @FXML
    private ComboBox<?> cmbFactoryID;

    @FXML
    private ComboBox<?> cmbTeaId;

    @FXML
    private TableColumn<?, ?> colAction;

    @FXML
    private TableColumn<?, ?> colFact;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colQuality;

    @FXML
    private TableColumn<?, ?> colTeaID;

    @FXML
    private Label lblAutogenerateCode;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTime;

    @FXML
    private TableView<?> tblAttendence;

    @FXML
    private TextField txtQuality;

    @FXML
    void btnSetOnAction(ActionEvent event) {

    }

    @FXML
    void cmbEmployeeOnAction(ActionEvent event) {

    }

    @FXML
    void cmbFactoryIDOnAction(ActionEvent event) {

    }

}

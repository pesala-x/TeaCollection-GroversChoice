package lk.ijse.tea.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PaymentFormController {

    @FXML
    private Button btnSetOnAction;

    @FXML
    private TableColumn<?, ?> colDescription;

    @FXML
    private TableColumn<?, ?> colPayID;

    @FXML
    private TableColumn<?, ?> colPayMethod;

    @FXML
    private TableColumn<?, ?> colProducerId;

    @FXML
    private TableColumn<?, ?> colTotalPay;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblPayID;

    @FXML
    private Label lblTime;

    @FXML
    private TableView<?> tblPayment;

    @FXML
    private TextField txtDESC;

    @FXML
    private TextField txtPayMethod;

    @FXML
    void btnSetOnAction(ActionEvent event) {

    }

}

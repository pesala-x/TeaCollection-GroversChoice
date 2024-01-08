package lk.ijse.tea.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import lk.ijse.tea.dto.TeaDto;
import lk.ijse.tea.dto.tm.TeaTm;
import lk.ijse.tea.model.TeaModel;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TeaFormController {

    private Timeline timeline;
    @FXML
    private TableColumn<?, ?> colDesc;

    @FXML
    private TableColumn<?, ?> colRate;

    @FXML
    private TableColumn<?, ?> colTeaID;

    @FXML
    private TableColumn<?, ?> colType;

    @FXML
    private TableColumn<?, ?> colWeight;

    @FXML
    private Label lblDate;

    @FXML
    private Label lblTeaID;

    @FXML
    private Label lblTime;

    @FXML
    private TableView<TeaTm> tblTea;

    @FXML
    private TextField txtTeaDesc;

    @FXML
    private TextField txtTeaRate;

    @FXML
    private TextField txtTeaType;

    @FXML
    private TextField txtTeaWeight;


    public void initialize() {
        generateNextTeaID();
        setDate();
        initializeTimeUpdater();
        setCellValueFactory();
        loadAllTea();
    }
    private void setDate() {
        String date = String.valueOf(LocalDate.now());
        lblDate.setText(date);
    }

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
    private void generateNextTeaID() {
        try {
            String TeaId = new TeaModel().generateNextTeaId();
            lblTeaID.setText(TeaId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSetOnAction(ActionEvent actionEvent) {
        String teaIDText = lblTeaID.getText();
        String teaWeightText = txtTeaWeight.getText();
        String teaTypeText = txtTeaType.getText();
        String teaRateText = txtTeaRate.getText();
        String teaDescText = txtTeaDesc.getText();
        // String username = LoginFormController.username;

        TeaModel teaModel = new TeaModel();
        TeaDto dto =new TeaDto(teaIDText,teaWeightText,teaTypeText,teaRateText,teaDescText,null);
        try {
            boolean isSaved = TeaModel.saveTea(dto);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Tea Added..").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
    private void loadAllTea() {
        TeaModel  model = new TeaModel();

        ObservableList<TeaTm> obList = FXCollections.observableArrayList();
        try {
            List<TeaDto> list = model.getAllTea();
            for (TeaDto dto: list) {
                TeaTm teaTm =new TeaTm(
                        dto.getT_id(),
                        dto.getWeight(),
                        dto.getType(),
                        dto.getMonthly_pay_kilo(),
                        dto.getDescription(),
                        dto.getPay_id()
                );
                obList.add(teaTm);

            }

            tblTea.setItems(obList);

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
    private void setCellValueFactory() {
        colTeaID.setCellValueFactory(new PropertyValueFactory<>("T_id"));
        colWeight.setCellValueFactory(new PropertyValueFactory<>("Weight"));
        colType.setCellValueFactory(new PropertyValueFactory<>("Type"));
        colRate.setCellValueFactory(new PropertyValueFactory<>("Monthly_pay_kilo"));
        colDesc.setCellValueFactory(new PropertyValueFactory<>("Description"));
        //.setCellValueFactory(new PropertyValueFactory<>("Pay_id"));

    }
}

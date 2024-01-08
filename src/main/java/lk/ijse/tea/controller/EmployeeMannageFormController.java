package lk.ijse.tea.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.tea.dto.AttendanceDto;
import lk.ijse.tea.dto.EmployeeDto;
import lk.ijse.tea.dto.tm.AttendenceTm;
import lk.ijse.tea.dto.tm.EmployeeTm;
import lk.ijse.tea.model.AttendenceModel;
import lk.ijse.tea.model.EmployeeModel;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;


public class EmployeeMannageFormController {

    public TextField lblOutTime;
    @FXML
    private Label lblAttendenceTime;

    @FXML
    private Label lblGetEmployeeName;

    @FXML
    private Label lblAttendenceDate;

    @FXML
    private Label lblAttendenceId;

    @FXML
    private ComboBox<String> cmbEmployeeId;
    private Timeline timeline;

    @FXML
    private TableColumn<?, ?> colAttEmpID;

    @FXML
    private TableColumn<?, ?> colAttId;

    @FXML
    private TableColumn<?, ?> colAttTimeIn;

    @FXML
    private TableColumn<?, ?> colAttWHours;

    @FXML
    private TableView<AttendenceTm> tblAttendence;

    @FXML
    private TableView<?> tblSallery;

    public void initialize() {
        generateNextAttId();
        loadEmployeeAttendence();
        setDate();
        initializeTimeUpdater();
        loadAllAttendance();
        setCellValueFactory();
        //setTime();
    }

    @FXML
    void cmbEmployeeOnAction(ActionEvent event) throws SQLException {
        String idValue = cmbEmployeeId.getValue();
        EmployeeDto dto = EmployeeModel.searchEmployee(idValue);

        lblGetEmployeeName.setText(dto.getFirst_name());
    }

    private void generateNextAttId(){
        try {
            String orderId = new AttendenceModel().generateNextAttendenceId();
            lblAttendenceId.setText(orderId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private void setDate() {
        String date = String.valueOf(LocalDate.now());
        lblAttendenceDate.setText(date);
    }

    private void initializeTimeUpdater() {
        timeline = new Timeline(new KeyFrame(Duration.seconds(1), this::updateTime));
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }

    private void updateTime(ActionEvent event) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String timeWithAmPm = LocalTime.now().format(formatter);
        lblAttendenceTime.setText(timeWithAmPm);
    }
    /*
    private  void setTime(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
        String timeWithAmPm = LocalTime.now().format(formatter);
        lblAttendenceTime.setText(timeWithAmPm);
    }*/


    private void loadEmployeeAttendence() {
        ObservableList<String> obList = FXCollections.observableArrayList();
        try {
            List<EmployeeDto> empList = EmployeeModel.loadAllEmployeeAttendence();

            for (EmployeeDto dto : empList) {
                obList.add(dto.getEmp_id());
            }
            cmbEmployeeId.setItems(obList);
        }catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void btnSetOnAction(ActionEvent actionEvent) {
        try{
            if(new AttendenceModel().setAttendaance(
                    new AttendanceDto(lblAttendenceId.getText(),cmbEmployeeId.getValue(),lblAttendenceTime.getText(),lblOutTime.getText()))){
                new Alert(Alert.AlertType.CONFIRMATION, "Woohoo..Attendance Set..!").show();
                loadAllAttendance();
            }else {
                new Alert(Alert.AlertType.ERROR, "OOPS...Something Went Wrong..!").show();
            }
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR,"OOPS...Employee Already Attended !").show();
        }
    }

    private void loadAllAttendance() {
        AttendenceModel  model = new AttendenceModel();

        ObservableList<AttendenceTm> obList = FXCollections.observableArrayList();
        try {
            List<AttendanceDto> list = model.getAllAttendence();
            for (AttendanceDto dto: list) {
                AttendenceTm attendenceTm =new AttendenceTm(
                        dto.getAtt_id(),
                        dto.getEmp_id(),
                        dto.getTime_in(),
                        dto.getWork_hours()
                );
                obList.add(attendenceTm);

            }

            tblAttendence.setItems(obList);

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
    private void setCellValueFactory() {
        colAttId.setCellValueFactory(new PropertyValueFactory<>("Att_id"));
        colAttEmpID.setCellValueFactory(new PropertyValueFactory<>("Emp_id"));
        colAttTimeIn.setCellValueFactory(new PropertyValueFactory<>("Time_in"));
        colAttWHours.setCellValueFactory(new PropertyValueFactory<>("Work_hours"));
    }

}

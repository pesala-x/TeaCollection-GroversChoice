package lk.ijse.tea.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.tea.dto.EmployeeDto;
import lk.ijse.tea.dto.FactoryDto;
import lk.ijse.tea.dto.TeaProducerDto;
import lk.ijse.tea.dto.tm.EmployeeTm;
import lk.ijse.tea.dto.tm.FactoryTm;
import lk.ijse.tea.dto.tm.TeaProducerTm;
import lk.ijse.tea.model.EmployeeModel;
import lk.ijse.tea.model.FactoryModel;
import lk.ijse.tea.model.TeaProducerModel;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class RegisterFormController {


    @FXML
    private TableColumn<?, ?> colProdecerContactNumber;

    @FXML
    private TableColumn<?, ?> colProducerAction;

    @FXML
    private TableColumn<?, ?> colProducerAddress;

    @FXML
    private TableColumn<?, ?> colProducerFullname;

    @FXML
    private TableColumn<?, ?> colProducerId;

    @FXML
    private TableColumn<?, ?> colProducerNIC;

    @FXML
    private TableColumn<?, ?> colProducerjoindate;

    @FXML
    private TableColumn<?, ?> colProducerEmail;

    @FXML
    private TextField txtProducerEmail;
    @FXML
    private ImageView imgEmployeeSearch;

    @FXML
    private ImageView imgFactorySearch;

    @FXML
    private ImageView imgTeaProducerSearch;
    @FXML
    private TableColumn<?, ?> colFactoryAction;

    @FXML
    private TableColumn<?, ?> colFactoryAddress;

    @FXML
    private TableColumn<?, ?> colFactoryContractTimePeriod;

    @FXML
    private TableColumn<?, ?> colFactoryId;

    @FXML
    private TableColumn<?, ?> colFactoryJoinedDate;

    @FXML
    private TableColumn<?, ?> colFactoryName;

    @FXML
    private TableColumn<?, ?> colFactoryTimeEndDate;

    @FXML
    private TableColumn<?, ?> colEmpAction;

    @FXML
    private TableColumn<?, ?> colEmpAddress;

    @FXML
    private TableColumn<?, ?> colEmpBasicPayment;

    @FXML
    private TableColumn<?, ?> colEmpContactNumber;

    @FXML
    private TableColumn<?, ?> colEmpFirstName;

    @FXML
    private TableColumn<?, ?> colEmpID;

    @FXML
    private TableColumn<?, ?> colEmpJobRole;

    @FXML
    private TableColumn<?, ?> colEmpLastName;

    @FXML
    private TableColumn<?, ?> colEmpUserName;

    @FXML
    private TableView<EmployeeTm> tblEmployee;

    @FXML
    private TableView<FactoryTm> tblFactory;

    @FXML
    private TableView<TeaProducerTm> tblTeaProducer;

    @FXML
    private TextField txtEmpAddress;

    @FXML
    private TextField txtEmpBasicPayment;

    @FXML
    private TextField txtEmpContactNumber;

    @FXML
    private TextField txtEmpFirstname;

    @FXML
    private TextField txtEmpId;

    @FXML
    private TextField txtEmpLastName;

    @FXML
    private TextField txtFactAddress;

    @FXML
    private TextField txtFactID;

    @FXML
    private DatePicker txtFactJoinedDate;

    @FXML
    private TextField txtFactName;

    @FXML
    private DatePicker txtFactTimeEnd;

    @FXML
    private TextField txtJobRole;

    @FXML
    private TextField txtProducerAddress;

    @FXML
    private TextField txtProducerContactNumber;

    @FXML
    private TextField txtProducerFullname;

    @FXML
    private TextField txtProducerId;

    @FXML
    private DatePicker txtProducerJoindate;

    @FXML
    private TextField txtProducerNic;

    @FXML
    private AnchorPane txtTimeEnd;

    //------------------------------------------------- Employee -------------------------------------------------------
    @FXML
    void btnEmpClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtEmpId.clear();
        txtEmpFirstname.clear();
        txtEmpLastName.clear();
        txtJobRole.clear();
        txtEmpContactNumber.clear();
        txtEmpAddress.clear();
        txtEmpBasicPayment.clear();


    }

    @FXML
    void btnEmpDeleteOnAction(ActionEvent event) {
        String id = txtEmpId.getText();
        EmployeeModel model = new EmployeeModel();
        try {
            boolean isDeleted = model.deleteEmployee(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION,"Employee Deleted Successfully").show();
                loadAllEmployees();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnEmpRegisterOnAction(ActionEvent event)  {

        String empIdText = txtEmpId.getText();
        String username = LoginFormController.username;
        String empFirstnameText = txtEmpFirstname.getText();
        String empLastNameText = txtEmpLastName.getText();
        String jobRoleText = txtJobRole.getText();
        String empContactNumberText = txtEmpContactNumber.getText();
        String empAddressText = txtEmpAddress.getText();
        String empBasicPaymentText = txtEmpBasicPayment.getText();


        EmployeeModel employeeModel = new EmployeeModel();
        EmployeeDto dto =new EmployeeDto(empIdText,username,empFirstnameText,empLastNameText,jobRoleText,empContactNumberText,empAddressText,empBasicPaymentText);
        try {
            boolean isSaved = employeeModel.saveEmployee(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION,"Employee Saved Successful").show();
                loadAllEmployees();
            }
        } catch (SQLException e) {
             new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnEmpUpdateOnAction(ActionEvent event) {
        String empIdText = txtEmpId.getText();
        String username = LoginFormController.username;
        String empFirstnameText = txtEmpFirstname.getText();
        String empLastNameText = txtEmpLastName.getText();
        String jobRoleText = txtJobRole.getText();
        String empContactNumberText = txtEmpContactNumber.getText();
        String empAddressText = txtEmpAddress.getText();
        String empBasicPaymentText = txtEmpBasicPayment.getText();

        EmployeeDto dto =new EmployeeDto(empIdText,username,empFirstnameText,empLastNameText,jobRoleText,empContactNumberText,empAddressText,empBasicPaymentText);
        EmployeeModel model = new EmployeeModel();
        try {
            boolean isUpdated = model.updateEmployee(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION,"Employee Updated Successfully").show();
                loadAllEmployees();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void txtEmpSearchOnAction(ActionEvent event) {

    }
    @FXML
    void btnOnActionEmployeeSearch(ActionEvent event) {

    }


    //------------------------------------------------- Factory -------------------------------------------------------
    @FXML
    void btnFactClearOnAction(ActionEvent event) {
        clearFieldsFact();

    }
    private void clearFieldsFact() {
        txtFactID.clear();
        txtFactName.clear();
        txtFactAddress.clear();

    }

    @FXML
    void btnFactDeleteOnAction(ActionEvent event) {
        String id = txtFactID.getText();
        FactoryModel model = new FactoryModel();
        try {
            boolean isDeleted = model.deleteFactory(id);
            if (isDeleted) {
                new Alert(Alert.AlertType.CONFIRMATION,"Factory Deleted Successfully").show();
                loadAllFactories();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnFactRegisterOnAction(ActionEvent event) {
        String factIDText = txtFactID.getText();
        String username = LoginFormController.username;
        String factNameText = txtFactName.getText();
        String factAddressText = txtFactAddress.getText();
        Date dateJoined = Date.valueOf(txtFactJoinedDate.getValue());
        Date dateProduce= Date.valueOf(txtFactTimeEnd.getValue());


        FactoryModel factoryModel = new FactoryModel();
        FactoryDto dto =new FactoryDto(factIDText,username,factNameText,factAddressText,dateJoined,dateProduce);
        try {
            boolean isSaved = factoryModel.saveFactory(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION,"Factory Saved Successful").show();
                loadAllFactories();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnFactUpdateOnAction(ActionEvent event) {
        String factIDText = txtFactID.getText();
        String username = LoginFormController.username;
        String factNameText = txtFactName.getText();
        String factAddressText = txtFactAddress.getText();
        Date dateJoined = Date.valueOf(txtFactJoinedDate.getValue());
        Date dateProduce= Date.valueOf(txtFactTimeEnd.getValue());
        FactoryDto dto =new FactoryDto(factIDText,username,factNameText,factAddressText,dateJoined,dateProduce);

        FactoryModel model = new FactoryModel();

        try {
            boolean isUpdated = model.updateFactory(dto);
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION,"Factory has Updated").show();
                loadAllFactories();
            }
        } catch (SQLException e) {
             new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

    }

    @FXML
    void btnOnActionFactorySearch(ActionEvent event) {

    }

    //----------------------------------------------- Tea Producer -----------------------------------------------------

    @FXML
    void btnProducerClearOnAction(ActionEvent event) {
        txtProducerId.clear();
        txtProducerFullname.clear();
        txtProducerAddress.clear();
        txtProducerNic.clear();
        txtProducerContactNumber.clear();
    }

    @FXML
    void btnProducerDeleteOnAction(ActionEvent event) {
        String id =txtProducerId.getText();
        TeaProducerModel model = new TeaProducerModel();

        try {
            boolean isDeleted = model.deleteProducer(id);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Tea Producer has Deleted").show();
                loadAllProducers();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void btnProducerRegisterOnAction(ActionEvent event) {
        String producerIdText = txtProducerId.getText();
        String username = LoginFormController.username;
        String producerFullNameText = txtProducerFullname.getText();
        String producerAddressText = txtProducerAddress.getText();
        String producerNicText = txtProducerNic.getText();
        String producerContactNumberText = txtProducerContactNumber.getText();
        Date producerDateJoined = Date.valueOf(txtProducerJoindate.getValue());

        TeaProducerModel producerModel =new TeaProducerModel();
        TeaProducerDto dto =new TeaProducerDto(producerIdText,username,producerFullNameText,producerAddressText,producerNicText,producerContactNumberText,producerDateJoined,null);

        try {
            boolean isSaved =producerModel.saveProducer(dto);
            if (isSaved) {
                new Alert(Alert.AlertType.CONFIRMATION,"Tea Producer Register Successful").show();
                loadAllProducers();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
    @FXML
    void btnProducerUpdateOnAction(ActionEvent event) {
        String producerIdText = txtProducerId.getText();
        String username = LoginFormController.username;
        String producerFullNameText = txtProducerFullname.getText();
        String producerAddressText = txtProducerAddress.getText();
        String producerNicText = txtProducerNic.getText();
        String producerContactNumberText = txtProducerContactNumber.getText();
        Date producerJoindateValue = Date.valueOf(txtProducerJoindate.getValue());

        TeaProducerDto dto = new TeaProducerDto(producerIdText,username,producerFullNameText,producerAddressText,producerNicText,producerContactNumberText,producerJoindateValue,null);

        TeaProducerModel model =new TeaProducerModel();

        try {
            boolean isUpdated = model.updateProducer(dto);
            if (isUpdated) {
                new Alert(Alert.AlertType.CONFIRMATION,"Tea Producer Updated").show();
                loadAllProducers();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

    @FXML
    void txtProducerSearchOnAction(ActionEvent event) {

    }

    @FXML
    void btnOnActionProducerSearch(ActionEvent event) {

    }

//----------------------------------------------------------------------------------------------------------------------
    public void initialize() {
        setCellValueFactory();
        loadAllEmployees();
        loadAllFactories();
        loadAllProducers();
    }

    /*----------------------------------------------------------- Load All Tea Producer  ---------------------------------------------------------------------------------------*/
    private void loadAllProducers() {
        TeaProducerModel model =new TeaProducerModel();
        ObservableList <TeaProducerTm> obList = FXCollections.observableArrayList();
        try {
            List<TeaProducerDto> list = model.getAllProducers();
            for (TeaProducerDto dto:list) {
                TeaProducerTm teaProducerTm = new TeaProducerTm(
                        dto.getProducer_id(),
                        dto.getUser_name(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getNIC(),
                        dto.getContact_no(),
                        dto.getJoin_date(),
                        null
                );
                obList.add(teaProducerTm);
            }
            tblTeaProducer.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }

/*----------------------------------------------------------- Load All Factory  ---------------------------------------------------------------------------------------*/

    private void loadAllFactories() {
        FactoryModel model = new FactoryModel();
        ObservableList <FactoryTm> obList=FXCollections.observableArrayList();
        try {
            List<FactoryDto> list = model.getAllFactories();
            for (FactoryDto dto:list) {
                FactoryTm factoryTm = new FactoryTm(
                        dto.getFactory_id(),
                        dto.getUser_name(),
                        dto.getName(),
                        dto.getAddress(),
                        dto.getJoined_date(),
                        dto.getTime_period()
                        );
                obList.add(factoryTm);
            }
            tblFactory.setItems(obList);
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
    }
/*----------------------------------------------------------- Load All Employee  ---------------------------------------------------------------------------------------*/
    private void loadAllEmployees() {
        EmployeeModel  model = new EmployeeModel();

        ObservableList<EmployeeTm> obList = FXCollections.observableArrayList();
        try {
            List<EmployeeDto> list = model.getAllEmployees();
            for (EmployeeDto dto: list) {

                Button btn = new Button("remove");
                btn.setCursor(Cursor.HAND);

                btn.setOnAction((e) -> {
                    ButtonType yes = new ButtonType("yes", ButtonBar.ButtonData.OK_DONE);
                    ButtonType no = new ButtonType("no", ButtonBar.ButtonData.CANCEL_CLOSE);

                    Optional<ButtonType> type = new Alert(Alert.AlertType.INFORMATION, "Are you sure to remove?", yes, no).showAndWait();

                    if(type.orElse(no) == yes) {
                        int selectedIndex = tblEmployee.getSelectionModel().getSelectedIndex();
                        ActionEvent code = (ActionEvent) colEmpAction.getCellData(selectedIndex);

                        btnEmpDeleteOnAction(code);   //delete item from the database

                        obList.remove(selectedIndex);   //delete item from the JFX-Table
                        tblEmployee.refresh();
                    }
                });

                EmployeeTm employeeTm =new EmployeeTm(
                        dto.getEmp_id(),
                        dto.getUser_name(),
                        dto.getFirst_name(),
                        dto.getLast_name(),
                        dto.getAddress(),
                        dto.getContact_no(),
                        dto.getJob_role(),
                        dto.getBasic_Pay(),
                        btn
                );
                obList.add(employeeTm);

            }

            tblEmployee.setItems(obList);

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }
//----------------------------------------------------------------------------------------------------------------------------
    private void setCellValueFactory() {

        colEmpID.setCellValueFactory(new PropertyValueFactory<>("Emp_id"));
        colEmpFirstName.setCellValueFactory(new PropertyValueFactory<>("First_name"));
        colEmpLastName.setCellValueFactory(new PropertyValueFactory<>("Last_name"));
        colEmpAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colEmpContactNumber.setCellValueFactory(new PropertyValueFactory<>("Contact_no"));
        colEmpJobRole.setCellValueFactory(new PropertyValueFactory<>("Job_role"));
        colEmpUserName.setCellValueFactory(new PropertyValueFactory<>("User_name"));
        colEmpBasicPayment.setCellValueFactory(new PropertyValueFactory<>("Basic_Pay"));
        System.out.println("methana yako 319");
        // -----------factory----------------------
        colFactoryId.setCellValueFactory(new PropertyValueFactory<>("Factory_id"));
        colFactoryName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colFactoryAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colFactoryJoinedDate.setCellValueFactory(new PropertyValueFactory<>("Joined_date"));
        colFactoryTimeEndDate.setCellValueFactory(new PropertyValueFactory<>("Time_period"));
        System.out.println("methana yako 327");
        // ------------ TeaProducer ------------------
        colProducerId.setCellValueFactory(new PropertyValueFactory<>("Producer_id"));
        colProducerFullname.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colProducerAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colProducerNIC.setCellValueFactory(new PropertyValueFactory<>("NIC"));
        colProdecerContactNumber.setCellValueFactory(new PropertyValueFactory<>("Contact_no"));
        colProducerjoindate.setCellValueFactory(new PropertyValueFactory<>("Join_date"));

    }
}


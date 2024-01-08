package lk.ijse.tea.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import lk.ijse.tea.db.DbConnection;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.SQLException;
import java.util.HashMap;

public class ReportFormController {

    @FXML
    void btnPaymentReport(ActionEvent event) throws JRException, SQLException {

        InputStream resourceAsStream = getClass().getResourceAsStream("/reports/PaymentReport.jrxml");
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport,
                null,
                DbConnection.getInstance().getConnection()
        );
        JasperViewer.viewReport(
                jasperPrint,
                false
        );

        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "C:\\Users\\User\\Documents\\Jasper PDF PRINT\\PaymentReport.pdf"
        );
    }

    @FXML
    void btnSalaryReport(ActionEvent event) throws JRException, SQLException {

        InputStream resourceAsStream = getClass().getResourceAsStream("/reports/SallaryReport.jrxml");
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport,
                null,
                DbConnection.getInstance().getConnection()
        );
        JasperViewer.viewReport(
                jasperPrint,
                false
        );

        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "C:\\Users\\User\\Documents\\Jasper PDF PRINT\\SalaryReport.pdf"
        );
    }

    @FXML
    void btnTeaReport(ActionEvent event) throws JRException, SQLException {

        InputStream resourceAsStream = getClass().getResourceAsStream("/reports/TeaReport.jrxml");
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport,
                null,
                DbConnection.getInstance().getConnection()
        );
        JasperViewer.viewReport(
                jasperPrint,
                false
        );

        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "C:\\Users\\User\\Documents\\Jasper PDF PRINT\\TeaReport.pdf"
        );

        /*
        //if you want to add values to rhe Report without using Database we can use Hashmap
        HashMap map = new HashMap<>();
        map.put("T_id","T001");

        InputStream resourceAsStream = getClass().getResourceAsStream(
                "/reports/TeaReport.jrxml"
        );
        JasperDesign load = JRXmlLoader.load(resourceAsStream);
        JasperReport jasperReport = JasperCompileManager.compileReport(load);
        JasperPrint jasperPrint = JasperFillManager.fillReport(
                jasperReport,
                map,
                new JREmptyDataSource()
        );
        JasperViewer.viewReport(
                jasperPrint,
                false
        );

        JasperExportManager.exportReportToPdfFile(jasperPrint,
                "C:\\Users\\User\\Documents\\Jasper PDF PRINT\\TeaReport.pdf"
        );*/

    }
}

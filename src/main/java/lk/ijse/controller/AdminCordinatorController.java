package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminCordinatorController implements Initializable {

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private Button btnpay;
    @FXML
    private Button addbtn;

    @FXML
    private Button back;

    @FXML
    private Button btnregister;

    @FXML
    private Label cordinatorCount;


    @FXML
    private Label studentCount;


    @FXML
    private Label CourseCount;

    UserBo userBo = (UserBo) BoFactory.getBoFactory().getBo(BoTypes.User);

    StudentBo studentBo = (StudentBo) BoFactory.getBoFactory().getBo(BoTypes.Student);

    CourseBo courseBo = (CourseBo) BoFactory.getBoFactory().getBo(BoTypes.Course);

    @FXML
    void addstudentbtn(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/CoStudent.fxml"));
        Scene scene1 = new Scene(root);
        Stage stage1 = (Stage) addbtn.getScene().getWindow();
        stage1.setScene(scene1);
        stage1.setTitle("Courses Form");
        stage1.centerOnScreen();
    }

    @FXML
    void backonaction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/LoginPage.fxml"));
        Scene scene1 = new Scene(root);
        Stage stage1 = (Stage) back.getScene().getWindow();
        stage1.setScene(scene1);
        stage1.setTitle("Courses Form");
        stage1.centerOnScreen();
    }

    @FXML
    void registeraction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/coregisterform.fxml"));
        Scene scene1 = new Scene(root);
        Stage stage1 = (Stage) btnregister.getScene().getWindow();
        stage1.setScene(scene1);
        stage1.setTitle("Courses Form");
        stage1.centerOnScreen();

    }


    @FXML
    public void paymentaction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/paymentForCordinator.fxml"));
        Scene scene1 = new Scene(root);
        Stage stage1 = (Stage) btnpay.getScene().getWindow();
        stage1.setScene(scene1);
        stage1.setTitle("Courses Form");
        stage1.centerOnScreen();
    }

    private void getUserCount() {
        int count = userBo.getUserCountByRole("Coordinator");
        cordinatorCount.setText(String.valueOf(count));
    }

    private void getStudentCount() {
        int count = studentBo.getStudentCount();
        studentCount.setText(String.valueOf(count));
    }
    private void getCourseCount() {
        int courseCount = courseBo.getCourseCount();
        CourseCount.setText(String.valueOf(courseCount));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getUserCount();
        getStudentCount();
        getCourseCount();
    }
}

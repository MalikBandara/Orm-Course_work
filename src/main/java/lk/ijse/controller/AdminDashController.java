package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminDashController  implements Initializable {

    @FXML
    private Button logout;

    @FXML
    private Label title2;
    @FXML
    private AnchorPane CourseCountPane;

    @FXML
    private AnchorPane MainPain;

    @FXML
    private AnchorPane StudentCountPane;

    @FXML
    private AnchorPane UserCountPane;

    @FXML
    private Button coursebtn;

    @FXML
    private Button registrationbtn;

    @FXML
    private AnchorPane slidePane;

    @FXML
    private Button paymentbtn;


    @FXML
    private Button stbtn;

    @FXML
    private Button userbtn;

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
    void StudentOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/StudentForm.fxml"));
        Scene scene1 = new Scene(root);
        Stage stage1 = (Stage) stbtn.getScene().getWindow();
        stage1.setScene(scene1);
        stage1.setTitle("Student Form");
        stage1.centerOnScreen();

    }

    @FXML
    void coursesOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/CoursesForm.fxml"));
        Scene scene1 = new Scene(root);
        Stage stage1 = (Stage) coursebtn.getScene().getWindow();
        stage1.setScene(scene1);
        stage1.setTitle("Courses Form");
        stage1.centerOnScreen();
    }

    @FXML
    void registrationOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/RegistrationUI.fxml"));
        Scene scene1 = new Scene(root);
        Stage stage1 = (Stage) registrationbtn.getScene().getWindow();
        stage1.setScene(scene1);
        stage1.setTitle("Registration Form");
        stage1.centerOnScreen();
    }

    @FXML
    void usersOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/UserRegisterForm.fxml"));
        Scene scene1 = new Scene(root);
        Stage stage1 = (Stage) userbtn.getScene().getWindow();
        stage1.setScene(scene1);
        stage1.setTitle("User Form");
        stage1.centerOnScreen();

    }

    public void logoutOnClick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/LoginPage.fxml"));
        Scene scene1 = new Scene(root);
        Stage stage1 = (Stage) logout.getScene().getWindow();
        stage1.setScene(scene1);
        stage1.setTitle("Login  Form");
        stage1.centerOnScreen();
    }

    public void btnpaymentclick(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/paymentForm.fxml"));
        Scene scene1 = new Scene(root);
        Stage stage1 = (Stage) paymentbtn.getScene().getWindow();
        stage1.setScene(scene1);
        stage1.setTitle("Payment Form");
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




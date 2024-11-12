package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.BoTypes;
import lk.ijse.bo.StudentBo;
import lk.ijse.dto.StudentDTO;
import lk.ijse.dto.tm.StudentTm;
import lk.ijse.dto.tm.StudentTm2;
import lk.ijse.entity.Student;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AllStudentWhoRegisterCourse implements Initializable {

    @FXML
    private Button btnback;

    @FXML
    private Button btnback1;

    @FXML
    private TableColumn<StudentTm2, String> colName;

    @FXML
    private TableColumn<StudentTm2, String> colcordinator;

    @FXML
    private TableColumn<StudentTm2, String> colid;

    @FXML
    private TableView<StudentTm2> tblStudent;

    StudentBo studentBo = (StudentBo) BoFactory.getBoFactory().getBo(BoTypes.Student);

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/AdminDash.fxml"));
        Scene scene1 = new Scene(root);
        Stage stage1 = (Stage) btnback.getScene().getWindow();
        stage1.setScene(scene1);
        stage1.setTitle("All Student Who registered for all courses Form");
        stage1.centerOnScreen();
    }


    private void LoadStudents() {


        try {
            tblStudent.getItems().clear();
            List<Student> allStudentWhoAll = studentBo.getAllStudentWhoAll();

            System.out.println(allStudentWhoAll.size());

            for (Student student : allStudentWhoAll) {
                StudentTm2 studentTm2 = new StudentTm2(student.getStudentId(), student.getStudentName(), student.getUserid());
                tblStudent.getItems().add(studentTm2);

            }



        } catch (Exception e) {
            e.printStackTrace();
            showAlert("Error", "Failed to load student table.", Alert.AlertType.ERROR);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            LoadStudents();
            setCellValueFactory();
    }

    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    private void setCellValueFactory() {
        colid.setCellValueFactory(new PropertyValueFactory<>("studentId"));
        colName.setCellValueFactory(new PropertyValueFactory<>("studentName"));
        colcordinator.setCellValueFactory(new PropertyValueFactory<>("userid"));


    }
}

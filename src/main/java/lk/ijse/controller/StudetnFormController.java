package lk.ijse.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.BoTypes;
import lk.ijse.bo.StudentBo;
import lk.ijse.config.SessionFactoryConfuguration;
import lk.ijse.dto.StudentDTO;
import lk.ijse.entity.Student;
import lk.ijse.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class StudetnFormController implements Initializable {

    @FXML
    private TextField studentId;

    @FXML
    private TextField studentName;

    @FXML
    private TextField Email;

    @FXML
    private TextField address;

    @FXML
    private AnchorPane anchorpane;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> coladdress;

    @FXML
    private TableColumn<?, ?> colcontact;

    @FXML
    private TableColumn<?, ?> colemail;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private ComboBox<User> cmbCoId; // Change to hold User objects

    @FXML
    private TextField contact;

    @FXML
    private TableView<?> tblStudent;

    StudentBo studentBo = (StudentBo) BoFactory.getBoFactory().getBo(BoTypes.Student);

    @FXML
    void SaveOnAction(ActionEvent event) {
        // Validate input fields
        int studentId = validateStudentId();
        if (studentId == -1) return; // Validation failed

        String studentName = this.studentName.getText();
        String address = this.address.getText();
        String contact = this.contact.getText();
        String email = this.Email.getText();

        User selectedCoordinator = this.cmbCoId.getSelectionModel().getSelectedItem();

        if (selectedCoordinator == null) {
            System.out.println("Please select a coordinator.");
            return;
        }

        // Create a new Student instance
        StudentDTO studentDTO = new StudentDTO(studentId, studentName, address, contact, email, selectedCoordinator);
        boolean b = studentBo.addStudent(studentDTO);

        if (b==true){
            System.out.println("Student added successfully 2 .");
        }
        else {
            System.out.println("Student addition failed.");
        }


        // Initialize Hibernate session and transaction

    }

    private int validateStudentId() {
        String studentIdText = this.studentId.getText();
        if (studentIdText.isEmpty()) {
            System.out.println("Student ID cannot be empty.");
            return -1;
        }

        try {
            return Integer.parseInt(studentIdText);
        } catch (NumberFormatException e) {
            System.out.println("Invalid Student ID. Please enter a valid number.");
            return -1;
        }
    }





    @FXML
    void btnBackOnAction(ActionEvent event) {
        // Implement back action
    }

    @FXML
    void clearOnAction(ActionEvent event) {
        // Implement clear form action
    }

    @FXML
    void deleteOnAction(ActionEvent event) {
        // Implement delete action
    }

    @FXML
    void searchOnAction(ActionEvent event) {
        // Implement search action
    }

    @FXML
    void updateOnAction(ActionEvent event) {
        // Implement update action
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbCordinator();
    }

    private void cmbCordinator() {
        List<User> users = studentBo.getUserIds(); // Adjust this method to return List<User>
        cmbCoId.getItems().addAll(users);
    }
}

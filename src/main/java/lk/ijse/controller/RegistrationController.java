package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.BoTypes;
import lk.ijse.bo.RegistrationBo;
import lk.ijse.dto.RegistrationDTO;
import lk.ijse.entity.Courses;
import lk.ijse.entity.Registration;
import lk.ijse.entity.Student;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class RegistrationController implements Initializable {

    @FXML
    private ComboBox<Courses> cmbcourseid;

    @FXML
    private ComboBox<Student> cmbstudentid;

    @FXML
    private TableColumn<?, ?> coladvanced;

    @FXML
    private TableColumn<?, ?> colcourseid;

    @FXML
    private TableColumn<?, ?> coldate;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colstudent;

    @FXML
    private DatePicker datapicker;

    @FXML
    private TextField payment;

    @FXML
    private TextField registrationid;

    @FXML
    private TableView<?> tblregistration;

    RegistrationBo registrationBo = (RegistrationBo) BoFactory.getBoFactory().getBo(BoTypes.Registration);

    @FXML
    void btnbackonaction(ActionEvent event) {

    }

//    @FXML
//    void btnsaveaction(ActionEvent event) {
//
//        String regId = registrationid.getText();
//        double payment = Double.parseDouble(this.payment.getText());
//        LocalDate selectedDate = datapicker.getValue();
//        Courses course = cmbcourseid.getSelectionModel().getSelectedItem();  // assuming this gives a Courses object
//        Student student = cmbstudentid.getSelectionModel().getSelectedItem();  // assuming this gives a Student object
//        RegistrationDTO registrationDTO = new RegistrationDTO(regId, payment, selectedDate, course, student);
//        System.out.println("DTO created: " + registrationDTO);
//        boolean b = registrationBo.saveRegistration(registrationDTO);
//        if (b){
//            System.out.println("Registration saved");
//        }
//    }

    @FXML
    void btnsaveaction(ActionEvent event) {
        try {
            String regId = registrationid.getText();
            double payment = Double.parseDouble(this.payment.getText());
            LocalDate selectedDate = datapicker.getValue();

            // Check if course and student are selected
            Courses course = cmbcourseid.getSelectionModel().getSelectedItem();
            Student student = cmbstudentid.getSelectionModel().getSelectedItem();

            if (course == null) {
                showAlert("Error", "Please select a course.");
                return;
            }

            if (student == null) {
                showAlert("Error", "Please select a student.");
                return;
            }

            RegistrationDTO registrationDTO = new RegistrationDTO(regId, payment, selectedDate, course, student);
            System.out.println("DTO created: " + registrationDTO);

            boolean b = registrationBo.saveRegistration(registrationDTO);
            if (b) {
                System.out.println("Registration saved");
                showAlert("Success", "Registration saved successfully.");
            } else {
                showAlert("Error", "Failed to save registration.");
            }

        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid payment amount. Please enter a valid number.");
        } catch (Exception e) {
            showAlert("Error", "An unexpected error occurred: " + e.getMessage());
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }


    @FXML
    void clearaction(ActionEvent event) {
        registrationid.setText("");
        payment.setText("");
        datapicker.setValue(null);


    }

    @FXML
    void deleteaction(ActionEvent event) {
        String id = registrationid.getText();


        if (id.isEmpty()) {
            showAlert("Error", "Please enter a registration ID to delete.");
            return;
        }


        boolean success = registrationBo.deleteRegistration(id);

        if (success) {
            showAlert("Success", "Registration with ID: " + id + " has been successfully deleted.");

            clearaction(event);
        } else {
            showAlert("Error", "Failed to delete the registration. Please check the ID and try again.");
        }
    }


    @FXML
    void searchaction(ActionEvent event) {
        String id = registrationid.getText();

        // Check if the ID field is empty
        if (id.isEmpty()) {
            showAlert("Error", "Please enter a registration ID to search.");
            return; // Exit if the ID is empty
        }

        // Attempt to find the registration based on the ID
        RegistrationDTO registrationDTO = registrationBo.searchRegistrations(id);

        if (registrationDTO != null) {
            // Populate fields with the found registration details
            this.registrationid.setText(String.valueOf(registrationDTO.getRegistrationId()));
            this.payment.setText(String.valueOf(registrationDTO.getAdvanced()));
            this.datapicker.setValue(registrationDTO.getDate());

            // Set the selected course and student in the combo boxes
            cmbcourseid.getSelectionModel().select(registrationDTO.getCourses());
            cmbstudentid.getSelectionModel().select(registrationDTO.getStudent());

            System.out.println("Registration found: " + registrationDTO);
        } else {
            // Show an error alert if the registration is not found
            showAlert("Error", "Registration not found for ID: " + id);
        }
    }



    @FXML
    void updateonaction(ActionEvent event) {


    }

    private void cmbCourseId(){
        List<Courses> courseId = registrationBo.getCourseId();
        cmbcourseid.getItems().addAll(courseId);


    }

    private void cmbStudentId(){
        List<Student> studentId = registrationBo.getStudentId();
        cmbstudentid.getItems().addAll(studentId);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbCourseId();
        cmbStudentId();
    }
}

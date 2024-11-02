package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.BoTypes;
import lk.ijse.bo.CourseBo;
import lk.ijse.dto.CoursesDTO;

import java.util.Date;



public class CourseFormController {

    @FXML
    private TableColumn<?, ?> colPrice;

    @FXML
    private TableColumn<?, ?> colid;

    @FXML
    private TableColumn<?, ?> colname;

    @FXML
    private TextField courseId;

    @FXML
    private TextField courseName;

    @FXML
    private TextField coursePrice;

    @FXML
    private TextField duaration;

    @FXML
    private TableColumn<?, ?> duration;

    @FXML
    private TableView<?> tblcourse;

    CourseBo courseBo = (CourseBo) BoFactory.getBoFactory().getBo(BoTypes.Course);

    @FXML
    void clearOnAction(ActionEvent event) {

    }

    @FXML
    void deleteonaction(ActionEvent event) {

    }

    @FXML
    void saveOnAction(ActionEvent event) {
        try {
            String courseId = this.courseId.getText();
            String courseName = this.courseName.getText();
            double coursePrice = Double.parseDouble(this.coursePrice.getText());
            String duration = this.duration.getText(); // Fixed typo from 'duaration' to 'duration'

            CoursesDTO coursesDTO = new CoursesDTO(courseId, courseName, duration, coursePrice);

            boolean isSaved = courseBo.saveCourses(coursesDTO);

            if (isSaved) {
                showAlert("Save", "Course saved successfully.", Alert.AlertType.INFORMATION);
            } else {
                showAlert("Save", "Course save failed.", Alert.AlertType.ERROR);
            }

        } catch (NumberFormatException e) {
            showAlert("Error", "Invalid input for course price. Please enter a valid number.", Alert.AlertType.ERROR);
        } catch (Exception e) {
            showAlert("Error", "An unexpected error occurred: " + e.getMessage(), Alert.AlertType.ERROR);

        }
    }


    @FXML
    void searchOnAction(ActionEvent event) {


    }

    @FXML
    void updateOnAction(ActionEvent event) {

    }
    private void showAlert(String title, String message, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

}

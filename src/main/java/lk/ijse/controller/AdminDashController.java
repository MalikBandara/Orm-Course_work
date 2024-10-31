package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class AdminDashController {

    @FXML
    private AnchorPane courseclickpane;



    @FXML
    private AnchorPane userclickpane;

    @FXML
    private AnchorPane slidePane;

    @FXML
    private AnchorPane CourseCountPane;

    @FXML
    private AnchorPane StudentCountPane;

    @FXML
    private AnchorPane UserCountPane;

    @FXML
    private AnchorPane MainPain;

    @FXML
    private Button studenclickpane;


    public void StudentOnClick(ActionEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/StudentForm.fxml"));
        Scene scene1 = new Scene(root);
        Stage stage1 = (Stage) studenclickpane.getScene().getWindow();
        stage1.setScene(scene1);
        stage1.setTitle("Dashboard Form");
        stage1.centerOnScreen();

    }

    public void coursesOnClick(MouseEvent mouseEvent) {

    }

    public void UsersOnClick(MouseEvent mouseEvent) {

    }
}

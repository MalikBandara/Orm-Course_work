package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.BoTypes;
import lk.ijse.bo.UserBo;
import lk.ijse.dto.UserDTO;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class UserRegisterController implements Initializable {

    @FXML
    private ComboBox<String> cmbrole;

    @FXML
    private TableColumn<?, ?> colpass;

    @FXML
    private TableColumn<?, ?> colrole;

    @FXML
    private TableColumn<?, ?> colusername;

    @FXML
    private TextField password;

    @FXML
    private TableView<?> tbluser;

    @FXML
    private TextField username;

    UserBo userBo = (UserBo) BoFactory.getBoFactory().getBo(BoTypes.User);

    @FXML
    void clearaction(ActionEvent event) {
        username.setText("");
        password.setText("");


    }

    @FXML
    void deleteaction(ActionEvent event) {
        String username = this.username.getText();

        boolean isDeleted = userBo.deleteUser(username);

        // Show alert based on the delete result
        Alert alert = new Alert(isDeleted ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
        alert.setTitle(isDeleted ? "Delete Successful" : "Delete Failed");
        alert.setHeaderText(null);
        alert.setContentText(isDeleted ? "User deleted successfully!" : "Failed to delete the user.");
        alert.showAndWait();
    }



    @FXML
    void saveaction(ActionEvent event) {
        String username = this.username.getText();
        String password = this.password.getText();
        cmbrole.setValue("Coordinator");

        UserDTO coordinator = new UserDTO(username, password, "Coordinator");

        // Attempt to save the user
        boolean isSaved = userBo.saveUsers(coordinator);

        // Show alert based on the save result
        Alert alert = new Alert(isSaved ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
        alert.setTitle(isSaved ? "Success" : "Error");
        alert.setHeaderText(null);
        alert.setContentText(isSaved ? "User saved successfully!" : "Failed to save the user.");
        alert.showAndWait();
    }


    @FXML
    void searchaction(ActionEvent event) {
        String username = this.username.getText();

        UserDTO userDTO = userBo.searchUsers(username);

        this.username.setText(userDTO.getUsername());
        this.password.setText(userDTO.getPassword());
        this.cmbrole.setValue("Coordinator");


    }



    @FXML
    void updateaction(ActionEvent event) {
        String username = this.username.getText();
        String password = this.password.getText();
        cmbrole.setValue("Coordinator");

        UserDTO coordinator = new UserDTO(username, password, "Coordinator");

        // Attempt to update the user
        boolean isUpdated = userBo.updateUser(coordinator);

        // Show alert based on the update result
        Alert alert = new Alert(isUpdated ? Alert.AlertType.INFORMATION : Alert.AlertType.ERROR);
        alert.setTitle(isUpdated ? "Update Successful" : "Update Failed");
        alert.setHeaderText(null);
        alert.setContentText(isUpdated ? "User updated successfully!" : "Failed to update the user.");
        alert.showAndWait();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbrole.getItems().addAll("Coordinator"); // Example roles
    }
}

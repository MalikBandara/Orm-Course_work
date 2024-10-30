package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BoFactory;
import lk.ijse.bo.BoTypes;
import lk.ijse.bo.UserBo;
import lk.ijse.config.SessionFactoryConfuguration;
import lk.ijse.dto.UserDTO;
import lk.ijse.entity.User;
import javafx.fxml.Initializable;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import java.util.List;

public class LoginFormController implements Initializable {

    @FXML
    private AnchorPane Anchor;

    @FXML
    private AnchorPane ChildPane;

    @FXML
    private TextField UserName;

    @FXML
    private ComboBox<String> cmbAdmin;

    @FXML
    private PasswordField passward;

    UserBo userBo = (UserBo) BoFactory.getBoFactory().getBo(BoTypes.User);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadRolesIntoComboBox();
    }

    private void loadRolesIntoComboBox() {
        List<String> roles = userBo.getAllRoles(); // Get roles from BO
        cmbAdmin.getItems().addAll(roles); // Add roles to ComboBox
    }

//    public void btnLoginOnAction(ActionEvent event) {
//        try {
//            String role = cmbAdmin.getValue();
//            String password = passward.getText();
//            String username = UserName.getText();
//
//            Session session = SessionFactoryConfuguration.getSessionFactoryConfuguration().getSession();
//            Transaction tx = session.beginTransaction();
//
//            Query query = session.createQuery("from User where username = :username and password = :password");
//            query.setParameter("username", username);
//            query.setParameter("password", password);
//            List<UserDTO> list = query.list(); // Assuming 'User' is your entity class representing the users table
//
//            if (!list.isEmpty()) {
//                UserDTO user = list.get(0);
//
//                if (user.getRole().equalsIgnoreCase(role)) {
//                    String fxmlFile = "";
//
//                    if ("Admin".equalsIgnoreCase(role)) {
//                        fxmlFile = "/AdminDash.fxml";
//                    } else if ("Cordinator".equalsIgnoreCase(role)) {
//                        fxmlFile = "/AdminCordinator.fxml";
//                    } else {
//                        Alert alert = new Alert(Alert.AlertType.WARNING);
//                        alert.setContentText("Role not recognized.");
//                        alert.showAndWait();
//                        return;
//                    }
//
//                    Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
//                    Scene scene = new Scene(root);
//                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                    stage.setScene(scene);
//                    stage.show();
//                } else {
//                    Alert alert = new Alert(Alert.AlertType.ERROR);
//                    alert.setContentText("Role does not match the selected option.");
//                    alert.showAndWait();
//                }
//            } else {
//                Alert alert = new Alert(Alert.AlertType.ERROR);
//                alert.setContentText("Invalid username or password.");
//                alert.showAndWait();
//            }
//
//            tx.commit();
//            session.close();
//        } catch (Exception e) {
//            Alert alert = new Alert(Alert.AlertType.ERROR);
//            alert.setContentText("Error fetching users.");
//            alert.showAndWait();
//            e.printStackTrace();
//        }
//    }




    public void btnLoginOnAction(ActionEvent event) {
        String role = cmbAdmin.getValue(); // Get the selected role from the ComboBox
        String password = passward.getText(); // Get the entered password
        String username = UserName.getText(); // Get the entered username

        UserDTO userDTO = new UserDTO(role, username, password);
        List<UserDTO> userList = new ArrayList<>();

        userList = userBo.getUserDetails(userDTO);

        System.out.println("hi" + userList);

        if(role.equals("Admin")) {

        }
    }

    // Utility method to show alerts







}

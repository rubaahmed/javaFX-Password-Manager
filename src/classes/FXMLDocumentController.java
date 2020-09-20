package classes;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import passwordmanager1.Connect;

public class FXMLDocumentController implements Initializable {

    @FXML
    private VBox vBOX;

    @FXML
    private JFXSnackbar snackbar;

    @FXML
    private JFXTextField Username;

    @FXML
    private JFXPasswordField Password;

    @FXML
    void Here(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/views/Question.fxml"));
        Scene scene = new Scene(root);
        stage.setScene((scene));
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.setResizable(false);
        stage.showAndWait();

    }

    @FXML
    void loginbutton(ActionEvent event) throws IOException, SQLException {
//        String mailReg = "\\w{4,32}@(hot|g)mail\\.com";

        EventHandler handler = (EventHandler) (Event event1) -> {
            snackbar.close();
        };
        if (Password.getText().isEmpty() && Username.getText().isEmpty()) {
            snackbar.show("Username and Password field are empty", "OK", 5000, handler);

        } else if (Username.getText().isEmpty()) {
            snackbar.show("Username field is empty", "OK", 5000, handler);
        } else if (Password.getText().isEmpty()) {
            snackbar.show("Password field is empty", "OK", 5000, handler);
        } else {
            ArrayList<webdata> registers = Register1Controller.fetchRegister();
            for (webdata a : registers) {
                if (Username.getText().equals(a.getUsername()) && Password.getText().equals(a.getPassword())) {
                    Parent root = FXMLLoader.load(getClass().getResource("/views/website password.fxml"));
                    Scene scene = new Scene(root);
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.show();

                    logindata();
                } else {
                    snackbar.show("Username or Password is incorrect", "OK", 5000, handler);
                }
            }

        }

    }

    private void logindata() {
        String query = "INSERT INTO login (Username ,Password ) "
                + "VALUES(?,?)";
        Connection conn = Connect.connect();
        try {
            PreparedStatement pa = (PreparedStatement) conn.prepareStatement(query);
            pa.setString(1, Username.getText());
            pa.setString(2, Password.getText());
            pa.executeUpdate();
            pa.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
            System.out.println("Adddeddddddddddddd");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @FXML
    void regisretbutton(ActionEvent event) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("/views/register1.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        snackbar = new JFXSnackbar(vBOX);

    }
}

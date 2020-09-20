/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXSnackbar;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import passwordmanager1.Connect;

/**
 * FXML Controller class
 *
 * @author reham
 */
public class Register1Controller implements Initializable {

    @FXML
    private JFXTextField Username;

    @FXML
    private JFXPasswordField Password;

    @FXML
    private JFXPasswordField Password1;

    @FXML
    private JFXTextField qusetion;

    @FXML
    private JFXTextField answer;

    @FXML
    private HBox v;

    @FXML
    private JFXSnackbar errorMsg2;

    @FXML
    void handelbutton(ActionEvent event) throws IOException {
        EventHandler handler = (EventHandler) new EventHandler() {
            @Override
            public void handle(Event event1) {
                errorMsg2.close();
            }
        };
        if (Password.getText().isEmpty()) {
            errorMsg2.show("Password field is empty", "OK", 5000, handler);
        } else if (Username.getText().isEmpty()) {
            errorMsg2.show("Username field is empty", "OK", 5000, handler);
        } else if (Password1.getText().isEmpty()) {
            errorMsg2.show("Password field is empty", "OK", 5000, handler);
        } else if (!Password.getText().equals(Password1.getText())) {
            errorMsg2.show("Password doesnt match", "OK", 5000, handler);
        } else if (qusetion.getText().isEmpty()) {
            errorMsg2.show("qusetion field is empty", "OK", 5000, handler);
        } else if (answer.getText().isEmpty()) {
            errorMsg2.show("answer field is empty", "OK", 5000, handler);
        } else {
            registerdata();
            Parent root = FXMLLoader.load(getClass().getResource("/views/FXMLDocument.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        }

    }

    private void registerdata() {
        String query = "INSERT INTO register (Username ,Password ,Password1,qusetion,answer) "
                + "VALUES(?,?,?,?,?)";
        Connection conn = Connect.connect();
        try {
            conn.setAutoCommit(false);
            PreparedStatement pa = (PreparedStatement) conn.prepareStatement(query);
            pa.setString(1, Username.getText());
            pa.setString(2, Password.getText());
            pa.setString(3, Password1.getText());
            pa.setString(4, qusetion.getText());
            pa.setString(5, answer.getText());
            pa.executeUpdate();
            pa.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
            System.out.println("Adddeddddddddddddd");
        } catch (SQLException e) {
            System.out.println(e);
        }

    }
    static ArrayList<webdata> fetchRegister() throws SQLException {
        String query = "SELECT * FROM register";
        Connection conn = Connect.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        ArrayList<webdata> list4 = new ArrayList();
        while (rs.next()) {
            String Username = rs.getString("Username");
            String Password = rs.getString("Password");
            webdata r = new webdata(Username, Password);
            list4.add(r);
        
        }
        return list4;
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        errorMsg2 = new JFXSnackbar(v);
    }

//    @FXML
//    void addSecurity(ActionEvent event) throws IOException {
//        Stage stage = new Stage();
//        stage.initModality(Modality.APPLICATION_MODAL);
//        Parent root = FXMLLoader.load(getClass().getResource("/views/Question.fxml"));
//        Scene scene = new Scene(root);
//        stage.setScene((scene));
//        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
//        stage.showAndWait();
//
//    }
}
//EventHandler handler =new EventHandler() {
//            @Override
//            public void handle(Event event) {
//               errorMsg2.close();
//            }
//          
//        };
//       if (question.getText().isEmpty()) {
//            errorMsg2.show("the qusetion field is empty", "OK", 5000, handler);
//        } else if (answer.getText().isEmpty()) {
//            errorMsg2.show("the answer field is empty", "OK", 5000, handler);
//        }

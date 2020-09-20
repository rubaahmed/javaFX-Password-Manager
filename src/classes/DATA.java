/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.Pane;
import passwordmanager1.Connect;

/**
 *
 * @author reham
 */
public class DATA implements Initializable {

    @FXML
    private JFXButton otherInfo1;

    @FXML
    private JFXButton passwordwebsite1;

    @FXML
    private JFXButton bankaccount1;

    @FXML
    private Pane INFO1;

    @FXML
    private JFXTextField nameInfo;

    @FXML
    private JFXPasswordField pass_hidden;

    @FXML
    private CheckBox pass_toggle;

    @FXML
    private JFXTextField pass_text;

    @FXML
    private JFXTextField pass_text1;

    @FXML
    private JFXPasswordField pass_hidden1;

    @FXML
    private CheckBox pass_toggle1;

    @FXML
    private Pane BANK1;

    @FXML
    private JFXTextField bankName;

    @FXML
    private JFXTextField securityCode;

    @FXML
    private JFXTextField CVV;

    @FXML
    private JFXTextField cardNumber;

    @FXML
    private JFXTextField AccountHolder;

    @FXML
    private Pane WEBSITE1;

    @FXML
    private JFXTextField userName;

    @FXML
    private JFXTextField passwordGenerator;

    @FXML
    private JFXTextField passwordGenerator1;

    @FXML
    private JFXPasswordField passwordGeneratorhidden1;
    @FXML
    private JFXTextField category;

    @FXML
    private JFXTextField website;

    @FXML
    private CheckBox pass_Toggle;
    
    @FXML
    private JFXPasswordField passwordGeneratorhidden;
    
    @FXML
    private CheckBox pass_ToggleQ;

    @FXML
    void addDataInfo(ActionEvent event) throws SQLException {
        adddataInfo();
    }

    @FXML
    void AddBank(ActionEvent event) {
        addBank();
    }

    @FXML
    void addWebsite(ActionEvent event) {
        addWebsite();
    }

    private void addWebsite() {
        String query = "INSERT INTO Website (username ,passwordweb ,website,category,passwordGenerator) "
                + "VALUES(?,?,?,?,?)";
        Connection conn = Connect.connect();
        try {
            conn.setAutoCommit(false);
            PreparedStatement pa = (PreparedStatement) conn.prepareStatement(query);
            pa.setString(1, userName.getText());
            pa.setString(2, passwordGeneratorhidden1.getText());
            pa.setString(3, website.getText());
            pa.setString(4, category.getText());
            pa.setString(5, passwordGeneratorhidden.getText());
            pa.executeUpdate();
            pa.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
            System.out.println("Adddeddddddddddddd");
            pa.close();

        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    private void addBank() {
        String query = "INSERT INTO Bank (bankName ,AccountHolder ,cardNumber,CVV,securityCode) "
                + "VALUES(?,?,?,?,?)";
        Connection conn = Connect.connect();
        try {
            conn.setAutoCommit(false);
            PreparedStatement pa = (PreparedStatement) conn.prepareStatement(query);
            pa.setString(1, bankName.getText());
            pa.setString(2, AccountHolder.getText());
            pa.setString(3, cardNumber.getText());
            pa.setString(4, CVV.getText());
            pa.setString(5, securityCode.getText());
            pa.executeUpdate();
            pa.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
            System.out.println("Adddeddddddddddddd");
            pa.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    private void adddataInfo() {
        String query = "INSERT INTO infoTable (Name ,Password ,PasswordGenerator) "
                + "VALUES(?,?,?)";
        Connection conn = Connect.connect();
        try {
            conn.setAutoCommit(false);
            PreparedStatement pa = (PreparedStatement) conn.prepareStatement(query);
            pa.setString(1, nameInfo.getText());
            pa.setString(2, pass_hidden.getText());
            pa.setString(3, pass_hidden1.getText());
            pa.executeUpdate();
            pa.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
            System.out.println("Adddeddddddddddddd");
            pa.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @FXML
    public void togglevisiblePassword(ActionEvent event) {
        if (pass_toggle.isSelected()) {
            pass_text.setText(pass_hidden.getText());
            pass_text.setVisible(true);
            pass_hidden.setVisible(false);
            return;
        }
        pass_hidden.setText(pass_text.getText());
        pass_hidden.setVisible(true);
        pass_text.setVisible(false);
    }

    @FXML
    void togglevisiblePassword1(ActionEvent event) {
        if (pass_toggle1.isSelected()) {
            pass_text1.setText(pass_hidden1.getText());
            pass_text1.setVisible(true);
            pass_hidden1.setVisible(false);
            return;
        }
        pass_hidden1.setText(pass_text1.getText());
        pass_hidden1.setVisible(true);
        pass_text1.setVisible(false);
    }

 

    @FXML
    void togglevisiblePasswordWEB(ActionEvent event) {
        if (pass_Toggle.isSelected()) {
            passwordGenerator.setText(passwordGeneratorhidden.getText());
            passwordGenerator.setVisible(true);
            passwordGeneratorhidden.setVisible(false);
            return;
        }
        passwordGeneratorhidden.setText(passwordGenerator.getText());
        passwordGeneratorhidden.setVisible(true);
        passwordGenerator.setVisible(false);
    }


    @FXML
    void pass_ToggleQq(ActionEvent event) {
        if (pass_ToggleQ.isSelected()) {
            passwordGenerator1.setText(passwordGeneratorhidden1.getText());
            passwordGenerator1.setVisible(true);
            passwordGeneratorhidden1.setVisible(false);
            return;
        }
        passwordGeneratorhidden1.setText(passwordGenerator1.getText());
        passwordGeneratorhidden1.setVisible(true);
        passwordGenerator1.setVisible(false);
    }


    @FXML
    void randomWeb(ActionEvent event) {
        int length = 10;
        String symbol = "/-^&*_!@%+>)";
        String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_letter = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String finalString = cap_letter + small_letter
                + numbers + symbol;
        Random random = new Random();
        String arryastr = "";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            password[i] = finalString.charAt(random.nextInt(finalString.length()));
        }
        for (int i = 0; i < length; i++) {
            arryastr += password[i];
        }
        passwordGeneratorhidden.setText(arryastr);
    }

    @FXML
    void handell(ActionEvent event) {
        if (event.getSource() == bankaccount1) {
            BANK1.toFront();
        } else if (event.getSource() == otherInfo1) {
            INFO1.toFront();

        } else if (event.getSource() == passwordwebsite1) {
            WEBSITE1.toFront();
        }

    }

    @FXML
    void randomm(ActionEvent event) {
        int length = 10;
        String symbol = "/-^&*_!@%+>)";
        String cap_letter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String small_letter = "abcdefghijklmnopqrstuvwxyz";
        String numbers = "0123456789";
        String finalString = cap_letter + small_letter
                + numbers + symbol;
        Random random = new Random();
        String arryastr = "";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            password[i] = finalString.charAt(random.nextInt(finalString.length()));
        }
        for (int i = 0; i < length; i++) {
            arryastr += password[i];
        }
        pass_hidden1.setText(arryastr);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.togglevisiblePassword(null);

    }

}

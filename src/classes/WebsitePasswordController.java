package classes;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import passwordmanager1.Connect;

public class WebsitePasswordController implements Initializable {

    @FXML
    private JFXButton bankaccount;

    @FXML
    private JFXButton passwordwebsite;

    @FXML
    private JFXButton otherInfo;


    @FXML
    private Pane paneOther;

    @FXML
    private Pane paneWebsite;

    @FXML
    private Pane paneBank;

    @FXML
    private TableView<webdata> otherTable;

    @FXML
    private TableColumn<webdata, String> Name;

    @FXML
    private TableColumn<webdata, String> Password;
     @FXML
    private TableView<webdata> webTable;

    @FXML
    private TableColumn<webdata, String> username;
@FXML
    private TableColumn<webdata, String> PasswordGenerator;
    @FXML
    private TableColumn<webdata, String> passwordweb;

    @FXML
    private TableColumn<webdata, String> website;

    @FXML
    private TableColumn<webdata, String> category;

    @FXML
    private TableColumn<webdata, String> passwordgenerator;
    @FXML
    private TableView<webdata> BankTable;

    @FXML
    private TableColumn<webdata, String> bankName;

    @FXML
    private TableColumn<webdata, String> AccountHolder;

    @FXML
    private TableColumn<webdata, Integer> cardNumber;

    @FXML
    private TableColumn<webdata, Integer> CVV;

    @FXML
    private TableColumn<webdata, Integer> securityCode;
    
    ObservableList<webdata> list = FXCollections.observableArrayList();
 ObservableList<webdata> listweb = FXCollections.observableArrayList();
 ObservableList<webdata> listBank = FXCollections.observableArrayList();
 @FXML
    private ToggleButton Encrypt;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        // TODO
    }

    @FXML
    void handell(ActionEvent event) throws SQLException {
        if (event.getSource() == bankaccount) {
            paneBank.toFront();
            fetchDataBank();
        } else if (event.getSource() == passwordwebsite) {
            paneWebsite.toFront();
            fetchDataWeb();
        } else if (event.getSource() == otherInfo) {
            paneOther.toFront();
            fetchData();
        }

    }

    @FXML
    void addData(ActionEvent event) throws IOException {

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        Parent root = FXMLLoader.load(getClass().getResource("/views/data.fxml"));
        Scene scene = new Scene(root);
        stage.setScene((scene));
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.showAndWait();
    }

    private void fetchData() throws SQLException {
        String query = "SELECT * FROM infoTable";

        Connection conn = Connect.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        list=null; 
        list = FXCollections.observableArrayList();
        while (rs.next()) {
            if(Encrypt.isSelected()){
            list.add(new webdata(rs.getString("Name"), star1(rs.getString("Password")),
                    star2(rs.getString("PasswordGenerator"))));
            System.out.println(list.size());
        
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        PasswordGenerator.setCellValueFactory(new PropertyValueFactory<>("PasswordGenerator"));
        otherTable.setItems(list);
        }else{
               list.add(new webdata(rs.getString("Name"), rs.getString("Password"),
                    rs.getString("PasswordGenerator")));
            System.out.println(list.size());
        
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Password.setCellValueFactory(new PropertyValueFactory<>("Password"));
        PasswordGenerator.setCellValueFactory(new PropertyValueFactory<>("PasswordGenerator"));
        otherTable.setItems(list); 
                }
        }
    }
    private  void fetchDataWeb() throws SQLException {
        String query = "SELECT * FROM Website";

        Connection conn = Connect.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        listweb=null; 
       listweb = FXCollections.observableArrayList();
        while (rs.next()) {
            if(Encrypt.isSelected()){
                 listweb.add(new webdata(rs.getString("username"),
                         starWeb1(rs.getString("passwordweb")),
                    rs.getString("website"), rs.getString("category"),
                    starWeb1(rs.getString("passwordgenerator"))));
            System.out.println(listweb.size());  
             username.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordweb.setCellValueFactory(new PropertyValueFactory<>("passwordweb"));
        website.setCellValueFactory(new PropertyValueFactory<>("website"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        passwordgenerator.setCellValueFactory(new PropertyValueFactory<>("passwordgenerator"));
        
        webTable.setItems(listweb);
        }
            else{
                    listweb.add(new webdata(rs.getString("username"), rs.getString("passwordweb"),
                    rs.getString("website"), rs.getString("category"),
                    rs.getString("passwordgenerator")));
            System.out.println(listweb.size());  
             username.setCellValueFactory(new PropertyValueFactory<>("username"));
        passwordweb.setCellValueFactory(new PropertyValueFactory<>("passwordweb"));
        website.setCellValueFactory(new PropertyValueFactory<>("website"));
        category.setCellValueFactory(new PropertyValueFactory<>("category"));
        passwordgenerator.setCellValueFactory(new PropertyValueFactory<>("passwordgenerator"));
        
        webTable.setItems(listweb);
            }
            }
           
    }
    private void fetchDataBank() throws SQLException {
        String query = "SELECT * FROM Bank";

        Connection conn = Connect.connect();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        listBank=null; 
       listBank = FXCollections.observableArrayList();
        while (rs.next()) {
            listBank.add(new webdata(rs.getString("bankName"), 
                    rs.getString("AccountHolder"),
                    rs.getInt("cardNumber"), rs.getInt("CVV"),
                    rs.getInt("securityCode")));
            System.out.println(listBank.size());   
        }
        bankName.setCellValueFactory(new PropertyValueFactory<>("bankName"));
        AccountHolder.setCellValueFactory(new PropertyValueFactory<>("AccountHolder"));
        cardNumber.setCellValueFactory(new PropertyValueFactory<>("cardNumber"));
        CVV.setCellValueFactory(new PropertyValueFactory<>("CVV"));
        securityCode.setCellValueFactory(new PropertyValueFactory<>("securityCode"));
        
        BankTable.setItems(listBank);
    }
    @FXML
    void Encrypt1(ActionEvent event) throws SQLException {
    fetchData();
    fetchDataWeb();
    }
    private String starWeb1 (String star){
         star="";
        for(int i=0;i<passwordweb.getText().length();i++){
        star=star+"*";
       
    }
        return star;
    }

        private String star1 (String star){
         star="";
        for(int i=0;i<Password.getText().length();i++){
        star=star+"*";
       
    }
        return star;
    }
         private String star2 (String star){
         star="";
        for(int i=0;i<Password.getText().length();i++){
        star=star+"*";
       
    }
        return star;
    }
    }
 
    


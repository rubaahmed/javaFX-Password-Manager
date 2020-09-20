/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordmanager1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author reham
 */
public class Connect {
     public static void main(String[] args) {
        connect();
    }
       public static Connection connect() {
        Connection con = null;
        try {
            String DataBasePath = "jdbc:sqlite:infoTable.db";
            con = DriverManager.getConnection(DataBasePath);
            System.out.println("connected1111111111111111");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return con;
    }
}

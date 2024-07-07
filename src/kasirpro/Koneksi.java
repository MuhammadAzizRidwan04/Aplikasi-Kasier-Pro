/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kasirpro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author M. Aziz Ridwan
 */
public class Koneksi {
    private static Connection mysqlconfig;

    public static Connection ConfigDB() throws SQLException {
        try {
            String url = "jdbc:mysql://localhost:3306/ambyar";
            String user = "root";
            String password = "";
            mysqlconfig = DriverManager.getConnection(url,user,password);
        } catch (Exception e) {
            System.err.println("Koneksi Gagal "+ e.getMessage());
        }
        return mysqlconfig;

    }
}

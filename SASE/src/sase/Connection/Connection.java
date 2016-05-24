/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sase.Connection;

import java.sql.*;

/**
 *
 * @author VAIO
 */
public class Connection {

    private java.sql.Connection con = null;
    private static String url = "SONY\\SQLEXPRESS";
    private static String port = "1433";
    private static String db = "BOTI2";
    private static String user = "sa";
    private static String pass = "seba123";

    // Create a variable for the connection string.
    String connectionUrl = "jdbc:sqlserver://" + url + ":" + port + ";"
            + "databaseName=" + db + ";user=" + user + ";password="+ pass + ";";   

    // Declare the JDBC objects.
    Statement stmt = null;
    ResultSet rs = null;

    public java.sql.Connection getConnection() {
        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return con;
    }

    public void closeConnection() {
        try {
            if (con != null) {
                con.close();
            }
            con = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void displayDbProperties() {
        java.sql.DatabaseMetaData dm = null;
        java.sql.ResultSet rs = null;
        try {
            con = this.getConnection();
            if (con != null) {
                dm = con.getMetaData();
                System.out.println("Información del controlador");
                System.out.println("\tNombre del controlador: " + dm.getDriverName());
                System.out.println("\tVersión del controlador: " + dm.getDriverVersion());
                System.out.println("\nInformación de la base de datos ");
                System.out.println("\tNombre de la base de datos: " + dm.getDatabaseProductName());
                System.out.println("\tVersión de la base de datos: " + dm.getDatabaseProductVersion());
                System.out.println("Catálogos disponibles ");
                rs = dm.getCatalogs();
                while (rs.next()) {
                    System.out.println("\tcatálogo: " + rs.getString(1));
                }
                rs.close();
                rs = null;
                closeConnection();
            } else {
                System.out.println("Error: No hay ninguna conexión activa");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        dm = null;
    }

    public static void main(String[] args) throws Exception {
        Connection myDbTest = new Connection();
        myDbTest.displayDbProperties();
    }
}

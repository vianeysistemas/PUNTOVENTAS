/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Vianey Vargas
 */
public class ConexionPuntoVenta extends Application {

    private Connection cn = null;
//    @FXML
//    private static final String user = "vianey";
//    @FXML
//    private static final String clave = "infinita%123";
//    @FXML
//    private static final String database = "PUNTOVENTAS";
//    @FXML
//    private static final String url = "jdbc:postgresql://LOCALHOST:5432/" + database;
//    @FXML

    //metodo constructor

    /* public ConexionPuntoVenta() {
     try {
     //Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
     Class.forName("org.postgresql.Driver");
     cn = DriverManager.getConnection(url, user, clave);
     //si la conexion obtuvo exito
     if (cn != null) {
     System.out.println("Conexion a la base de datos \n" + database + " Listo");
     //System.out.println("Conexion a la base de datos \n" + misPropiedades.getProperty("dataBaseCatalog") + " Listo");
     }
     } catch (SQLException ex) {
     System.out.println("Error en la conexion SQL" + ex.getMessage());
     } catch (ClassNotFoundException ex) {
     System.out.println("Error no se encuentra la clase Driver" + ex.getMessage());
     }
     }*/
    public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        try {
            Properties propiedades = new Properties();
            propiedades.load(getClass().getResourceAsStream("ConexionPuntoVenta.properties"));
            String strCnn = propiedades.getProperty("ConnectionString");
            String strUser = propiedades.getProperty("User");
            String strPwr = propiedades.getProperty("Password");
            Class.forName("org.postgresql.Driver");
            cn = DriverManager.getConnection(strCnn, strUser, strPwr);
            return cn;
        } catch (IOException | ClassNotFoundException | SQLException ex) {
            throw ex;
        }
    }

    //METODO PARA DESCONECTAR LA BASE DE DATOS
    @FXML
    public void desconectar() {
        cn = null;
        if (cn != null) {
            System.out.println("No se pudo cerrar la base de datos");
        }
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

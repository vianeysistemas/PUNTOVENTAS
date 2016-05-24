/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import controlador.LoguinController;
import dto.ScreensController;
import javafx.scene.image.Image;

/**
 *
 * @author Vianey Vargas
 */
public class PuntoVenta extends Application {
    public static String home="";
    public static String viewHome="/view/FXMLHome.fxml";
    public static String main = "main";
    public static String mainPrincipal = "/view/FXMLApplication.fxml";
    public static String principal = "loguin";
    public static String principalFile = "/view/loguin.fxml";
    public static String productos = "productos";
    public static String viewProductos = "/view/FXMLProductos.fxml";
    public static String listaPrecios = "listaprecios";
    public static String viewListaPrecios = "/view/FXMLListaPrecios.fxml";
    public static String bodegas = "bodegas";
    public static String viewBodegas = "/view/FXMLBodegas.fxml";
    public static String clientes = "";
    public static String viewClientes = "/view/FXMLClientes.fxml";
    public static String proveedor = "";
    public static String viewProveedores = "/view/FXMLProveedores.fxml";
    public static String acercaDe="";
    public static String viewAcercaDe="/view/FXMLAcercaDe.fxml";
//    public static String grafico = "grafico";
//    public static String graficoFile = "Grafico.fxml";

    @Override
    public void start(Stage stage) {
        try {
            //Parent parent = FXMLLoader.load(getClass().getResource("/view/FXMLProductos.fxml"));
            /*Parent parent = FXMLLoader.load(getClass().getResource("/view/loguin.fxml"));
             //Parent parent = FXMLLoader.load(getClass().getResource("/view/FXMLBodegas.fxml"));
             Scene scene = new Scene(parent);
             stage.setScene(scene);
             scene.setFill(new Color(0, 0, 0, 0));
             stage.setTitle("INISIO SMART(VENTA)");
             stage.initStyle(StageStyle.TRANSPARENT);vianey
             stage.show();*/
            //otra forma de abrir las ventanas
            Parent root = FXMLLoader.load(getClass().getResource(principalFile));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.getIcons().add(new Image("/imagenes/loguin.png"));
            scene.setFill(new Color(0, 0, 0, 0));
            stage.setResizable(false);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (Exception ex) {
            System.out.println("Error clase Main Principal : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}

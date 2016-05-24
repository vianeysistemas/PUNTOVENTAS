/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import main.PuntoVenta;

/**
 * FXML Controller class
 *
 * @author SISTEMAS
 */
public class FXMLMenu1Controller extends FXMLGenerico implements Initializable {

    @FXML
    private Button btnProductos;
    @FXML
    private Button btnListaPrecios;
    @FXML
    private Button btnBodegas;
    @FXML
    private Button btnSalir;
    @FXML
    private BorderPane rootLayout;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void OnActionProductos(ActionEvent event) {
        // TODO
        try {
            showFXMLview(rootLayout, PuntoVenta.viewProductos);
        } catch (Exception ex) {
            System.out.println("Error abriendo Ventana Productos : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    public void OnActionSalir(ActionEvent event) {
        //sai do sistema
        Platform.exit();
    }

    @FXML
    private void OnActionListaPrecios(ActionEvent event) {
        try {
            showFXMLview(rootLayout, PuntoVenta.viewListaPrecios);
        } catch (Exception ex) {
            System.out.println("Error abriendo Ventana ListaPrecios : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    private void OnActionBodegas(ActionEvent event) {
        try {
            showFXMLview(rootLayout, PuntoVenta.viewBodegas);
        } catch (Exception ex) {
            System.out.println("Error abriendo Ventana Bodegas : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}

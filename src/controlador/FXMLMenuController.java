/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Interfaces.ControlledScreen;
import de.jensd.fx.fontawesome.AwesomeDude;
import de.jensd.fx.fontawesome.AwesomeIcon;
import dto.ScreensController;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import main.PuntoVenta;

/**
 * FXML Controller class
 *
 * @author SISTEMAS
 */
public class FXMLMenuController extends FXMLGenerico implements Initializable {

    @FXML
    private VBox vbox;
    @FXML
    private AnchorPane apAnchorPaneTelas;
    @FXML
    private BorderPane rootLayout;//Esta linea es para abrir dentro del border la ventana fxml
    @FXML
    private Button btnProductosMenu;
    @FXML
    private Button btnCategorias;
    @FXML
    private Button btnPrecios;
    @FXML
    private Button btnListaPrecios;
    @FXML
    private Button btnBodegas;
    @FXML
    private Button btnProveedor;
    @FXML
    private Button btnClientes;
    @FXML
    private Button btnLotes;
    @FXML
    private TitledPane titlePanelMaestros;
    @FXML
    private TitledPane titlePanelMenu;

    Node node;
    Stage stage;
    Parent parent;
    Scene scene;
    ScreensController controlador;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AwesomeDude.setIcon(btnProductosMenu, AwesomeIcon.PLUS_SQUARE, "20px");
        AwesomeDude.setIcon(btnCategorias, AwesomeIcon.BARS, "20px");
        AwesomeDude.setIcon(btnPrecios, AwesomeIcon.DOLLAR, "20px");
        AwesomeDude.setIcon(btnListaPrecios, AwesomeIcon.ALIGN_JUSTIFY, "20px");
        AwesomeDude.setIcon(btnBodegas, AwesomeIcon.CUBE, "20px");
        AwesomeDude.setIcon(btnProveedor, AwesomeIcon.USERS, "20px");
        AwesomeDude.setIcon(btnClientes, AwesomeIcon.USER_MD, "20px");
        AwesomeDude.setIcon(btnLotes, AwesomeIcon.TH_LARGE, "20px");
        AwesomeDude.setIcon(titlePanelMenu, AwesomeIcon.COGS, "15px");
        AwesomeDude.setIcon(titlePanelMaestros, AwesomeIcon.DATABASE, "15px");

    }

    @FXML
    public void OnActionAbrirVentanaProducto(ActionEvent event) {
        try {
            /*node = (Node) event.getSource();
             stage = (Stage) node.getScene().getWindow();
             parent = FXMLLoader.load(getClass().getResource("/view/FXMLProductos.fxml"));
             scene = new Scene(parent);
             stage.setScene(scene);
             stage.setTitle("PRODUCTOS");
             //            stage.setResizable(false);
             stage.initStyle(StageStyle.UTILITY);
             //            stage.initStyle(StageStyle.DECORATED);
             //            stage.initStyle(StageStyle.UNDECORATED);
             //            stage.initStyle(StageStyle.UNIFIED);
             //            stage.initStyle(StageStyle.TRANSPARENT);
             stage.show();*/
            showFXMLview(rootLayout, PuntoVenta.viewProductos);
        } catch (Exception ex) {
            System.out.println("Error abriendo Ventana Productos : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

}

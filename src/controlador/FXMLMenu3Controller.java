/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import main.PuntoVenta;

/**
 * FXML Controller class
 *
 * @author SISTEMAS
 */
public class FXMLMenu3Controller extends FXMLGenerico implements Initializable {

    @FXML
    private ImageView imgMenuBtn;
    @FXML
    private ImageView imgHomeBtn;
    @FXML
    private StackPane acContent;
    @FXML
    private ScrollPane leftSideBarScroolPan;
    @FXML
    private ToggleButton sideMenuToogleBtn;
    @FXML
    private BorderPane appContent;
    @FXML
    private Button btnLogOut;
    @FXML
    private MenuItem miPopOver;
    @FXML
    private AnchorPane acDashBord;//Esta variable no esta ciendo utilizada
    @FXML
    private AnchorPane acHead;
    @FXML
    private AnchorPane acMain;
    @FXML
    private MenuButton mbtnUsrInfoBox;
    @FXML
    private Button btnHome;
    @FXML
    private Button btnProductos;
    @FXML
    private ImageView imgProductosBtn;
    @FXML
    private Button btnClientes;
    @FXML
    private ImageView imgClientesBtn;
    @FXML
    private Button btnListaPrecios;
    @FXML
    private ImageView imgPreciosBtn;
    @FXML
    private Button btnConfiguracion;
    @FXML
    private ImageView imgConfiguracionBtn;
    @FXML
    private Button btnAcercaDe;
    @FXML
    private ImageView imgAcercaDeBtn;
    @FXML
    private ImageView imgProveedoresBtn;
    @FXML
    private Button btnProveedores;
    @FXML
    private Label lblUsrName;
    @FXML
    private Label lblUsrNamePopOver;
    @FXML
    private Label lblFullName;
    @FXML
    private Label lblRoleAs;
    @FXML
    private Hyperlink hlEditUpdateAccount;
    @FXML
    private Circle imgUsrTop;
    @FXML
    private Circle circleImgUsr;
    @FXML
    private Label lblUserId;
    @FXML
    private AnchorPane anchorPane1;
    @FXML
    private String defultStyle = "-fx-border-width: 0px 0px 0px 5px;" + "-fx-border-color:none";
    @FXML
    private String activeStyle = "-fx-border-width: 0px 0px 0px 5px;"
            + "-fx-border-color:#FF4E3C";
    Image home = new Image("/imagenes/home.png");
    Image homeRed = new Image("/imagenes/homeRed.png");
    Image stock = new Image("/imagenes/stock.png");
    Image stockRed = new Image("/imagenes/stockRed.png");
    Image sell = new Image("/imagenes/sell2.png");
    Image sellRed = new Image("/imagenes/sell2Red.png");
    Image employee = new Image("/imagenes/employe.png");
    Image employeeRed = new Image("/imagenes/employeRed.png");
    Image setting = new Image("/imagenes/settings.png");
    Image settingRed = new Image("/imagenes/settingsRed.png");
    Image about = new Image("/imagenes/about.png");
    Image aboutRed = new Image("/imagenes/aboutRed.png");
    Image menuImage = new Image("/imagenes/menu.png");
    Image menuImageRed = new Image("/imagenes/menuRed.png");
    Image image;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void OnActionToogleButton(ActionEvent event) throws IOException {
        if (sideMenuToogleBtn.isSelected()) {
            imgMenuBtn.setImage(menuImageRed);
            TranslateTransition sideMenu = new TranslateTransition(Duration.millis(200.0), anchorPane1);
            sideMenu.setByX(-130);
            sideMenu.play();
            anchorPane1.getChildren().clear();
        } else {
            imgMenuBtn.setImage(menuImage);
            TranslateTransition sideMenu = new TranslateTransition(Duration.millis(200.0), anchorPane1);
            sideMenu.setByX(130);
            sideMenu.play();
            anchorPane1.getChildren().add(leftSideBarScroolPan);
        }
    }

    @FXML
    private void OnActionHome(ActionEvent event) {
        try {
            homeActive();
            showFXMLview(appContent, PuntoVenta.viewHome);
        } catch (Exception ex) {
            System.out.println("Error abriendo Ventana Home : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    public void OnActionProductos(ActionEvent event) {
        // TODO
        try {
            Btnproductos();
            showFXMLview(appContent, PuntoVenta.viewProductos);
        } catch (Exception ex) {
            System.out.println("Error abriendo Ventana Productos : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    private void OnActionListaPrecios(ActionEvent event) {
        try {
            BtnPrecios();
            showFXMLview(appContent, PuntoVenta.viewListaPrecios);
        } catch (Exception ex) {
            System.out.println("Error abriendo Ventana ListaPrecios : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    private void OnActionClientes(ActionEvent event) {
        try {
            BtnClientes();
            showFXMLview(appContent, PuntoVenta.viewClientes);
        } catch (Exception ex) {
            System.out.println("Error abriendo Ventana Clientes : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    public void OnActionNose(ActionEvent event) {
        try {
            BtnProveedores();
        } catch (Exception ex) {

        }
    }

    @FXML
    private void OnActionConfiguracion(ActionEvent event) {
        try {
            BtnSettingsActive();
            //showFXMLview(appContent, PuntoVenta.viewClientes);
        } catch (Exception ex) {
            System.out.println("Error abriendo Ventana Configuracion : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    private void OnActionAcercaDe(ActionEvent event) {
        try {
            BtnAcercaDe();
            showFXMLview(appContent, PuntoVenta.viewAcercaDe);
        } catch (Exception ex) {
            System.out.println("Error abriendo Ventana Acerca De : " + ex.getMessage());
            ex.printStackTrace();
        }
    }

    @FXML
    public void OnActionSalir(ActionEvent event) {
        //sai do sistema
        Platform.exit();
    }

    //BOTONES
    private void homeActive() {
        imgHomeBtn.setImage(homeRed);
        imgProductosBtn.setImage(stock);
        imgPreciosBtn.setImage(sell);
        imgClientesBtn.setImage(employee);
        imgConfiguracionBtn.setImage(setting);
        imgAcercaDeBtn.setImage(about);
        imgProveedoresBtn.setImage(employee);
        btnHome.setStyle(activeStyle);
        btnProductos.setStyle(defultStyle);
        btnListaPrecios.setStyle(defultStyle);
        btnClientes.setStyle(defultStyle);
        btnConfiguracion.setStyle(defultStyle);
        btnAcercaDe.setStyle(defultStyle);
        btnProveedores.setStyle(defultStyle);
    }

    private void Btnproductos() {
        imgHomeBtn.setImage(home);
        imgProductosBtn.setImage(stockRed);
        imgPreciosBtn.setImage(sell);
        imgClientesBtn.setImage(employee);
        imgConfiguracionBtn.setImage(setting);
        imgAcercaDeBtn.setImage(about);
        imgProveedoresBtn.setImage(employee);
        btnHome.setStyle(defultStyle);
        btnProductos.setStyle(activeStyle);
        btnListaPrecios.setStyle(defultStyle);
        btnClientes.setStyle(defultStyle);
        btnConfiguracion.setStyle(defultStyle);
        btnAcercaDe.setStyle(defultStyle);
        btnProveedores.setStyle(defultStyle);
    }

    private void BtnPrecios() {
        imgHomeBtn.setImage(home);
        imgProductosBtn.setImage(stock);
        imgPreciosBtn.setImage(sellRed);
        imgClientesBtn.setImage(employee);
        imgConfiguracionBtn.setImage(setting);
        imgAcercaDeBtn.setImage(about);
        imgProveedoresBtn.setImage(employee);
        btnHome.setStyle(defultStyle);
        btnProductos.setStyle(defultStyle);
        btnListaPrecios.setStyle(activeStyle);
        btnClientes.setStyle(defultStyle);
        btnConfiguracion.setStyle(defultStyle);
        btnAcercaDe.setStyle(defultStyle);
        btnProveedores.setStyle(defultStyle);
    }

    private void BtnClientes() {
        imgHomeBtn.setImage(home);
        imgProductosBtn.setImage(stock);
        imgPreciosBtn.setImage(sell);
        imgClientesBtn.setImage(employeeRed);
        imgConfiguracionBtn.setImage(setting);
        imgAcercaDeBtn.setImage(about);
        imgProveedoresBtn.setImage(employee);
        btnHome.setStyle(defultStyle);
        btnProductos.setStyle(defultStyle);
        btnListaPrecios.setStyle(defultStyle);
        btnClientes.setStyle(activeStyle);
        btnConfiguracion.setStyle(defultStyle);
        btnAcercaDe.setStyle(defultStyle);
        btnProveedores.setStyle(defultStyle);
    }

    private void BtnSettingsActive() {
        imgHomeBtn.setImage(home);
        imgProductosBtn.setImage(stock);
        imgPreciosBtn.setImage(sell);
        imgClientesBtn.setImage(employee);
        imgConfiguracionBtn.setImage(settingRed);
        imgAcercaDeBtn.setImage(about);
        imgProveedoresBtn.setImage(employee);
        btnHome.setStyle(defultStyle);
        btnProductos.setStyle(defultStyle);
        btnListaPrecios.setStyle(defultStyle);
        btnClientes.setStyle(defultStyle);
        btnConfiguracion.setStyle(activeStyle);
        btnAcercaDe.setStyle(defultStyle);
        btnProveedores.setStyle(defultStyle);
    }

    private void BtnAcercaDe() {
        imgHomeBtn.setImage(home);
        imgProductosBtn.setImage(stock);
        imgPreciosBtn.setImage(sell);
        imgClientesBtn.setImage(employee);
        imgConfiguracionBtn.setImage(setting);
        imgAcercaDeBtn.setImage(aboutRed);
        imgProveedoresBtn.setImage(employee);
        btnHome.setStyle(defultStyle);
        btnProductos.setStyle(defultStyle);
        btnListaPrecios.setStyle(defultStyle);
        btnClientes.setStyle(defultStyle);
        btnConfiguracion.setStyle(defultStyle);
        btnAcercaDe.setStyle(activeStyle);
        btnProveedores.setStyle(defultStyle);
    }

    private void BtnProveedores() {
        imgHomeBtn.setImage(home);
        imgProductosBtn.setImage(stock);
        imgPreciosBtn.setImage(sell);
        imgClientesBtn.setImage(employee);
        imgConfiguracionBtn.setImage(setting);
        imgAcercaDeBtn.setImage(about);
        imgProveedoresBtn.setImage(employeeRed);
        btnProveedores.setStyle(activeStyle);
        btnHome.setStyle(defultStyle);
        btnProductos.setStyle(defultStyle);
        btnListaPrecios.setStyle(defultStyle);
        btnClientes.setStyle(defultStyle);
        btnConfiguracion.setStyle(defultStyle);
        btnAcercaDe.setStyle(defultStyle);
    }
}

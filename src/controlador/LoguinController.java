/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clasesDao.LoguinDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import static javafx.scene.control.Alert.AlertType.ERROR;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialogs;

/**
 * FXML Controller class
 *
 * @author Vianey Vargas
 */
public class LoguinController implements Initializable {

    Node node;
    Stage stage;
    Parent parent;
    Scene scene;

    @FXML
    private BorderPane rootLayout;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private Stage stagePrincipal;
    @FXML
    private TextField txtUsuario;
    @FXML
    private TextField txtClave;
    @FXML
    private Button btnEntrar;
    @FXML
    private Button btnCancelar;
    @FXML
    private Button btnMinimizarLoguin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void onKeyPressed(KeyEvent evt) {
        if (evt.getCode().equals(KeyCode.ENTER)) {
            txtClave.requestFocus();
        }
    }

    @FXML
    public void onKeyPressedClave(KeyEvent evt) {
        if (evt.getCode().equals(KeyCode.ENTER)) {
            btnEntrar.fire();
        }
    }

    @FXML
    public void OnActionMinimizarLoguin(ActionEvent event) {
        Stage stage = (Stage) btnMinimizarLoguin.getScene().getWindow();
        stage.toBack();//Minimizamos la Ventana
    }

    @FXML
    public void accionCerrarLoguin(ActionEvent event) {
        Node node = (Node) event.getSource();
        Stage st = (Stage) node.getScene().getWindow();
        st.close();
    }

    @FXML
    private void accionEntrar(ActionEvent evt) throws IOException {
        String user = txtUsuario.getText();
        String clave = txtClave.getText();
        LoguinDao inicio = new LoguinDao();
        if (inicio.verificaUsuarioInterface(user, clave)) {
            ((Node) (evt.getSource())).getScene().getWindow().hide();//Permite Cerrar la ventana de Loguin
            parent = FXMLLoader.load(getClass().getResource("/view/FXMLApplication.fxml"));
            //parent = FXMLLoader.load(getClass().getResource("/view/Application.fxml"));
            stage = new Stage();
            scene = new Scene(parent);
            stage.setScene(scene);
            stage.getIcons().add(new Image("/imagenes/iconoPrograma.png"));
            stage.centerOnScreen();
            stage.setMaximized(true);
            stage.setTitle("SMART");
            stage.show();
        } else {
            //Dialogs.showErrorDialog(stage, "Ooops, there was an error!", "Error Dialog", "title");
            //JOptionPane.showMessageDialog(null, "¡¡¡Usuario o Clave Incorrectos!!!");
            Action acNotActive = Dialogs.create().title("ADVERTERNCIA")
                    .message("\n ¡¡¡Usuario o Clave Incorrectos!!!")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    //.masthead("Acceso Incorrecto")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showError();
            System.out.println("¡¡¡Usuario o Clave Incorrectos!!!");
            txtUsuario.requestFocus();
            txtUsuario.selectAll();
        }
    }

    @FXML
    public void accionCancelar(ActionEvent event) {
        node = (Node) event.getSource();
        stage = (Stage) node.getScene().getWindow();
        stage.close();
    }
}

/*
 //CODIGO PARA ABRIR UNA NUEVA VENTANA
 node = (Node) event.getSource();//Es nuestra interfaz y sobre que elementos vamos agregar sobre ella es decir los que sigue del borde azul de una ventana
 stage = (Stage) node.getScene().getWindow();//Permite crear el Contorno de la interfaz es decir el borde azul de una ventana
 parent = FXMLLoader.load(getClass().getResource("/view/FXMLMenu.fxml"));//Es el que nos permite dar esa conexion con la interfaz que vamos a interactuaar en este caso llamamos FXMLMenu.fxml
 stage = new Stage();
 scene = new Scene(parent);//Es donde van a estar nuesro lienzo es decir nuestros objetos y por eso le pasamos el parent que es el que contiene el FXML el cual tiene todos los objetos controlres
 stage.setScene(scene);//Y ya el objeto estage permite darle atributos a una interface o ventana .
 stage.centerOnScreen();//Permite centrar la aplicacion en todo el centro
 stage.setTitle("INICIO PUNTO DE VENTA");
 stage.show();
 */

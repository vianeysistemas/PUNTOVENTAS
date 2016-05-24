/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clasesDao.ProductosDao;
import dto.DtoProductos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialogs;

/**
 * FXML Controller class
 *
 * @author SISTEMAS
 */
public class FXMLBuscaProductosController implements Initializable {

    @FXML
    private TableView tblBuscaProductos;
    @FXML
    private Button btnCerrar;
    @FXML
    private Button btnMinimizar;
    @FXML
    private TextField txtBuscaProducto;
    @FXML
    private Button btnEnviarProducto;
    @FXML
    private TableColumn<DtoProductos, String> columCodProducto;
    @FXML
    private TableColumn<DtoProductos, String> columReferencia;
    @FXML
    private TableColumn<DtoProductos, String> columNombreProducto;
    private ProductosDao daoProd;
    private ObservableList<DtoProductos> listObsListProductos;

    public FXMLBuscaProductosController() {
        daoProd = new ProductosDao();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        llenarTblColumnProductos();
        cargaTablaProductos();
    }

    private void llenarTblColumnProductos() {
        columCodProducto.setCellValueFactory(
                (TableColumn.CellDataFeatures<DtoProductos, String> cellData)
                -> cellData.getValue().getPropertyIdCodigo());
        columReferencia.setCellValueFactory(
                (TableColumn.CellDataFeatures<DtoProductos, String> cellData)
                -> cellData.getValue().getPropertyReferencia());
        columNombreProducto.setCellValueFactory(
                (TableColumn.CellDataFeatures<DtoProductos, String> cellData)
                -> cellData.getValue().getPropertyDescripcion());
    }

    private void cargaTablaProductos() {
        listObsListProductos = daoProd.listarTblProductos();
        tblBuscaProductos.setItems(listObsListProductos);
    }

    @FXML
    public void OnActionClose(ActionEvent event) {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();//Con este boton cerramos la ventana 
    }

    @FXML
    public void OnActionMinimizar(ActionEvent event) {
        Stage stage = (Stage) btnMinimizar.getScene().getWindow();
        stage.toBack();//Minizamos la ventana
    }

    @FXML
    public void OnKeyReleasedBuscarProductos(KeyEvent event) {
        listObsListProductos = daoProd.buscarProductos(txtBuscaProducto.getText().toUpperCase());
        tblBuscaProductos.setItems(listObsListProductos);
    }

    @FXML
    public void OnMouseClickedTblProductos(MouseEvent event) {
        DtoProductos dto = (DtoProductos) tblBuscaProductos.getSelectionModel().getSelectedItem();
        try {
            if (dto == null) {
                Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                        .message("Debe Seleccionar un Registro para Enviar")
                        .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                        .masthead("Seleccione")
                        .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                        .showWarning();
            } else {
                if (event.getClickCount() == 2) {
                    FXMLProductosController controller = new FXMLProductosController();
                    controller.txtReferencia.setText(dto.getPropertyReferencia().toString());
                    controller.txtDescripcionProducto.setText(dto.getPropertyDescripcion().toString());
                } else {
                    System.out.println("Debe dar Dobli Click para poder enviar");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                    .message("Error Clickeando la tabla Productos\n" + ex.getMessage())
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Error!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showError();
        }
    }

}

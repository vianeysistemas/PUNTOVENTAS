/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clasesDao.TercerosDAo;
import dto.DtoTerceros;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
public class FXMLBuscaProveedorController implements Initializable {

    @FXML
    private TextField txtBuscaProveedor;
    @FXML
    private Button btnEnviarProveedor;
    @FXML
    private Button btnCerrarVentProv;
    @FXML
    private Button btnMinimizarVentProv;
    @FXML
    private TableView tblProveedor;
    @FXML
    private TableColumn<DtoTerceros, String> columNit;
    @FXML
    private TableColumn<DtoTerceros, String> columProveedor;

    private ObservableList<DtoTerceros> listObsListProveedor;
    private TercerosDAo daoTercero;

    //metodo constructor para iniciar las clases DAo
    public FXMLBuscaProveedorController() {
        daoTercero = new TercerosDAo();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        llenarTblColumnProveedores();
        cargaTablaProveedores();
    }

    private void llenarTblColumnProveedores() {
        columNit.setCellValueFactory(
                (TableColumn.CellDataFeatures<DtoTerceros, String> cellData)
                -> cellData.getValue().getPropertyNitProveedor());
        columProveedor.setCellValueFactory(
                (TableColumn.CellDataFeatures<DtoTerceros, String> cellData)
                -> cellData.getValue().getPropertyNomProveedor());
    }

    private void cargaTablaProveedores() {
        listObsListProveedor = daoTercero.listarTblProveedores(txtBuscaProveedor.getText());
        tblProveedor.setItems(listObsListProveedor);
    }

    @FXML
    public void OnKeyReleasedBuscaProveedor(KeyEvent event) {
        listObsListProveedor = daoTercero.listarTblProveedores(txtBuscaProveedor.getText());
        tblProveedor.setItems(listObsListProveedor);
    }

    @FXML
    public void OnActionCerrarVentProv(ActionEvent event) {
        Stage stage = (Stage) btnCerrarVentProv.getScene().getWindow();
        stage.close();//Con este boton cerramos la ventana 
    }

    @FXML
    public void OnActionMinimizarVentProv(ActionEvent event) {
        Stage stage = (Stage) btnMinimizarVentProv.getScene().getWindow();
        stage.toBack();//Minizamos la ventana
    }

    @FXML
    public void OnMouseClickedTblProveedor(MouseEvent event) {
        DtoTerceros dto = (DtoTerceros) tblProveedor.getSelectionModel().getSelectedItem();
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
                    controller.txtNitProveedor.setText(dto.getPropertyStringNitProv());
                    controller.txtNomProveedor.setText(dto.getPropertyStringNomProv());
                } else {
                    System.out.println("Debe dar Dobli Click para poder enviar");
                }
            }
        } catch (Exception ex) {
            Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                    .message("Error Clickeando la tabla Proveedores\n" + ex.getMessage())
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Error!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showError();
        }
    }

}

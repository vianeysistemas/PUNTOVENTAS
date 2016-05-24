/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clasesDao.ListaPreciosDao;
import dto.DtoListaPrecios;
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
public class FXMLBuscaListaPreciosController implements Initializable {

    @FXML
    private Button btnCerrar;
    @FXML
    private Button btnMinimizar;
    @FXML
    private Button btnEnviar;
    @FXML
    private TextField txtBuscaListaPrecio;
    @FXML
    private TableView tblBuscaListaPrecios;
    @FXML
    private TableColumn<DtoListaPrecios, String> columCodPrecio;
    @FXML
    private TableColumn<DtoListaPrecios, String> columListaPrecio;
    @FXML
    private TableColumn<DtoListaPrecios, String> columnDescripcion;

    private ListaPreciosDao daoListaP;
    private ObservableList<DtoListaPrecios> listObservableListaPrecios;

    //metodo constructor
    public FXMLBuscaListaPreciosController() {
        daoListaP = new ListaPreciosDao();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        llenarTblColumnListaPrecios();
        cargaTablaListaPrecios();
    }

    private void llenarTblColumnListaPrecios() {
        columCodPrecio.setCellValueFactory(
                (TableColumn.CellDataFeatures<DtoListaPrecios, String> cellData)
                -> cellData.getValue().getPropertyCodPrecio());
        columListaPrecio.setCellValueFactory(
                (TableColumn.CellDataFeatures<DtoListaPrecios, String> cellData)
                -> cellData.getValue().getPropertyTitulo());
        columnDescripcion.setCellValueFactory(
                (TableColumn.CellDataFeatures<DtoListaPrecios, String> cellData)
                -> cellData.getValue().getPropertyDescripcion());
    }

    private void cargaTablaListaPrecios() {
        listObservableListaPrecios = daoListaP.listarTblListaPrecios();
        tblBuscaListaPrecios.setItems(listObservableListaPrecios);
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
    public void OnKeyReleasedBuscarListaPrecios(KeyEvent event) {
        listObservableListaPrecios = daoListaP.buscaListaPrecioModal(txtBuscaListaPrecio.getText().toUpperCase());
        tblBuscaListaPrecios.setItems(listObservableListaPrecios);
    }

    @FXML
    public void OnMouseClickedTblListaPrecios(MouseEvent event) {
        DtoListaPrecios dto = (DtoListaPrecios) tblBuscaListaPrecios.getSelectionModel().getSelectedItem();
        if (dto == null) {
            Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                    .message("Debe Seleccionar un Registro para enviar")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Seleccione")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
        } else {
            //FXMLLoader loader = new FXMLLoader();
            FXMLListaPreciosController fxmlP = new FXMLListaPreciosController();
            fxmlP.txtCodListaPrecio.setText(dto.getCodPrecio());
            fxmlP.txtTitulo.setText(dto.getTitulo());
        }
    }
}

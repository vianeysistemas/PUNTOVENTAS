/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clasesDao.ListaPreciosDao;
import dto.DtoListaPrecios;
import java.net.URL;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

/**
 * FXML Controller class
 *
 * @author SISTEMAS
 */
public class FXMLListaPreciosController implements Initializable {

    @FXML
    public TextField txtCodListaPrecio;
    @FXML
    public TextField txtTitulo;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private Button btnListaPrecios;
    @FXML
    private DatePicker datePicker1;
    @FXML
    private DatePicker datePicker2;
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TableView tblListaPrecios1;
    @FXML
    private TableColumn<DtoListaPrecios, String> columCodPrecio1;
    @FXML
    private TableColumn<DtoListaPrecios, String> columListaPrecio1;
    @FXML
    private TableColumn<DtoListaPrecios, String> columnDescripcion1;
    @FXML
    private TableColumn<DtoListaPrecios, String> columnFecha1;
    @FXML
    private TableColumn<DtoListaPrecios, String> columnFecha2;

    private Stage stage;
    private ListaPreciosDao daoListaP;
    private ObservableList<DtoListaPrecios> listObservableListaPrecios1;

//metodo constructor
    public FXMLListaPreciosController() {
        daoListaP = new ListaPreciosDao();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cargaTablaListaPrecios1();
        llenarTblColumnListaPrecios1();
    }

    private void llenarTblColumnListaPrecios1() {
        columCodPrecio1.setCellValueFactory(
                (TableColumn.CellDataFeatures<DtoListaPrecios, String> cellData)
                -> cellData.getValue().getPropertyCodPrecio());
        columListaPrecio1.setCellValueFactory(
                (TableColumn.CellDataFeatures<DtoListaPrecios, String> cellData)
                -> cellData.getValue().getPropertyTitulo());
        columnDescripcion1.setCellValueFactory(
                (TableColumn.CellDataFeatures<DtoListaPrecios, String> cellData)
                -> cellData.getValue().getPropertyDescripcion());
    }

    private void cargaTablaListaPrecios1() {
        listObservableListaPrecios1 = daoListaP.listarTblListaPrecios();
        tblListaPrecios1.setItems(listObservableListaPrecios1);
    }

    public void FechaHoyTxt() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy", new Locale("es_ES"));
        String mifecha;
        java.util.Date fechaHoy = new java.util.Date();
        mifecha = formateador.format(fechaHoy);
        datePicker1.setPromptText(mifecha);
    }

    @FXML
    public void OnActionNuevaListaPrecio(ActionEvent event) {
        txtCodListaPrecio.setText("");
        txtCodListaPrecio.requestFocus();
        txtTitulo.setText("");
        txtDescripcion.setText("");
        FechaHoyTxt();
    }

    @FXML
    public void OnActionListaPrecios(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/FXMLBuscaListaPrecios.fxml"));
            loader.load();
            Parent parent = loader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (Exception ex) {
            System.out.println("Error al abrir la ventana Busquedad de Lista Precios : " + ex.getMessage());
        }
    }

    @FXML
    public void OnActionGuardarListaPrecio(ActionEvent event) {
        if (txtCodListaPrecio.getText().equals("0") || txtCodListaPrecio.getText().equals("")) {
            Action mensaje = Dialogs.create().title("ADVERTENCIA")
                    .message("El Campo CodPrecio es Requerido!")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Verifique!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
            txtCodListaPrecio.requestFocus();
            txtCodListaPrecio.selectAll();
        } else if (txtTitulo.getText().equals("")) {
            Action mensaje = Dialogs.create().title("ADVERTENCIA")
                    .message("El Campo Titulo es Requerido!")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Verifique!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
            txtTitulo.requestFocus();
            txtTitulo.selectAll();
        } else if (txtDescripcion.getText().equals("")) {
            Action mensaje = Dialogs.create().title("ADVERTENCIA")
                    .message("El Campo Descripcion es Requerido!")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Verifique!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
            txtDescripcion.requestFocus();
            txtDescripcion.selectAll();
        } else if (datePicker1.getValue() == null) {
            Action mensaje = Dialogs.create().title("ADVERTENCIA")
                    .message("El Campo Fecha Inicial es Requerido!")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Verifique!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
            datePicker1.requestFocus();
        } else if (datePicker2.getValue() == null) {
            Action mensaje = Dialogs.create().title("ADVERTENCIA")
                    .message("El Campo Fecha Final es Requerido!")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Verifique!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
            datePicker2.requestFocus();
        } else {
            String codPrecio = txtCodListaPrecio.getText();
            String descripcion = txtDescripcion.getText();
            String titulo = txtTitulo.getText();
            String fecha1 = datePicker1.getValue().toString();
            String fecha2 = datePicker2.getValue().toString();
            Action ok = Dialogs.create().title("Confirmar")
                    //.masthead("Guardar Categoria")
                    .actions(Dialog.ACTION_YES, Dialog.ACTION_NO)
                    .styleClass(Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .message("¿Esta Seguro de Guardar los Datos Ingresados ?")
                    .showConfirm();
            if (ok == Dialog.ACTION_YES) {
                try {
                    DtoListaPrecios dto = new DtoListaPrecios();
                    dto.setCodPrecio(codPrecio);
                    dto.setDescripcion(descripcion);
                    dto.setTitulo(titulo);
                    dto.setFecha1(Date.valueOf(datePicker1.getValue()));
                    dto.setFecha2(Date.valueOf(datePicker2.getValue()));
                    String result = "";
                    result = daoListaP.insertListaPrecio(dto);
                    //Registro exitoso
                    Action mensaje = Dialogs.create().title("CONFIRMADO")
                            .message("" + result)
                            .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                            .masthead("EXITO.")
                            .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                            .showConfirm();
                    cargaTablaListaPrecios1();
                } catch (Exception ex) {
                    Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                            .message("Error al Guardar la ListaPrecio\n" + ex.getMessage())
                            .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                            .masthead("Error!!")
                            .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                            .showError();
                    ex.printStackTrace();
                    System.out.println("Error al registrar " + ex.getMessage());
                }
            }
        }
    }

    @FXML
    public void OnMouseClickedTblListaPrecios(MouseEvent event) {
        DtoListaPrecios dto = (DtoListaPrecios) tblListaPrecios1.getSelectionModel().getSelectedItem();
        if (dto == null) {
            Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                    .message("Debe Seleccionar un Registro para Actualizar")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Seleccione")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
        } else {
            txtCodListaPrecio.setText(dto.getPropertyStringCodPrecio());
            txtTitulo.setText(dto.getPropertyStringTitulo());
            txtDescripcion.setText(dto.getPropertyStringDescripcion());
        }
    }

    @FXML
    public void OnActionEliminarListaPrecio() {

    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clasesDao.CategoriasDao;
import dto.DtoCategoria;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableView.TableViewSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

/**
 * FXML Controller class
 *
 * @author SISTEMAS
 */
public class FXMLCategoriaController implements Initializable {

    @FXML
    private TableView tblCategorias;
    @FXML
    private TableColumn<DtoCategoria, String> columCodigoCategoria;
    @FXML
    private TableColumn<DtoCategoria, String> columNombreCategoria;
    @FXML
    private Button btnGuardarCategoria;
    @FXML
    private TextField txtNomCategoria;
    @FXML
    private TextField txtCodCategoria;
    @FXML
    private Button btnNuevaCategoria;

    CategoriasDao daoCategoria;
    ObservableList<DtoCategoria> listObservTblCategoria;

    public FXMLCategoriaController() {
        daoCategoria = new CategoriasDao();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ultimoCodigoCategoria();
        llenarTblColumnCategoria();
        cargaTablaCategorias();
    }

    private void llenarTblColumnCategoria() {
        columCodigoCategoria.setCellValueFactory(
                (TableColumn.CellDataFeatures<DtoCategoria, String> cellData)
                -> cellData.getValue().getCodCatTblProperty());
        columNombreCategoria.setCellValueFactory(
                (TableColumn.CellDataFeatures<DtoCategoria, String> cellData)
                -> cellData.getValue().getNomCatProperty());
    }

    private void cargaTablaCategorias() {
        listObservTblCategoria = daoCategoria.getAllTbl();
        tblCategorias.setItems(listObservTblCategoria);
    }

    public void limpiarTxt() {
        txtCodCategoria.setEditable(false);
        txtCodCategoria.setText("0");
        txtNomCategoria.setText("");
        txtNomCategoria.requestFocus();
    }

    @FXML
    public void OnActionNuevaCategoria() {
        limpiarTxt();
    }

    @FXML
    public void ultimoCodigoCategoria() {
        try {
            Integer id = daoCategoria.ultimoCodCategoria();
            txtCodCategoria.setText(String.valueOf(id));
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error Consultado el ultimo Codigo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    public void OnActionGuardarCategoria(ActionEvent event) {
        DtoCategoria dto = new DtoCategoria();
        String codCategoria = txtCodCategoria.getText();
        int codCat = Integer.parseInt(codCategoria);
        String nomCategoria = txtNomCategoria.getText().toUpperCase();
        if (codCategoria.equals("")) {
            Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                    //.message("Verifique")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("El Codigo Categoria no puede ir Vacio!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
            txtCodCategoria.requestFocus();
            return;
        } else if (nomCategoria.equals("")) {
            Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                    //.message("Verifique")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("El Nombre de la Categoria no puede ir Vacio!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
            txtNomCategoria.requestFocus();
            return;
        } else {
            Action ok = Dialogs.create().title("Confirmar")
                    //.masthead("Guardar Categoria")
                    .actions(Dialog.ACTION_YES, Dialog.ACTION_NO)
                    .styleClass(Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .message("¿Esta Seguro de Guardar los Datos ?")
                    .showConfirm();
            if (ok == Dialog.ACTION_YES) {
                try {
                    dto.setCodigo(Integer.parseInt(codCategoria));
                    dto.setNombreCat(nomCategoria);
                    daoCategoria.insertCategoria(dto);
                    Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                            .message("Categoria Registrada Correctamente")
                            .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                            .masthead("Registro Exitoso")
                            .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                            .showConfirm();
                    limpiarTxt();
                    ultimoCodigoCategoria();
                    cargaTablaCategorias();
                } catch (Exception ex) {
                    Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                            .message("Error Registrando la Categoria\n" + ex.getMessage())
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
    public void OnMouseClickedTblCategorias(MouseEvent event) {
        DtoCategoria dto = (DtoCategoria) tblCategorias.getSelectionModel().getSelectedItem();
        if (dto == null) {
            Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                    .message("Debe Seleccionar un Registro para Actualizar")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Seleccione")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
        } else {
            txtCodCategoria.setText(dto.getCodCatProperty());
            txtNomCategoria.setText(dto.getNombreCat());
        }
    }

}

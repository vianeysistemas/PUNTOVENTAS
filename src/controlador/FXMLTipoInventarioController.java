/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clasesDao.TipoInvDao;
import dto.DtoTipoInventario;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

/**
 * FXML Controller class
 *
 * @author SISTEMAS
 */
public class FXMLTipoInventarioController implements Initializable {

    @FXML
    private Button btnCerrar;
    @FXML
    private Button btnGuardar;
    @FXML
    private TextField txtCodTipoInv;
    @FXML
    private TextField txtNomTipoInv;

    private TipoInvDao daoTipoInv;

    public FXMLTipoInventarioController() {
        daoTipoInv = new TipoInvDao();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ultimoCodigoTipoInv();
    }

    public void ultimoCodigoTipoInv() {
        try {
            Integer id = daoTipoInv.ultimoCodTipoInv();
            txtCodTipoInv.setText(String.valueOf(id));
        } catch (Exception ex) {
            System.out.println("Error Consultado el ultimo Codigo: " + ex.getMessage());
            Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                    .message("Error Consultado el ultimo Codigo\n" + ex.getMessage())
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Error!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showError();
        }
    }

    @FXML
    public void OnActionGuardarTipoInv(ActionEvent event) {
        if (txtNomTipoInv.getText().equals("")) {
            Action mensaje = Dialogs.create().title("ADVERTENCIA")
                    .message("El Campo Nombre es Requerido!")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Verifique!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
            txtNomTipoInv.requestFocus();
            txtNomTipoInv.selectAll();
        } else {
            Action ok = Dialogs.create().title("Confirmar")
                    //.masthead("Guardar Categoria")
                    .actions(Dialog.ACTION_YES, Dialog.ACTION_NO)
                    .styleClass(Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .message("¿Esta Seguro de Guardar el Tipo de Inventario ?")
                    .showConfirm();
            if (ok == Dialog.ACTION_YES) {
                try {
                    DtoTipoInventario dto = new DtoTipoInventario();
                    dto.setCodTipoInv(Integer.parseInt(txtCodTipoInv.getText()));
                    dto.setNomTipoInv(txtNomTipoInv.getText().toUpperCase());
                    daoTipoInv.insertTipoInv(dto);
                    //Registro exitoso
                    Action mensaje = Dialogs.create().title("CONFIRMADO")
                            .message("Tipo de Inventario Registrado Correctamente")
                            .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                            .masthead("Registro Exitoso")
                            .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                            .showConfirm();
                } catch (Exception ex) {
                    Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                            .message("Error al Guardar el Tipo de Inventario\n" + ex.getMessage())
                            .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                            .masthead("Error!!")
                            .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                            .showError();
                }
            }
        }
    }

    @FXML
    public void OnActionCerrarTipoInv(ActionEvent event) {
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();//Con este boton cerramos la ventana 
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clasesDao.FormaPagosDao;
import clasesDao.TercerosDAo;
import dto.DtoTerceros;
import dto.DtoFormaPagos;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javax.swing.JOptionPane;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

/**
 *
 * @author Vianey Vargas
 */
public class FXMLClientesController implements Initializable {

//    @FXML
//    private Label label;
    @FXML
    private Button btnNuevo;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancelar;
    @FXML
    private TextField txtNit;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtNombre2Cliente;
    @FXML
    private TextField txtApePaterno;
    @FXML
    private TextField txtApeMaterno;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtCel;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextArea txtAreaNota;
    @FXML
    private TextField txtCiudad;
    @FXML
    private TextField txtContacto;
    @FXML
    private TextField txtCodPrecio;
    @FXML
    private TextField txtNitSucursal;
    @FXML
    private TextField txtFlete;
    @FXML
    private TextField txtCupo;
    @FXML
    private TextField txtPlazo;
    @FXML
    private TextField txtDsctoComercial;
    @FXML
    private TextField txtDsctoFinanciero;
    @FXML
    private DatePicker datePikerCumple;
    @FXML
    private TextField txtFechaIngreso;
    @FXML
    private TextField txtCodClasificacion;
    @FXML
    private TextField txtCodTipoProveedor;
    @FXML
    private TextField txtCodTipoCuentaCxP;
    @FXML
    private TextField txtCodCuenta;
    @FXML
    private ComboBox<String> jComboTipoIdentificacion;
    @FXML
    private ComboBox jComboFormaPago;
    @FXML
    private ToggleGroup grupoRadio;//esta variable no ha sido utilizada
    //checbox
    @FXML
    private CheckBox checkboxEsCliente;
    @FXML
    private CheckBox checkboxEsProveedor;
    @FXML
    private CheckBox checboxHabilitado;
    @FXML
    private CheckBox checboxEsSocio;
    @FXML
    private CheckBox checkboxEsEmpleado;
    @FXML
    private CheckBox checboxEsSucursal;
    @FXML
    private CheckBox checboxAdminImpuestos;

    ObservableList<String> listComboTipoIdent;
    private FormaPagosDao daoFormaPago;
    private TercerosDAo daoTercero;

    //metodo constructor
    public FXMLClientesController() {
        grupoRadio = new ToggleGroup();
        daoFormaPago = new FormaPagosDao();
        daoTercero = new TercerosDAo();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        //Aqui utilizamos la variale radios de la siguiente forma :  radioHabilitado.setToggleGroup(grupoRadio);
        listarComboFormaPagos();
        llenarComboTipoIdentificacion();
        FechaHoySistema();
    }

    public void llenarComboTipoIdentificacion() {
        listComboTipoIdent = FXCollections.observableArrayList(
                "---Seleccione---",
                "NIT",
                "CC",
                "NE",
                "CE",
                "TI",
                "RC"
        );
        jComboTipoIdentificacion.setItems(listComboTipoIdent);
    }

    public void FechaHoySistema() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy", new Locale("es_ES"));
        String mifecha;
        Date fechaHoy = new Date();
        mifecha = formateador.format(fechaHoy);
        txtFechaIngreso.setText(mifecha);
    }

    public void listarComboFormaPagos() {
        try {
            jComboFormaPago.getItems().removeAll();
            jComboFormaPago.getItems().add("---Seleccione---");
            List<DtoFormaPagos> list = daoFormaPago.listaComboFormaPago();
            Object fila[] = new Object[2];
            for (DtoFormaPagos dto : list) {
                fila[0] = dto.getCodFormaPago();
                fila[1] = dto.getNomFormaPago();
            }
            jComboFormaPago.getItems().addAll(list);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al Listar el combo Forma Pagos " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    private void accionNuevo(ActionEvent event) {
        txtNit.requestFocus();
        txtNit.setText("");
        txtNitSucursal.setText("");
        txtNombre.setText("");
        txtNombre2Cliente.setText("");
        txtApePaterno.setText("");
        txtApeMaterno.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCel.setText("");
        txtContacto.setText("");
        txtFlete.setText("0");
        txtDsctoComercial.setText("0");
        txtDsctoFinanciero.setText("0");
        txtCupo.setText("0");
        txtPlazo.setText("0");
        txtCodPrecio.setText("");
        txtCodTipoProveedor.setText("");
        txtCiudad.setText("");
        txtCodTipoCuentaCxP.setText("");
        txtCodClasificacion.setText("");
        txtCodCuenta.setText("");
        checkboxEsCliente.setSelected(true);
        checkboxEsEmpleado.setSelected(false);
        checkboxEsProveedor.setSelected(false);
        checboxEsSucursal.setSelected(false);
        checboxHabilitado.setSelected(false);
        checboxAdminImpuestos.setSelected(false);
        checboxEsSocio.setSelected(false);
        txtEmail.setText("");
        txtAreaNota.setText("");
        txtCiudad.setText("");
        txtNombre.setEditable(true);
        txtApePaterno.setEditable(true);
        txtApeMaterno.setEditable(true);
        txtDireccion.setEditable(true);
        txtTelefono.setEditable(true);
        txtCel.setEditable(true);
        txtEmail.setEditable(true);
        txtAreaNota.setEditable(true);
        txtCiudad.setEditable(true);
        jComboFormaPago.setValue("---Seleccione---");
        jComboTipoIdentificacion.setValue("---Seleccione---");
    }

    @FXML
    private void accionGuardar(ActionEvent event) {
        if (txtNit.getText().equals("")) {
            Action mensaje = Dialogs.create().title("ADVERTENCIA")
                    .message("El Campo Nit es Requerido!")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Verifique!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
            txtNit.requestFocus();
            txtNit.selectAll();
        } else if (jComboTipoIdentificacion.getSelectionModel().getSelectedItem().equals("---Seleccione---")) {
            Action mensaje = Dialogs.create().title("ADVERTENCIA")
                    .message("El Tipo de Identificacion es Requerido!")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Verifique!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
            jComboTipoIdentificacion.requestFocus();
        } else if (txtNombre.getText().equals("")) {
            Action mensaje = Dialogs.create().title("ADVERTENCIA")
                    .message("El Campo Nombre es Requerido!")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Verifique!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
            txtNombre.requestFocus();
            txtNombre.selectAll();
        } else {
            Action ok = Dialogs.create().title("Confirmar")
                    //.masthead("Guardar Categoria")
                    .actions(Dialog.ACTION_YES, Dialog.ACTION_NO)
                    .styleClass(Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .message("¿Esta Seguro de Guardar los Datos Cliente Ingresados ?")
                    .showConfirm();
            if (ok == Dialog.ACTION_YES) {
                DtoTerceros dto = new DtoTerceros();
                try {
                    String nit = txtNit.getText();
                    String nitSucursal = txtNitSucursal.getText();
                    String comboTipoIdenti = jComboTipoIdentificacion.getValue();
                    String comboFormaPago = jComboFormaPago.getValue().toString();
                    String fechaIngreso = txtFechaIngreso.getText();
                    //date fechaCumple = datePikerCumple.getValue();
                    String nomCliente1 = txtNombre.getText();
                    String nomCliente2 = txtNombre2Cliente.getText();
                    String apePat = txtApePaterno.getText();
                    String apeMat = txtApeMaterno.getText();
                    String direccion = txtDireccion.getText();
                    String email = txtEmail.getText();
                    String tel = txtTelefono.getText();
                    String cel = txtCel.getText();
                    String contacto = txtContacto.getText();
                    double flete = Double.parseDouble(txtFlete.getText());
                    double cupo = Double.parseDouble(txtCupo.getText());
                    int diasPlazo = Integer.parseInt(txtPlazo.getText());
                    float descuentoComercial = Float.parseFloat(txtDsctoComercial.getText());
                    float descuentoFinanciero = Float.parseFloat(txtDsctoFinanciero.getText());
                    String codPrecio = txtCodPrecio.getText();
                    String codCiudad = txtCiudad.getText();
                    String codClasificacion = txtCodClasificacion.getText();
                    String codTipoProveedor = txtCodTipoProveedor.getText();
                    String codTipoCXP = txtCodTipoCuentaCxP.getText();
                    String codCuenta = txtCodCuenta.getText();
                    String nota = txtAreaNota.getText();
                    boolean esCliente = checkboxEsCliente.isSelected();
                    boolean esProveedor = checkboxEsProveedor.isSelected();
                    boolean habilitado = checboxHabilitado.isSelected();
                    boolean esSocio = checboxEsSocio.isSelected();
                    boolean esEmpleado = checkboxEsEmpleado.isSelected();
                    boolean esSucursal = checboxEsSucursal.isSelected();
                    boolean esAdminImpuestos = checboxAdminImpuestos.isSelected();
                    dto.setNit(nit);
                    dto.setNitSucursal(nitSucursal);
                    dto.setTipoIdentificacion(comboTipoIdenti);
                    dto.setCodFormaPago(Integer.parseInt(comboFormaPago));
                    dto.setFechaIngreso(fechaIngreso);
                    //dto.setFechaCumple(fechaCumple);
                    dto.setNombre1(nomCliente1);
                    dto.setNombre2(nomCliente2);
                    dto.setApellido1(apePat);
                    dto.setApellido2(apeMat);
                    dto.setDireccion(direccion);
                    dto.setEmail(email);
                    dto.setTelefono(tel);
                    dto.setCelular(cel);
                    dto.setContacto(contacto);
                    dto.setFlete(flete);
                    dto.setCupoCredito(cupo);
                    dto.setPlazo(diasPlazo);
                    dto.setDescuentoComercial(descuentoComercial);
                    dto.setDescuentoFinanciero(descuentoFinanciero);
                    dto.setCodPrecio(codPrecio);
                    dto.setCodCiudad(codCiudad);
                    dto.setClasificacionDIAN(Integer.parseInt(codClasificacion));
                    dto.setCodTipoProveedor(codTipoProveedor);
                    dto.setCodTipoCxP(codTipoCXP);
                    dto.setCodCuenta(codCuenta);
                    dto.setObservacion(nota);
                    dto.setEsCliente(esCliente);
                    dto.setEsProveedor(esProveedor);
                    dto.setHabilitado(habilitado);
                    dto.setEsSocio(esSocio);
                    dto.setEsEmpleado(esEmpleado);
                    dto.setEsSucursal(esSucursal);
                    dto.setEsAdminImpuestos(esAdminImpuestos);
                    daoTercero.insertTercero(dto);
                    Action mensaje = Dialogs.create().title("CONFIRMACION")
                            .message("Datos Cliente Registrados Correctamente")
                            .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                            .masthead("Registro Exitoso")
                            .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                            .showConfirm();
                } catch (Exception ex) {
                    System.out.println("ERROR AL REGISTRAR EL CLIENTE\n");
                    Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                            .message("Error Registrando el Cliente\n" + ex.getMessage())
                            .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                            .masthead("Error!!")
                            .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                            .showError();
                }
            }
        }
    }

    @FXML
    private void accionCancelar(ActionEvent event) {
        txtNombre.setEditable(false);
        txtApePaterno.setEditable(false);
        txtApeMaterno.setEditable(false);
        txtDireccion.setEditable(false);
        txtTelefono.setEditable(false);
        txtCel.setEditable(false);
        txtEmail.setEditable(false);
        txtAreaNota.setEditable(false);
        txtCiudad.setEditable(false);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import clasesDao.CategoriasDao;
import clasesDao.ProductosDao;
import clasesDao.TipoInvDao;
import clasesDao.UnidadMedidaDao;
import dto.DtoCategoria;
import dto.DtoProductos;
import dto.DtoTipoInventario;
import dto.DtoUnidadMedida;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.swing.JOptionPane;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

/**
 * FXML Controller class
 *
 * @author SISTEMAS
 */
public class FXMLProductosController implements Initializable {

    @FXML
    private TextField txtFechaRegistroProducto;
    @FXML
    private Label lblCodigo;
    @FXML
    private Label lblReferencia;
    @FXML
    private Label lblProveedor;
    @FXML
    private Label lblPrecioCompra;
    @FXML
    private Label lblStock;
    @FXML
    private Label lblIva;
    @FXML
    private Label lblDescuento;
    @FXML
    private Label lblCodigoBarras;
    @FXML
    private Label lblCodPLU;
    @FXML
    private Label lblManifiesto;
    @FXML
    private RadioButton radioServicio;
    @FXML
    private RadioButton radioHabilitado;
    @FXML
    private TextField txtCodigoIdProducto;
    @FXML
    public TextField txtNitProveedor;
    @FXML
    public TextField txtReferencia;
    @FXML
    public TextField txtDescripcionProducto;
    @FXML
    private TextField txtNroManifiesto;
    @FXML
    private TextField txtCodigoPLU;
    @FXML
    private Button btnProveedor;
    @FXML
    private Button btnProducto;
    @FXML
    public TextField txtNomProveedor;
    @FXML
    private TextField txtPrecioCompra;
    @FXML
    private TextField txtStock;
    @FXML
    private TextField txtIvaProducto;
    @FXML
    private TextField txtDescuentoProducto;
    @FXML
    private ComboBox jComboCategoria;
    @FXML
    private ComboBox jComboTipoInventario;
    @FXML
    private ComboBox jComboUnidadMedida;
    @FXML
    private TableView tblProducto;
    @FXML
    private TableColumn colum;
    @FXML
    private TextArea txtAreaNota;
    @FXML
    private Button btnNuevoProducto;
    @FXML
    private Button btnGuardarProducto;
    @FXML
    private Button btnElminarProducto;
    @FXML
    private TextField txtCodigoBarras;
    @FXML
    private ToggleGroup grupoRadio;
    @FXML
    private Button btnAddCategoria;
    @FXML
    private Button btnTipoInventario;

    private CategoriasDao daoCategoria;
    private UnidadMedidaDao daoUnidMedida;
    private TipoInvDao daoTipoInv;
    private ProductosDao daoProd;
    private Stage stage;

    public FXMLProductosController() {
        daoCategoria = new CategoriasDao();
        daoUnidMedida = new UnidadMedidaDao();
        daoTipoInv = new TipoInvDao();
        grupoRadio = new ToggleGroup();
        daoProd = new ProductosDao();

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //TODO
        listarComboCategorias();
        listarUnidadMedida();
        listarComboTipoInvent();
        ultimoCodigoProducto();
        FechaHoySistema();
        radioHabilitado.setToggleGroup(grupoRadio);
        radioServicio.setToggleGroup(grupoRadio);
        radioHabilitado.setSelected(true);
        txtCodigoBarras.requestFocus();
    }

    public void FechaHoySistema() {
        SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy", new Locale("es_ES"));
        String mifecha;
        Date fechaHoy = new Date();
        mifecha = formateador.format(fechaHoy);
        txtFechaRegistroProducto.setText(mifecha);
    }

    @FXML
    /*Metodo para cargo el combo listarCategorias*/
    public void listarComboCategorias() {
        try {
            jComboCategoria.getItems().removeAll();
            jComboCategoria.getItems().add("---Seleccione---");
            List<DtoCategoria> list = daoCategoria.listarCategorias();
            Object fila[] = new Object[2];
            for (DtoCategoria dto : list) {
                fila[0] = dto.getCodigo();
                fila[1] = dto.getNombre();
            }
            jComboCategoria.getItems().addAll(list);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Listar el combo Categorias " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    /*Metodo para cargo el combo listarUnidadMedida*/
    public void listarUnidadMedida() {
        try {
            jComboUnidadMedida.getItems().removeAll();
            jComboUnidadMedida.getItems().add("---Seleccione---");
            List<DtoUnidadMedida> list = daoUnidMedida.listaComboUnidadMedida();
            Object fila[] = new Object[2];
            for (DtoUnidadMedida dto : list) {
                fila[0] = dto.getUnidad();
                fila[1] = dto.getNomUnidad();
            }
            jComboUnidadMedida.getItems().addAll(list);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al Listar el combo Unidad Medida " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    /*Metodo para cargo el combo listar Tipo Inventario*/
    public void listarComboTipoInvent() {
        try {
            jComboTipoInventario.getItems().removeAll();
            jComboTipoInventario.getItems().add("--Seleccione---");
            List<DtoTipoInventario> list = daoTipoInv.listarTipoInv();
            Object fila[] = new Object[2];
            for (DtoTipoInventario dto : list) {
                fila[0] = dto.getCodTipoInv();
                fila[1] = dto.getNomTipoInv();
            }
            jComboTipoInventario.getItems().addAll(list);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al Listar el combo TipoInventario " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void ultimoCodigoProducto() {
        try {
            Integer id = daoProd.ultimoCodProducto();
            txtCodigoIdProducto.setText(String.valueOf(id));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error Consultado el ultimo Codigo: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @FXML
    public void OnActionProductos(ActionEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.setLocation(getClass().getResource("/view/FXMLBuscaProductos.fxml"));
            fXMLLoader.load();
            Parent parent = fXMLLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);//Permite que obligue cerrar la ventana
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (Exception ex) {
            System.out.println("Error al abrir la ventana Busquedad de Productos : " + ex.getMessage());
        }
    }

    @FXML
    public void OnActionProveedor(ActionEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.setLocation(getClass().getResource("/view/FXMLBuscaProveedor.fxml"));
            fXMLLoader.load();
            Parent parent = fXMLLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);//Permite que obligue cerrar la ventana
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } catch (Exception ex) {
            System.out.println("Error al abrir la ventana Busquedad de Productos : " + ex.getMessage());
        }
    }

    @FXML
    public void OnActionAddCategoria(ActionEvent event) {
        try {
            //((Node) (event.getSource())).getScene().getWindow().hide();//Esta linea es para esconder la ventana de atras
            Parent parent = FXMLLoader.load(getClass().getResource("/view/FXMLCategoria.fxml"));
            stage = new Stage();
            Scene scene = new Scene(parent);
            stage.initStyle(StageStyle.DECORATED);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.setTitle("Registro de Categorias");
            stage.show();

        } catch (Exception ex) {
            System.out.println("Error al abrir la ventana Categorias : " + ex.getMessage());
            Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                    .message("Error al abrir la ventana Categorias\n" + ex.getMessage())
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Error!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showError();
        }
    }

    @FXML
    public void OnActionAbrirTipoInvent(ActionEvent event) {
        try {
            FXMLLoader fXMLLoader = new FXMLLoader();
            fXMLLoader.setLocation(getClass().getResource("/view/FXMLTipoInventario.fxml"));
            fXMLLoader.load();
            Parent parent = fXMLLoader.getRoot();
            Scene scene = new Scene(parent);
            scene.setFill(new Color(0, 0, 0, 0));
            stage = new Stage();
            stage.setScene(scene);
            stage.initModality(Modality.APPLICATION_MODAL);//Permite que obligue cerrar la ventana
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();

        } catch (Exception ex) {
            System.out.println("Error al abrir la ventana Tipo Inventario : " + ex.getMessage());
            Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                    .message("Error al abrir la ventana Tipo Inventario\n" + ex.getMessage())
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Error!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showError();
        }
    }

    @FXML
    public void OnKeyPressedCodBarras(KeyEvent evt) {
        if (evt.getCode().equals(KeyCode.ENTER)) {
            txtCodigoPLU.requestFocus();
        }
    }

    @FXML
    public void OnKeyPressedCodPLU(KeyEvent evt) {
        if (evt.getCode().equals(KeyCode.ENTER)) {
            txtReferencia.requestFocus();
        }
    }

    @FXML
    public void OnKeyPressedReferencia(KeyEvent evt) {
        if (evt.getCode().equals(KeyCode.ENTER)) {
            txtDescripcionProducto.requestFocus();
        }
    }

    @FXML
    public void OnKeyPressedDescripcionProducto(KeyEvent evt) {
        if (evt.getCode().equals(KeyCode.ENTER)) {
            txtNitProveedor.requestFocus();
        }
    }

    @FXML
    public void OnKeyPressedProveedor(KeyEvent evt) {
        if (evt.getCode().equals(KeyCode.ENTER)) {
            btnProveedor.fire();
        }
    }

    @FXML
    public void OnKeyPressedNomProveedor(KeyEvent evt) {
        if (evt.getCode().equals(KeyCode.ENTER)) {
            txtPrecioCompra.requestFocus();
        }
    }

    @FXML
    public void OnKeyPressedPrecioCompra(KeyEvent evt) {
        if (evt.getCode().equals(KeyCode.ENTER)) {
            txtStock.requestFocus();
        }
    }

    @FXML
    public void OnKeyPressedStock(KeyEvent evt) {
        if (evt.getCode().equals(KeyCode.ENTER)) {
            txtIvaProducto.requestFocus();
        }
    }

    @FXML
    public void OnKeyPressedIvaProducto(KeyEvent evt) {
        if (evt.getCode().equals(KeyCode.ENTER)) {
            txtDescuentoProducto.requestFocus();
        }
    }

    @FXML
    public void OnKeyPressedDescuentoProducto(KeyEvent evt) {
        if (evt.getCode().equals(KeyCode.ENTER)) {
            jComboCategoria.requestFocus();
        }
    }

    @FXML
    public void OnActionNuevoProducto(ActionEvent event) {
        ultimoCodigoProducto();
        limpiarTXT();
    }

    @FXML
    public void OnActionGuardarProductoss(ActionEvent event) {
        if (txtReferencia.getText().equals("")) {
            Action mensaje = Dialogs.create().title("ADVERTENCIA")
                    .message("El Campo Referencia es Requerido!")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Verifique!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
            txtReferencia.requestFocus();
            txtReferencia.selectAll();
        } else if (txtNitProveedor.getText().equals("")) {
            Action mensaje = Dialogs.create().title("ADVERTENCIA")
                    .message("El Campo Nit Proveedor es Requerido!")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Verifique!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
            txtNitProveedor.requestFocus();
            txtNitProveedor.selectAll();
        } else if (txtPrecioCompra.getText().equals("") || txtPrecioCompra.getText().equals("0")) {
            Action mensaje = Dialogs.create().title("ADVERTENCIA")
                    .message("El Campo Precio Compra es Requerido!")
                    .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                    .masthead("Verifique!!")
                    .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .showWarning();
            txtPrecioCompra.requestFocus();
            txtPrecioCompra.selectAll();
        } else {
            Action ok = Dialogs.create().title("Confirmar")
                    //.masthead("Guardar Categoria")
                    .actions(Dialog.ACTION_YES, Dialog.ACTION_NO)
                    .styleClass(Dialog.STYLE_CLASS_CROSS_PLATFORM)
                    .message("¿Esta Seguro de Guardar los Datos Ingresados ?")
                    .showConfirm();
            if (ok == Dialog.ACTION_YES) {
                try {
                    //guardamos variables
                    DtoProductos dto = new DtoProductos();
                    String idCodigo = txtCodigoIdProducto.getText();
                    String codbarras = txtCodigoBarras.getText();
                    String codPLU = txtCodigoPLU.getText();
                    String referencia = txtReferencia.getText();
                    String descripcion = txtDescripcionProducto.getText();
                    String nitProveedor = txtNitProveedor.getText();
                    double precioCompra = Double.parseDouble(txtPrecioCompra.getText());
                    int stock = Integer.parseInt(txtStock.getText());
                    float ivaProducto = Float.parseFloat(txtIvaProducto.getText());
                    float descuentoProducto = Float.parseFloat(txtDescuentoProducto.getText());
                    String manifiesto = txtNroManifiesto.getText();
                    String nota = txtAreaNota.getText();
                    String codCategoria = jComboCategoria.getValue().toString().split("-")[0].trim();
                    String codUnidadMed = jComboUnidadMedida.getValue().toString().split("-")[0].trim();
                    String codTipoInv = jComboTipoInventario.getValue().toString().split("-")[0].trim();
                    boolean servicio = radioServicio.isSelected();
                    boolean habilitado = radioHabilitado.isSelected();
                    dto.setIdCodigo(idCodigo);
                    dto.setReferenciaProducto(referencia);
                    dto.setDescripcion(descripcion);
                    dto.setPrecioCompra(precioCompra);
                    dto.setStock(stock);
                    dto.setObservacionProducto(nota);
                    dto.setCodCategoria(Integer.parseInt(codCategoria));
                    dto.setDniProveedor(nitProveedor);
                    dto.setIvaProd(ivaProducto);
                    dto.setDescuentoProd(descuentoProducto);
                    dto.setCodTipoInv(codTipoInv);
                    dto.setCodUnidadMedida(codUnidadMed);
                    dto.setCodigoBarras(codbarras);
                    dto.setCodigoPLU(codPLU);
                    dto.setNroManifiestro(manifiesto);
                    dto.setServicio(servicio);
                    dto.setHabilitado(habilitado);
                    String result = "";
                    result = daoProd.insertaProducto(dto);
                    //Registro exitoso
                    Action mensaje = Dialogs.create().title("CONFIRMADO")
                            .message(""+result)
                            .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                            .masthead("EXITO.")
                            .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                            .showConfirm();
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Action mensaje = Dialogs.create().title("ADVERTERNCIA")
                            .message("Error al Guardar el Producto\n" + ex.getMessage())
                            .actions(org.controlsfx.dialog.Dialog.ACTION_CLOSE)
                            .masthead("Error!!")
                            .styleClass(org.controlsfx.dialog.Dialog.STYLE_CLASS_CROSS_PLATFORM)
                            .showError();
                }
            }
        }
    }

    public void limpiarTXT() {
        txtCodigoBarras.requestFocus();
        txtCodigoBarras.setText("");
        txtCodigoPLU.setText("");
        txtReferencia.setText("");
        txtDescripcionProducto.setText("");
        txtNitProveedor.setText("");
        txtNomProveedor.setText("");
        txtPrecioCompra.setText("0");
        txtStock.setText("0");
        txtIvaProducto.setText("0");
        txtDescuentoProducto.setText("0");
        txtAreaNota.setText("");
        txtNroManifiesto.setText("");
        jComboCategoria.setValue("---Seleccione---");
        jComboUnidadMedida.setValue("---Seleccione---");
        jComboTipoInventario.setValue("---Seleccione---");
    }
}

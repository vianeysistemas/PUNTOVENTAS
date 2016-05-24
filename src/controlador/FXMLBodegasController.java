/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import dto.DtoBodegas;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

/**
 * FXML Controller class
 *
 * @author SISTEMAS
 */
public class FXMLBodegasController implements Initializable {

    @FXML
    private TextField txtCodBodega;
    @FXML
    private TextField txtDescripcionBodega;
    @FXML
    private TextField txtBodega;
    @FXML
    private TableView<DtoBodegas> tblBodega;
    @FXML
    private TableColumn<DtoBodegas, String> colCodigo;
    @FXML
    private TableColumn<DtoBodegas, String> colBodega;
    @FXML
    private TableColumn<DtoBodegas, String> colDescripcion;
    @FXML
    private TableColumn colAccion;

    ObservableList<DtoBodegas> listBodega;
    private String StatusKode;
    private String statusKlik;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        colCodigo.setCellValueFactory(
                (TableColumn.CellDataFeatures<DtoBodegas, String> cellData)
                -> cellData.getValue().getBodegaProperty());
        colDescripcion.setCellValueFactory(
                (TableColumn.CellDataFeatures<DtoBodegas, String> cellData)
                -> cellData.getValue().getDescripcionProperty());
        colBodega.setCellValueFactory(
                (TableColumn.CellDataFeatures<DtoBodegas, String> cellData)
                -> cellData.getValue().getBodegaProperty());
        colAccion.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Object, Boolean>, ObservableValue<Boolean>>() {
            @Override
            public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<Object, Boolean> p) {
                return new SimpleBooleanProperty(p.getValue() != null);
            }
        });

        colAccion.setCellFactory(new Callback<TableColumn<Object, Boolean>, TableCell<Object, Boolean>>() {
            @Override
            public TableCell<Object, Boolean> call(TableColumn<Object, Boolean> p) {
                return new ButtonCell(tblBodega);
            }
        });

        listBodega = FXCollections.observableArrayList();
        tblBodega.getSelectionModel().clearSelection();
    }

    @FXML
    private void OnMouseClickedTblBodega(MouseEvent event) {
        if (statusKlik.equals("1")) {
            StatusKode = "1";
            try {
                DtoBodegas dto = tblBodega.getSelectionModel().getSelectedItems().get(0);
                txtCodBodega.setText(String.valueOf(dto.getCodBodega()));
                txtBodega.setText(dto.getBodega());
                txtDescripcionBodega.setText(dto.getDescripcionBodega());
            } catch (Exception e) {
                System.out.println("Error Al hacer click en la tabla : " + e.getMessage());
            }
        }
    }

    private void clear() {
        txtBodega.clear();
        txtBodega.clear();
        txtDescripcionBodega.clear();
        StatusKode = "0";
    }

    private class ButtonCell extends TableCell<Object, Boolean> {

        final Hyperlink cellButtonDelete = new Hyperlink("ELIMINAR");
        final Hyperlink cellButtonEdit = new Hyperlink("EDITAR");
        final HBox hb = new HBox(cellButtonDelete, cellButtonEdit);

        ButtonCell(final TableView tblView) {
            hb.setSpacing(4);

            //cell delete
            cellButtonDelete.setOnAction((ActionEvent t) -> {
                statusKlik = "1";
                int row = getTableRow().getIndex();
                tblBodega.getSelectionModel().select(row);
                OnMouseClickedTblBodega(null);
                DtoBodegas dto = new DtoBodegas();
                dto.setCodBodegaProperty(txtCodBodega.getText());
                clear();
                //dialog(Alert.AlertType.INFORMATION, "Registro Eliminado!!");
                statusKlik = "0";
                StatusKode = "0";
            });

            //cell edit
            cellButtonEdit.setOnAction((ActionEvent event) -> {
                statusKlik = "1";
                int row = getTableRow().getIndex();
                tblBodega.getSelectionModel().select(row);
                OnMouseClickedTblBodega(null);
                statusKlik = "0";
            });
        }

        @Override
        protected void updateItem(Boolean t, boolean empty) {
            super.updateItem(t, empty);
            if (!empty) {
                setGraphic(hb);
            } else {
                setGraphic(null);
            }
        }
    }
}

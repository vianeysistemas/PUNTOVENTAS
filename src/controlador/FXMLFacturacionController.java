/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import eu.schudt.javafx.controls.calendar.DatePicker;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Sistemas
 */
public class FXMLFacturacionController implements Initializable {

    @FXML
    private ComboBox<String> comboTipoDocumento;
    @FXML
    private DatePicker txtFecha;

    ObservableList<String> listComboTipoDcto = FXCollections.observableArrayList(
            "FACTURA", "NOTA-VENTA"
    );

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        comboTipoDocumento.setItems(listComboTipoDcto);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 *
 * @author Edidelson
 */
public class FXMLGenerico {

    /**
     * Shows the person overview scene.
     *
     * @param rootLayout
     * @param fxml
     */
    public void showFXMLview(BorderPane rootLayout, String fxml) {
        try {
            // Load the fxml file and set into the center of the main layout
            FXMLLoader loader = new FXMLLoader(FXMLClientesController.class.getResource(fxml));
            AnchorPane overviewPage = (AnchorPane) loader.load();
            rootLayout.setCenter(overviewPage);
        } catch (IOException e) {
            System.out.println("Error showFXMLView : "+e.getMessage());
            // Exception gets thrown if the fxml file could not be loaded
            e.printStackTrace();
        }
    }

}

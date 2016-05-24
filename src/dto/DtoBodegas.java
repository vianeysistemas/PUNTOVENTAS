/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author SISTEMAS
 */
public class DtoBodegas {

    private final StringProperty codBodegaProperty = new SimpleStringProperty();
    private final StringProperty descripcionProperty = new SimpleStringProperty();
    private final StringProperty bodegaProperty = new SimpleStringProperty();

    private int codBodega;
    private String descripcionBodega;
    private String bodega;

    public DtoBodegas(){
        
    }
    
    public int getCodBodega() {
        return codBodega;
    }

    public void setCodBodega(int codBodega) {
        this.codBodega = codBodega;
    }

    public String getDescripcionBodega() {
        return descripcionBodega;
    }

    public void setDescripcionBodega(String descripcionBodega) {
        this.descripcionBodega = descripcionBodega;
    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }
    //PROPERTY

    public StringProperty getCodBodegaProperty() {
        return codBodegaProperty;
    }

    public StringProperty getDescripcionProperty() {
        return descripcionProperty;
    }

    public StringProperty getBodegaProperty() {
        return bodegaProperty;
    }

    public void setCodBodegaProperty(String value) {
        codBodegaProperty.setValue(value);
    }

    public void setBodegaProperty(String value) {
        bodegaProperty.setValue(value);
    }

    public void setDescripcionProperty(String value) {
        descripcionProperty.setValue(value);
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author SISTEMAS
 */
public class DtoCategoria {

    private final StringProperty codCatProperty = new SimpleStringProperty();
    private final StringProperty nomCatProperty = new SimpleStringProperty();
    private Integer codigo;
    private String nombre;

    public DtoCategoria() {

    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Propertys para tabla
    public void setCodCatProperty(String value) {
        codCatProperty.set(value);
    }

    public StringProperty getCodCatTblProperty() {//con este metodo hacemos que en el controlador se almacenen losdatos en las columnas de la tabla
        return codCatProperty;
    }

    public String getCodCatProperty() {
        return codCatProperty.get();
    }

    public StringProperty getNomCatProperty() {
        return nomCatProperty;
    }

    public String getNombreCat() {
        return nomCatProperty.get();
    }

    public void setNombreCat(String value) {
        this.nomCatProperty.set(value);
    }

//    @Override
//    public String toString() {
//        return codCategoria + " - " + nomCategoria;
//    }
    @Override
    public String toString() {
        return codigo + " - " + nombre;
    }

}

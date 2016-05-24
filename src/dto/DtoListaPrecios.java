/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.text.SimpleDateFormat;
import java.util.Date;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Vianey Vargas
 */
public class DtoListaPrecios {

    //variables para llenar tabla productos
    private StringProperty propertyCodPrecio = new SimpleStringProperty();
    private StringProperty propertyDescripcion = new SimpleStringProperty();
    private StringProperty propertyTitulo = new SimpleStringProperty();
    private StringProperty propertyPrecio = new SimpleStringProperty();
    private StringProperty propertyMasIva = new SimpleStringProperty();
    private ObjectProperty<Date> propertyFecha1 = new SimpleObjectProperty<>();
    private ObjectProperty<Date> propertyFecha2 = new SimpleObjectProperty<>();
    //-----------------------------------------------------------------------------
    private String codPrecio;
    private String descripcion;
    private Date fecha1;
    private Date fecha2;
    private String titulo;
    private double precio;
    private double masIva;
    private String formatTanggal;

    public DtoListaPrecios() {

    }
    public void setFormatTanggal(String formatTanggal) {
        this.formatTanggal = formatTanggal;
    }

    public String getCodPrecio() {
        return codPrecio;
    }

    public void setCodPrecio(String codPrecio) {
        this.codPrecio = codPrecio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getMasIva() {
        return masIva;
    }

    public void setMasIva(double masIva) {
        this.masIva = masIva;
    }

    //GETTER propertys para tabla
    public void setPropertyCodPrecio(String propertyCodPrecio) {
        this.propertyCodPrecio.set(propertyCodPrecio);
    }

    public void setPropertyDescripcion(String propertyDescripcion) {
        this.propertyDescripcion.set(propertyDescripcion);
    }

    public void setPropertyTitulo(String propertyTitulo) {
        this.propertyTitulo.set(propertyTitulo);
    }

    public void setPropertyPrecio(String propertyPrecio) {
        this.propertyPrecio.set(propertyPrecio);
    }

    public void setPropertyMasIva(String propertyMasIva) {
        this.propertyMasIva.set(propertyMasIva);
    }

    public void setPropertyFecha1(Date propertyFecha1) {
        this.propertyFecha1.set(propertyFecha1);
    }

    public void setPropertyFecha2(Date propertyFecha2) {
        this.propertyFecha2.set(propertyFecha2);
    }
    //GETTER NOT GET propertys para tabla

    public StringProperty getPropertyCodPrecio() {
        return propertyCodPrecio;
    }

    public StringProperty getPropertyDescripcion() {
        return propertyDescripcion;
    }

    public StringProperty getPropertyTitulo() {
        return propertyTitulo;
    }

    public StringProperty getPropertyPrecio() {
        return propertyPrecio;
    }

    public StringProperty getPropertyMasIva() {
        return propertyMasIva;
    }

    public ObjectProperty<Date> getPropertyFecha1() {
        return propertyFecha1;
    }

    public ObjectProperty<Date> getPropertyFecha2() {
        return propertyFecha2;
    }

    //GETTER CON GET
    public String getPropertyStringCodPrecio() {
        return propertyCodPrecio.get();
    }

    public String getPropertyStringDescripcion() {
        return propertyDescripcion.get();
    }

    public String getPropertyStringTitulo() {
        return propertyTitulo.get();
    }

    public String getFormatFecha1() {
        Date tanggal = getFecha1();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String format = df.format(tanggal);
        return format;
    }

    public String getFormatFecha2() {
        Date tanggal = getFecha1();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String format = df.format(tanggal);
        return format;
    }

}

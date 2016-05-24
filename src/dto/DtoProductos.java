/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dto.DtoProductos;
import java.sql.ResultSet;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author soporte
 */
public class DtoProductos {

    //variables para llenar tabla productos
    private final StringProperty propertyIdCodigo = new SimpleStringProperty();
    private final StringProperty propertyReferencia = new SimpleStringProperty();
    private final StringProperty propertyDescripcion = new SimpleStringProperty();

    private String idCodigo;
    private String referenciaProducto;
    private String descripcion;
    private double precioCompra;
    private double precioVenta;
    private int stock;
    private String observacionProducto;
    private int codCategoria;
    private String dniProveedor;
    private float ivaProd;
    private float descuentoProd;
    private String codTipoInv;
    private String codUnidadMedida;
    private String codigoBarras;
    private String codigoPLU;
    private String nroManifiestro;
    private boolean servicio;
    private boolean habilitado;
    private boolean retorno;
    private String mensajeBD;

    private double cantDisponible;
    /*METDO CONSTRUCTOR */

    public DtoProductos() {
    }

    public String getIdCodigo() {
        return idCodigo;
    }

    public void setIdCodigo(String idCodigo) {
        this.idCodigo = idCodigo;
    }

    public String getReferenciaProducto() {
        return referenciaProducto;
    }

    public void setReferenciaProducto(String referenciaProducto) {
        this.referenciaProducto = referenciaProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(Double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getObservacionProducto() {
        return observacionProducto;
    }

    public void setObservacionProducto(String observacionProducto) {
        this.observacionProducto = observacionProducto;
    }

    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public void setIvaProd(float ivaProd) {
        this.ivaProd = ivaProd;
    }

    public void setDescuentoProd(float descuentoProd) {
        this.descuentoProd = descuentoProd;
    }

    public float getIvaProd() {
        return ivaProd;
    }

    public float getDescuentoProd() {
        return descuentoProd;
    }

    public String getDniProveedor() {
        return dniProveedor;
    }

    public void setDniProveedor(String dniProveedor) {
        this.dniProveedor = dniProveedor;
    }

    public double getCantDisponible() {
        return cantDisponible;
    }

    public void setCantDisponible(double cantDisponible) {
        this.cantDisponible = cantDisponible;
    }

    public String getCodTipoInv() {
        return codTipoInv;
    }

    public void setCodTipoInv(String codTipoInv) {
        this.codTipoInv = codTipoInv;
    }

    public String getCodUnidadMedida() {
        return codUnidadMedida;
    }

    public void setCodUnidadMedida(String codUnidadMedida) {
        this.codUnidadMedida = codUnidadMedida;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getCodigoPLU() {
        return codigoPLU;
    }

    public void setCodigoPLU(String codigoPLU) {
        this.codigoPLU = codigoPLU;
    }

    public String getNroManifiestro() {
        return nroManifiestro;
    }

    public void setNroManifiestro(String nroManifiestro) {
        this.nroManifiestro = nroManifiestro;
    }

    public boolean isServicio() {
        return servicio;
    }

    public void setServicio(boolean servicio) {
        this.servicio = servicio;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public boolean isRetorno() {
        return retorno;
    }

    public void setRetorno(boolean retorno) {
        this.retorno = retorno;
    }

    public String getMensajeBD() {
        return mensajeBD;
    }

    public void setMensajeBD(String mensajeBD) {
        this.mensajeBD = mensajeBD;
    }
    
    
    

    //geter and setter propertys para tabla
    public StringProperty getPropertyIdCodigo() {
        return propertyIdCodigo;
    }

    public StringProperty getPropertyReferencia() {
        return propertyReferencia;
    }

    public StringProperty getPropertyDescripcion() {
        return propertyDescripcion;
    }

    public void setPropertyIdCodigo(String value) {
        propertyIdCodigo.set(value);
    }

    public void setPropertyReferencia(String value) {
        this.propertyReferencia.set(value);
    }

    public void setPropertyDescripcion(String value) {
        this.propertyDescripcion.set(value);
    }

    public String getPropertyStringIdCodigo() {
        return propertyIdCodigo.get();
    }

    public String getPropertyStringReferencia() {
        return propertyReferencia.get();
    }

    public String getPropertyStringDescripcion() {
        return propertyDescripcion.get();
    }

}

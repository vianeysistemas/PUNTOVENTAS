/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dto.DtoTerceros;
import java.sql.ResultSet;
import java.util.Date;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Sistemas
 */
public class DtoTerceros {

    private final StringProperty propertyNitProveedor = new SimpleStringProperty();
    private final StringProperty propertyNomProveedor = new SimpleStringProperty();

    private String nit;
    private String nombre1;
    private String nombre2;
    private String apellido1;
    private String apellido2;
    private String telefono;
    private String celular;
    private String Email;
    private String direccion;
    private boolean esCliente;
    private boolean esProveedor;
    private boolean esEmpleado;
    private boolean esSocio;
    private boolean habilitado;
    private boolean esAdminImpuestos;
    private boolean esSucursal;
    private String codPrecio;
    private int codContribuyente;
    private String contacto;
    private int CodFormaPago;
    private int codVendedor;
    private String codActividadEc;
    private String codTipoProveedor;
    private String fechaIngreso;
    private String fechaCumple;
    private String nitSucursal;
    private String tipoIdentificacion;
    private Double flete;
    private String codCiudad;
    private Double cupoCredito;
    private int clasificacionDIAN;
    private int plazo;
    private String observacion;
    private String nomVendedor;
    private String nomTipoContribuyente;
    private String nomActividad;
    private String nomCiudad;
    private String nomTituloPrecio;
    private String nomClasificacion;
    private String fechaVencimiento;
    private Float descuentoComercial;
    private Float descuentoFinanciero;
    private String codTipoCxP;
    private String codCuenta;

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public boolean isEsCliente() {
        return esCliente;
    }

    public void setEsCliente(boolean esCliente) {
        this.esCliente = esCliente;
    }

    public boolean isEsProveedor() {
        return esProveedor;
    }

    public void setEsProveedor(boolean esProveedor) {
        this.esProveedor = esProveedor;
    }

    public boolean isEsEmpleado() {
        return esEmpleado;
    }

    public void setEsEmpleado(boolean esEmpleado) {
        this.esEmpleado = esEmpleado;
    }

    public boolean isEsSocio() {
        return esSocio;
    }

    public void setEsSocio(boolean esSocio) {
        this.esSocio = esSocio;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    public boolean isEsAdminImpuestos() {
        return esAdminImpuestos;
    }

    public void setEsAdminImpuestos(boolean esAdminImpuestos) {
        this.esAdminImpuestos = esAdminImpuestos;
    }

    public boolean isEsSucursal() {
        return esSucursal;
    }

    public void setEsSucursal(boolean esSucursal) {
        this.esSucursal = esSucursal;
    }

    public String getCodPrecio() {
        return codPrecio;
    }

    public void setCodPrecio(String codPrecio) {
        this.codPrecio = codPrecio;
    }

    public int getCodContribuyente() {
        return codContribuyente;
    }

    public void setCodContribuyente(int codContribuyente) {
        this.codContribuyente = codContribuyente;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public int getCodFormaPago() {
        return CodFormaPago;
    }

    public void setCodFormaPago(int CodFormaPago) {
        this.CodFormaPago = CodFormaPago;
    }

    public int getCodVendedor() {
        return codVendedor;
    }

    public void setCodVendedor(int codVendedor) {
        this.codVendedor = codVendedor;
    }

    public String getCodActividadEc() {
        return codActividadEc;
    }

    public void setCodActividadEc(String codActividadEc) {
        this.codActividadEc = codActividadEc;
    }

    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(String fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getFechaCumple() {
        return fechaCumple;
    }

    public void setFechaCumple(String fechaCumple) {
        this.fechaCumple = fechaCumple;
    }

    public String getNitSucursal() {
        return nitSucursal;
    }

    public void setNitSucursal(String nitSucursal) {
        this.nitSucursal = nitSucursal;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public Double getFlete() {
        return flete;
    }

    public void setFlete(Double flete) {
        this.flete = flete;
    }

    public String getCodCiudad() {
        return codCiudad;
    }

    public void setCodCiudad(String codCiudad) {
        this.codCiudad = codCiudad;
    }

    public Double getCupoCredito() {
        return cupoCredito;
    }

    public void setCupoCredito(Double cupoCredito) {
        this.cupoCredito = cupoCredito;
    }

    public int getClasificacionDIAN() {
        return clasificacionDIAN;
    }

    public void setClasificacionDIAN(int clasificacionDIAN) {
        this.clasificacionDIAN = clasificacionDIAN;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getNomVendedor() {
        return nomVendedor;
    }

    public void setNomVendedor(String nomVendedor) {
        this.nomVendedor = nomVendedor;
    }

    public String getNomTipoContribuyente() {
        return nomTipoContribuyente;
    }

    public void setNomTipoContribuyente(String nomTipoContribuyente) {
        this.nomTipoContribuyente = nomTipoContribuyente;
    }

    public String getNomActividad() {
        return nomActividad;
    }

    public void setNomActividad(String nomActividad) {
        this.nomActividad = nomActividad;
    }

    public String getNomCiudad() {
        return nomCiudad;
    }

    public void setNomCiudad(String nomCiudad) {
        this.nomCiudad = nomCiudad;
    }

    public String getNomTituloPrecio() {
        return nomTituloPrecio;
    }

    public void setNomTituloPrecio(String nomTituloPrecio) {
        this.nomTituloPrecio = nomTituloPrecio;
    }

    public String getNomClasificacion() {
        return nomClasificacion;
    }

    public void setNomClasificacion(String nomClasificacion) {
        this.nomClasificacion = nomClasificacion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Float getDescuentoComercial() {
        return descuentoComercial;
    }

    public void setDescuentoComercial(Float descuentoComercial) {
        this.descuentoComercial = descuentoComercial;
    }

    public Float getDescuentoFinanciero() {
        return descuentoFinanciero;
    }

    public void setDescuentoFinanciero(Float descuentoFinanciero) {
        this.descuentoFinanciero = descuentoFinanciero;
    }

    public String getCodTipoProveedor() {
        return codTipoProveedor;
    }

    public void setCodTipoProveedor(String codTipoProveedor) {
        this.codTipoProveedor = codTipoProveedor;
    }

    public String getCodTipoCxP() {
        return codTipoCxP;
    }

    public void setCodTipoCxP(String codTipoCxP) {
        this.codTipoCxP = codTipoCxP;
    }

    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }
    
    
    
    
    
    
    

    //geter and setter propertys para tabla
    public StringProperty getPropertyNitProveedor() {
        return propertyNitProveedor;
    }

    public StringProperty getPropertyNomProveedor() {
        return propertyNomProveedor;
    }

    public void setPropertyNitProveedor(String value) {
        this.propertyNitProveedor.set(value);
    }

    public void setPropertyNomProveedor(String value) {
        this.propertyNomProveedor.set(value);
    }

    public String getPropertyStringNitProv() {
        return propertyNitProveedor.get();
    }

    public String getPropertyStringNomProv() {
        return propertyNomProveedor.get();
    }

}

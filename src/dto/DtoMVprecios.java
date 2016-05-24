/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author SISTEMAS
 */
public class DtoMVprecios {
    private String codPrecio;
    private String referencia;
    private double precio;
    private double descuentoProducto;
    private double ivaProducto;
    
    public DtoMVprecios(){
        
    }

    public String getCodPrecio() {
        return codPrecio;
    }

    public void setCodPrecio(String codPrecio) {
        this.codPrecio = codPrecio;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDescuentoProducto() {
        return descuentoProducto;
    }

    public void setDescuentoProducto(double descuentoProducto) {
        this.descuentoProducto = descuentoProducto;
    }

    public double getIvaProducto() {
        return ivaProducto;
    }

    public void setIvaProducto(double ivaProducto) {
        this.ivaProducto = ivaProducto;
    }
    
}

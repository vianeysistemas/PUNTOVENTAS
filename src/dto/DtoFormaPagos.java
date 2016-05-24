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
public class DtoFormaPagos {

    public DtoFormaPagos() {

    }
    private int codFormaPago;
    private String nomFormaPago;

    public int getCodFormaPago() {
        return codFormaPago;
    }

    public void setCodFormaPago(int codFormaPago) {
        this.codFormaPago = codFormaPago;
    }

    public String getNomFormaPago() {
        return nomFormaPago;
    }

    public void setNomFormaPago(String nomFormaPago) {
        this.nomFormaPago = nomFormaPago;
    }

    @Override
    public String toString() {
        return codFormaPago + " - " + nomFormaPago;
    }

}

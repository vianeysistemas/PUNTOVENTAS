/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import dto.DtoProveedor;

/**
 *
 * @author Sistemas
 */
public class DtoProveedor {

    private String dniProveedor;
    private String razonSocialProv;
    private String direccionProv;
    private String telefonoProv;
    private String celularProv;
    private String emailProv;
    private String observacionProv;
    private String nomTipoProv;
    private String codTipoCxP;
    private float desctoComercia;
    private float desctoFinanciero;

    public DtoProveedor(){
       
    }

    public String getDniProveedor() {
        return dniProveedor;
    }

    public void setDniProveedor(String dniProveedor) {
        this.dniProveedor = dniProveedor;
    }

    public String getRazonSocialProv() {
        return razonSocialProv;
    }

    public void setRazonSocialProv(String razonSocialProv) {
        this.razonSocialProv = razonSocialProv;
    }

    public String getDireccionProv() {
        return direccionProv;
    }

    public void setDireccionProv(String direccionProv) {
        this.direccionProv = direccionProv;
    }

    public String getTelefonoProv() {
        return telefonoProv;
    }

    public void setTelefonoProv(String telefonoProv) {
        this.telefonoProv = telefonoProv;
    }

    public String getCelularProv() {
        return celularProv;
    }

    public void setCelularProv(String celularProv) {
        this.celularProv = celularProv;
    }

    public String getEmailProv() {
        return emailProv;
    }

    public void setEmailProv(String emailProv) {
        this.emailProv = emailProv;
    }

    public String getObservacionProv() {
        return observacionProv;
    }

    public void setObservacionProv(String observacionProv) {
        this.observacionProv = observacionProv;
    }

    public String getNomTipoProv() {
        return nomTipoProv;
    }

    public void setNomTipoProv(String nomTipoProv) {
        this.nomTipoProv = nomTipoProv;
    }

    public String getCodTipoCxP() {
        return codTipoCxP;
    }

    public void setCodTipoCxP(String codTipoCxP) {
        this.codTipoCxP = codTipoCxP;
    }

    public float getDesctoComercia() {
        return desctoComercia;
    }

    public void setDesctoComercia(float desctoComercia) {
        this.desctoComercia = desctoComercia;
    }

    public float getDesctoFinanciero() {
        return desctoFinanciero;
    }

    public void setDesctoFinanciero(float desctoFinanciero) {
        this.desctoFinanciero = desctoFinanciero;
    }

}

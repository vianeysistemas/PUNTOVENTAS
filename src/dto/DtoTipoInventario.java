/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

/**
 *
 * @author Vianey Vargas
 */
public class DtoTipoInventario {

    private int codTipoInv;
    private String nomTipoInv;

    public DtoTipoInventario() {

    }

    public int getCodTipoInv() {
        return codTipoInv;
    }

    public void setCodTipoInv(int codTipoInv) {
        this.codTipoInv = codTipoInv;
    }

    public String getNomTipoInv() {
        return nomTipoInv;
    }

    public void setNomTipoInv(String nomTipoInv) {
        this.nomTipoInv = nomTipoInv;
    }

    @Override
    public String toString() {
         return codTipoInv + " - " + nomTipoInv;
    }
    

}

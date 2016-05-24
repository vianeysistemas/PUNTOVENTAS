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
public class DtoUnidadMedida {

    private int codUnidadMedida;
    private String unidad;
    private String nomUnidad;

    public DtoUnidadMedida() {

    }

    public int getCodUnidadMedida() {
        return codUnidadMedida;
    }

    public void setCodUnidadMedida(int codUnidadMedida) {
        this.codUnidadMedida = codUnidadMedida;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public String getNomUnidad() {
        return nomUnidad;
    }

    public void setNomUnidad(String nomUnidad) {
        this.nomUnidad = nomUnidad;
    }

    @Override
    public String toString() {
        return unidad + " - " + nomUnidad;
    }

}

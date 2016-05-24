/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import dto.DtoUnidadMedida;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IUnidadMedida {

    public String insertUnidadMedida(DtoUnidadMedida dto) throws SQLException, IOException, ClassNotFoundException;/*Metodo para Registrar Unidad Medida*/

    public Integer ultimoCodUnidadMedida() throws SQLException, IOException, ClassNotFoundException;

    public List<DtoUnidadMedida> listaComboUnidadMedida() throws SQLException, IOException, ClassNotFoundException;
}

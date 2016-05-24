/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import dto.DtoTipoInventario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface ITipoInventario {

    public String insertTipoInv(DtoTipoInventario dto) throws SQLException, IOException, ClassNotFoundException;

    public String updateTipoInv(DtoTipoInventario dto) throws SQLException, IOException, ClassNotFoundException;

    public String deleteTipoInv(int codTipo) throws SQLException, IOException, ClassNotFoundException;

    public Integer ultimoCodTipoInv() throws SQLException, IOException, ClassNotFoundException;

    public List<DtoTipoInventario> listarTipoInv() throws SQLException, IOException, ClassNotFoundException;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import dto.DtoFormaPagos;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public interface IFormaDePagos {

    public List<DtoFormaPagos> listaComboFormaPago() throws SQLException, IOException, ClassNotFoundException;
}

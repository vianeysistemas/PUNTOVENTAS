/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Interfaces.ICategorias;
import dto.DtoCategoria;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author SISTEMAS
 */
public interface ICategorias {

    public String insertCategoria(DtoCategoria dto) throws SQLException, IOException, ClassNotFoundException;/*Metodo para Registrar Un Categira*/


    public String updateCategoria(DtoCategoria dto) throws SQLException, IOException, ClassNotFoundException;/*Metodo para Actualizar Un CAtegoria*/


    public String deleteCategoria(int codCuenta) throws SQLException, IOException, ClassNotFoundException;/*Metodo para eliminar una CAtegoria*/


    public Integer ultimoCodCategoria() throws SQLException, IOException, ClassNotFoundException;//Metodo para recuperar el ultimo codigo de la tabla CAtegoria

    public List<DtoCategoria> listarCategorias() throws SQLException, IOException, ClassNotFoundException;

    public ObservableList<DtoCategoria> getAllTbl();
}

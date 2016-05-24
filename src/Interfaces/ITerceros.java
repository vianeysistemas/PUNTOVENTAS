/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import dto.DtoCategoria;
import dto.DtoTerceros;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Vianey Vargas
 */
public interface ITerceros {

    public String insertTercero(DtoTerceros dto) throws SQLException, IOException, ClassNotFoundException;/*Metodo para Registrar Un Producto*/


    public String updateTercero(DtoTerceros dto) throws SQLException, IOException, ClassNotFoundException;/*Metodo para Actualizar Un Producto*/


    public String deleteTercero(String nitTercero) throws SQLException, IOException, ClassNotFoundException;/*Metodo para eliminar una Producto*/


    public List<DtoCategoria> listarCategorias() throws SQLException, IOException, ClassNotFoundException;

    public DtoTerceros cargarDatosTerceros(String nit) throws SQLException, IOException, ClassNotFoundException;

    public List<DtoTerceros> buscaTerceroModal(String filtro) throws SQLException, IOException, ClassNotFoundException;

   // public List<DtoTerceros> buscaProveedorClientModal(String proveedor) throws SQLException, IOException, ClassNotFoundException;
    
    public ObservableList<DtoTerceros> listarTblProveedores(String proveedor);
}

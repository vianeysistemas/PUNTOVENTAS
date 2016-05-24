/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import dto.DtoListaPrecios;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author Vianey Vargas
 */
public interface IListaPrecios {

    public String insertListaPrecio(DtoListaPrecios dto) throws Exception;/*Metodo para Registrar listaPrecio*/


    public String updateListaPrecio(DtoListaPrecios dto);/*Metodo para Actualizar los datos de listaPrecios*/


    public String deleteListaPrecio(String codListaPrecio);/*Metodo para eliminar una ListaPrecio*/


    public ObservableList<DtoListaPrecios> listarTblListaPrecios();

    public ObservableList<DtoListaPrecios> buscaListaPrecioModal(String filtro);

    public DtoListaPrecios cargaDatosListaPrecio(String codigo) throws SQLException, IOException, ClassNotFoundException;
}

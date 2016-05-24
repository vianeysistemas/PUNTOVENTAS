/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import dto.DtoCategoria;
import dto.DtoMVprecios;
import dto.DtoProductos;
import dto.DtoProveedor;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javafx.collections.ObservableList;

/**
 *
 * @author SISTEMAS
 */
public interface IProductos {

    public String insertaProducto(DtoProductos dto) throws SQLException, IOException, ClassNotFoundException;/*Metodo para Registrar Un Producto*/


    public String updateProducto(DtoProductos dto) throws SQLException, IOException, ClassNotFoundException;/*Metodo para Actualizar Un Producto*/


    public String deleteProducto(int codCuenta) throws SQLException, IOException, ClassNotFoundException;/*Metodo para eliminar una Producto*/


    public Integer ultimoCodProducto() throws SQLException, IOException, ClassNotFoundException;//Metodo para recuperar el ultimo CodProducto de la tabla Parametros

    public List<DtoCategoria> listarCategorias() throws SQLException, IOException, ClassNotFoundException;

    public ObservableList<DtoProductos> buscarProductos(String filtro);

    public ObservableList<DtoProductos> listarTblProductos();

    public List<DtoProveedor> buscarProveedores(String filtro) throws SQLException, IOException, ClassNotFoundException;

    public DtoProductos cargaDatosProductos(String codigo) throws SQLException, IOException, ClassNotFoundException;

    public DtoProductos ultimoCodigoProducto(int codigo) throws SQLException, IOException, ClassNotFoundException;

    public DtoProductos cargaCantDisponibleProducto(String referencia) throws SQLException, IOException, ClassNotFoundException;

    public DtoMVprecios cargaPrecioVenta(String nit, String referencia) throws SQLException, IOException, ClassNotFoundException;

    public DtoProductos cargaDescuentoEIva(String referencia) throws SQLException, IOException, ClassNotFoundException;

    public DtoProductos cargaDatosDescuentoEIva(String referencia) throws SQLException, IOException, ClassNotFoundException;
}

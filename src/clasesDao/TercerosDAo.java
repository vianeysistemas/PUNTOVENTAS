/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesDao;

import bd.ConexionPuntoVenta;
import dto.DtoCategoria;
import dto.DtoListaPrecios;
import dto.DtoTerceros;
import Interfaces.ITerceros;
import bd.ConexionPuntoVenta;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Vianey Vargas
 */
public class TercerosDAo implements ITerceros {

    ConexionPuntoVenta conex;

    public TercerosDAo() {
        conex = new ConexionPuntoVenta();
    }

    @Override
    public String insertTercero(DtoTerceros dto) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String updateTercero(DtoTerceros dto) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteTercero(String nitTercero) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DtoCategoria> listarCategorias() throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoTerceros cargarDatosTerceros(String nit) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DtoTerceros> buscaTerceroModal(String filtro) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    @Override
//    public List<DtoTerceros> buscaProveedorClientModal(String proveedor) throws SQLException, IOException, ClassNotFoundException {
//        List<DtoTerceros> list = null;
//        //String sql = "select Nit,Nombre1+' '+Apellido1+' '+Apellido2 as PROVEEDOR from maestros.Terceros where EsProveedor='True' AND  Nit='" + proveedor + "' OR Nombre1 LIKE'%" + proveedor + "%'";
//        String sql = "execute sp_BuscaProveedorClient '" + proveedor + "'";
//        try {
//            PreparedStatement prepare;
//            Connection cnn = null;
//            try {
//                cnn = conex.getConnection();
//                prepare = (PreparedStatement) cnn.prepareStatement(sql);
//                ResultSet res = prepare.executeQuery();
//                list = new ArrayList<>();
//                DtoTerceros dto;
//                while (res.next()) {
//                    dto = new DtoTerceros();
//                    dto.setNit(res.getString("Nit"));
//                    dto.setNombre1(res.getString("PROVEEDOR"));
//                    list.add(dto);
//                }
//            } finally {
//                if (cnn != null) {
//                    cnn.close();
//                }
//            }
//            prepare.close();
//        } catch (SQLException ex) {
//            System.out.println("Error Consultando Proveedores:" + ex.getMessage());
//            throw ex;
//        }
//        return list;
//    }
    @Override
    public ObservableList<DtoTerceros> listarTblProveedores(String proveedor) {
        ObservableList<DtoTerceros> list = FXCollections.observableArrayList();
        String sql = "select maestros.sp_BuscaProveedorClient('" + proveedor + "');";
        //String sql = "select Nit,CONCAT_WS(' ',Nombre1,Apellido1,Apellido2) as PROVEEDOR from maestros.Terceros where EsProveedor='True';";
        try {
            PreparedStatement prepare;
            Connection cnn = null;
            try {
                cnn = conex.getConnection();
                prepare = (PreparedStatement) cnn.prepareStatement(sql);
                ResultSet ress = prepare.executeQuery();
                DtoTerceros dto;
                while (ress.next()) {
                    dto = new DtoTerceros();
//                    dto.setIdCodigo(ress.getString("Cod_Prod"));
//                    dto.setReferenciaProducto(ress.getString("Ref_Prod"));
//                    dto.setDescripcion(ress.getString("Nom_Prod"));
                    dto.setPropertyNitProveedor(ress.getString("Nit"));
                    dto.setPropertyNomProveedor(ress.getString("PROVEEDOR"));
                    list.add(dto);
                }
            } finally {
                if (cnn != null) {
                    cnn.close();
                }
            }
            prepare.close();
        } catch (Exception ex) {
            System.out.println("Error Listando Proveedores Dao : " + ex.getMessage());
        }
        return list;
    }

}

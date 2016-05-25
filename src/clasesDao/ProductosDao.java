/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesDao;

import Interfaces.IProductos;
import bd.ConexionPuntoVenta;
import dto.DtoCategoria;
import dto.DtoMVprecios;
import dto.DtoProductos;
import dto.DtoProveedor;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author SISTEMAS
 */
public class ProductosDao implements IProductos {

    ConexionPuntoVenta conex;

    public ProductosDao() {
        conex = new ConexionPuntoVenta();
    }

    @Override
    public String insertaProducto(DtoProductos dto) throws SQLException, IOException, ClassNotFoundException {
        String resultado = null;
        Connection cn = conex.getConnection();
        CallableStatement call = null;
        try {
            call = cn.prepareCall("{call maestros.sp_insertaproductosjaja(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,cast(? as character varying))}");
            call.setString(1, dto.getIdCodigo());
            call.setString(2, dto.getReferenciaProducto());
            call.setString(3, dto.getDescripcion());
            call.setDouble(4, dto.getPrecioCompra());
            call.setInt(5, dto.getStock());
            call.setString(6, dto.getObservacionProducto());
            call.setInt(7, dto.getCodCategoria())/*Nombre de la Categoria*/;
            call.setString(8, dto.getDniProveedor());
            call.setFloat(9, dto.getIvaProd());
            call.setFloat(10, dto.getDescuentoProd());
            call.setString(11, dto.getCodTipoInv());
            call.setString(12, dto.getCodUnidadMedida());
            call.setString(13, dto.getCodigoBarras());
            call.setString(14, dto.getCodigoPLU());
            call.setString(15, dto.getNroManifiestro());
            call.setInt(16, (dto.isServicio()) ? 1 : 0);
            call.setInt(17, (dto.isHabilitado()) ? 1 : 0);
            call.registerOutParameter(18, java.sql.Types.VARCHAR);
            call.executeUpdate();
            resultado = call.getString(18);//retornando el parametro de salida del store procedure
            call.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error insertando productos Dao: " + e.getMessage());
            e.printStackTrace();
            throw e;
        } finally {
            if (call != null) {
                call.close();
                call = null;
            }
            if (cn != null) {
                cn.close();
                cn = null;
            }
        }
        return resultado;
    }

    @Override
    public String updateProducto(DtoProductos dto) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteProducto(int codCuenta) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer ultimoCodProducto() throws SQLException, IOException, ClassNotFoundException {
        Integer codigo = 0;
        String sql = "select valorActual_Param from permisos.Parametros where Cod_Param='10'";
        try {
            PreparedStatement st;
            try (Connection cn = conex.getConnection()) {
                st = (PreparedStatement) cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    //codigo = rs.getInt(1) + 1;
                    codigo = rs.getInt(1);
                }
            }
            st.close();
        } catch (Exception e) {
            throw e;
        }
        return codigo;
    }

    @Override
    public List<DtoCategoria> listarCategorias() throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<DtoProductos> buscarProductos(String filtro) {
        ObservableList<DtoProductos> list = FXCollections.observableArrayList();
        String sql = "select Cod_Prod ,Ref_Prod,Nom_Prod  from maestros.Productos where  Ref_Prod LIKE'%" + filtro + "%' OR Nom_Prod LIKE '%" + filtro + "%'";
        try {
            PreparedStatement prepare;
            Connection cnn = null;
            try {
                cnn = conex.getConnection();
                prepare = (PreparedStatement) cnn.prepareStatement(sql);
                ResultSet ress = prepare.executeQuery();
                DtoProductos dto;
                while (ress.next()) {
                    dto = new DtoProductos();
//                    dto.setIdCodigo(ress.getString("Cod_Prod"));
//                    dto.setReferenciaProducto(ress.getString("Ref_Prod"));
//                    dto.setDescripcion(ress.getString("Nom_Prod"));
                    dto.setPropertyIdCodigo(ress.getString("Cod_Prod"));
                    dto.setPropertyReferencia(ress.getString("Ref_Prod"));
                    dto.setPropertyDescripcion(ress.getString("Nom_Prod"));
                    list.add(dto);
                }
            } finally {
                if (cnn != null) {
                    cnn.close();
                }
            }
            prepare.close();
        } catch (Exception ex) {
            System.out.println("Error al Buscar los Productos :" + ex.getMessage());
        }
        return list;
    }

    @Override
    public List<DtoProveedor> buscarProveedores(String filtro) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoProductos cargaDatosProductos(String codigo) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoProductos ultimoCodigoProducto(int codigo) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoProductos cargaCantDisponibleProducto(String referencia) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoMVprecios cargaPrecioVenta(String nit, String referencia) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoProductos cargaDescuentoEIva(String referencia) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoProductos cargaDatosDescuentoEIva(String referencia) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ObservableList<DtoProductos> listarTblProductos() {
        ObservableList<DtoProductos> list = FXCollections.observableArrayList();
        String sql = "select Cod_Prod ,Ref_Prod,Nom_Prod  from maestros.Productos order by Cod_Prod";
        try {
            PreparedStatement prepare;
            Connection cnn = null;
            try {
                cnn = conex.getConnection();
                prepare = (PreparedStatement) cnn.prepareStatement(sql);
                ResultSet ress = prepare.executeQuery();
                DtoProductos dto;
                while (ress.next()) {
                    dto = new DtoProductos();
//                    dto.setIdCodigo(ress.getString("Cod_Prod"));
//                    dto.setReferenciaProducto(ress.getString("Ref_Prod"));
//                    dto.setDescripcion(ress.getString("Nom_Prod"));
                    dto.setPropertyIdCodigo(ress.getString("Cod_Prod"));
                    dto.setPropertyReferencia(ress.getString("Ref_Prod"));
                    dto.setPropertyDescripcion(ress.getString("Nom_Prod"));
                    list.add(dto);
                }
            } finally {
                if (cnn != null) {
                    cnn.close();
                }
            }
            prepare.close();
        } catch (Exception ex) {
            System.out.println("Error Listando Productos Dao : " + ex.getMessage());
        }
        return list;
    }

}

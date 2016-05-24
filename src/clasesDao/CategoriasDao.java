/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesDao;

import Interfaces.ICategorias;
import bd.ConexionPuntoVenta;
import dto.DtoCategoria;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author SISTEMAS
 */
public class CategoriasDao implements ICategorias {

    ConexionPuntoVenta conex;

    public CategoriasDao() {
        conex = new ConexionPuntoVenta();

    }

    @Override
    public String insertCategoria(DtoCategoria dto) throws SQLException, IOException, ClassNotFoundException {
        String resultado = null;
        try {
            try (Connection cn = conex.getConnection(); CallableStatement call = (CallableStatement) cn.prepareCall("select maestros.sp_categoria_admin(?,?)")) {
                call.setInt(1, dto.getCodigo());
                call.setString(2, dto.getNombreCat());
                call.execute();
                call.close();
                cn.close();
            }
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    @Override
    public String updateCategoria(DtoCategoria dto) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteCategoria(int codCuenta) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer ultimoCodCategoria() throws SQLException, IOException, ClassNotFoundException {
        Integer codigo = 0;
        String sql = "SELECT MAX(Cod_Cat) + 1 AS Codigo from maestros.Categoria";
        try {
            PreparedStatement st;
            try (Connection cn = conex.getConnection()) {
                st = (PreparedStatement) cn.prepareStatement(sql);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    codigo = rs.getInt("Codigo");
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
        List<DtoCategoria> list = null;
        String sql = "select cod_Cat,nom_Cat from maestros.Categoria";
        try {
            PreparedStatement prepare;
            Connection cnn = null;
            try {
                cnn = conex.getConnection();
                prepare = (PreparedStatement) cnn.prepareStatement(sql);
                ResultSet ress = prepare.executeQuery();
                list = new ArrayList<>();
                DtoCategoria dto;
                while (ress.next()) {
                    dto = new DtoCategoria();
                    dto.setCodigo(ress.getInt("cod_Cat"));
                    dto.setNombre(ress.getString("nom_Cat").trim());
                    list.add(dto);
                }
            } finally {
                if (cnn != null) {
                    cnn.close();
                }
            }
            prepare.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return list;
    }

    @Override
    public ObservableList<DtoCategoria> getAllTbl() {
        ObservableList<DtoCategoria> listData = FXCollections.observableArrayList();
        String sql = "select cod_cat,nom_cat from maestros.Categoria order by cod_cat";
        try {
            PreparedStatement prepare;
            Connection cnn = null;
            try {
                cnn = conex.getConnection();
                prepare = (PreparedStatement) cnn.prepareStatement(sql);
                ResultSet rs = conex.getConnection().createStatement().executeQuery(sql);
                DtoCategoria dto;
                while (rs.next()) {
                    dto = new DtoCategoria();
                    dto.setCodCatProperty(rs.getString("Cod_Cat"));
                    dto.setNombreCat(rs.getString("nom_Cat"));
                    listData.add(dto);
                }
            } finally {
                if (cnn != null) {
                    cnn.close();
                }
            }
        } catch (Exception ex) {
            System.out.println("Error Llenando la tabla Categorias :" + ex.getMessage());
        }
        return listData;
    }

}

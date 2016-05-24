/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesDao;

import Interfaces.ITipoInventario;
import bd.ConexionPuntoVenta;
import dto.DtoTipoInventario;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author SISTEMAS
 */
public class TipoInvDao implements ITipoInventario {

    ConexionPuntoVenta conex;

    public TipoInvDao() {
        conex = new ConexionPuntoVenta();

    }

    @Override
    public String insertTipoInv(DtoTipoInventario dto) throws SQLException, IOException, ClassNotFoundException {
        String resultado = null;
        try {
            try (Connection cn = conex.getConnection(); CallableStatement call = (CallableStatement) cn.prepareCall("select sp_InsertarTipoInv(?,?,?)")) {
                call.setInt(1, dto.getCodTipoInv());
                call.setString(2, dto.getNomTipoInv());
                call.registerOutParameter(3, java.sql.Types.VARCHAR);
                call.execute();
                resultado = call.getString(3);//retornando el parametro de salida del store procedure
                call.close();
                cn.close();
            }
        } catch (Exception e) {
            throw e;
        }
        return resultado;
    }

    @Override
    public String updateTipoInv(DtoTipoInventario dto) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteTipoInv(int codTipo) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer ultimoCodTipoInv() throws SQLException, IOException, ClassNotFoundException {
        Integer codigo = 0;
        String sql = "SELECT MAX(CodTipoInv) + 1 AS Codigo from maestros.TipoInventario";
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
    public List<DtoTipoInventario> listarTipoInv() throws SQLException, IOException, ClassNotFoundException {
        List<DtoTipoInventario> list = null;
        String sql = "select * from maestros.TipoInventario order by NomTipoInv";
        try {
            PreparedStatement prepare;
            Connection cnn = null;
            try {
                cnn = conex.getConnection();
                prepare = (PreparedStatement) cnn.prepareStatement(sql);
                ResultSet ress = prepare.executeQuery();
                list = new ArrayList<>();
                DtoTipoInventario dto;
                while (ress.next()) {
                    dto = new DtoTipoInventario();
                    dto.setCodTipoInv(ress.getInt("CodTipoInv"));
                    dto.setNomTipoInv(ress.getString("NomTipoInv").trim());
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

}

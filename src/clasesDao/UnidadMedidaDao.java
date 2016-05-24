/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesDao;

import Interfaces.IUnidadMedida;
import bd.ConexionPuntoVenta;
import dto.DtoUnidadMedida;
import java.io.IOException;
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
public class UnidadMedidaDao implements IUnidadMedida{
    ConexionPuntoVenta conex;
    
    public UnidadMedidaDao(){
        conex = new ConexionPuntoVenta();
    }

    @Override
    public String insertUnidadMedida(DtoUnidadMedida dto) throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer ultimoCodUnidadMedida() throws SQLException, IOException, ClassNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DtoUnidadMedida> listaComboUnidadMedida() throws SQLException, IOException, ClassNotFoundException {
       List<DtoUnidadMedida> list = null;
        String sql = "select * from inventario.UnidadMedida order by DESCRIPCION";
        try {
            PreparedStatement prepare;
            Connection cnn = null;
            try {
                cnn = conex.getConnection();
                prepare = (PreparedStatement) cnn.prepareStatement(sql);
                ResultSet ress = prepare.executeQuery();
                list = new ArrayList<>();
                DtoUnidadMedida dto;
                while (ress.next()) {
                    dto = new DtoUnidadMedida();
                    dto.setCodUnidadMedida(ress.getInt("CodUnidad"));
                    dto.setUnidad(ress.getString("Unidad").trim());
                    dto.setNomUnidad(ress.getString("DESCRIPCION").trim());
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

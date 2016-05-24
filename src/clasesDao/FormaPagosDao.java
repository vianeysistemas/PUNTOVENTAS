/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesDao;

import dto.DtoFormaPagos;
import Interfaces.IFormaDePagos;
import bd.ConexionPuntoVenta;
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
public class FormaPagosDao implements IFormaDePagos {

    ConexionPuntoVenta conex;

    public FormaPagosDao() {
        conex = new ConexionPuntoVenta();
    }

    @Override
    public List<DtoFormaPagos> listaComboFormaPago() throws SQLException, IOException, ClassNotFoundException {
        List<DtoFormaPagos> lista = null;
        String sql = "select CodForm_Pago,NomPago from maestros.FormaPago order by NomPago";
        Connection cnn = null;
        PreparedStatement prepare;
        try {
            cnn = conex.getConnection();
            prepare = cnn.prepareStatement(sql);
            ResultSet res = prepare.executeQuery();
            lista = new ArrayList<>();
            DtoFormaPagos dto;
            while (res.next()) {
                dto = new DtoFormaPagos();
                dto.setCodFormaPago(res.getInt("CodForm_Pago"));
                dto.setNomFormaPago(res.getString("NomPago"));
                lista.add(dto);
            }
            prepare.close();
            cnn.close();
        } catch (SQLException ex) {
            throw ex;
        }
        return lista;

    }

}

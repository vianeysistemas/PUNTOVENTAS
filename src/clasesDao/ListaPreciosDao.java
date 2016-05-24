/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesDao;

import dto.DtoListaPrecios;
import Interfaces.IListaPrecios;
import bd.ConexionPuntoVenta;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Vianey Vargas
 */
public class ListaPreciosDao implements IListaPrecios {

    ConexionPuntoVenta conex;

    public ListaPreciosDao() {
        conex = new ConexionPuntoVenta();
    }

    @Override
    public ObservableList<DtoListaPrecios> buscaListaPrecioModal(String filtro) {
        ObservableList<DtoListaPrecios> list = FXCollections.observableArrayList();
        String sql = "select CodPrecio,Titulo,Descripcion from maestros.ListaPrecios where CodPrecio='" + filtro + "' OR Titulo LIKE '%" + filtro + "%' ";
        Connection cnn;
        PreparedStatement prepare;
        try {
            cnn = conex.getConnection();
            prepare = cnn.prepareStatement(sql);
            ResultSet res = prepare.executeQuery();
            DtoListaPrecios dto;
            while (res.next()) {
                dto = new DtoListaPrecios();
//                dto.setCodPrecio(res.getString("CodPrecio"));
//                dto.setTitulo(res.getString("Titulo"));
                dto.setPropertyCodPrecio(res.getString("CodPrecio"));
                dto.setPropertyTitulo(res.getString("Titulo"));
                dto.setPropertyDescripcion(res.getString("Descripcion"));
                list.add(dto);
            }
            prepare.close();
            cnn.close();
        } catch (Exception ex) {
            System.out.println("Error al Buscar Lista Precios Dao " + ex.getMessage());
        }
        return list;
    }

    @Override
    public String insertListaPrecio(DtoListaPrecios dto) throws SQLException, IOException, ClassNotFoundException {
        String resultado = null;
        Connection cn = conex.getConnection();
        CallableStatement call = null;
        try {
            call = cn.prepareCall("{call maestros.sp_InsertaListaPrecio(?,?,?,?,?,?)}");
            call.setString(1, dto.getCodPrecio());
            call.setString(2, dto.getDescripcion());
            call.setString(3, dto.getTitulo());
            call.setDate(4, (Date) dto.getFecha1());//Fecha1
            call.setDate(5, (Date) dto.getFecha2());//Fecha2
            call.registerOutParameter(6, java.sql.Types.VARCHAR);
            call.executeUpdate();
            resultado = call.getString(6);//retornando el parametro de salida del store procedure
            call.close();
            cn.close();
        } catch (Exception e) {
            System.out.println("Error INSERTANDO DAO :" + e.getMessage());
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
    public String updateListaPrecio(DtoListaPrecios dto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String deleteListaPrecio(String codListaPrecio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtoListaPrecios cargaDatosListaPrecio(String codigo) throws SQLException, IOException, ClassNotFoundException {
        DtoListaPrecios dto = null;
        String sql = "select P.CodPrecio,P.Titulo,P.Descripcion from maestros.ListaPrecios P where CodPrecio='" + codigo + "'";

        try {
            PreparedStatement prepare;
            Connection cnn = null;
            try {
                cnn = conex.getConnection();
                prepare = (PreparedStatement) cnn.prepareStatement(sql);
                ResultSet ress = prepare.executeQuery();
                while (ress.next()) {
                    dto = new DtoListaPrecios();
                    dto.setCodPrecio(ress.getString("CodPrecio"));
                    dto.setTitulo(ress.getString("Titulo"));
                    dto.setDescripcion(ress.getString("Descripcion"));
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
        return dto;
    }

    @Override
    public ObservableList<DtoListaPrecios> listarTblListaPrecios() {
        ObservableList list = FXCollections.observableArrayList();
        //String sql = "SELECT CodPrecio,Titulo,Descripcion,TO_CHAR(fechainicial,'dd/MM/yyyy')as Fecha_Inicial,TO_CHAR(fechafinal,'dd/MM/yyyy')AS Fecha_Final FROM maestros.ListaPrecios ORDER BY CodPrecio;";
        String sql = "SELECT CodPrecio,Titulo,Descripcion FROM maestros.ListaPrecios ORDER BY CodPrecio;";
        try {
            PreparedStatement prepare;
            Connection cnn = null;
            try {
                cnn = conex.getConnection();
                prepare = cnn.prepareStatement(sql);
                ResultSet res = prepare.executeQuery();
                DtoListaPrecios dto;
                while (res.next()) {
                    dto = new DtoListaPrecios();
                    dto.setPropertyCodPrecio(res.getString("CodPrecio"));
                    dto.setPropertyTitulo(res.getString("Titulo"));
                    dto.setPropertyDescripcion(res.getString("Descripcion"));
                    //dto.setPropertyFecha1(res.getDate("Fecha_Inicial"));
                    //dto.setPropertyFecha2(res.getDate("Fecha_Final"));
                    list.add(dto);
                }
            } finally {
                if (cnn != null) {
                    cnn.close();
                }
            }
            prepare.close();
        } catch (Exception ex) {
            System.out.println("Error Lista Precios Dao : " + ex.getMessage());
        }
        return list;
    }

}

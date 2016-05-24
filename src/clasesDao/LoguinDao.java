/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package clasesDao;

import Interfaces.IverificarUsuario;
import bd.ConexionPuntoVenta;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author soporte
 */
public class LoguinDao implements IverificarUsuario {

    //private boolean permiso = true;
    private Connection cn;
    private ConexionPuntoVenta conexion;

    public LoguinDao() {
        conexion = new ConexionPuntoVenta();
    }

    @Override
    public Boolean verificaUsuarioInterface(String user, String clave) {
        int hola = 0;
        try {
            Connection cnn = conexion.getConnection();
            String sql = "select Usuario, Clave,Habilitado from permisos.Usuarios where Usuario = '" + user + "' AND Clave='" + clave + "' AND Habilitado='True'";
            Statement estado = cnn.createStatement();
            ResultSet resultado = estado.executeQuery(sql);
            while (resultado.next()) {
                if (resultado.getString(1) == null) {
                    hola = 0;
                } else {
                    hola = 1;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.println(ex.getMessage());
        }
        if (hola == 1) {
            return true;
        } else {
            return false;
        }
    }
}

/*
 * DBContactos.java
 * 
 * Created on 7/04/2008, 10:26:02 PM
 */
package basedatos;

import java.sql.*;
import Logica.Personaje;

public class DBPersonajes {

    DBConexion cn;
    
    public DBPersonajes() {
        cn = new DBConexion();
    }

    public ResultSet getPersonajeById(int id) throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT con_id, "
                + " con_clase, "
                + " con_nombre, "
                + " con_altura, "
                + " con_color "
                + " FROM registros "
                + " WHERE con_id = ? ");
        pstm.setInt(1, id);

        ResultSet res = pstm.executeQuery();
        /*
         res.close();	
         */

        return res;
    }

    /**
     * trae todos los registros de la tabla contactos
     */
    public ResultSet getPersonajes() throws SQLException {
        PreparedStatement pstm = cn.getConexion().prepareStatement("SELECT con_id, "
                + " con_clase, "
                + " con_nombre, "
                + " con_altura, "
                + " con_color "
                + " FROM registros "
                + " ORDER BY con_id ");


        ResultSet res = pstm.executeQuery();
        return res;
    }

    public void insertarPersonaje(Personaje p) {
        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("insert into registros (con_clase, "
                    + " con_nombre, "    
                    + " con_altura, "
                    + " con_color) "
                    + " values(?,?,?,?)");
            pstm.setString(1, String.valueOf(p.getClass().getSimpleName()));
            pstm.setString(2, p.getNombre());
            pstm.setDouble(3, p.getAltura());
            pstm.setString(4, p.getColor());

            pstm.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void actualizarPersonaje(Personaje p) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("update registros set con_clase = ?, "
                    + " con_nombre = ?, "    
                    + " con_altura = ?, "
                    + " con_color = ? "
                    + " where con_id = ?");
            pstm.setString(1, String.valueOf(p.getClass().getSimpleName()));
            pstm.setString(2, p.getNombre());
            pstm.setDouble(3, p.getAltura());
            pstm.setString(4, p.getColor());
            pstm.setInt(5, p.getID());

            pstm.executeUpdate();


        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void borrarPersonaje(Personaje p) {

        try {
            PreparedStatement pstm = cn.getConexion().prepareStatement("delete from registros "
                    + " where con_id = ?");

            pstm.setInt(1, p.getID());

            pstm.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e);
        }


    }

    public String getMensaje() {
        return cn.getMensaje();
    }
}

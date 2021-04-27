/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.Database;
import cr.ac.una.db.dao.AbsAdministradorDAO;
import cr.ac.una.db.dao.crud.AbstractCRUD;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Administrador;
import modelo.beans.Estudiante;
import modelo.dao.crud.AdministradorCRUD;

/**
 *
 * @author Esteban
 */
public class AdministradorDAO extends AbsAdministradorDAO<Integer, Administrador>{

    public AdministradorDAO() throws Exception {
        super(new AdministradoresBD(), new AdministradorCRUD());
    }

    @Override
    public Administrador getRecord(ResultSet rs) throws SQLException {
        return new Administrador(
                rs.getInt("id_administrador"),
                rs.getString("apellido1"),
                rs.getString("apellido2"),
                rs.getString("nombre"),
                rs.getString("telefono"),
                rs.getString("e_mail")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Administrador value) throws SQLException {
        stm.setInt(1, id);
        stm.setString(2, value.getUsuario_id().getId_usuario());
        stm.setString(3, value.getApellido1());
        stm.setString(4, value.getApellido2());
        stm.setString(5, value.getNombre());
        stm.setString(6, value.getTelefono());
        stm.setString(7, value.getEmail());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Administrador value) throws SQLException {
        stm.setString(1, value.getApellido1());
        stm.setString(2, value.getApellido2());
        stm.setString(3, value.getNombre());
        stm.setString(4, value.getTelefono());
        stm.setString(5, value.getEmail());
        stm.setInt(6, id);
    }
    
}

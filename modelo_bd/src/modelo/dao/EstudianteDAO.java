/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.Database;
import cr.ac.una.db.dao.AbsEstudianteDAO;
import cr.ac.una.db.dao.crud.AbstractCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Estudiante;
import modelo.dao.crud.EstudianteCRUD;

/**
 *
 * @author Esteban
 */
public class EstudianteDAO extends AbsEstudianteDAO<Integer,Estudiante>{

    public EstudianteDAO() throws Exception{
        super(new EstudiantesBD(), new EstudianteCRUD());
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Estudiante value) throws SQLException {
        stm.setInt(1, id);
        stm.setString(2, value.getUsuario_id().getId_usuario());
        stm.setString(3, value.getApellido1());
        stm.setString(4, value.getApellido2());
        stm.setString(5, value.getNombre());
        stm.setString(6, value.getTelefono());
        stm.setString(7, value.getEmail());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Estudiante value) throws SQLException {
        stm.setString(1, value.getApellido1());
        stm.setString(2, value.getApellido2());
        stm.setString(3, value.getNombre());
        stm.setString(4, value.getTelefono());
        stm.setString(5, value.getEmail());
        stm.setInt(6, id);
    }

    @Override
    public Estudiante getRecord(ResultSet rs) throws SQLException {
        return new Estudiante(
                rs.getInt("id_estudiante"),
                rs.getString("apellido1"),
                rs.getString("apellido2"),
                rs.getString("nombre"),
                rs.getString("telefono"),
                rs.getString("e_mail")
        );
    }
    
}

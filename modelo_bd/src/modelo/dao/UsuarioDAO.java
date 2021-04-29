/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.dao.AbsUsuarioDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Usuario;
import modelo.dao.crud.UsuarioCRUD;

/**
 *
 * @author Esteban
 */
public class UsuarioDAO extends AbsUsuarioDAO<String, Usuario>{
    
    public UsuarioDAO() throws Exception{
        super(new UsuarioBD(), new UsuarioCRUD());
    }

    @Override
    public Usuario getRecord(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAddParameters(PreparedStatement stm, String id, Usuario value) throws SQLException {
        stm.setString(1, id);
        stm.setInt(2, value.getRol_id().getId_rol());
        stm.setString(3, value.getClave());
        stm.setDate(4, new java.sql.Date(value.getUltimo_acceso().getTime()));
        stm.setBoolean(5, value.isActivo());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, String id, Usuario value) throws SQLException {
        stm.setString(1, value.getClave());
        stm.setBoolean(2, value.isActivo());
        stm.setString(5, id);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.dao.AbsEspecialidadDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Especialidad;
import modelo.dao.crud.EspecialidadCRUD;

/**
 *
 * @author Esteban
 */
public class EspecialidadDAO extends AbsEspecialidadDAO<Integer, Especialidad>{
    
    public EspecialidadDAO() throws Exception{
        super(new EspecialidadBD(), new EspecialidadCRUD());
    }

    @Override
    public Especialidad getRecord(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Especialidad value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Especialidad value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.dao.AbsMatriculaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Matricula;
import modelo.dao.crud.MatriculaCRUD;

/**
 *
 * @author Esteban
 */
public class MatriculaDAO extends AbsMatriculaDAO<Integer, Matricula>{
    
    public MatriculaDAO() throws Exception{
        super(new MatriculaBD(), new MatriculaCRUD());
    }

    @Override
    public Matricula getRecord(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Matricula value) throws SQLException {
        stm.setInt(1, value.getEstudiante_id().getId_estudiante());
        stm.setInt(2, value.getGrupo_num());
        stm.setInt(3, value.getCurso_id());
        stm.setInt(4, 2);
        stm.setInt(5, 0);
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Matricula value) throws SQLException {
        
    }
    
}

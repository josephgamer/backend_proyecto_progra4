/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.Database;
import cr.ac.una.db.dao.AbsCursoDAO;
import cr.ac.una.db.dao.crud.AbstractCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Curso;
import modelo.dao.crud.CursoCRUD;

/**
 *
 * @author Greivin
 */
public class CursoDAO extends AbsCursoDAO<Integer, Curso>{

    public CursoDAO() throws Exception{
        super(new CursosBD(), new CursoCRUD());
    }

    @Override
    public Curso getRecord(ResultSet rs) throws SQLException {
        return new Curso(
                rs.getInt("id_curso"),
                rs.getString("descripcion")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Curso value) throws SQLException {
        stm.setInt(1, id);
        stm.setString(2, value.getCurso_descrip());
        stm.setInt(3, value.getAreaTematica_id().getId_area());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Curso value) throws SQLException {
        stm.setString(1, value.getCurso_descrip());
        stm.setInt(2, id);
    }
    
}

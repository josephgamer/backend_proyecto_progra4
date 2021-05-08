/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.dao.AbsAsignacionCursosDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Curso;
import modelo.beans.Grupo;
import modelo.beans.Profesor;
import modelo.dao.crud.AsignacionCursosCRUD;

/**
 *
 * @author Esteban
 */
public class AsignacionCursosDAO extends AbsAsignacionCursosDAO<Integer,Grupo>{
    
    public AsignacionCursosDAO() throws Exception{
        super(new AsignacionCursosBD(), new AsignacionCursosCRUD());
    }

    @Override
    public Grupo getRecord(ResultSet rs) throws SQLException {
        Grupo grupo = new Grupo();
        Curso curso = new Curso();
        Profesor profe = new Profesor();
        profe.setId_profesor(rs.getInt("id_profesor"));
        grupo.setNum_grupo(rs.getInt("num_grupo"));
        curso.setId_curso(rs.getInt("curso_id"));
        curso.setCurso_descrip(rs.getString("descripcion"));
        grupo.setProfesor_id(profe);
        grupo.setCurso_id(curso);
        return grupo;
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Grupo value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Grupo value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.dao.AbsGrupoDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Curso;
import modelo.beans.Estudiante;
import modelo.beans.Grupo;
import modelo.beans.Profesor;
import modelo.dao.crud.GrupoCRUD;

/**
 *
 * @author Esteban
 */
public class GrupoDAO extends AbsGrupoDAO<Integer,Grupo> {

    public GrupoDAO() throws Exception {
        super(new GrupoBD(), new GrupoCRUD());
    }

    @Override
    public Grupo getRecord(ResultSet rs) throws SQLException {
        Curso c = new Curso();
        c.setId_curso(rs.getInt("curso_id"));
        Profesor p = new Profesor();
        p.setId_profesor(rs.getInt("profesor_id"));
        return new Grupo(
                rs.getInt("num_Grupo"),
                c,
                p
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Grupo value) throws SQLException {
        stm.setInt(1, id);
        stm.setInt(2, value.getCurso_id().getId_curso());
        stm.setInt(3, value.getProfesor_id().getId_profesor());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Grupo value) throws SQLException {
        stm.setInt(1, value.getCurso_id().getId_curso());
        stm.setInt(2, value.getProfesor_id().getId_profesor());
        stm.setInt(6, id);
    }
    
}

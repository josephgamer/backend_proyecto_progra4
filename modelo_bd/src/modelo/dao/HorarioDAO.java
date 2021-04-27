/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.Database;
import cr.ac.una.db.dao.AbsHorarioDAO;
import cr.ac.una.db.dao.crud.AbstractCRUD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Curso;
import modelo.beans.Grupo;
import modelo.beans.Horario;
import modelo.dao.crud.HorarioCRUD;

/**
 *
 * @author Esteban
 */
public class HorarioDAO extends AbsHorarioDAO<Integer, Horario>{

    public HorarioDAO() throws Exception{
        super(new HorarioBD(), new HorarioCRUD());
    }

    @Override
    public Horario getRecord(ResultSet rs) throws SQLException {
        Curso curso = new Curso();
        Grupo grupo = new Grupo();
        curso.setId_curso(rs.getInt("grupo_curso_id"));
        grupo.setNum_grupo(rs.getInt("grupo_num"));
        return new Horario(
                rs.getInt("seq"),
                grupo,
                curso,
                rs.getInt("dia"),
                rs.getInt("hora")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Horario value) throws SQLException {
        stm.setInt(1, id);
        stm.setInt(2, value.getGrupo_num().getNum_grupo());
        stm.setInt(3, value.getGrupo_curso_id().getId_curso());
        stm.setInt(4, value.getDia());
        stm.setInt(5, value.getHora());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Horario value) throws SQLException {
        stm.setInt(1, value.getGrupo_num().getNum_grupo());
        stm.setInt(2, value.getGrupo_curso_id().getId_curso());
        stm.setInt(3, value.getDia());
        stm.setInt(4, value.getHora());
        stm.setInt(5, id);
    }
    
}

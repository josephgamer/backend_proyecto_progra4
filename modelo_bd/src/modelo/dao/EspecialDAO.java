/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.dao.AbsEspecialDAO;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.AreaTematica;
import modelo.beans.Curso;
import modelo.beans.Grupo;
import modelo.beans.Horario;
import modelo.beans.Profesor;
import modelo.dao.crud.EspecialCRUD;

/**
 *
 * @author Esteban
 */
public class EspecialDAO extends AbsEspecialDAO<Integer, Horario> implements Serializable{
    
    public EspecialDAO() throws Exception{
        super(new EspecialBD(), new EspecialCRUD());
    }

    @Override
    public Horario getRecord(ResultSet rs) throws SQLException {
        Grupo grupo = new Grupo();
        Curso curso = new Curso();
        Profesor profesor = new Profesor();
        AreaTematica area = new AreaTematica();
        grupo.setNum_grupo(rs.getInt("num_grupo"));
        curso.setId_curso(rs.getInt("id_curso"));
        profesor.setNombre(rs.getString("nombre"));
        profesor.setApellido1(rs.getString("apellido1"));
        profesor.setApellido2(rs.getString("apellido2"));
        curso.setCurso_descrip(rs.getString("descripcion"));
        area.setTematica_descrip(rs.getString("descripcion_area"));
        curso.setAreaTematica_id(area);
        grupo.setProfesor_id(profesor);
        return new Horario(
        grupo,curso, rs.getInt("dia"), rs.getInt("hora")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Horario value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Horario value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

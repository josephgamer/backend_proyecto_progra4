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
import modelo.beans.AreaTematica;
import modelo.beans.Curso;
import modelo.beans.Estado;
import modelo.beans.Estudiante;
import modelo.beans.Grupo;
import modelo.beans.Horario;
import modelo.beans.Matricula;
import modelo.beans.Profesor;
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
        Grupo grupo = new Grupo();
        Curso curso = new Curso();
        Profesor profesor = new Profesor();
        AreaTematica area = new AreaTematica();
        Estado estado = new Estado();
        Estudiante estudiante = new Estudiante();
        
        grupo.setNum_grupo(rs.getInt("num_grupo"));
        curso.setId_curso(rs.getInt("id_curso"));
        profesor.setNombre(rs.getString("nombre"));
        profesor.setApellido1(rs.getString("apellido1"));
        profesor.setApellido2(rs.getString("apellido2"));
        curso.setCurso_descrip(rs.getString("descripcion"));
        area.setTematica_descrip(rs.getString("descripcion_area"));
        estado.setEst_descripcion(rs.getString("descripcion"));
        estudiante.setId_estudiante(rs.getInt("estudiante_id"));
        
        curso.setAreaTematica_id(area);
        grupo.setProfesor_id(profesor);
        
        return new Matricula(grupo.getNum_grupo(), curso.getId_curso(), estudiante, rs.getInt("nota"), estado);
        
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

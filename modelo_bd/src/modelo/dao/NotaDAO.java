/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.dao.AbsNotaDAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.Estado;
import modelo.beans.Estudiante;
import modelo.beans.Matricula;
import modelo.dao.crud.NotaCRUD;

/**
 *
 * @author Esteban
 */
public class NotaDAO extends AbsNotaDAO<Integer,Matricula>{
    
    public NotaDAO() throws Exception{
        super(new NotaBD(), new NotaCRUD());
    }

    @Override
    public Matricula getRecord(ResultSet rs) throws SQLException {
        Matricula matricula = new Matricula();
        Estudiante estudiante = new Estudiante();
        Estado estado = new Estado();
        estudiante.setId_estudiante(rs.getInt("id_estudiante"));
        estudiante.setNombre(rs.getString("nombre"));
        estudiante.setApellido1(rs.getString("apellido1"));
        estudiante.setApellido2(rs.getString("apellido2"));
        matricula.setNota(rs.getInt("nota"));
        estado.setEst_descripcion(rs.getString("descripcion"));
        matricula.setGrupo_num(rs.getInt("grupo_num"));
        matricula.setEstado_id(estado);
        matricula.setEstudiante_id(estudiante);
        return matricula;
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Matricula value) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Matricula value) throws SQLException {
        stm.setInt(1, value.getNota());
        stm.setInt(2, value.getEstado_id().getId_estado());
        stm.setInt(3, id);
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.Database;
import cr.ac.una.db.dao.AbsCursoDAO;
import cr.ac.una.db.dao.crud.AbstractCRUD;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.AreaTematica;
import modelo.beans.Curso;
import modelo.beans.Grupo;
import modelo.dao.crud.CursoCRUD;

/**
 *
 * @author Esteban
 */
public class CursoDAO extends AbsCursoDAO<Integer, Curso> implements Serializable{

    public CursoDAO() throws Exception{
        super(new CursosBD(), new CursoCRUD());
    }

    @Override
    public Curso getRecord(ResultSet rs) throws SQLException {
        AreaTematica area = new AreaTematica();
        //Grupo grupo = new Grupo();
        area.setId_area(rs.getInt("area_tematica_id"));
        area.setTematica_descrip(rs.getString("descripcion_area"));
        //grupo.setNum_grupo(rs.getInt("grupo_num")); ERROR
        return new Curso(
                rs.getInt("id_curso"),
                rs.getString("descripcion"), //En el viejo no aparece _area
                area
          //      grupo
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, Curso value) throws SQLException {
        stm.setInt(1, id);
        stm.setString(2, value.getCurso_descrip());
        stm.setInt(3, value.getIdTematica());
       // stm.setInt(4, value.getGrupo().getNum_grupo());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, Curso value) throws SQLException {
        stm.setString(1, value.getCurso_descrip());
        stm.setInt(2, id);
       // stm.setInt(3, value.getAreaTematica_id().getId_area());
       // stm.setInt(4, value.getGrupo().getNum_grupo());
    }
    
}

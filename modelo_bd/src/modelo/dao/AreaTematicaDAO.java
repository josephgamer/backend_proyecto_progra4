/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao;

import cr.ac.una.db.Database;
import cr.ac.una.db.dao.AbsAreaTematicaDAO;
import cr.ac.una.db.dao.crud.AbstractCRUD;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import modelo.beans.AreaTematica;
import modelo.dao.crud.AreaTematicaCRUD;

/**
 *
 * @author Greivin
 */
public class AreaTematicaDAO extends AbsAreaTematicaDAO <Integer, AreaTematica>{

    public AreaTematicaDAO() throws Exception {
        super(new AreasTematicasBD(), new AreaTematicaCRUD());
    }

    @Override
    public AreaTematica getRecord(ResultSet rs) throws SQLException {
        return new AreaTematica(
                rs.getInt("id_area"),
                rs.getString("descripcion")
        );
    }

    @Override
    public void setAddParameters(PreparedStatement stm, Integer id, AreaTematica value) throws SQLException {
        stm.setInt(1, id);
        stm.setString(2, value.getTematica_descrip());
    }

    @Override
    public void setUpdateParameters(PreparedStatement stm, Integer id, AreaTematica value) throws SQLException {
        stm.setString(1, value.getTematica_descrip());
        stm.setInt(2, id);
    }
    
}

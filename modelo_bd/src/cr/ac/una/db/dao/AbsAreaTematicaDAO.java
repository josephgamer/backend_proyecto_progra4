/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.db.dao;

import cr.ac.una.db.Database;
import cr.ac.una.db.dao.crud.AbstractCRUD;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.beans.AreaTematica;
import modelo.dao.crud.AreaTematicaCRUD;
/**
 *
 * @author Esteban
 */
public abstract class AbsAreaTematicaDAO<K, V> implements DAO<K, V> {
    
    private final Database db;
    private final AbstractCRUD crud;
    
    public AbsAreaTematicaDAO(Database db, AbstractCRUD crud) {
        this.db = db;
        this.crud = crud;
    }

    @Override
    public List<V> listAll() throws SQLException, IOException {
        List<V> r = new ArrayList<>();
        try (Connection cnx = db.getConnection();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(getCRUD().getListAllCmd())) {
            while (rs.next()) {
                r.add(getRecord(rs));
            }
        }
        return r;
    }

    @Override
    public void add(K id, V value) throws SQLException, IOException {
        try (Connection cnx = db.getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getAddCmd())) {
            stm.clearParameters();
            setAddParameters(stm, id, value);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException();
            }
        }
    }
    
    /////////////Prueba
        public int add(V value) throws SQLException, IOException {
        try (Connection cnx = db.getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getAddCmd())) {
            stm.clearParameters();
            setAddParameters(stm, value);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException();
            }   
        }
        return getLast();
    }
        
        
        public int getLast() throws SQLException{
        int lastId = 0;
        
        try (Connection cnx = db.getConnection();
                Statement stm = cnx.createStatement();
                ResultSet rs = stm.executeQuery(getCRUD().getLast())) {
            if (rs.next()) {
                lastId = rs.getInt("id_area");
            }
        }
        return lastId;
    }
////////////
    
    @Override
    public V retrieve(K id) throws SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(K id, V value) throws SQLException, IOException {
        try (Connection cnx = db.getConnection();
                PreparedStatement stm = cnx.prepareStatement(getCRUD().getUpdateCmd())) {
            stm.clearParameters();
            setUpdateParameters(stm, id, value);
            if (stm.executeUpdate() != 1) {
                throw new IllegalArgumentException();
            }
        }
    }

    @Override
    public void delete(K id) throws SQLException, IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public abstract V getRecord(ResultSet rs) throws SQLException;

    public abstract void setAddParameters(PreparedStatement stm, K id, V value)
            throws SQLException;
    
        ///
        public abstract void setAddParameters(PreparedStatement stm, V value)
            throws SQLException;
        
        public AreaTematica getTematica(ResultSet rs) throws SQLException {
        return new AreaTematica(
                rs.getInt("id_area"),
                rs.getString("descripcion_area")
        );
    }
        ///

    public abstract void setUpdateParameters(PreparedStatement stm, K id, V value)
            throws SQLException;
    
    public AbstractCRUD getCRUD() {
        return crud;
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.crud;

import cr.ac.una.db.dao.crud.AbstractCRUD;

/**
 *
 * @author Greivin
 */
public class AreaTematicaCRUD extends AbstractCRUD{

    @Override
    public String getListAllCmd() {
        return LIST_CMD;
    }

    @Override
    public String getAddCmd() {
        return ADD_CMD;
    }

    @Override
    public String getRetrieveCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdateCmd() {
        return UPDATE_CMD;
    }

    @Override
    public String getDeleteCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected static final String LIST_CMD
            = "SELECT "
            + "id_area, descripcion "
            + "FROM area_tematica; ";
    
    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.area_tematica "
            + "(id_area, descripcion) "
            + "VALUES (?, ?); ";
    
    protected static final String UPDATE_CMD
            = "UPDATE area_tematica "
            + "SET descripcion = ? "
            + "WHERE id_area = ?; ";
    
}

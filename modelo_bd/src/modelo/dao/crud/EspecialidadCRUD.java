/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.dao.crud;

import cr.ac.una.db.dao.crud.AbstractCRUD;

/**
 *
 * @author Esteban
 */
public class EspecialidadCRUD extends AbstractCRUD{

    @Override
    public String getListAllCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAddCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getRetrieveCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdateCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeleteCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.especialidad "
            + "(profesor_id_profesor, area_tematica__id) "
            + "VALUES (?, ?); ";
    
}

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
public class ProfesorCRUD extends AbstractCRUD {

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
            + "id_profesor, apellido1, apellido2, nombre, telefono, e_mail "
            + "FROM profesor; ";
    
    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.profesor "
            + "(id_profesor, usuario_id ,apellido1, apellido2, nombre, telefono,e_mail) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?); ";
    
    protected static final String UPDATE_CMD
            = "UPDATE profesor "
            + "SET apellido1 = ?, apellido2 = ?, nombre = ?, telefono = ?, e_mail = ? "
            + "WHERE id_profesor = ?; ";
    
}

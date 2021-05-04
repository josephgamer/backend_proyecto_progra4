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
public class UsuarioCRUD extends AbstractCRUD{

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
    
    public static String existeUsuario() {
        return SELECT_USER;
    }
    
    protected static final String LIST_CMD
            = "SELECT "
            + "id_usuario, rol_id, clave, ultimo_aceso, activo "
            + "FROM usuario; ";
    
    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.usuario "
            + "(id_usuario, rol_id ,clave, ultimo_aceso, activo) "
            + "VALUES (?, ?, ?, ?, ?); ";
    
    protected static final String UPDATE_CMD
            = "UPDATE usuario "
            + "SET activo = ?, ultimo_aceso = ? "
            + "WHERE id_usuario = ?; ";
    
    protected static final String SELECT_USER 
            = "select id_usuario, clave from usuario where id_usuario = ? and clave = ?;";
    
}

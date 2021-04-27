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
public class HorarioCRUD extends AbstractCRUD{

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
            + "seq, grupo_num, grupo_curso_id, dia, hora "
            + "FROM horario; ";
    
    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.horario "
            + "(seq, grupo_num ,grupo_curso_id, dia, hora) "
            + "VALUES (?, ?, ?, ?, ?); ";
    
    protected static final String UPDATE_CMD
            = "UPDATE horario "
            + "SET grupo_num = ?, grupo_curso_id = ?, dia = ?, hora = ? "
            + "WHERE seq = ?; ";

    
}

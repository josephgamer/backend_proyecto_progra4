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
public class CursoCRUD extends AbstractCRUD {

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
            = "SELECT c.id_curso, c.descripcion, c.area_tematica_id, a.descripcion_area FROM curso c\n"
            + " inner join area_tematica a on c.area_tematica_id=a.id_area; ";

    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.curso "
            + "(id_curso, descripcion, area_tematica_id) "
            + "VALUES (?, ?, ?); ";

    protected static final String UPDATE_CMD
            = "UPDATE curso "
            + "SET descripcion = ? "
            + "WHERE id_curso = ?; ";

}

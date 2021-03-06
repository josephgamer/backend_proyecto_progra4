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
public class GrupoCRUD extends AbstractCRUD {

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
            = "SELECT g.num_grupo, g.curso_id, g.profesor_id, p.nombre, p.apellido1, p.apellido2 FROM grupo g\n"
            + " inner join profesor p on g.profesor_id=p.id_profesor; ";

    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.grupo "
            + "(num_grupo, curso_id, profesor_id) "
            + "VALUES (?, ?, ?); ";

    protected static final String UPDATE_CMD
            = "UPDATE grupo "
            + "SET  curso_id = ?, profesor_id = ? "
            + "WHERE num_grupo = ?; ";

}

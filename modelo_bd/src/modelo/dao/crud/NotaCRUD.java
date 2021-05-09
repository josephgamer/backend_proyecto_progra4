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
public class NotaCRUD extends AbstractCRUD {

    @Override
    public String getListAllCmd() {
        return LIST_CMD;
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
        return UPDATE_CMD;
    }

    @Override
    public String getDeleteCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected static final String LIST_CMD
            = "select e.id_estudiante,e.nombre,e.apellido1,e.apellido2,m.nota,es.descripcion, m.grupo_num\n"
            + "from matricula m inner join estudiante e on m.estudiante_id=e.id_estudiante\n"
            + "inner join estado es on m.estado_id=es.id_estado inner join grupo g\n"
            + "where m.grupo_num=g.num_grupo; ";
    
    protected static final String UPDATE_CMD
            = "UPDATE matricula "
            + "SET nota = ?, estado_id = ? "
            + "WHERE estudiante_id = ? and grupo_num = ?; ";

}

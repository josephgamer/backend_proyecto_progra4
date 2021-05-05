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
public class MatriculaCRUD extends AbstractCRUD {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeleteCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected static final String ADD_CMD
            = "INSERT INTO eif209_2021_01.matricula "
            + "(estudiante_id, grupo_num ,curso_id, estado_id, nota) "
            + "VALUES (?, ?, ?, ?, ?); ";

    protected static final String LIST_CMD
            = "select m.estudiante_id, g.num_grupo, a.descripcion_area, c.descripcion, p.nombre, p.apellido1, p.apellido2, m.nota, e.descripcion "
            + "from grupo g inner join curso c on g.curso_id = c.id_curso join profesor p on g.profesor_id = p.id_profesor "
            + "inner join area_tematica a on c.area_tematica_id = a.id_area inner join estado e inner join matricula m on e.id_estado = m.estado_id "
            + "and m.estudiante_id = ?; ";
    
}

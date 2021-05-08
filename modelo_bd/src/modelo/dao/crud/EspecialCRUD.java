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
public class EspecialCRUD extends AbstractCRUD {

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getDeleteCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    protected static final String LIST_CMD
            = "select h.dia, h.hora, g.num_grupo, c.id_curso, p.nombre, p.apellido1, p.apellido2,\n"
            + "c.descripcion,a.descripcion_area from horario h inner join grupo g\n"
            + "on h.grupo_num=g.num_grupo and h.grupo_curso_id=g.curso_id inner join\n"
            + "profesor p on g.profesor_id=p.id_profesor inner join curso c on\n"
            + "g.curso_id=c.id_curso inner join area_tematica a on c.area_tematica_id=a.id_area; ";
}

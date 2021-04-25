/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.Serializable;

/**
 *
 * @author Esteban
 */
public class Especialidad implements Serializable{
    public Especialidad(Profesor profe_id_profe, AreaTematica area_tematica_id) {
        this.profe_id_profe = profe_id_profe;
        this.area_tematica_id = area_tematica_id;
    }

    public Especialidad() {
        this.area_tematica_id = new AreaTematica();
        this.profe_id_profe = new Profesor();
    }

    public Profesor getProfe_id_profe() {
        return profe_id_profe;
    }

    public void setProfe_id_profe(Profesor profe_id_profe) {
        this.profe_id_profe = profe_id_profe;
    }

    public AreaTematica getArea_tematica_id() {
        return area_tematica_id;
    }

    public void setArea_tematica_id(AreaTematica area_tematica_id) {
        this.area_tematica_id = area_tematica_id;
    }
    
    private Profesor profe_id_profe;
    private AreaTematica area_tematica_id;
}

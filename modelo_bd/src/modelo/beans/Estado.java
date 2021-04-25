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
public class Estado implements Serializable {
    public Estado(int id_estado, String est_descripcion) {
        this.id_estado = id_estado;
        this.est_descripcion = est_descripcion;
    }

    public Estado() {
        this.id_estado = 0;
        this.est_descripcion = "-";
    }

    public int getId_estado() {
        return id_estado;
    }

    public void setId_estado(int id_estado) {
        this.id_estado = id_estado;
    }

    public String getEst_descripcion() {
        return est_descripcion;
    }

    public void setEst_descripcion(String est_descripcion) {
        this.est_descripcion = est_descripcion;
    }
    
    private int id_estado;
    private String est_descripcion;
}

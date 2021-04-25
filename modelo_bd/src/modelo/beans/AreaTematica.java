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
public class AreaTematica implements Serializable {
    public AreaTematica(int id_area, String tematica_descrip) {
        this.id_area = id_area;
        this.tematica_descrip = tematica_descrip;
        
    }

    public AreaTematica() {
        this.id_area = 0;
        this.tematica_descrip = "-";
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public String getTematica_descrip() {
        return tematica_descrip;
    }

    public void setTematica_descrip(String tematica_descrip) {
        this.tematica_descrip = tematica_descrip;
    }
    
    private int id_area;
    private String tematica_descrip;
}

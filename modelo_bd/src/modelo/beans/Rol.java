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
public class Rol implements Serializable{
    
    public Rol(int id_rol, String descripcion) {
        this.id_rol = id_rol;
        this.descripcion = descripcion;
    }

    public Rol() {
        this.id_rol = 0;
        this.descripcion = "-";
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    private int id_rol;
    private String descripcion;
    
}

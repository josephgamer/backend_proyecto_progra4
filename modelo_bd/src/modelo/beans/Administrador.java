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
public class Administrador implements Serializable {
    public Administrador(int id_admin, String apellido1, String apellido2, String nombre, String telefono, String email) {
        this.id_admin = id_admin;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public Administrador() {
        this.id_admin = 0;
        this.apellido1 = "-";
        this.apellido2 = "-";
        this.nombre = "-";
        this.telefono = "-";
        this.email = "-";
    }

    public int getId_admin() {
        return id_admin;
    }

    public void setId_admin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Usuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }
    

    @Override
    public String toString() {
        return "Administrador{" + "id_admin=" + id_admin + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", nombre=" + 
                nombre + ", telefono=" + telefono + ", email=" + email + '}';
    }
    
    private int id_admin;
    private String apellido1;
    private String apellido2;
    private String nombre;
    private String telefono;
    private String email;
    private Usuario usuario_id;
}

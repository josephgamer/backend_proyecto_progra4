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
public class Estudiante implements Serializable {
     public Estudiante(int id_estudiante, String apellido1, String apellido2, String nombre, String telefono, String email) {
        this.id_estudiante = id_estudiante;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.telefono = telefono;
        this.e_mail = email;
    }

    public Estudiante(int id_estudiante, Usuario usuario_id ,String apellido1, String apellido2, String nombre, String telefono, String email) {
        this.id_estudiante = id_estudiante;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.telefono = telefono;
        this.e_mail = email;
        this.usuario_id = usuario_id;
    }

    public Estudiante() {
        this.id_estudiante = 0;
        this.apellido1 = "-";
        this.apellido2 = "-";
        this.nombre = "-";
        this.telefono = "-";
        this.e_mail = "-";
    }

    public int getId_estudiante() {
        return id_estudiante;
    }

    public void setId_estudiante(int id_estudiante) {
        this.id_estudiante = id_estudiante;
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
        return e_mail;
    }

    public Usuario getUsuario_id() {
        return usuario_id;
    }

    public void setUsuario_id(Usuario usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setEmail(String email) {
        this.e_mail = email;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "id_estudiante=" + id_estudiante + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", nombre=" + nombre + ", telefono=" + telefono + ", e_mail=" + e_mail + ", usuario_id=" + usuario_id + '}';
    }
    
    private int id_estudiante;
    private String apellido1;
    private String apellido2;
    private String nombre;
    private String telefono;
    private String e_mail;
    private Usuario usuario_id;
}


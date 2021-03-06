/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 *
 * @author Esteban
 */
public class Profesor implements Serializable {

    public Profesor(int id_profesor, String apellido1, String apellido2, String nombre, String telefono, String email) {
        this.id_profesor = id_profesor;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }

    public Profesor(int id_profesor, Usuario usuario_id, String apellido1, String apellido2, String nombre, String telefono, String email) {
        this.id_profesor = id_profesor;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
        this.usuario_id = usuario_id;
    }

    public Profesor() {
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
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
        return "Profesor{" + "id_profesor=" + id_profesor + ", apellido1="
                + apellido1 + ", apellido2=" + apellido2 + ", nombre=" + nombre
                + ", telefono=" + telefono + ", email=" + email + ", usuario_id="
                + usuario_id + '}';
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getId_profesor()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getApellido1()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getApellido2()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getNombre()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getEmail()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getTelefono()));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }

    private int id_profesor;
    private String apellido1;
    private String apellido2;
    private String nombre;
    private String telefono;
    private String email;
    private Usuario usuario_id;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dao.ProfesorDAO;
import modelo.dao.UsuarioDAO;

/**
 *
 * @author YENDRI
 */

public class ConjuntoProfesor implements Serializable {

//    public ConjuntoProfesor() {
//        this.profesores = null;
//        try {
//            this.profesores = new ProfesorDAO();
//        } catch (Exception ex) {
//            System.err.printf("Excepción: '%s'%n", ex.getMessage());
//        }
//    }
    
        public ConjuntoProfesor() {
        this.profesores = null;
        this.user = null;
        try {
            this.profesores = new ProfesorDAO();
            this.user = new UsuarioDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public void agregar(Profesor nuevoProfesor) throws SQLException, IOException {
        profesores.add(nuevoProfesor.getId_profesor(), nuevoProfesor);
    }
    
    public void agregar2(Profesor nuevoProfesor) throws SQLException, IOException {
         user.add(nuevoProfesor.getUsuario_id().getId_usuario(), nuevoProfesor.getUsuario_id());
        profesores.add(nuevoProfesor.getId_profesor(), nuevoProfesor);
    }

    public void borrarTodos() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Profesor> t = getListaProfesor();
        for (Profesor p : t) {
            r.append(String.format("\t%s,%n", p));
        }
        r.append("]");
        return r.toString();
    }

    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaProfesores\">\n");

        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Apellido 1"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Apellido 2"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Nombre"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Correo"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Telefono"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Profesor> t = getListaProfesor();
        for (Profesor p : t) {
            r.append(p.toStringHTML());
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }

    
    ////////////////Nuevo
    
      public String toStringHTMLBusqueda(String descripcion) {
        String minuscula = "";
        String result = "";
        if (!descripcion.isEmpty()) {
            minuscula = descripcion.toLowerCase();
            char[] arr = minuscula.toCharArray();
            arr[0] = Character.toUpperCase(arr[0]);
            result = new String(arr);
        }
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaCursos\">\n");

        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Apellido 1"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Apellido 2"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Nombre"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Correo"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Télefono"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Profesor> t = getListaProfesor();
        for (Profesor c : t) {
            if (c.getNombre().equals(result)) {
                r.append(c.toStringHTML());
            }

        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }
    
    
    
      public String toStringHTMLBusqueda2(String descripcion) {
        String minuscula = "";
        String result = "";
        if (!descripcion.isEmpty()) {
            minuscula = descripcion.toLowerCase();
            char[] arr = minuscula.toCharArray();
            arr[0] = Character.toUpperCase(arr[0]);
            result = new String(arr);
        }
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaProfesores\">\n");

        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Apellido 1"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Apellido 2"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Nombre"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Correo"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Télefono"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Profesor> t = getListaProfesor();
        for (Profesor c : t) {
            if (c.getNombre().equals(result)) {
                r.append(c.toStringHTML());
            }

        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }
    
    
    
    
    
    ///////////////////////Nuevo
    
    
    public List<Profesor> getListaProfesor() {
        try {
            return profesores.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }

    public String getTabla() {
        return toStringHTML();
    }

    private ProfesorDAO profesores;
    private UsuarioDAO user;
}

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
import modelo.dao.EstudianteDAO;
import modelo.dao.UsuarioDAO;

/**
 *
 * @author Esteban
 */
public class ConjuntoEstudiantes implements Serializable{
    
    private EstudianteDAO estudiantes;
    private UsuarioDAO user;
    
    public ConjuntoEstudiantes() {
        this.estudiantes = null;
        this.user = null;
        try {
            this.estudiantes = new EstudianteDAO();
            this.user = new UsuarioDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public void agregar(Estudiante nuevoLooser) throws SQLException, IOException {
        user.add(nuevoLooser.getUsuario_id().getId_usuario(), nuevoLooser.getUsuario_id());
        estudiantes.add(nuevoLooser.getId_estudiante(), nuevoLooser);
    }
    
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Estudiante> t = getListaEstudiantes();
        for (Estudiante p : t) {
            r.append(String.format("\t%s,%n", p));
        }
        r.append("]");
        return r.toString();
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaPersonas\">\n");

        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Apellido 1"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Apellido 2"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Nombre"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Nacimiento"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "&nbsp;"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Estudiante> t = getListaEstudiantes();
        for (Estudiante p : t) {
            r.append(p.toStringHTML());
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }
    
    public String getTabla() {
        return toStringHTML();
    }
    
    public List<Estudiante> getListaEstudiantes() {
        try {
            return estudiantes.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
}

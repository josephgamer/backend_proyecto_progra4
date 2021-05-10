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
import modelo.dao.MatriculaDAO;

/**
 *
 * @author Esteban
 */
public class ConjuntoHistorial implements Serializable{
    
    private MatriculaDAO matricula;
    
    public ConjuntoHistorial() {
        this.matricula = null;        try {
            this.matricula = new MatriculaDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public List<Matricula> buscarHistorialID(int id) {
        List<Matricula> result = new ArrayList<>();
        List<Matricula> all = todoHistorial();
        for (Matricula m : all) {
            if (m.getEstudiante_id().getId_estudiante() == id) {
                result.add(m);
            }
        }
        return result;
    }
    
    public String mostrarHistorial(int cedula) {
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaHistorial\">\n");

        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Nombre "));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Primer apellido"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Segundo apellido"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Nota"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Estatus del curso"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "&nbsp;"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Matricula> t = todoHistorial();
        for (Matricula p : t) {
            if (p.getEstudiante_id().getId_estudiante() == cedula) {
                r.append(p.toStringHistorial());
            }
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }
    
    List<Matricula> todoHistorial() {
        try {
            return matricula.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
}

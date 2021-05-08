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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.AsignacionCursosDAO;

/**
 *
 * @author Esteban
 */
public class ConjuntoAsignacionCursos implements Serializable{
    
    private AsignacionCursosDAO asignados;
    
    public ConjuntoAsignacionCursos() {
        this.asignados = null;
        try {
            this.asignados = new AsignacionCursosDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public String toStringAsignados(int cedula) {
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaCursosAsignados\">\n");

        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Cedula Profesor"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Numero Grupo"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Codigo Curso"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Materia"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "&nbsp;"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Grupo> t = getListaAsignados();
        for (Grupo p : t) {
            if (p.getProfesor_id().getId_profesor() == cedula) {
                r.append(p.toStringHTML());
            }
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }
    
    public List<Grupo> getListaAsignados() {
        try {
            return asignados.listAll();
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoAsignacionCursos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoAsignacionCursos.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
        return new ArrayList<>();
    }
    
}

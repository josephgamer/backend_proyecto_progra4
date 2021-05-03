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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import modelo.dao.EspecialDAO;

/**
 *
 * @author Esteban
 */
@XmlRootElement(name = "lista-cursos")
public class ConjuntoEspecial implements Serializable{
    
    @XmlTransient
    private EspecialDAO cursos;
    
    public ConjuntoEspecial() {
        this.cursos = null;
        try {
            this.cursos = new EspecialDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Horario> t = getListaHoraiosCursos();
        for (Horario c : t) {
            r.append(String.format("\t%s,%n", c));
        }
        r.append("]");
        return r.toString();
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaCursos\">\n");

        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Dia"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Hora"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Numero de Grupo"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Numero de Curso"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Nombre Profesor"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Primer Apellido"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Segundo Apellido"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Materia del curso"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Area Tematica del curso"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Horario> t = getListaHoraiosCursos();
        for (Horario c : t) {
            r.append(c.toStringHTML());
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }
    
    public List<Horario> getListaHoraiosCursos() {
        try {
            return cursos.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
    
    public String getTabla() {
        return toStringHTML();
    }
}

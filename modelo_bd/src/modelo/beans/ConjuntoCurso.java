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
import modelo.dao.CursoDAO;
import modelo.dao.EspecialDAO;

/**
 *
 * @author YENDRI
 */
public class ConjuntoCurso implements Serializable {

    public ConjuntoCurso() {
        this.cursos = null;
        this.especial = null;
        try {
            this.cursos = new CursoDAO();
            this.especial = new EspecialDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public void agregar(Curso nuevoCurso) throws SQLException, IOException {
        cursos.add(nuevoCurso.getId_curso(), nuevoCurso);
    }

    public void borrarTodos() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String toString() {
        StringBuilder r = new StringBuilder();
        r.append("[\n");
        List<Curso> t = getListaCurso();
        for (Curso c : t) {
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
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Id"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Descripcion"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Curso> t = getListaCurso();
        for (Curso c : t) {
            r.append(c.toStringHTML());
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }

    public String toStringHTML2() {
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
            if (c.getGrupo_curso_id().getAreaTematica_id().getTematica_descrip().equals(result)
                    || c.getGrupo_curso_id().getCurso_descrip().equals(result)) {
                r.append(c.toStringHTML());
            }

        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }

    public List<Curso> getListaCurso() {
        try {
            return cursos.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }

    public List<Horario> getListaHoraiosCursos() {
        try {
            return especial.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }

    public String getTabla() {
        return toStringHTML2();
    }

    private CursoDAO cursos;
    private EspecialDAO especial;
}

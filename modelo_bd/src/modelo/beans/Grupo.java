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
public class Grupo implements Serializable {
    public Grupo(int num_grupo) {
        this.num_grupo = num_grupo;
    }
    
    public Grupo(int num_grupo, Curso curso_id) {
        this.num_grupo = num_grupo;
        this.curso_id = curso_id;
    }

    public Grupo() {
        this.curso_id = new Curso();
        this.num_grupo = 0;
        this.profesor_id = new Profesor();
    }

    public Grupo(int num_grupo, Curso curso_id, Profesor profesor_id) {
        this.num_grupo = num_grupo;
        this.curso_id = curso_id;
        this.profesor_id = profesor_id;
    }

    public int getNum_grupo() {
        return num_grupo;
    }

    public void setNum_grupo(int num_grupo) {
        this.num_grupo = num_grupo;
    }

    public Curso getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(Curso curso_id) {
        this.curso_id = curso_id;
    }

    public Profesor getProfesor_id() {
        return profesor_id;
    }

    public void setProfesor_id(Profesor profesor_id) {
        this.profesor_id = profesor_id;
    }

    @Override
    public String toString() {
        return "Grupo{" + "num_grupo=" + num_grupo + ", curso_id=" + curso_id + ", profesor_id=" + profesor_id + '}';
    }
    
    public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getProfesor_id().getId_profesor()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getNum_grupo()));
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getCurso_id().getId_curso()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getCurso_id().getCurso_descrip()));
        r.append(String.format(
                "\t\t\t\t<td><form action='%s'><button name='id_numGrupo' value='%d' >Ver Estudiantes</button></td></form>\n",
                "VerEstudiantes.jsp",
                getCurso_id().getId_curso()));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }
    
    private int num_grupo;
    private Curso curso_id;
    private Profesor profesor_id;
    
}

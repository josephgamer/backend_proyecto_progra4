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
public class Curso implements Serializable{
    

    public Curso(int id_curso, String curso_descrip) {
        this.id_curso = id_curso;
        this.curso_descrip = curso_descrip;
    }
    
     public Curso(int id_curso, String curso_descrip, AreaTematica areaTematica_id) {
        this.id_curso = id_curso;
        this.curso_descrip = curso_descrip;
        this.areaTematica_id = areaTematica_id;
    }

//    public Curso(int id_curso, String curso_descrip, AreaTematica areaTematica_id, Grupo grupo) {
//        this.id_curso = id_curso;
//        this.curso_descrip = curso_descrip;
//        this.areaTematica_id = areaTematica_id;
//        this.grupo = grupo;
//    }

    public Curso() {
        this.id_curso = 0;
        this.curso_descrip = "-";
    }

    public int getId_curso() {
        return id_curso;
    }

    public void setId_curso(int id_curso) {
        this.id_curso = id_curso;
    }

    public String getCurso_descrip() {
        return curso_descrip;
    }

    public void setCurso_descrip(String curso_descrip) {
        this.curso_descrip = curso_descrip;
    }

    public AreaTematica getAreaTematica_id() {
        return areaTematica_id;
    }

    public void setAreaTematica_id(AreaTematica areaTematica_id) {
        this.areaTematica_id = areaTematica_id;
    }

//    public Grupo getGrupo() {
//        return grupo;
//    }
//
//    public void setGrupo(Grupo grupo) {
//        this.grupo = grupo;
//    }
    
    
    
     public String toStringHTML() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getId_curso()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getCurso_descrip()));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }
     
     public String toStringHTMLAdmin() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");
        
        r.append(String.format("\t\t\t\t<td>%d</td>\n", getId_curso()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getCurso_descrip()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getAreaTematica_id().getTematica_descrip()));
        //r.append(String.format("\t\t\t\t<td>%s</td>\n", getGrupo().getNum_grupo()));
        //getGrupo().getNum_grupo();
        r.append("\t\t\t</tr>\n");
        return r.toString();
    }


    private int id_curso;
    private String curso_descrip;
    private AreaTematica areaTematica_id;
    //private Grupo grupo;
}

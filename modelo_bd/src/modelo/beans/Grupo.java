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
    
    private int num_grupo;
    private Curso curso_id;
    private Profesor profesor_id;
    
}

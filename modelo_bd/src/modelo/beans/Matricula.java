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
public class Matricula implements Serializable{
    
     public Matricula() {
        this.matricula_id = 0;
        this.grupo_num = 0;
        this.curso_id = 0;
        this.nota = 0;
    }
    
    public Matricula(int matricula_id, int grupo_num, int curso_id, int nota) {
        this.matricula_id = matricula_id;
        this.grupo_num = grupo_num;
        this.curso_id = curso_id;
        this.nota = nota;
    }

    public Matricula(int grupo_num, int curso_id, Estudiante estudiante_id, int nota, Estado estado_id) {
        this.grupo_num = grupo_num;
        this.curso_id = curso_id;
        this.estudiante_id = estudiante_id;
        this.nota = nota;
        this.estado_id = estado_id;
    }

    public int getMatricula_id() {
        return matricula_id;
    }

    public void setMatricula_id(int matricula_id) {
        this.matricula_id = matricula_id;
    }

    public int getGrupo_num() {
        return grupo_num;
    }

    public void setGrupo_num(int grupo_num) {
        this.grupo_num = grupo_num;
    }

    public int getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(int curso_id) {
        this.curso_id = curso_id;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public Estudiante getEstudiante_id() {
        return estudiante_id;
    }

    public void setEstudiante_id(Estudiante estudiante_id) {
        this.estudiante_id = estudiante_id;
    }

    public Estado getEstado_id() {
        return estado_id;
    }

    public void setEstado_id(Estado estado_id) {
        this.estado_id = estado_id;
    }
    
    public String toStringHTMLActualizarNota() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getEstudiante_id().getId_estudiante()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getEstudiante_id().getNombre()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getEstudiante_id().getApellido1()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getEstudiante_id().getApellido2()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getNota()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getEstado_id().getEst_descripcion()));

        
        r.append(String.format("\t\t\t\t<td><form action='%s'><input type='%s' name='%s'>\n","ServicioNota" ,"number","nota"));
        r.append(String.format(
                "\t\t\t\t<button name='cedula' value='%d' >Actualizar Nota</button></td></form>\n",
                getEstudiante_id().getId_estudiante()));

        r.append("\t\t\t</tr>\n");
        return r.toString();
    }
    
    public String toStringHistorial() {
        StringBuilder r = new StringBuilder();
        r.append("\t\t\t<tr>\n");

        r.append(String.format("\t\t\t\t<td>%d</td>\n", getEstudiante_id().getId_estudiante()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getCurso_id()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getGrupo_num()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getNota()));
        r.append(String.format("\t\t\t\t<td>%s</td>\n", getEstado_id().getEst_descripcion()));
        r.append("\t\t\t</tr>\n");
        return r.toString();
    }
    
    private int matricula_id;
    private int grupo_num;
    private int curso_id;
    private int nota;
    private Estudiante estudiante_id;
    private Estado estado_id;
    
}

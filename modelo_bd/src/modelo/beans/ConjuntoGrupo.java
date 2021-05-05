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
import modelo.dao.GrupoDAO;

/**
 *
 * @author Esteban
 */
public class ConjuntoGrupo implements Serializable{
    
    private GrupoDAO grupo;
    
    public ConjuntoGrupo() {
        this.grupo = null;        try {
            this.grupo = new GrupoDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public Grupo buscarCurso(int numGrupo) {
        List<Grupo> busqueda = getListaCurso();
        for (Grupo grupo : busqueda) {
            if (grupo.getNum_grupo() == numGrupo) {
                return grupo;
            }
        }
        return null;
    }
    
    public List<Grupo> getListaCurso() {
        try {
            return grupo.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
}

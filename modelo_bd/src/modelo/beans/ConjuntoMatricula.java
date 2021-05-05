/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import modelo.dao.MatriculaDAO;

/**
 *
 * @author Esteban
 */
public class ConjuntoMatricula implements Serializable {
    private MatriculaDAO matricula;
    
    public ConjuntoMatricula() {
        this.matricula = null;        try {
            this.matricula = new MatriculaDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public void agregar(Matricula nuevoCurso) throws SQLException, IOException {
        matricula.add(0, nuevoCurso);
    }
}

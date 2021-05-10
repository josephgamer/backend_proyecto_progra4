/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import modelo.dao.EspecialidadDAO;

/**
 *
 * @author Esteban
 */
public class ConjuntoEspecialidad implements Serializable{
    private EspecialidadDAO especialidad;
    
    public ConjuntoEspecialidad() {
        this.especialidad = null;
        try {
            this.especialidad = new EspecialidadDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public void agregarEspecialidad(Especialidad value) throws SQLException, IOException {
        this.especialidad.add(0, value);
    }
}

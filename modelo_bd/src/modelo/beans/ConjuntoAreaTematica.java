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
import modelo.dao.AreaTematicaDAO;

/**
 *
 * @author Esteban
 */
public class ConjuntoAreaTematica implements Serializable {

    private AreaTematicaDAO area;

    public ConjuntoAreaTematica() {
        this.area = null;
        try {
            this.area = new AreaTematicaDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public String verAreas() {
        StringBuilder r = new StringBuilder();
        List<AreaTematica> result = getListaAreas();
        for (AreaTematica s : result) {
            r.append(String.format("\t\t\t<option size = '1' value = '%d'>\n", s.getId_area()));
            r.append(String.format(s.getTematica_descrip()));
            r.append(String.format("\t\t\t</option>\n"));

        }
        return r.toString();
    }

    public List<AreaTematica> getListaAreas() {
        try {
            return area.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
}

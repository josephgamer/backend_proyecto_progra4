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
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.dao.NotaDAO;

/**
 *
 * @author Esteban
 */
public class ConjuntoNota implements Serializable {

    private NotaDAO nota;

    public ConjuntoNota() {
        this.nota = null;
        try {
            this.nota = new NotaDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }

    public void actualizarNota(Integer cedula, Matricula value) {
        try {
            this.nota.update(cedula, value);
        } catch (SQLException ex) {
            Logger.getLogger(ConjuntoNota.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ConjuntoNota.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String toStringHTMLVerEstudiantes(int numGrupo) {
        StringBuilder r = new StringBuilder();
        r.append("\t<table class=\"tablaPersonas\">\n");

        r.append("\t\t<thead>\n");
        r.append("\t\t\t<tr>\n");
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Cedula Estudiante"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Nombre"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Primer Apellido"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Segundo Apellido"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Nota"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "Condicion"));
        r.append(String.format("\t\t\t\t<th>%s</th>\n", "&nbsp;"));
        r.append("\t\t\t<tr>\n");
        r.append("\t\t</thead>\n");

        r.append("\t\t<tbody>\n");
        List<Matricula> t = getListaNotas();
        for (Matricula p : t) {
            if (p.getGrupo_num() == numGrupo) {
                r.append(p.toStringHTMLActualizarNota());
            }
        }
        r.append("\t\t</tbody>\n");

        r.append("\t\t<tfoot></tfoot>\n");
        r.append("\t</table>\n");

        return r.toString();
    }

    public List<Matricula> getListaNotas() {
        try {
            return nota.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
}

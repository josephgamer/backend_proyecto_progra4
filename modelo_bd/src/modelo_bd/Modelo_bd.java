/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo_bd;

import cr.ac.una.db.Database;
import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import modelo.beans.Estudiante;
import modelo.beans.Usuario;
import modelo.dao.EstudianteDAO;
import modelo.dao.EstudiantesBD;

/**
 *
 * @author Esteban
 */
public class Modelo_bd {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        /*Database db = new EstudiantesBD();
        if (db == null) {
            System.out.println("me jodi");
        } else {
            System.out.println("Soy feliz");
        }*/
        
        try {
            Database db = new EstudiantesBD() {
            };
            System.out.println(db);

            //DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            EstudianteDAO bd = new EstudianteDAO();
            //mostrarLista(bd);
            
            Usuario u = new Usuario();
            u.setId_usuario("122223333");

            Estudiante x = new Estudiante(
                    122223333,u , 
                    "González", "Benavides",
                    "Andrea",
                    "23554645657", "andrea@crack.com");

            //bd.delete(x.getId());
            //mostrarLista(bd);

            //bd.add(x.getId_estudiante(), x);
            mostrarLista(bd);

            x.setApellido1("Corrales");
            x.setApellido2("Montero");
            bd.update(x.getId_estudiante(), x);
            mostrarLista(bd);

        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    private static void mostrarLista(EstudianteDAO bd) throws IOException, SQLException {
        List<Estudiante> estudiantes = bd.listAll();
        for (Estudiante estudiante : estudiantes) {
            System.out.println(estudiante.toString());
        }
        System.out.println();
    }
}

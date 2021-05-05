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
import modelo.beans.Horario;
import modelo.beans.Matricula;
import modelo.beans.Profesor;
import modelo.beans.Usuario;
import modelo.dao.EspecialBD;
import modelo.dao.EspecialDAO;
import modelo.dao.EstudianteDAO;
import modelo.dao.EstudiantesBD;
import modelo.dao.MatriculaDAO;
import modelo.dao.ProfesorDAO;

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
            Database db = new EspecialBD() {
            };
            System.out.println(db);

            //DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            //ProfesorDAO bd = new ProfesorDAO();
            MatriculaDAO bd = new MatriculaDAO();
            Matricula value = new Matricula();
            Estudiante e = new Estudiante();
            e.setId_estudiante(122223333);
            value.setEstudiante_id(e);
            System.out.println(bd.listAll().size());
            //mostrarListaCursos(bd);
            
            /*Usuario u = new Usuario();
            u.setId_usuario("4892");*/

            /*Profesor x = new Profesor(
                    4892,u , 
                    "Herrera", "Hernandez",
                    "Jorge",
                    "23554645657", "jorge@estricto.com");*/

            //bd.delete(x.getId());
            /*mostrarListaProfesor(bd);

            bd.add(x.getId_profesor(), x);
            mostrarListaProfesor(bd);

            x.setApellido1("Corrales");
            x.setApellido2("Montero");
            bd.update(x.getId_profesor(), x);
            mostrarListaProfesor(bd);*/

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
    
    private static void mostrarListaProfesor(ProfesorDAO bd) throws IOException, SQLException {
        List<Profesor> profesores = bd.listAll();
        for (Profesor profesor : profesores) {
            System.out.println(profesor.toString());
        }
        System.out.println();
    }
    
    private static void mostrarListaCursos(EspecialDAO bd) throws IOException, SQLException {
        List<Horario> cursos = bd.listAll();
        for (Horario curso : cursos) {
            System.out.println(curso.toStringHTML());
        }
        System.out.println();
    }
    
    
}

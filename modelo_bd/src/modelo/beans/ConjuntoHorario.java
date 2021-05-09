/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package modelo.beans;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.dao.HorarioDAO;

public class ConjuntoHorario {
    
    private HorarioDAO horario;
    
    public ConjuntoHorario() {
        this.horario = null;        try {
            this.horario = new HorarioDAO();
        } catch (Exception ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
        }
    }
    
    public Horario buscarHorario(int numHorario) {
        List<Horario> busqueda = getListaHorario();
        for (Horario horario : busqueda) {
            if (horario.getSeq() == numHorario) {
                return horario;
            }
        }
        return null;
    }
    
    public List<Horario> getListaHorario() {
        try {
            return horario.listAll();
        } catch (IOException | SQLException ex) {
            System.err.printf("Excepción: '%s'%n", ex.getMessage());
            return new ArrayList<>();
        }
    }
    
    public Horario getHorario(int id_horario){
        for(Horario g: getListaHorario()){
            if(g.getSeq() == id_horario){
                return g;
            }
        }
        return null;
    }
    
    //Nuevo
    public void agregar(Horario nuevoHorario) throws SQLException, IOException {
        horario.add(nuevoHorario.getSeq(), nuevoHorario);
    }
    
    public int getLast()  throws SQLException, IOException {
        return horario.getLast();
    }   
}
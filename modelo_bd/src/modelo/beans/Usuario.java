/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.beans;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Esteban
 */
public class Usuario implements Serializable {
    
    public Usuario(String id_usuario, String clave, Date ultimo_acceso, boolean activo) {
        this.id_usuario = id_usuario;
        this.clave = clave;
        this.ultimo_acceso = ultimo_acceso;
        this.activo = activo;
    }

    public Usuario() {
        this.id_usuario = "-";
        this.clave = "-";
        this.ultimo_acceso = new Date();
        this.activo = false;
    }

    public String getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(String id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Date getUltimo_acceso() {
        return ultimo_acceso;
    }

    public void setUltimo_acceso(Date ultimo_acceso) {
        this.ultimo_acceso = ultimo_acceso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public Rol getRol_id() {
        return rol_id;
    }

    public void setRol_id(Rol rol_id) {
        this.rol_id = rol_id;
    }
    
    private String id_usuario;
    private String clave;
    private Date ultimo_acceso;
    private boolean activo;
    private Rol rol_id;
    
}

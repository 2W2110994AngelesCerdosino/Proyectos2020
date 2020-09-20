/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author NotebookSFC
 */
public class DTOVisitas 
{
//Nombre del paciente, nombre del visitante, nombre del recepcionista, duración
    private String nombrePaciente;
    private String nombreVisitante;
    private String nombreRecepcionista;
    private int duracion;

    public DTOVisitas(String nombrePaciente, String nombreVisitante, String nombreRecepcionista, int duracion) {
        this.nombrePaciente = nombrePaciente;
        this.nombreVisitante = nombreVisitante;
        this.nombreRecepcionista = nombreRecepcionista;
        this.duracion = duracion;
    }
    
    
    public DTOVisitas(){};

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public String getNombreVisitante() {
        return nombreVisitante;
    }

    public void setNombreVisitante(String nombreVisitante) {
        this.nombreVisitante = nombreVisitante;
    }

    public String getNombreRecepcionista() {
        return nombreRecepcionista;
    }

    public void setNombreRecepcionista(String nombreRecepcionista) {
        this.nombreRecepcionista = nombreRecepcionista;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    
    
}

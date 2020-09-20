/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author NotebookSFC
 */
public class Visitas 
{
 private int idVisita;
    private int legajoRecepcionista;
    private String nombre;
    private int duracion;
    private Pacientes paciente;

    public Visitas (int idVisita, int legajoRecepcionista, String nombre, int duracion, Pacientes paciente) {
        this.idVisita = idVisita;
        this.legajoRecepcionista = legajoRecepcionista;
        this.nombre = nombre;
        this.duracion = duracion;
        this.paciente = paciente;
    }
    
    public Visitas (){};

    public int getIdVisita() {
        return idVisita;
    }

    public void setIdVisita(int idVisita) {
        this.idVisita = idVisita;
    }

    public int getLegajoRecepcionista() {
        return legajoRecepcionista;
    }

    public void setLegajoRecepcionista(int legajoRecepcionista) {
        this.legajoRecepcionista = legajoRecepcionista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Pacientes getPaciente() {
        return paciente;
    }

    public void setPaciente(Pacientes paciente) {
        this.paciente = paciente;
    }    
}

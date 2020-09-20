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
public class DTOReporte 
{
    private String nombre;
    private int visitasCantidad;

    public DTOReporte(String nombre, int visitasCantidad) {
        this.nombre = nombre;
        this.visitasCantidad = visitasCantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVisitasCantidad() {
        return visitasCantidad;
    }

    public void setVisitasCantidad(int visitasCantidad) {
        this.visitasCantidad = visitasCantidad;
    }
    
    
}

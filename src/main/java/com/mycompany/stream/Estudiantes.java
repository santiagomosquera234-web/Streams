
package com.mycompany.stream;


public class Estudiantes {
    
private String nombre;
    private String programa;
    private double nota;

    public Estudiantes(String nombre, String programa, double nota) {
        this.nombre = nombre;
        this.programa = programa;
        this.nota = nota;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrograma() {
        return programa;
    }

    public double getNota() {
        return nota;
    }

   
    public String toString() {
        return nombre + " - " + programa + " - " + nota;
    }
}

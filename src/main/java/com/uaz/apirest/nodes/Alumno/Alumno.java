package com.uaz.apirest.nodes.Alumno;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import com.uaz.apirest.nodes.Titulo.Titulo;

@Node
public class Alumno {
    
    @Id private int matricula;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private LocalDate fechaIngreso;
    private LocalDate fechaEgreso;
    @Relationship(type = "HAS_TITULO", direction = Relationship.Direction.INCOMING)
    private Titulo titulo; 
    

    // Default constructor
    private Alumno() {};

    public Alumno(int matricula) {
        this.matricula = matricula;
    }

    

    public Alumno(int matricula, String nombres, String apellido1, String apellido2, LocalDate fechaIngreso,
            LocalDate fechaEgreso, Titulo titulo) {
        this.matricula = matricula;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
        this.titulo = titulo;
    }

    

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public LocalDate getFechaEgreso() {
        return fechaEgreso;
    }

    public void setFechaEgreso(LocalDate fechaEgreso) {
        this.fechaEgreso = fechaEgreso;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "matricula=" + matricula +
                ", nombres='" + nombres + '\'' +
                ", apellido1='" + apellido1 + '\'' +
                ", apellido2='" + apellido2 + '\'' +
                ", fechaIngreso=" + fechaIngreso +
                ", fechaEgreso=" + fechaEgreso +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;

        return matricula == alumno.matricula;
    }

    @Override
    public int hashCode() {
        return matricula;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public void setTitulo(Titulo titulo) {
        this.titulo = titulo;
    }
}
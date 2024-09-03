package com.uaz.apirest.Alumno;

import java.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class Alumno {
    
    @Id
    private String matricula;
    private String nombres;
    private String apellido1;
    private String apellido2;
    private LocalDate fechaIngreso;
    private LocalDate fechaEgreso;

    private Alumno() {};

    public Alumno(String matricula) {
        this.matricula = matricula;
    }

    public Alumno(String matricula, String nombres, String apellido1, String apellido2, LocalDate fechaIngreso, LocalDate fechaEgreso) {
        this.matricula = matricula;
        this.nombres = nombres;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaIngreso = fechaIngreso;
        this.fechaEgreso = fechaEgreso;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
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

    // Optional: equals and hashCode methods for proper comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Alumno alumno = (Alumno) o;

        return matricula == alumno.matricula;
    }

    @Override
    public int hashCode() {
        return matricula.hashCode();
    }
}
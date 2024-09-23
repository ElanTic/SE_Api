package com.uaz.apirest.nodes.Titulo;

import java.time.LocalDate;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import com.uaz.apirest.nodes.Alumno.Alumno;

@Node
public class Titulo {

    @Id 
    @GeneratedValue
    private Long id;
    
    // Relationship TipoTitulacion
    @Relationship(type = "HAS_TIPO", direction = Relationship.Direction.INCOMING)
    private TipoTitulacion tipoTitulacion;

    private LocalDate fechaTitulacion;
    private int cedula;

    //@Relationship(type = "HAS_TITULO", direction = Relationship.Direction.OUTGOING)
    //private Alumno alumno; 
    

    private Titulo() {};

    public Titulo(LocalDate fechaTitulacion) {
        this.fechaTitulacion = fechaTitulacion;
    }

    public Titulo(TipoTitulacion tipoTitulacion, LocalDate fechaTitulacion, int cedula) {
        //this.alumno = alumno;
        this.tipoTitulacion = tipoTitulacion;
        this.fechaTitulacion = fechaTitulacion;
        this.cedula = cedula;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoTitulacion getTipoTitulacion() {
        return tipoTitulacion;
    }

    public void setTipoTitulacion(TipoTitulacion tipoTitulacion) {
        this.tipoTitulacion = tipoTitulacion;
    }

    public LocalDate getFechaTitulacion() {
        return fechaTitulacion;
    }

    public void setFechaTitulacion(LocalDate fechaTitulacion) {
        this.fechaTitulacion = fechaTitulacion;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "Titulo{" +
                "id=" + id +
//                ", alumno=" + alumno +
                ", tipoTitulacion=" + tipoTitulacion +
                ", fechaTitulacion=" + fechaTitulacion +
                ", cedula=" + cedula +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Titulo titulo = (Titulo) o;

        return id != null ? id.equals(titulo.id) : titulo.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

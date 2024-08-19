package com.uaz.apirest.Puestos;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class TipoPuesto {

    @Id
    @GeneratedValue
    private String id;

    private String nombre;

    // Default constructor
    public TipoPuesto() {}

    // Parameterized constructor
    public TipoPuesto(String nombre) {
        this.nombre = nombre;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Optional: toString method for debugging
    @Override
    public String toString() {
        return "TipoPuesto{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    // Optional: equals and hashCode methods for proper comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoPuesto that = (TipoPuesto) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
package com.uaz.apirest.Titulo;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class TipoTitulacion {

    @Id
    @GeneratedValue
    private Long id; // Changed to Long with auto-generated ID
    
    private String tipo;

    // Default constructor
    public TipoTitulacion() {}

    // Parameterized constructor
    public TipoTitulacion(String tipo) {
        this.tipo = tipo;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    // Optional: toString method for debugging
    @Override
    public String toString() {
        return "TipoTitulacion{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    // Optional: equals and hashCode methods for proper comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoTitulacion that = (TipoTitulacion) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

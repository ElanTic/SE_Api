package com.uaz.apirest.Puestos;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.GeneratedValue.UUIDGenerator;

@Node
public class TipoPuesto {

    @Id
    @GeneratedValue
    private String elementId;

    private String nombre;

    public TipoPuesto() {}

    public TipoPuesto(String nombre) {
        this.nombre = nombre;
    }

    // Getters and setters
    public String getElementId() {
        return elementId;
    }

    public void setElementId(String id) {
        this.elementId = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "TipoPuesto{" +
                "id=" + elementId +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoPuesto that = (TipoPuesto) o;

        return elementId != null ? elementId.equals(that.elementId) : that.elementId == null;
    }

    @Override
    public int hashCode() {
        return elementId != null ? elementId.hashCode() : 0;
    }
}
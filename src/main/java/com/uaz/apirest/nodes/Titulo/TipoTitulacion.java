package com.uaz.apirest.nodes.Titulo;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Node
public class TipoTitulacion {

    @Id
    @GeneratedValue
    private Long elementId; // Changed to Long with auto-generated ID
    
    private String tipo;

    public TipoTitulacion() {}

    public TipoTitulacion(String tipo) {
        this.tipo = tipo;
    }

    // Getters and setters
    public Long getElementId() {
        return elementId;
    }

    public void setElementId(Long id) {
        this.elementId = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoTitulacion that = (TipoTitulacion) o;

        return elementId != null ? elementId.equals(that.elementId) : that.elementId == null;
    }

    @Override
    public int hashCode() {
        return elementId != null ? elementId.hashCode() : 0;
    }
}

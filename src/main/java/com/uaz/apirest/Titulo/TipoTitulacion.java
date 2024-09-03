package com.uaz.apirest.Titulo;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.GeneratedValue.UUIDGenerator;

@Node
public class TipoTitulacion {

    @Id
    @GeneratedValue(generatorClass = UUIDGenerator.class)
    private String uuid;
    
    private String tipo;

    public TipoTitulacion() {}

    public TipoTitulacion(String tipo) {
        this.tipo = tipo;
    }

    // Getters and setters
    public String getUuid() {
        return uuid;
    }

    public void setUuid(String id) {
        this.uuid = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "TipoTitulacion{" +
                "id=" + uuid +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TipoTitulacion that = (TipoTitulacion) o;

        return uuid != null ? uuid.equals(that.uuid) : that.uuid == null;
    }

    @Override
    public int hashCode() {
        return uuid != null ? uuid.hashCode() : 0;
    }
}

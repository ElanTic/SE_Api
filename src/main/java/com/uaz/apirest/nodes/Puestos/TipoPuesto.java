package com.uaz.apirest.nodes.Puestos;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Node
public class TipoPuesto {

    @Id
    @GeneratedValue(generatorClass = UUIDStringGenerator.class)
    private String elementId;

    public String getElementId() {
        return this.elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }
    
    
    private String nombre;

    public TipoPuesto() {}

    public TipoPuesto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    
}
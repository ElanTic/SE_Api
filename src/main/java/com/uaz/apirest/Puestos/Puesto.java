package com.uaz.apirest.Puestos;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue.UUIDGenerator;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

@Node
public class Puesto {

    @Id
    @GeneratedValue
    private String elementId;

    @Relationship(type = "HAS_TIPO", direction = Relationship.Direction.OUTGOING)
    private TipoPuesto tipo;

    private String desc;
    private double salario;

    public Puesto() {}

    public Puesto(TipoPuesto tipo, String desc, double salario) {
        this.tipo = tipo;
        this.desc = desc;
        this.salario = salario;
    }

    // Getters and setters
    public String getElementId() {
        return elementId;
    }

    public void setElementId(String elementId) {
        this.elementId = elementId;
    }

    public TipoPuesto getTipo() {
        return tipo;
    }

    public void setTipo(TipoPuesto tipo) {
        this.tipo = tipo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    // Optional: toString method for debugging
    @Override
    public String toString() {
        return "Puesto{" +
                "elementId=" + elementId +
                ", tipo=" + tipo +
                ", desc='" + desc + '\'' +
                ", salario=" + salario +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Puesto puesto = (Puesto) o;

        return elementId != null ? elementId.equals(puesto.elementId) : puesto.elementId == null;
    }

    @Override
    public int hashCode() {
        return elementId != null ? elementId.hashCode() : 0;
    }
}
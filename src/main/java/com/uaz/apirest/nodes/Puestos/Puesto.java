package com.uaz.apirest.nodes.Puestos;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;
import org.springframework.data.neo4j.core.support.UUIDStringGenerator;

@Node
public class Puesto {

    @Id
    @GeneratedValue(generatorClass = UUIDStringGenerator.class)
    private String id;

    @Relationship(type = "HAS_TIPO", direction = Relationship.Direction.OUTGOING)
    private TipoPuesto tipo;

    private String desc;
    private double salario;

    // Default constructor
    public Puesto() {}

    // Parameterized constructor
    public Puesto(TipoPuesto tipo, String desc, double salario) {
        this.tipo = tipo;
        this.desc = desc;
        this.salario = salario;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
                "id=" + id +
                ", tipo=" + tipo +
                ", desc='" + desc + '\'' +
                ", salario=" + salario +
                '}';
    }

    // Optional: equals and hashCode methods for proper comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Puesto puesto = (Puesto) o;

        return id != null ? id.equals(puesto.id) : puesto.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
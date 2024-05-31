package com.uaz.apirest.Empresa;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;


@Node
public class Empresa {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String rfc;
    private String direccion;
    private String telefono;
    private String email;
    private String tipoDeEmpresa;
    private String representanteLegal;
    private String website;

    // Default constructor
    public Empresa() {}

    // Parameterized constructor
    public Empresa(String nombre, String rfc, String direccion, String telefono, String email, String tipoDeEmpresa, String representanteLegal, String website) {
        this.nombre = nombre;
        this.rfc = rfc;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.tipoDeEmpresa = tipoDeEmpresa;
        this.representanteLegal = representanteLegal;
        this.website = website;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipoDeEmpresa() {
        return tipoDeEmpresa;
    }

    public void setTipoDeEmpresa(String tipoDeEmpresa) {
        this.tipoDeEmpresa = tipoDeEmpresa;
    }

    public String getRepresentanteLegal() {
        return representanteLegal;
    }

    public void setRepresentanteLegal(String representanteLegal) {
        this.representanteLegal = representanteLegal;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    // Optional: toString method for debugging
    @Override
    public String toString() {
        return "Empresa{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", rfc='" + rfc + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                ", email='" + email + '\'' +
                ", tipoDeEmpresa='" + tipoDeEmpresa + '\'' +
                ", representanteLegal='" + representanteLegal + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    // Optional: equals and hashCode methods for proper comparison
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Empresa empresa = (Empresa) o;

        return id != null ? id.equals(empresa.id) : empresa.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}

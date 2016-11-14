package com.alex.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Equipo {

@Id
@GeneratedValue
    private Long id;
    private String nombre;
    private String localidad;
    @JsonIgnore
    private LocalDate fechacreacion;

    public Equipo(String nombre, String localidad, LocalDate fechacreacion){
        this.nombre=nombre;
        this.localidad=localidad;
        this.fechacreacion=fechacreacion;
    }

    public Equipo(){

    }

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

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public LocalDate getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(LocalDate fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", fechacreacion=" + fechacreacion +
                '}';
    }
}

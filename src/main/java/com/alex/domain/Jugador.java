package com.alex.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Jugador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nombre;
    private LocalDate fechaNacimiento;
    private Integer canastas;
    private Integer asistencias;
    private Integer rebotes;
    private String posicion;
    @ManyToOne
    private Equipo equipo;

    public Jugador(String nombre, LocalDate fechaNacimiento, Integer canastas, Integer asistencias, Integer rebotes, String posicion){
        this.nombre=nombre;
        this.fechaNacimiento=fechaNacimiento;
        this.canastas=canastas;
        this.asistencias = asistencias;
        this.rebotes=rebotes;
        this.posicion=posicion;
    }

    public Jugador() {
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getcanastas() {
        return canastas;
    }

    public void setcanastas(Integer canastas) {
        this.canastas = canastas;
    }

    public Integer getasis() {
        return asistencias;
    }

    public void setasis(Integer asis) {
        this.asistencias = asis;
    }

    public Integer getrebotes() {
        return rebotes;
    }

    public void setrebotes(Integer rebotes) {
        this.rebotes = rebotes;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", canastas=" + canastas +
                ", asistencias=" + asistencias +
                ", rebotes=" + rebotes +
                ", posicion='" + posicion + '\'' +
                '}';
    }
}

package com.alex.Repository;


import com.alex.domain.Equipo;
import com.alex.domain.Jugador;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EquipoRepository extends JpaRepository<Equipo, Long>{


    List<Equipo> findByLocalidad(String Localidad);
    @Query ("SELECT jugador FROM Jugador jugador Equipo equipo WHERE equipo.id = jugador.equipo AND equipo.nombre = :equipoNombre")
    List<Jugador> findByJugadoresEquipoNombre(@Param("equipoNombre") String Nombre);
}

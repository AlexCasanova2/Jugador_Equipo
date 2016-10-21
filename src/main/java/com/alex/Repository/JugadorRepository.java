package com.alex.Repository;

import com.alex.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

public interface JugadorRepository extends JpaRepository<Jugador, Long>{

    List<Jugador> findByNombre(String nombre);
    List<Jugador> findByCanastasGreaterThanEqual(int canastas);
    List<Jugador> findByAsistenciasBetween(int asistencias, int asistencias2);
    List<Jugador> findByPosicion(String posicion);
    List<Jugador> findByFechaNacimientoBefore(LocalDate fechaNacimineto);

    @Query("SELECT AVG (jugador.canastas), AVG(jugador.asistencias), AVG(jugador.rebotes), jugador.posicion FROM Jugador jugador GROUP BY jugador.posicion")
    List<Object[]> findByMediaCanastasRebotesAsistenciasPosicion();

//    @Query("SELECT jugador.posicion, AVG(jugador.canastas), MAX(jugador.canastas), MIN(jugador.canastas)," +
//            " AVG(jugador.rebotes), MAX (jugador.rebotes), MIN(jugador.rebotes), AVG(jugador.asistencias)," +
//            " MAX(jugador.asistencias), MIN(jugador.asistencias) FROM Jugador jugador GROUP BY jugador.posicion")
//    List<Object[]> findByAvgMinMaxOfAllposicion();



}

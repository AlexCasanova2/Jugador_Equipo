package com.alex.Repository;

import com.alex.controller.DTO.EstadisticasPosicion;
import com.alex.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@SuppressWarnings("JpaQlInspection")
public interface JugadorRepository extends JpaRepository<Jugador, Long>{

    List<Jugador> findByNombre(String nombre);
    List<Jugador> findByCanastasGreaterThanEqual(int canastas);
    List<Jugador> findByAsistenciasBetween(int asistencias, int asistencias2);
    List<Jugador> findByPosicion(String posicion);
    List<Jugador> findByFechaNacimientoBefore(LocalDate fechaNacimineto);
    List<Jugador> findByAsistenciasGreaterThan(int asistencias);

    @Query("SELECT AVG (jugador.canastas), AVG(jugador.asistencias), AVG(jugador.rebotes), jugador.posicion FROM Jugador jugador GROUP BY jugador.posicion")
    List<Object[]> findByMediaCanastasRebotesAsistenciasPosicion();


  //@Query("SELECT jugador.posicion, AVG(jugador.canastas), MAX(jugador.canastas), MIN(jugador.canastas)," +
    //      " AVG(jugador.rebotes), MAX (jugador.rebotes), MIN(jugador.rebotes), AVG(jugador.asistencias)," +
      //     " MAX(jugador.asistencias), MIN(jugador.asistencias) FROM Jugador jugador GROUP BY jugador.posicion")
   //List<Object[]> findByAvgMinMaxOfAllposicion();

    @Query("SELECT jugador.posicion, AVG(jugador.canastas), AVG(jugador.asistencias),AVG(jugador.rebotes),MAX(jugador.canastas),MAX(jugador.asistencias),MAX(jugador.rebotes),MIN(jugador.canastas), MIN(jugor.rebotes),MIN(jugador.asistencias),FROM Jugador jugador " + "GROUP BY jugador.posicion")
    List<Object[]> AvgCanastasAndAvgAsistenciasAndAvgRebotesGroupbyPosicion2();




    List<Jugador> findByEquipoNombre(String nombre);
    List<Jugador> findByEquipoNombreAndPosicion(String nombre, String posicion);

    List<Jugador> findAllByOrderByCanastas();
    List<Jugador> findByCanastasGreaterThan(Integer puntos);
    List<Jugador> findByCanastasBetween(Integer min, Integer max);


    @Query("SELECT jugador.posicion, " +
            " MIN(jugador.canastas)," +
            " MAX(jugador.canastas), " +
            "AVG(jugador.canastas)" +
            "FROM Jugador jugador " +
            "GROUP BY jugador.posicion")
    List<Object[]> findByPosicionAndMedia();


}

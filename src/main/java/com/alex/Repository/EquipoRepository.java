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




    @Query ("SELECT (jugador) FROM Jugador jugador WHERE jugador.equipo.nombre = :equipoNombre order by jugador.canastas desc")
    List<Jugador> findByJugadorEquipoCanastas(@Param("equipoNombre")String Nombre);
}

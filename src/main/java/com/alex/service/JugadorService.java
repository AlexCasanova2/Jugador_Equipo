package com.alex.service;

import com.alex.Repository.EquipoRepository;
import com.alex.Repository.JugadorRepository;
import com.alex.domain.Equipo;
import com.alex.domain.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private EquipoRepository equipoRepository;

    public void testJugadores() {

        Jugador jugador1 = new Jugador("Alex Casanova", LocalDate.of(1995, 11, 15), 221, 454, 432, "Base");
        Jugador jugador2 = new Jugador("Pepito", LocalDate.of(1892, 5, 12), 25, 36, 76, "Pivot");
        Jugador jugador3 = new Jugador("Kristian", LocalDate.of(1973, 10, 28), 12, 13, 23, "Base");
        Jugador jugador4 = new Jugador("Ricard", LocalDate.of(1996,2,4),20,10,4, "Aleron");
        Jugador jugador5 = new Jugador("Alan", LocalDate.of(1998,4,7),13,7,9, "Pivot");
        Jugador jugador6 = new Jugador("Kobe", LocalDate.of(1978, 8,23),23,15,34,"Base");

        Equipo equipo1 = new Equipo("Bulls","Chicago",LocalDate.of(1966,10,2));
        equipoRepository.save(equipo1);
        jugador1.setEquipo(equipo1);
        jugador5.setEquipo(equipo1);
        jugadorRepository.save(jugador1);
        jugadorRepository.save(jugador5);

        Equipo equipo2 = new Equipo("Lakers","LA", LocalDate.of(1946,3,6));
        equipoRepository.save(equipo2);
        jugador2.setEquipo(equipo2);
        jugador6.setEquipo(equipo2);
        jugadorRepository.save(jugador2);
        jugadorRepository.save(jugador6);

        Equipo equipo3 = new Equipo("Cleveland Cavaliers","New York", LocalDate.of(1967,4,12));
        equipoRepository.save(equipo3);
        jugador4.setEquipo(equipo3);
        jugador3.setEquipo(equipo3);
        jugadorRepository.save(jugador4);
        jugadorRepository.save(jugador3);


        System.out.println("Buscar jugadores por nombre");
        System.out.println(jugadorRepository.findByNombre("Alex Casanova"));
        System.out.println("Mayores o iguales a canastas");
        System.out.println(jugadorRepository.findByCanastasGreaterThanEqual(200));
        System.out.println("Asistencias dentro del rango: 10-20");
        System.out.println(jugadorRepository.findByAsistenciasBetween(10,20));
        System.out.println("Posicion especifica");
        System.out.println(jugadorRepository.findByPosicion("Base"));
        System.out.println("Nacidos antes de la fecha señalada");
        System.out.println(jugadorRepository.findByFechaNacimientoBefore(LocalDate.of(2000, 2, 10)));

    }
}
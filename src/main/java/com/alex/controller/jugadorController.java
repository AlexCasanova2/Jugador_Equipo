package com.alex.controller;

import com.alex.Repository.JugadorRepository;
import com.alex.controller.DTO.EstadisticasPosicion;
import com.alex.domain.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/jugadores")
public class jugadorController {

    @Autowired
    private JugadorRepository jugadorRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Jugador crearJugador(@RequestBody Jugador jugador) {
        return jugadorRepository.save(jugador);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Jugador> findAll() {
        return jugadorRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Jugador findById(@PathVariable Long id) {
        Jugador jugador = jugadorRepository.findOne(id);
        return jugador;
    }

    @RequestMapping(value = "/byAsitencias{num}", method = RequestMethod.GET)
    public List<Jugador> findByAsistenciasGreaterThan(@PathVariable Integer num) {
        return jugadorRepository.findByAsistenciasGreaterThan(num);
    }


    @RequestMapping(method = RequestMethod.PUT)
    public Jugador updateJugador(@RequestBody Jugador jugador) {
        return jugador;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public Jugador deleteJugador(@RequestBody Jugador jugador) {
        return jugador;
    }


    @GetMapping("/orderByPoints")
    public List<Jugador> findAllOrderByCanasto() {
        return jugadorRepository.findAllByOrderByCanastas();
    }


    @GetMapping("/greaterThanPoints/{points}")
    public List<Jugador> findByPointsGreaterThan(@PathVariable Integer points) {
        return jugadorRepository.findByCanastasGreaterThan(points);
    }

    @GetMapping("/between/{points1}/{points2}")
    public List<Jugador> findByPointsBetween(@PathVariable Integer points1, Integer points2) {
        return jugadorRepository.findByCanastasBetween(points1, points2);
    }


    @GetMapping("/posicionAndMedia")
    public Map<String, EstadisticasPosicion> findByPosicionAndMedia() {

        List<Object[]> estadisticasPosiciones = jugadorRepository.findByPosicionAndMedia();

        Map<String, EstadisticasPosicion> estadisticasPosicionMap = new HashMap<>();

        estadisticasPosiciones.forEach(estadisticasPosicion -> {
            EstadisticasPosicion aux = new EstadisticasPosicion();
            aux.setPosicion((String) estadisticasPosicion[0]);
            aux.setMinCanastas((Integer) estadisticasPosicion[1]);
            aux.setMaxCanastas((Integer) estadisticasPosicion[2]);
            aux.setAvgCanastas((Double) estadisticasPosicion[3]);
            estadisticasPosicionMap.put(aux.getPosicion(), aux);

        });

        return estadisticasPosicionMap;
    }
}

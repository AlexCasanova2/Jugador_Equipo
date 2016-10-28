package com.alex.controller;

import com.alex.Repository.JugadorRepository;
import com.alex.domain.Jugador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class jugadorController{

    @Autowired
    private JugadorRepository jugadorRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Jugador crearJugador(@RequestBody Jugador jugador){
        return jugadorRepository.save(jugador);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Jugador> findAll(){
        return jugadorRepository.findByNombre("Alex");
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Jugador findById(@PathVariable Long id){
        Jugador jugador = jugadorRepository.findOne(id);
        return jugador;
    }

    @RequestMapping(value = "/byAsitencias{num}", method = RequestMethod.GET)
    public List<Jugador> findByAsistenciasGreaterThan(@PathVariable Integer num){
        return jugadorRepository.findByAsistenciasGreaterThan(num);
    }

}

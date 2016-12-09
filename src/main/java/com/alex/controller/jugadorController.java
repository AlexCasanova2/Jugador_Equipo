package com.alex.controller;

import com.alex.Repository.EquipoRepository;
import com.alex.Repository.JugadorRepository;
import com.alex.controller.DTO.EstadisticasPosicion;
import com.alex.domain.HeaderUtil;
import com.alex.domain.Jugador;
import com.alex.domain.Equipo;
import com.alex.domain.Posicion;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ListMultimap;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/jugadores")
public class jugadorController {

    @Autowired
    private JugadorRepository jugadorRepository;
    private EquipoRepository equipoRepository;

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Jugador> crearJugador(@RequestBody Jugador jugador) throws URISyntaxException {
        if(jugador.getId()!=null){
            return ResponseEntity.badRequest().headers(HeaderUtil.createFailureAlert("jugador","idexists","El jugador no puede tener esta ID")).body(null);
        }
        Jugador resultado= jugadorRepository.save(jugador);
       return ResponseEntity.created(new URI("/jugadores/" + resultado.getId()))
               .headers(HeaderUtil.createEntityCreationAlert("jugador",resultado.getId().toString()))
               .body(resultado);
    }



    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Jugador findById(@PathVariable Long id) {
        Jugador jugador = jugadorRepository.findOne(id);
        return jugador;
    }


//    @RequestMapping(value = "/{id}")
//    public responseEntity <Jugador>(PathVariable Long id) {
//        if(jugador!=null){
//            return
//        }
//
//    }

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


    @GetMapping("/byPosicionAllJugadores")
    public Map <Posicion,Collection<Jugador>>findByAllPosiciones(){
        List<Jugador> jugadores = jugadorRepository.findAll();
        ListMultimap<Posicion, Jugador> JugadorMultiMap = ArrayListMultimap.create();

        jugadores.forEach(jugador ->
        JugadorMultiMap.put(jugador.getPosicion(),jugador));

        return JugadorMultiMap.asMap();
    }


    @GetMapping("/byLocalidadAllEquipos")
    public Map<String,Collection<Equipo>>findByAllLocalidades(){
        List<Equipo> equipos = equipoRepository.findAll();
        ListMultimap<String, Equipo> EquipoMultiMap = ArrayListMultimap.create();

        equipos.forEach(equipo ->
        EquipoMultiMap.put(equipo.getLocalidad(),equipo));

        return EquipoMultiMap.asMap();

    }

    @GetMapping
    public List<Jugador> findAllOrderBy(
            @RequestParam(
                    name="orderBy", required=false) String orderBy,
            @RequestParam(
                    name="direccion", defaultValue = "ASC") String direccion
            ){

        if(orderBy!=null){
            Sort sort;
            if(direccion.equals("ASC")) {
                sort = new Sort(Sort.Direction.ASC,orderBy);
                //return jugadorRepository.findAll(new Sort(Sort.Direction.DESC, orderBy));
            }
            else{
                sort= new Sort(Sort.Direction.DESC,orderBy);
            }
            return jugadorRepository.findAll(sort);
        }
        return jugadorRepository.findAll();
    }

    @GetMapping("/GroupByPosition")
    public Map<Posicion, List<Jugador>> getJugadoresGroupByPosicion(){
               return jugadorRepository
                              .findAll()
                              .parallelStream()
                              .collect(Collectors.groupingBy(Jugador::getPosicion));
          }




}



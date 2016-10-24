package com.alex.service;

import com.alex.Repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipoService {
    @Autowired
    EquipoRepository equipoRepository;

    public void testEquipo(){

        System.out.println("Encontrar equipos por localidad");
        System.out.println(equipoRepository.findByLocalidad("LA"));


        System.out.println("Jugador con más canastas de un equipo determinado");
        System.out.println(equipoRepository.findByJugadorEquipoCanastas("Bulls"));
    }

}

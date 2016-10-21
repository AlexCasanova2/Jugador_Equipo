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
        System.out.println("23432");
        System.out.println(equipoRepository.findByJugadoresEquipoNombre("Lakers"));

    }

}

package com.example.apicinemarxjava.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Proyeccion {

    int id;
    Date fechaHora;
    String sala;
    double precioEntrada;
    boolean subtitulada;
    int peliculaId;

}

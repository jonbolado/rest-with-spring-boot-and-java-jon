package com.curso.erudio.rest_spring_aws.mapper;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class Mapper {

    public static ModelMapper mapper = new ModelMapper();

    public static <O, D> D parseObject(O origem, Class<D> destino) {
        return mapper.map(origem, destino);
    }

    public static <O, D> List<D> parseList(List<O> origem, Class<D> destino) {
        List<D> objetos = new ArrayList<>();

        for (O objeto : origem) {
            objetos.add(mapper.map(objeto, destino));
        }

        return objetos;
    }

}
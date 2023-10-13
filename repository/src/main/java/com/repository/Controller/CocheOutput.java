package com.repository.Controller;

import com.repository.Domain.Coche;
import com.repository.Exception.IsEmptyException;
import com.repository.Exception.NullException;


public class CocheOutput {
    private String matricula;
    private String marca;
    private String modelo;
    private int anyo;


    public CocheOutput(String matricula, String marca, String modelo, int anyo) throws NullException, IsEmptyException {
        if (matricula == null) throw new NullException("Matrícula no puede ser null");
        if (matricula.isEmpty()) throw new IsEmptyException("Matrícula no puede ser null");
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anyo = anyo;
    }

    public static CocheOutput getCoche(Coche coche) throws IsEmptyException, NullException {
        return new CocheOutput(coche.getMatricula(),coche.getMarca(),coche.getModelo(), coche.getAnyo());
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

}

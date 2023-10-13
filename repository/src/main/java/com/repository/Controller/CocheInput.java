package com.repository.Controller;

import com.repository.Domain.Coche;
import com.repository.Exception.IsEmptyException;
import com.repository.Exception.NullException;

public class CocheInput {
    private String matricula;
    private String modelo;


    public CocheInput(String matricula, String modelo) throws IsEmptyException, NullException {
        if (matricula == null) throw new NullException("Matrícula no puede ser null");
        if (matricula.isEmpty()) throw new IsEmptyException("Matrícula no puede ser null");
        this.matricula = matricula;
        if (modelo == null) throw new NullException("Modelo no puede ser null");
        if (modelo.isEmpty()) throw new IsEmptyException("Modelo no puede ser null");
        this.modelo = modelo;
    }

    public static Coche getCoche (CocheInput c) throws IsEmptyException, NullException {
        return new Coche(c.getMatricula(), "marca" ,c.getModelo(), 1900);
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

}

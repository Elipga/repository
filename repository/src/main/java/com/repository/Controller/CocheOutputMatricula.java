package com.repository.Controller;

import com.repository.Exception.IsEmptyException;
import com.repository.Exception.NullException;

public class CocheOutputMatricula {
    private String matricula;

    public CocheOutputMatricula(String matricula) throws NullException, IsEmptyException {
        if (matricula == null) throw new NullException("Matrícula no puede ser null");
        if (matricula.isEmpty()) throw new IsEmptyException("Matrícula no puede ser null");
        this.matricula = matricula;
    }
    public String getMatricula() {
        return matricula;
    }
}

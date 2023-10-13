package com.repository.Domain;

import com.repository.Exception.IsEmptyException;
import com.repository.Exception.NullException;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Coche {

    @Id
    private String matricula;
    private String marca;

    private String modelo;

    private int anyo;

    public Coche(String matricula) throws NullException, IsEmptyException {
        if (matricula == null) throw new NullException("Matrícula no puede ser null");
        if (matricula.isEmpty()) throw new IsEmptyException("Matrícula no puede ser null");
        this.matricula = matricula;
    }

    public Coche(String matricula, String marca, String modelo, int anyo) throws IsEmptyException, NullException {
        if (matricula == null) throw new NullException("Matrícula no puede ser null");
        if (matricula.isEmpty()) throw new IsEmptyException("Matrícula no puede ser null");
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anyo = anyo;
    }

    public Coche() throws IsEmptyException, NullException {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.anyo = anyo;
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

    public int getAnyo() {
        return anyo;
    }

}

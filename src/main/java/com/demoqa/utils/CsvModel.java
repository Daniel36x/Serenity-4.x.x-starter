package com.demoqa.utils;

import com.demoqa.utils.builders.BuilderCsv;

public class CsvModel {

    private String nombre;
    private String apellido;
    private String email;
    private String edad;
    private String salario;
    private String departamento;

    public CsvModel(BuilderCsv builder) {
        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.email = builder.email;
        this.edad = builder.edad;
        this.salario= builder.salario;
        this.departamento= builder.departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public String getEdad() {
        return edad;
    }

    public String getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    @Override
    public String toString() {
        return "CsvModel{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", edad='" + edad + '\'' +
                ", salario='" + salario + '\'' +
                ", departamento='" + departamento + '\'' +
                '}';
    }
}

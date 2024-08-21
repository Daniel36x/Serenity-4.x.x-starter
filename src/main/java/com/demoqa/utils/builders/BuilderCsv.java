package com.demoqa.utils.builders;

import com.demoqa.utils.CsvModel;

import java.util.Map;

public class BuilderCsv{

    public String nombre;
    public String apellido;
    public String email;
    public String edad;
    public String salario;
    public String departamento;

    public BuilderCsv(Map<String, String> usuario) {
        this.nombre = usuario.get("Nombre");
        this.apellido = usuario.get("Apellido");
        this.email = usuario.get("Email");
        this.edad = usuario.get("Edad");
        this.salario = usuario.get("Salario");
        this.departamento = usuario.get("Departamento");
    }

    public CsvModel build(){
        CsvModel user = new CsvModel(this);
        return user;
    }
}

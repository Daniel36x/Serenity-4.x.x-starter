package com.demoqa.utils;

import com.demoqa.utils.builders.BuilderCsv;

import java.util.Map;

public class BuilderCsvWebTable {

    private String nombre;
    private String apellido;
    private String email;
    private String edad;
    private String salario;
    private String departamento;


    public BuilderCsvWebTable(UserBuilder builder) {

        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.email = builder.email;
        this.edad = builder.edad;
        this.salario= builder.salario;
        this.departamento= builder.departamento;

    }

    public String getEmail() {
        return email;
    }

    public String getSalario() {
        return salario;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "BuilderCsvWebTable{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", email='" + email + '\'' +
                ", edad='" + edad + '\'' +
                ", salario='" + salario + '\'' +
                ", departamento='" + departamento + '\'' +
                '}';
    }

    public static class UserBuilder{

        private String nombre;
        private String apellido;
        private String email;
        private String edad;
        private String salario;
        private String departamento;


        public UserBuilder(Map<String, String> usuario) {
            this.nombre = usuario.get("Nombre");
            this.apellido = usuario.get("Apellido");
            this.email = usuario.get("Email");
            this.edad = usuario.get("Edad");
            this.salario = usuario.get("Salario");
            this.departamento = usuario.get("Departamento");

        }
        public BuilderCsvWebTable build(){
            BuilderCsvWebTable user = new BuilderCsvWebTable(this);
            return user;
        }
    }
}

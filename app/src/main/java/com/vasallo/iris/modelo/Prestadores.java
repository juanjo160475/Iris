package com.vasallo.iris.modelo;

public class Prestadores {

    private String especialidad,centroSalud,emai,telefono;

    public Prestadores(String especialidad, String centroSalud, String emai, String telefono) {
        this.especialidad = especialidad;
        this.centroSalud = centroSalud;
        this.emai = emai;
        this.telefono = telefono;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getCentroSalud() {
        return centroSalud;
    }

    public String getEmai() {
        return emai;
    }

    public String getTelefono() {
        return telefono;
    }
}

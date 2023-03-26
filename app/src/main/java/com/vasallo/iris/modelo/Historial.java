package com.vasallo.iris.modelo;

public class Historial {

    private String fecha, diagnostico;

    public Historial(String fecha, String diagnostico) {
        this.fecha = fecha;
        this.diagnostico = diagnostico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}

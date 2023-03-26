package com.vasallo.iris.modelo;

public class Recomendaciones {
    private String contacto,telefono,diagnostico,recomendacion;
    private int doc;

    public Recomendaciones(String diagnostico, String recomendacion,String contacto, String telefono,int doc) {
        this.contacto = contacto;
        this.telefono = telefono;
        this.diagnostico=diagnostico;
        this.recomendacion=recomendacion;
        this.doc=doc;
    }

    public int getDoc() {
        return doc;
    }

    public void setDoc(int doc) {
        this.doc = doc;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getRecomendacion() {
        return recomendacion;
    }

    public void setRecomendacion(String recomendacion) {
        this.recomendacion = recomendacion;
    }
}

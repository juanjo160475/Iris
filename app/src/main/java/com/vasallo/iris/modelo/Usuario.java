package com.vasallo.iris.modelo;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import org.jetbrains.annotations.NotNull;

@Entity
public class Usuario {
    @PrimaryKey
    @NotNull
    private String id ;
    @ColumnInfo(name = "nombre")
    private String nombre;
    @ColumnInfo (name="apellido")
    private String apellido;
    @ColumnInfo (name="correo")
    private String correo;
    @ColumnInfo(name="telefono")
    private String telefono;
    @ColumnInfo(name="foto")
    private String fotoUbicacion="";
    @ColumnInfo(name="sexo")
    private  String sexo="No Definido";
    @ColumnInfo(name="pass")
    private String pass ;

    public Usuario() {
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getFotoUbicacion() {
        return fotoUbicacion;
    }

    public void setFotoUbicacion(String fotoUbicacion) {
        this.fotoUbicacion = fotoUbicacion;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
}

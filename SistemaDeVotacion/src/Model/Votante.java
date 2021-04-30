/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author megabit
 */
public class Votante extends Persona{
    private Domicilio addres;
    private Integer noEstado;
    private Integer noMunicipio;
    private Integer seccion;
    private Integer localidad;
    private Boolean voto;

    public Votante(Domicilio addres, Integer noEstado, Integer noMunicipio, Integer seccion, Integer localidad, String nombre, String apellidoPaterno, String apellidoMaterno, String curp) {
        super(nombre, apellidoPaterno, apellidoMaterno, curp);
        this.addres = addres;
        this.noEstado = noEstado;
        this.noMunicipio = noMunicipio;
        this.seccion = seccion;
        this.localidad = localidad;
    }

    public Domicilio getAddres() {
        return addres;
    }

    public void setAddres(Domicilio addres) {
        this.addres = addres;
    }

    public Integer getNoEstado() {
        return noEstado;
    }

    public void setNoEstado(Integer noEstado) {
        this.noEstado = noEstado;
    }

    public Integer getNoMunicipio() {
        return noMunicipio;
    }

    public void setNoMunicipio(Integer noMunicipio) {
        this.noMunicipio = noMunicipio;
    }

    public Integer getSeccion() {
        return seccion;
    }

    public void setSeccion(Integer seccion) {
        this.seccion = seccion;
    }

    public Integer getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Integer localidad) {
        this.localidad = localidad;
    }
    
    public void checarVoto(){
        
    }
    
    public Boolean getVoto() {
        return voto;
    }

    public void setVoto(Boolean voto) {
        this.voto = voto;
    }           
}

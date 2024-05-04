/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;

import java.time.LocalTime;
import desafio.utilities;




/**
 *
 * @author Jorge LG
 */
public class CD extends Material {
    private String artist;
    private String genero;
    private LocalTime duracion;
    private int canciones;
    private int unidades;

    public CD(String artist, String genero, LocalTime duracion, int canciones, int unidades, String L2, String tipo, String id, String titulo) {
        super(L2, tipo, id, titulo);
        this.artist = artist;
        this.genero = genero;
        this.duracion = duracion;
        this.canciones = canciones;
        this.unidades = unidades;
    }


    public String getArtist() {
        return artist;
    }

    public String getGenero() {
        return genero;
    }

    public LocalTime getDuracion() {
        return duracion;
    }

    public int getCanciones() {
        return canciones;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public void setCanciones(int canciones) {
        this.canciones = canciones;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
}

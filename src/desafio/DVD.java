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
public class DVD extends Material{
    private String director;
    private LocalTime duracion;
    private String genero;
    private int unidades;

    public DVD(String director, LocalTime duracion, String genero, int unidades, String L2, String tipo, String id, String titulo) {
        super(L2, tipo, id, titulo);
        this.director = director;
        this.duracion = duracion;
        this.genero = genero;
        this.unidades = unidades;
    }

    

    public String getDirector() {
        return director;
    }

    public LocalTime getDuracion() {
        return duracion;
    }
    public int getUnidades() {
        return unidades;
    }


    public String getGenero() {
        return genero;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setDuracion(LocalTime duracion) {
        this.duracion = duracion;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
     
    
}

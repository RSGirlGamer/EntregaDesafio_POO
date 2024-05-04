/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;

import java.util.Date;
import desafio.utilities;


/**
 *
 * @author Jorge LG
 */
public class Revista extends Material{
    private String editorial;
    private String period;
    private Date date;
    private int unidades;

    public Revista(String editorial, String period, Date date, int unidades, String L2, String tipo, String id, String titulo) {
        super(L2, tipo, id, titulo);
        this.editorial = editorial;
        this.period = period;
        this.date = date;
        this.unidades = unidades;
    }


    public String getEditorial() {
        return editorial;
    }

    public String getPeriod() {
        return period;
    }

    public Date getDate() {
        return date;
    }

    public int getUnidades() {
        return unidades;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }
    
    
    
}

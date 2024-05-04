/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;

/**
 *
 * @author Jorge LG
 */
public class Libro extends Material{
        private String autor;
        private int pags;
        private String editorial;
        private String ISBN;
        private int year;
        private int unidades;

    public Libro(String autor, int pags, String editorial, String ISBN, int year, int unidades, String L2, String tipo, String id, String titulo) {
        super(L2, tipo, id, titulo);
        this.autor = autor;
        this.pags = pags;
        this.editorial = editorial;
        this.ISBN = ISBN;
        this.year = year;
        this.unidades = unidades;
    }

      public void setAutor(String autor) {
            this.autor = autor;
        }

        public void setPags(int pags) {
            this.pags = pags;
        }

        public void setEditorial(String editorial) {
            this.editorial = editorial;
        }

        public void setISBN(String ISBN) {
            this.ISBN = ISBN;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public void setUnidades(int unidades) {
            this.unidades = unidades;
        }

        public String getAutor() {
            return autor;
        }

        public int getPags() {
            return pags;
        }

        public String getEditorial() {
            return editorial;
        }

        public String getISBN() {
            return ISBN;
        }

        public int getYear() {
            return year;
        }

        public int getUnidades() {
            return unidades;
        }
    
}

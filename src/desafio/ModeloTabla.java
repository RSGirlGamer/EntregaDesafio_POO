/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;
import java.util.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import desafio.Material;
import java.awt.*;

/**
 *
 * @author Jorge LG
 */
public class ModeloTabla {
    public static class myTable extends AbstractTableModel {
        private ArrayList<Material> list;
        private String [] columnNames = {"Categoria","Tipo", "ID","Titulo"};

        public myTable(ArrayList<Material> list) {
            this.list = list;
        }
    
        public int getRowCount(){
            return list.size();
        }
        public int getColumnCount (){
            return columnNames.length;
        }
        
        public Object getValueAt(int rowIndex, int colIndex){
            Material material = list.get(rowIndex);
            switch (colIndex) {
                case 0:
                    return material.getL2();
                case 1: 
                    return material.getTipo();
                case 2: 
                    return material.getId();
                case 3:
                    return material.getTitulo();
                
                default:
                    return null;
            }
        }
        public String getColumnName(int column){
            return columnNames[column];
        }
    } 
}


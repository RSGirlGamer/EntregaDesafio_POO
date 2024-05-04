/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;

import javax.swing.JFrame;
import javax.swing.JTable;
import desafio.ModeloTabla;
import desafio.ModeloTabla.myTable;
import java.util.ArrayList;
import desafio.Material;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;

/**
 *
 * @author Jorge LG
 */
public class MiTabla extends JFrame {
    
    private JTable tabla;
    private ModeloTabla.myTable myTable;
    
    
    public MiTabla(ArrayList<Material> list){
        setTitle("Materiales Disponibles");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(500,600);
        
        myTable = new ModeloTabla.myTable(list);
        tabla = new JTable(myTable);

        
        JScrollPane scrollPane = new JScrollPane(tabla);
        getContentPane().add(scrollPane,BorderLayout.CENTER);        
    }
}
    

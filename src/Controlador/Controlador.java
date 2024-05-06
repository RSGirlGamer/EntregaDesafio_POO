/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import desafio.AgregarMateriales;
import desafio.Material;
import desafio.bd_Connection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import vista.Materiales_Vista;

/**
 *
 * @author Jorge LG
 */
public class Controlador implements ActionListener{
    ArrayList<Material> materiales =new ArrayList<>();
    Materiales_Vista vista = new Materiales_Vista();
    DefaultTableModel modelo = new DefaultTableModel();
    AgregarMateriales registro = new AgregarMateriales();
    bd_Connection materialesBD = new bd_Connection();
        
    public Controlador(Materiales_Vista v) {
        this.vista = v;
        Materiales_Vista.btnMostrar.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==vista.btnMostar) {
            try {
                mostrar(vista.tblDatos);
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
    
    public void mostrar(JTable tabla) throws SQLException{
        modelo = (DefaultTableModel)tabla.getModel();
        materiales = registro.fromBD(materialesBD);
        for(Material material:materiales){
            Object[] fila = {material.getId(),material.getL2(),material.getTipo(),material.getTitulo()};
            modelo.addRow(fila);
            
        }
        vista.tblDatos.setModel(modelo);
    }
            
    
}

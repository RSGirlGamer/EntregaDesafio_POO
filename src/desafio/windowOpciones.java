/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JButton;

/**
 *
 * @author Jorge LG
 */
public class windowOpciones extends JDialog {
    private int selection;
    public windowOpciones(){
        super();
        setTitle("Seleccione una opción");
        setSize(300,200);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        JButton btnAgregar = new JButton("Agregar Material");
        JButton btnModificar = new JButton("Modificar Material");
        JButton btnLista = new JButton("Lista de Materiales disponibles");
        JButton btnBorrar = new JButton("Borrar Material");
        JButton btnBuscar = new JButton("Buscar Material");
        JButton btnSalir = new JButton("Salir");
        
        btnAgregar.addActionListener(e -> {selection = 1; dispose();});
        btnModificar.addActionListener(e -> {selection = 2; dispose();});
        btnLista.addActionListener(e -> {selection = 3; dispose();});
        btnBorrar.addActionListener(e -> {selection = 4; dispose();});
        btnBuscar.addActionListener(e -> {selection = 5; dispose();});
        btnSalir.addActionListener(e -> {selection = 6; dispose();});
        
        panel.add(btnAgregar);
        panel.add(btnModificar);
        panel.add(btnLista);
        panel.add(btnBorrar);
        panel.add(btnBuscar);
        panel.add(btnSalir);
        
        add(panel);
        setModal(false);
        
    }
    
       public int getOpcionSeleccionada() {
        return selection;
    }
    
}

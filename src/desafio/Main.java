/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;
import javax.swing.JOptionPane;
import desafio.AgregarMateriales;
import desafio.MiTabla.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import desafio.MiTabla;
import desafio.ModeloTabla;
import desafio.bd_Connection;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;

/**
 *
 * @author Jorge LG
 */
public class Main {
    private static int option;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        bd_Connection materialesBD = new bd_Connection();
        materialesBD.getConnection();
        
        
        AgregarMateriales registro = new AgregarMateriales();
        MiTabla frame = new MiTabla(new ArrayList<>());
        ArrayList<Material> materiales =new ArrayList<>();
        /*windowOpciones ventana = new windowOpciones();*/
        do {
            
           /* ventana.setVisible(true);
            
            ventana.addWindowListener(new WindowAdapter (){
                public void closed(WindowEvent e){
                    option = ventana.getOpcionSeleccionada();
                    System.out.println("Opción seleccionada: " + option);
                }
            });*/
                    
                   option = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción:\n" +
                    "1. Agregar Material\n" +
                    "2. Modificar Material\n" +
                    "3. Lista de Materiales disponibles\n" +
                    "4. Borrar Material\n" +
                    "5. Buscar Material\n"+
                    "6. Salir\n"));
            switch (option){
                    case 1 :
                        frame.setVisible(false);
                        
                        int material;
                        do {        
                        material = Integer.parseInt(JOptionPane.showInputDialog("Seleccione una opción:\n" +
                    "1. Agregar libro\n" +
                    "2. Agregar revista\n" +
                    "3. Agregar CD\n" +
                    "4. Agregar DVD\n" +
                    "5. Regresar al menu anterior\n"));
                        
                            if (material<5) {
                                registro.registroMateriales(material);
                            } 
                        } while(material !=5);   
                                                  
                        break;
                    case 2:
//                        frame.setVisible(false);
//                        Modificar material
                        String consulta = "SELECT * FROM materiales";
                        ResultSet resultados = materialesBD.createQuery(consulta);
                        try {
                            while (resultados.next()) {
                                String  idMateriales = resultados.getString("idMateriales");
                                String  L2 = resultados.getString("L2");
                                String  Tipo = resultados.getString("Tipo");
                                String  Titulo = resultados.getString("Titulo");
                                System.out.println("ID Material: "+idMateriales+" L2: "+L2+" Tipo: "+Tipo+" Titulo: "+Titulo);
                            }
                            
                        }catch(SQLException e){
                            JOptionPane.showMessageDialog(null, "Error al procesar los resultados: "+ e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                        }
                        finally{
                                    try{
                                    if (resultados!= null) {
                                    resultados.close();
                                    }if (materialesBD.getConnection()!=null) {
                                    materialesBD.getConnection().close();
                                    }
                                    }catch(SQLException e){
                                    JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                                    }
                                    }
                        break;
                    case 3:
                        if(frame.isVisible()){
                            frame.setVisible(false);                            
                        }
                        materiales = registro.fromBD(materialesBD);
                            frame = new MiTabla(materiales);
                            frame.setVisible(true);
                        break;
                    case 4:
//                        Borrar Material
                        String idMaterial;
                        boolean encontrado ;
                        if(frame.isVisible()){
                            frame.setVisible(false);                            
                        }
                                                
                        do {
                            materiales = registro.fromBD(materialesBD);
                            encontrado = false;
                            idMaterial = JOptionPane.showInputDialog("Ingrese el ID del material a eliminar");
                            for(Material mtrl: materiales){
                                if (mtrl.getId().equals(idMaterial)) {
                                    encontrado = true;
                                    break;
                                }   
                        }
                            if (!encontrado) {
                                JOptionPane.showMessageDialog(null, "El ID ingresado no existe. Intente nuevamente.","Not Found",JOptionPane.WARNING_MESSAGE);     
                            }
                            
                        } while (!encontrado);
                        registro.deleteDato(idMaterial);
                        break;
                    case 5:
//                        Buscar Material
                        break;
                    case 6:
                        if (frame.isVisible()) {
                            frame.dispose();
                        }
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida, seleccione nuevamente.","Advertencia",JOptionPane.WARNING_MESSAGE);
                        break;                     
            }
                        
                        
        } while (option != 6);
        
    }
    
}

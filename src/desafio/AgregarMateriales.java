/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;

import java.util.*;
import desafio.AgregarMateriales;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.ZoneOffset;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge LG
 */
public class AgregarMateriales {
    ArrayList <Material> listaMaterial = new ArrayList<>();
    public void registroMateriales(int tipo){
        String titulo = JOptionPane.showInputDialog("Ingrese el título del material a registrar");
        String id = JOptionPane.showInputDialog("Ingrese el id");
        String hierarchy, L2;
        
        switch (tipo) {
            case 1:
                hierarchy = "Libro";
                L2="MaterialEscrito";
                String autor = JOptionPane.showInputDialog("Ingrese el autor");
                String editorialL = JOptionPane.showInputDialog("Ingrese el editorial");
                String ISBN = JOptionPane.showInputDialog("Ingrese el ISBN");
                String yearString = JOptionPane.showInputDialog("Ingrese el año");
                while(yearString.isEmpty()|| !isNumeric(yearString)) {
                    JOptionPane optionPane = new JOptionPane("Año no válido", JOptionPane.ERROR_MESSAGE);    
                    JDialog dialog = optionPane.createDialog("Failure");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                    yearString = JOptionPane.showInputDialog("Ingrese el año");
                }
                int year = Integer.parseInt(yearString);
                String unidadesString = JOptionPane.showInputDialog("Ingrese el numero de unidades");
                while(unidadesString.isEmpty()|| !isNumeric(unidadesString)) {
                    JOptionPane optionPane = new JOptionPane("Unidad no válida", JOptionPane.ERROR_MESSAGE);    
                    JDialog dialog = optionPane.createDialog("Failure");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                    unidadesString = JOptionPane.showInputDialog("Ingrese el numero de unidades");
                }
                int unidades = Integer.parseInt(unidadesString);
                String pagsString = JOptionPane.showInputDialog("Ingrese el numero de páginas del libro");
                while(pagsString.isEmpty()|| !isNumeric(pagsString)) {
                    JOptionPane optionPane = new JOptionPane("Número de páginas no válida", JOptionPane.ERROR_MESSAGE);    
                    JDialog dialog = optionPane.createDialog("Failure");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                    pagsString = JOptionPane.showInputDialog("Ingrese el numero de páginas del libro");
                }
                int pags = Integer.parseInt(pagsString);
                id = "LIB" + id;
                insertToLibros(id,L2, autor,editorialL, ISBN, pags,  year, unidades,hierarchy, titulo);
                //listaMaterial.add(new Libro(autor,pags, editorialL,ISBN, year, unidades, L2, hierarchy, id, titulo ));
                break;
            case 2:
                hierarchy = "Revista";
                L2="MaterialEscrito";
                String editorialR = JOptionPane.showInputDialog("Ingrese el editorial");               
                String period = JOptionPane.showInputDialog("Ingrese cada cuanto tiempo se publica");
                String dateSTR = JOptionPane.showInputDialog("Ingrese la fecha de publicación. Formato dd-mm-yyyy");                 
                Date date = utilities.parseDate(dateSTR);
                while(date == null) {
                    dateSTR = JOptionPane.showInputDialog("Ingrese la fecha de publicación. Formato dd-mm-yyyy");                 
                    date = utilities.parseDate(dateSTR);
                }
                String unitsString = JOptionPane.showInputDialog("Ingrese el numero de unidades");
                while(unitsString.isEmpty()|| !isNumeric(unitsString)) {
                    JOptionPane optionPane = new JOptionPane("Número de páginas no válida", JOptionPane.ERROR_MESSAGE);    
                    JDialog dialog = optionPane.createDialog("Failure");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                    unitsString = JOptionPane.showInputDialog("Ingrese el numero de unidades");
                }
                int units = Integer.parseInt(unitsString);
                id = "REV" + id;
                insertToRevistas(id,L2, editorialR,period, date, units,hierarchy,titulo);
                //listaMaterial.add(new Revista(editorialR, period, date,units,L2,hierarchy,id,titulo));
                break;
            case 3:
                hierarchy = "CD";
                L2="MaterialAudiovisual"; 
                String artist = JOptionPane.showInputDialog("Ingrese el artista");  
                String genero = JOptionPane.showInputDialog("Ingrese el genero");  
                String duracionStr = JOptionPane.showInputDialog("Ingrese la duracion. Formato HH:mm:ss");                 
                LocalTime duracion = utilities.parseDuracion(duracionStr);
                while(duracion == null) {
                    duracionStr = JOptionPane.showInputDialog("Ingrese la duracion. Formato HH:mm:ss");                 
                    duracion = utilities.parseDuracion(duracionStr);
                }
                String cancionesString = JOptionPane.showInputDialog("Ingrese el numero de canciones del disco");
                while(cancionesString.isEmpty()|| !isNumeric(cancionesString)) {
                    JOptionPane optionPane = new JOptionPane("Numero de canciones no válida", JOptionPane.ERROR_MESSAGE);    
                    JDialog dialog = optionPane.createDialog("Failure");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                    cancionesString = JOptionPane.showInputDialog("Ingrese el numero de canciones del disco");
                }
                int canciones = Integer.parseInt(cancionesString);
                String unidadesCString = JOptionPane.showInputDialog("Ingrese el numero de unidades");
                while(unidadesCString.isEmpty()|| !isNumeric(unidadesCString)) {
                    JOptionPane optionPane = new JOptionPane("Unidad no válida", JOptionPane.ERROR_MESSAGE);    
                    JDialog dialog = optionPane.createDialog("Failure");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                    unidadesCString = JOptionPane.showInputDialog("Ingrese el numero de unidades");
                }
                int unidadesC = Integer.parseInt(unidadesCString);
                id = "CDA" + id;
                insertToCds(id,L2,artist,genero,duracion,canciones,unidadesC,hierarchy,titulo);
               // listaMaterial.add(new CD(artist, genero, duracion, canciones, unidadesC, L2, hierarchy, id, titulo));
                
                break;
            case 4:
                hierarchy = "DVD";
                L2="MaterialAudiovisual"; 
                String director = JOptionPane.showInputDialog("Ingrese el director");
                String duracionStrD = JOptionPane.showInputDialog("Ingrese la duracion. Formato HH:mm:ss");                 
                LocalTime duracionD = utilities.parseDuracion(duracionStrD);
                while(duracionD == null) {
                    duracionStrD = JOptionPane.showInputDialog("Ingrese la duracion. Formato HH:mm:ss");                 
                    duracionD = utilities.parseDuracion(duracionStrD);
                }
                String generoD= JOptionPane.showInputDialog("Ingrese el genero");    
                String unidadesD = JOptionPane.showInputDialog("Ingrese el numero de unidades");
                while(unidadesD.isEmpty()|| !isNumeric(unidadesD)) {
                    JOptionPane optionPane = new JOptionPane("Unidad no válida", JOptionPane.ERROR_MESSAGE);    
                    JDialog dialog = optionPane.createDialog("Failure");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                    unidadesD = JOptionPane.showInputDialog("Ingrese el numero de unidades");
                }
                int unidadesDVD = Integer.parseInt(unidadesD);
                id = "DVD" + id;
                insertToDvds(id,L2,director,duracionD,generoD,unidadesDVD, hierarchy, titulo);
                //listaMaterial.add(new DVD(director, duracionD, generoD,unidadesDVD, L2, hierarchy, id, titulo));
                break;
            default:
               break;
        }     
    }
    
    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    public void getLibros(bd_Connection materialesBD){
       String consultaLIB = "SELECT * FROM libros";
       String tituloConsulta =""; 
       String b="Libro";
       String titulo=""; 
       ResultSet resultados = materialesBD.createQuery(consultaLIB);
        try {
             

             while (resultados.next()) {
                String  idLibros = resultados.getString("idLibros"); 
                tituloConsulta ="SELECT Titulo FROM materiales WHERE idMateriales=?";  
                try (PreparedStatement stmt = materialesBD.getConnection().prepareStatement(tituloConsulta)) {
                stmt.setString(1,idLibros); 
                ResultSet resAll = stmt.executeQuery();
                    if (resAll.next()) {
                        titulo = resAll.getString("Titulo");
                    }
                String  L2 = resultados.getString("L2");
                String  autor = resultados.getString("autor");
                int  num_pags = Integer.parseInt(resultados.getString("num_pags"));
                String  editorial = resultados.getString("editorial");
                String  ISBN = resultados.getString("ISBN");
                int  anio_publicacion = Integer.parseInt(resultados.getString("anio_publicacion")); 
                int  unidades_disp = Integer.parseInt(resultados.getString("unidades_disp")); 
                listaMaterial.add(new Libro(autor,num_pags, editorial,ISBN, anio_publicacion, unidades_disp, L2, b, idLibros, titulo));    
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al procesar los resultados: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error al convertir un número: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
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
    }
    
    public void getRevistas(bd_Connection materialesBD){
       String consultaREV = "SELECT * FROM revistas";
       String tituloConsulta =""; 
       String r="Revista";
       String titulo=""; 
       ResultSet resultados = materialesBD.createQuery(consultaREV);
        try {
                while (resultados.next()) {
                String  idRevistas = resultados.getString("idRevistas"); 
                tituloConsulta ="SELECT Titulo FROM materiales WHERE idMateriales=?";  
                try (PreparedStatement stmt = materialesBD.getConnection().prepareStatement(tituloConsulta)) {
                stmt.setString(1,idRevistas); 
                ResultSet resAll = stmt.executeQuery();
                    if (resAll.next()) {
                        titulo = resAll.getString("Titulo");
                    }
                String  L2 = resultados.getString("L2");
                String  editorial = resultados.getString("editorial");
                int  unidades = Integer.parseInt(resultados.getString("unidades"));
                String  peridocidad = resultados.getString("peridocidad");
                Date fecha_publicacion = resultados.getDate("fecha_publicacion");
                listaMaterial.add(new Revista(editorial, peridocidad, fecha_publicacion,unidades,L2,r,idRevistas,titulo)); 
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al procesar los resultados: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error al convertir un número: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
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
    }
    public void getCD(bd_Connection materialesBD){
       String consultaCD = "SELECT * FROM cds";
       String tituloConsulta =""; 
       String c="CD";
       String titulo=""; 
       ResultSet resultados = materialesBD.createQuery(consultaCD);
        try {
                while (resultados.next()) {
                String  idCd = resultados.getString("idCd"); 
                tituloConsulta ="SELECT Titulo FROM materiales WHERE idMateriales=?";  
                try (PreparedStatement stmt = materialesBD.getConnection().prepareStatement(tituloConsulta)) {
                stmt.setString(1,idCd); 
                ResultSet resAll = stmt.executeQuery();
                    if (resAll.next()) {
                        titulo = resAll.getString("Titulo");
                    }
                String  L2 = resultados.getString("L2");
                String  artista = resultados.getString("artista");
                int  num_canciones = Integer.parseInt(resultados.getString("num_canciones"));
                String  genero = resultados.getString("genero");
                Time duracionSQL = resultados.getTime("duracion");
                Date utilDate = new Date(duracionSQL.getTime());
                LocalTime duracion = utilDate.toInstant().atOffset(ZoneOffset.UTC).toLocalTime();
                int unidades = resultados.getInt("unidades");
                listaMaterial.add(new CD(artista, genero, duracion, num_canciones, unidades, L2, c, idCd, titulo));
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al procesar los resultados: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error al convertir un número: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
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
    }
        public void getDVD(bd_Connection materialesBD){
       String consultaDVD = "SELECT * FROM dvds";
       String tituloConsulta =""; 
       String d="DVD";
       String titulo=""; 
       ResultSet resultados = materialesBD.createQuery(consultaDVD);
        try {
                while (resultados.next()) {
                String  idDvd = resultados.getString("idDvd"); 
                tituloConsulta ="SELECT Titulo FROM materiales WHERE idMateriales=?";  
                try (PreparedStatement stmt = materialesBD.getConnection().prepareStatement(tituloConsulta)) {
                stmt.setString(1,idDvd); 
                ResultSet resAll = stmt.executeQuery();
                    if (resAll.next()) {
                        titulo = resAll.getString("Titulo");
                    }
                String  L2 = resultados.getString("L2");
                String  director = resultados.getString("director");
                String  genero = resultados.getString("genero");
                Time duracionSQL = resultados.getTime("duracion");
                Date utilDate = new Date(duracionSQL.getTime());
                LocalTime duracion = utilDate.toInstant().atOffset(ZoneOffset.UTC).toLocalTime();
                int unidades_disp = resultados.getInt("unidades_disp");
                listaMaterial.add(new DVD(director, duracion, genero,unidades_disp, L2, d, idDvd, titulo));
            }catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al procesar los resultados: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Error al convertir un número: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
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
    }
    public ArrayList<Material> fromBD(bd_Connection materialesBD){
//        String consulta = "SELECT * FROM materiales";
        listaMaterial.clear();
        getLibros(materialesBD);
        getRevistas(materialesBD);
        getCD(materialesBD);
        getDVD(materialesBD);
        
        return listaMaterial;
    }
    
    public ArrayList<Material> getLista(){
        return listaMaterial;
    }
    
    public void insertToCds(String id,String L2, String artista, String genero,LocalTime duracion, int canciones,int unidades, String tipo, String titulo){
        bd_Connection materialesBD = new bd_Connection();
        PreparedStatement pStm = null;
        PreparedStatement pStmM = null;
        
        try{
            pStm = materialesBD.getConnection().prepareStatement("INSERT INTO cds VALUES (?,?,?,?,?,?,?)");
            pStmM = materialesBD.getConnection().prepareStatement("INSERT INTO materiales VALUES (?,?,?,?)");
            //CD(artist, genero, duracion, canciones, unidadesC, L2, hierarchy, id, titulo))
            //tabla material
            pStmM.setString(1, id);
            pStmM.setString(2, L2);
            pStmM.setString(3, tipo);
            pStmM.setString(4, titulo);   
            
            //tabla cds
            pStm.setString(1, id);
            pStm.setString(2, L2);
            pStm.setString(3, artista);
            pStm.setString(4, genero);
            pStm.setTime(5, Time.valueOf(duracion));
            pStm.setInt(6,canciones );
            pStm.setInt(7,unidades);
            
            pStmM.executeUpdate();
            pStm.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null, "CD registrado exitosamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (pStm != null) {
                pStm.close();
                }if (materialesBD.getConnection()!=null) {
                materialesBD.getConnection().close();
                }
                }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
                }           
    }
    
    public void insertToDvds(String id,String L2, String director,LocalTime duracion, String genero,int unidades, String tipo, String titulo){
        bd_Connection materialesBD = new bd_Connection();
        PreparedStatement pStm = null;
        PreparedStatement pStmM = null;
        
        try{
            pStm = materialesBD.getConnection().prepareStatement("INSERT INTO dvds VALUES (?,?,?,?,?,?)");
            pStmM = materialesBD.getConnection().prepareStatement("INSERT INTO materiales VALUES (?,?,?,?)");
            //CD(artist, genero, duracion, canciones, unidadesC, L2, hierarchy, id, titulo))
            
            pStmM.setString(1, id);
            pStmM.setString(2, L2);
            pStmM.setString(3, tipo);
            pStmM.setString(4, titulo);          
         
            pStm.setString(1, id);
            pStm.setString(2, L2);
            pStm.setString(3, director);
            pStm.setTime(4, Time.valueOf(duracion));
            pStm.setString(5,genero );
            pStm.setInt(6,unidades);
            
            pStmM.executeUpdate();
            pStm.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null, "DVD registrado exitosamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (pStm != null) {
                pStm.close();
                }if (materialesBD.getConnection()!=null) {
                materialesBD.getConnection().close();
                }
                }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
                }           
    }
    
        public void insertToLibros(String id,String L2, String autor,String editorial, String ISBN,int num_pags, int anio_publicacion, int unidades_disp,String tipo, String titulo){
        bd_Connection materialesBD = new bd_Connection();
        PreparedStatement pStm = null;
        PreparedStatement pStmM = null;
        
        try{
            pStm = materialesBD.getConnection().prepareStatement("INSERT INTO libros VALUES (?,?,?,?,?,?,?,?)");
            pStmM = materialesBD.getConnection().prepareStatement("INSERT INTO materiales VALUES (?,?,?,?)");
            //CD(artist, genero, duracion, canciones, unidadesC, L2, hierarchy, id, titulo))
            
            pStmM.setString(1, id);
            pStmM.setString(2, L2);
            pStmM.setString(3, tipo);
            pStmM.setString(4, titulo);          
         
            pStm.setString(1, id);
            pStm.setString(2, L2);
            pStm.setString(3, autor);
            pStm.setInt(4,num_pags);
            pStm.setString(5, editorial);
            pStm.setString(6,ISBN );
            pStm.setInt(7,anio_publicacion);
            pStm.setInt(8,unidades_disp);
            
            pStmM.executeUpdate();
            pStm.executeUpdate();
            
            
            JOptionPane.showMessageDialog(null, "Libro registrado exitosamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (pStm != null) {
                pStm.close();
                }if (materialesBD.getConnection()!=null) {
                materialesBD.getConnection().close();
                }
                }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
                } 
        
    }
        public void insertToRevistas(String id,String L2,String editorial, String periodicidad, Date fecha_publicacion, int unidades_disp,String tipo, String titulo){
        bd_Connection materialesBD = new bd_Connection();
        PreparedStatement pStm = null;
        PreparedStatement pStmM = null;
        
        try{
            pStm = materialesBD.getConnection().prepareStatement("INSERT INTO revistas VALUES (?,?,?,?,?,?)");
            pStmM = materialesBD.getConnection().prepareStatement("INSERT INTO materiales VALUES (?,?,?,?)");
            
            pStmM.setString(1, id);
            pStmM.setString(2, L2);
            pStmM.setString(3, tipo);
            pStmM.setString(4, titulo);          
         
            pStm.setString(1, id);
            pStm.setString(2, L2);
            pStm.setString(3, editorial);
            pStm.setString(4,periodicidad );
            pStm.setDate(5, new java.sql.Date(fecha_publicacion.getTime()));
            pStm.setInt(6,unidades_disp);
            
            pStmM.executeUpdate();
            pStm.executeUpdate();

            JOptionPane.showMessageDialog(null, "Revista registrada exitosamente", "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }catch (ClassCastException e) {
        JOptionPane.showMessageDialog(null, "Error de conversión de tipos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            try{
                if (pStm != null) {
                pStm.close();
                }if (materialesBD.getConnection()!=null) {
                materialesBD.getConnection().close();
                }
                }catch(SQLException e){
                JOptionPane.showMessageDialog(null, "Error al cerrar la conexión: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
                }
                } 
        
    }
        
        public void deleteDato(String idMaterial){
        bd_Connection materialesBD = new bd_Connection();
        PreparedStatement pStm = null;
        PreparedStatement pStmTable = null;
        String consulta = "SELECT Tipo FROM materiales WHERE idMateriales =?";
        
        
        String materialSQL = "DELETE from materiales WHERE idMateriales=?";
        
        try{
            
            pStmTable = materialesBD.getConnection().prepareStatement(consulta);
            pStmTable.setString(1, idMaterial);
            
            ResultSet resultado =pStmTable.executeQuery();

            if (resultado.next()) {
                String comparison =resultado.getString("Tipo");
                String material = comparison.toLowerCase()+"s";
                String forQuery;
                
                if (comparison == "CD" || comparison == "DVD" ) {
                    forQuery ="id"+comparison;
                }else{
                    forQuery ="id"+material;
                }
                
                PreparedStatement pStmDelete = materialesBD.getConnection().prepareStatement("DELETE FROM " + material + " WHERE " +forQuery+" = ?");
                pStmDelete.setString(1, idMaterial);
                pStmDelete.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se elimino registro "+ idMaterial+" de tabla "+material, "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

            }
            
            pStm = materialesBD.getConnection().prepareStatement(materialSQL);
            pStm.setString(1, idMaterial);         
            pStm.executeUpdate(); //borra el dato en la tabla materiales - falta agregar validacion para verificar que se borro la fila
            
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Error al ejecturar DELETE action: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
        }finally{
            try {
            if (pStm != null) {
                pStm.close();
            }
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
   
        }                
            
        } 
 
        
    
    
}

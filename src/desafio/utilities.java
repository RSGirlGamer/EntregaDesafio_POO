/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import java.util.Date;
import javax.swing.JDialog;


/**
 *
 * @author Jorge LG
 */
public class utilities {
     public static LocalTime parseDuracion(String duracionStr){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        try {
            return LocalTime.parse(duracionStr, formatter);    
        } catch (DateTimeParseException e){
            JOptionPane optionPane = new JOptionPane("Formato incorrecto. Utilice hh:mm:ss", JOptionPane.ERROR_MESSAGE);    
            JDialog dialog = optionPane.createDialog("Failure");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
            return null;
            
        }      
    }
     
     public static Date parseDate(String dateStr){
         SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
         Date date = null;
         
         try{
             date = dateFormat.parse(dateStr);
         } catch (ParseException e) {
            JOptionPane optionPane = new JOptionPane("Fecha ingresada incorrectamente", JOptionPane.ERROR_MESSAGE);    
            JDialog dialog = optionPane.createDialog("Failure");
            dialog.setAlwaysOnTop(true);
            dialog.setVisible(true);
         }
         return date;
     }
     public static String parseDateSQL(String dateStr) {
    SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date date = null;
    String formattedDateStr = null;

    try {
        date = inputFormat.parse(dateStr);
        formattedDateStr = outputFormat.format(date);
    } catch (ParseException e) {
        // Manejar el error de formato de fecha aquí
        JOptionPane.showMessageDialog(null, "Fecha ingresada incorrectamente", "Error", JOptionPane.ERROR_MESSAGE);
    }

    return formattedDateStr;
}
}

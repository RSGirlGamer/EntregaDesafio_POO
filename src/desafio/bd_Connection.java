/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desafio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Jorge LG
 */
public class bd_Connection {
    private static String driver="com.mysql.jdbc.Driver";
    private static String user  ="root";
    private static String pw    ="Hello7410.";
    private static String URL   ="jdbc:mysql://127.0.0.1:3308/mediateca_materiales";
    private Connection conexion; //conexion a db
    private ResultSet rs; //tabla interna para mostrar consulta
    private Statement stm; //sentencias sql
    
    static {
            try{
                Class.forName(driver);
                }   catch(ClassNotFoundException e){
                    JOptionPane.showMessageDialog(null, "Error en el driver"+e, "Error",JOptionPane.ERROR_MESSAGE);
                }
            }
    public Connection getConnection(){ //metodo que se usa para asegurarse primeramente que la conexion fue exitosa. 
    try{
        conexion = DriverManager.getConnection(URL, user, pw);
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, "Error al ejecutar la consulta: " + e.getMessage(), "Error",JOptionPane.ERROR_MESSAGE);
    }
    return conexion;
}
    
   public ResultSet createQuery(String consulta){
       try{
        //usando el metodo get connection definido antes para usar la conexion establecida para poder hacer la consulta
       Connection conexion = getConnection();
       //Crea un objeto statement para ejecutar la consulta a la conexion creada anteriormente
       Statement stm = conexion.createStatement(); 
       rs = stm.executeQuery(consulta);
          
       }catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Error en la consulta", "Error",JOptionPane.ERROR_MESSAGE);
       }
        return rs;
   }
   /*    public bd_Connection() throws SQLException, ClassNotFoundException{
        
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(
            "jdbc:mysql://127.0.0.1:3308/?user=root");
            //stm = conexion.createStatement();
            
           if (conexion != null) {
                System.out.println("Conexión exitosa a la base de datos mediateca_materiales.");
            } 
                       
            
        }catch(ClassNotFoundException e){
            System.out.println("Error: Not found"+e.getMessage());    
        }catch(SQLException e){
            System.out.println("Error: Fallo en SQL: "+e.getMessage());
            System.exit(0);
        }
    }
    
 public void consultarInfo() throws SQLException {
        try {
        rs =stm.executeQuery("SELECT * FROM mediateca_materiales");
        rs =stm.executeQuery("SELECT * FROM mediateca_materiales");
        while (rs.next()) {
            System.out.println("ID: "+rs.getString("idMateriales"));
            System.out.println("ID: "+rs.getString("L2"));
            System.out.println("ID: "+rs.getString("Tipo"));
            System.out.println("ID: "+rs.getString("Titulo"));
            System.out.println("**********************************************");
        }
        } catch (SQLException e){
            System.out.println("Error al ejecutar la consulta: "+ e.getMessage());
        }
    }
*/
    
}

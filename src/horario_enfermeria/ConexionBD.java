/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario_enfermeria;
/**
 *
 * @author Zelada_Torrez
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConexionBD {
    public void ConectarDB(){
        Connection con;
        ResultSet rs;

        try {
           Class.forName("com.mysql.jdbc.Driver");
           con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/enfer_db",
           "root", "");
            // Creamos un Statement para poder hacer peticiones a la bd
            Statement stat = con.createStatement();
           // Insertar 2 filas en la tabla Motor
           /*String insertar = "INSERT INTO enfermeras VALUES ('3','Valentina','Mollo','Gutierrez','86','enfermera','provisional','160','1')";
           stat.executeUpdate(insertar);     */                           

           // Seleccionar todos los datos ordenados por potencia
           String seleccionar = "SELECT * FROM enfermeras";
           rs = stat.executeQuery(seleccionar);

           // Recorrer todas las filas de la tabla Motor           
           while (rs.next()) {
                     System.out.println(rs.getString("nombres")+"\t");
                 }
        } catch (ClassNotFoundException | SQLException e) {
           System.out.println("Error: " + e.getMessage());
        }
    }
    
    public static String[] get_turno(){
        Connection con;
        ResultSet rs;
        String [] turno = new String[6];
        int i=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/enfer_db",
            "root", "");
            // Creamos un Statement para poder hacer peticiones a la bd
            Statement stat = con.createStatement();
            String seleccionar = "SELECT * FROM turnos";
            rs = stat.executeQuery(seleccionar);
            
            while (rs.next()) {                    
                     turno[i]="turno "+rs.getString("nombre");
                     i++;
                 }
        }catch(ClassNotFoundException | SQLException e) {
           System.out.println("Error: " + e.getMessage());
        }
        return turno;
        
    }
    
    public static String[] get_horario(){
        Connection con;
        ResultSet rs;
        String [] horario = new String[6];
        int i=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/enfer_db",
            "root", "");
            // Creamos un Statement para poder hacer peticiones a la bd
            Statement stat = con.createStatement();
            String seleccionar = "SELECT * FROM turnos";
            rs = stat.executeQuery(seleccionar);
             
            while (rs.next()) {                    
                     horario[i]=rs.getString("hora_inicio")+" : "+rs.getString("hora_fin");
                     i++;
                 }
        }catch(ClassNotFoundException | SQLException e) {
           System.out.println("Error: " + e.getMessage());
        }
        return horario;
    }
    
    public static String[] get_enfermera(String x,int tam){
        Connection con;
        ResultSet rs;
        String [] enfermeras = new String[tam];
        int i=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/enfer_db",
            "root", "");
            // Creamos un Statement para poder hacer peticiones a la bd
            Statement stat = con.createStatement();
            String seleccionar;
            if(tam!=2){
                seleccionar = "SELECT * FROM enfermeras";
            }else{
                seleccionar = "SELECT * FROM enfermeras WHERE grupo='"+x+"'";
            }
            
            rs = stat.executeQuery(seleccionar);
                         
            
            while (rs.next()) {   
                
                     enfermeras[i]=rs.getString("nombres")+" "+rs.getString("ap_paterno")+" "+rs.getString("ap_materno")+" "+rs.getString("tipo_enfermera")+" "+rs.getString("tipo_contrato")+" "+rs.getString("grupo");
                     i++;
                 }
        }catch(ClassNotFoundException | SQLException e) {
           System.out.println("Error: " + e.getMessage());
        }
        return enfermeras;
    }
    
    public static turnos [] get_turnoCompleto(){
        
        Connection con;
        ResultSet rs;
        turnos [] horario = new turnos[6];
        int i=0;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/enfer_db",
            "root", "");
            // Creamos un Statement para poder hacer peticiones a la bd
            Statement stat = con.createStatement();
            String seleccionar = "SELECT * FROM turnos";
            rs = stat.executeQuery(seleccionar);
             
            while (rs.next()) {                                         
                
                    horario[i]=new turnos(rs.getString("nombre"), rs.getString("hora_inicio"), rs.getString("hora_fin"));                    
                     i++;
                 }
        }catch(ClassNotFoundException | SQLException e) {
           System.out.println("Error: " + e.getMessage());
        }
        return horario;
        
    }
    
    public static void UpdateEnfermera(String new_nombre,String new_ap_paterno,String new_ap_materno,String new_date,String new_cargo,String new_contrato,int id){    
        Connection con;
        ResultSet rs;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/enfer_db","root", "");
            String query = "update enfermeras set nombres = ?, ap_paterno = ?, ap_materno =?, año_nacimiento=?,tipo_enfermera=?,tipo_contrato=? where id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);            
            preparedStmt.setString(1, new_nombre);
            preparedStmt.setString(2, new_ap_paterno);
            preparedStmt.setString(3, new_ap_materno);
            preparedStmt.setString(4, new_date);
            preparedStmt.setString(5, new_cargo);
            preparedStmt.setString(6, new_contrato);
            preparedStmt.setInt   (7, id);
            
            preparedStmt.executeUpdate();
       
            con.close();
        }catch(ClassNotFoundException | SQLException e) {
           System.out.println("Error: " + e.getMessage());
        }  
             
    }
    
     public static void UpdateTurno(String new_nombre,String new_inicio,String new_fin,int id){    
        Connection con;
        ResultSet rs;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/enfer_db","root", "");
            String query = "update turnos set nombre = ?, hora_inicio = ?, hora_fin =?  where id = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);            
            preparedStmt.setString(1, new_nombre);
            preparedStmt.setString(2, new_inicio);
            preparedStmt.setString(3, new_fin);            
            preparedStmt.setInt   (4, id);
            
            preparedStmt.executeUpdate();
       
            con.close();
        }catch(ClassNotFoundException | SQLException e) {
           System.out.println("Error: " + e.getMessage());
        }  
             
    }
}

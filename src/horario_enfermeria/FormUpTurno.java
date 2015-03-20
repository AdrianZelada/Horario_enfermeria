

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario_enfermeria;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Zelada_Torrez
 */
public class FormUpTurno extends JFrame{
    
    
    JLabel nombre;
    JLabel inicio;
    JLabel fin;        
    
    JTextField T_nomb;
    JTextField T_ini;
    JTextField T_fin;           

    
    JButton Guardar;
    JButton Cancelar;
    
    public FormUpTurno(String nomb,String inicio,String fin,int id) throws HeadlessException {    
        try{
            inicializar(nomb,inicio,fin,id);     
        }catch (Exception e) {
            e.printStackTrace();
        } 
    }
    public void inicializar (String nomb,String inicios,String fins,int id){
        this.setTitle("Formulario.");
        this.setVisible(true);
        //this.setResizable(false);
        this.setBounds(200, 50,280,340);    
        this.setLayout(null);    
        
        JPanel ContentForm=new JPanel();
        ContentForm.setBounds(10, 10, 250, 280);
        ContentForm.setLayout(null);
        
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Formulario.");      
        ContentForm.setBorder(bordejpanel); 
        
        nombre = new JLabel("Nombre");
        inicio = new JLabel("Apellido Paterno");
        fin = new JLabel("Apellido Materno");
      
        
        T_nomb = new JTextField(nomb);
        T_ini=new JTextField(inicios);
        T_fin=new JTextField(fins);               
        
        Guardar =new JButton("Guardar");
        Cancelar=new JButton("Cancelar");
        
        nombre.setBounds(20, 20, 120, 20);
        T_nomb.setBounds(30, 45, 200, 30);
        inicio.setBounds(20, 80, 120, 20);
        T_ini.setBounds(30, 105, 200, 30);
        fin.setBounds(20, 140, 120, 20);
        T_fin.setBounds(30, 165, 200, 30);              
        
        Guardar.setBounds(35, 220, 85  , 30);
        Cancelar.setBounds(140, 220, 85 , 30);
    
        ContentForm.add(nombre);
        ContentForm.add(T_nomb);
        ContentForm.add(inicio);
        ContentForm.add(T_ini);
        ContentForm.add(fin);
        ContentForm.add(T_fin);              
        ContentForm.add(Guardar);
        ContentForm.add(Cancelar);
        this.add(ContentForm);
        
        Guardar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {      
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
                if(resp==0){
                    String nombre=T_nomb.getText();
                    String inicio=T_ini.getText();
                    String fin=T_fin.getText();                
                    ConexionBD.UpdateTurno(nombre,inicio,fin,id);
                    JOptionPane.showMessageDialog(null, "Datos Actualizados", "Confirmacion", JOptionPane.DEFAULT_OPTION);
                    setVisible(false);
                }
            }          
        });
        
        Cancelar.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {  
                closeFrame();
            }
        });
        
        
    }
    
    public void closeFrame(){
        this.setVisible(false);
    }
    
    public static void main(String[] args)throws Exception {
        // TODO code application logic here
        FormAddUpd ventana= new FormAddUpd("Edna","Crabapel","Skiner","","","",1);
        
    } 
    
}

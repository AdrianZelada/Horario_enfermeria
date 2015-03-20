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
public class FormAddUpd extends JFrame{
    
    
    JLabel nombre;
    JLabel ap_paterno;
    JLabel ap_materno;    
    JLabel Fecha_Naci;
    JLabel cargo;
    JLabel contrato;
    
    JTextField T_nomb;
    JTextField T_ap_paterno;
    JTextField T_ap_materno;           
    JTextField year;
    JTextField month;
    JTextField day;
    JTextField T_cargo;
    JTextField T_contrato;
    
    JButton Guardar;
    JButton Cancelar;
    
    public FormAddUpd(String nomb,String Ap_1,String Ap_2,String fecha,String carg,String ti_contra,int id) throws HeadlessException {    
        try{
            inicializar(nomb,Ap_1,Ap_2,carg,ti_contra,id);     
        }catch (Exception e) {
            e.printStackTrace();
        } 
    }
    public void inicializar (String nomb,String Ap_1,String Ap_2,String carg,String ti_contra,int id){
        this.setTitle("Formulario.");
        this.setVisible(true);
        //this.setResizable(false);
        this.setBounds(200, 50,300,500);    
        this.setLayout(null);    
        
        JPanel ContentForm=new JPanel();
        ContentForm.setBounds(10, 10, 265, 450);
        ContentForm.setLayout(null);
        
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Formulario.");      
        ContentForm.setBorder(bordejpanel); 
        
        nombre = new JLabel("Nombre");
        ap_paterno = new JLabel("Apellido Paterno");
        ap_materno = new JLabel("Apellido Materno");
        Fecha_Naci =new JLabel("Año de Nacimiento");
        cargo=new JLabel("Cargo");
        contrato=new JLabel("Tipo Contrato");
        
        T_nomb = new JTextField(nomb);
        T_ap_paterno=new JTextField(Ap_1);
        T_ap_materno=new JTextField(Ap_2);
        year=new JTextField();
        month=new JTextField();
        day=new JTextField();
        T_cargo = new JTextField(carg);
        T_contrato=new JTextField(ti_contra);
        
        Guardar =new JButton("Guardar");
        Cancelar=new JButton("Cancelar");
        
        nombre.setBounds(20, 20, 120, 20);
        T_nomb.setBounds(30, 45, 200, 30);
        ap_paterno.setBounds(20, 80, 120, 20);
        T_ap_paterno.setBounds(30, 105, 200, 30);
        ap_materno.setBounds(20, 140, 120, 20);
        T_ap_materno.setBounds(30, 165, 200, 30);
        Fecha_Naci.setBounds(20, 200, 120, 20);
        year.setBounds(30, 225, 40, 30);
        month.setBounds(70, 225, 40, 30);
        day.setBounds(110, 225, 40, 30);
        cargo.setBounds(20, 260, 120, 20);
        T_cargo.setBounds(30, 285, 200, 30);
        contrato.setBounds(20, 320, 120, 20);
        T_contrato.setBounds(30, 345, 200, 30);
        
        Guardar.setBounds(35, 385, 85  , 30);
        Cancelar.setBounds(140, 385, 85 , 30);
    
        ContentForm.add(nombre);
        ContentForm.add(T_nomb);
        ContentForm.add(ap_paterno);
        ContentForm.add(T_ap_paterno);
        ContentForm.add(ap_materno);
        ContentForm.add(T_ap_materno);
        ContentForm.add(Fecha_Naci);
        ContentForm.add(year);        
        ContentForm.add(cargo);
        ContentForm.add(T_cargo);                                
        ContentForm.add(contrato);
        ContentForm.add(T_contrato);
        ContentForm.add(Guardar);
        ContentForm.add(Cancelar);
        this.add(ContentForm);
        
        Guardar.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {       
               int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
                if(resp==0){
                    String nombre=T_nomb.getText();
                    String paterno=T_ap_paterno.getText();
                    String materno=T_ap_materno.getText();
                    String fecha=year.getText();
                    String cargo = T_cargo.getText();
                    String contrato=T_contrato.getText();
                    ConexionBD.UpdateEnfermera(nombre,paterno,materno,fecha,cargo,contrato,id);
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

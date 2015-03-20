/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario_enfermeria;

import enfermeria.AsignacionHorario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class Main extends JFrame{
    
    JMenuBar menu;
    JMenu opciones;
    JMenuItem E_enfermeras, E_Horarios;
    PanelInicioFondo panel=new PanelInicioFondo();
    public static AsignacionHorario B;
    public Main(){
        this.setTitle("Horario Generado");
        this.setVisible(true);
        this.setResizable(false);
        this.setBounds(400, 100,400,400);    
        this.setLayout(null);   
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
        this.add(panel);
        
        menu=new JMenuBar();
        this.setJMenuBar(menu);
        
        opciones=new JMenu("Opciones");
        menu.add(opciones);
        
        E_enfermeras=new JMenuItem("Editar Enfermeras");
        opciones.add(E_enfermeras);
        E_Horarios=new JMenuItem("Editar Horarios");
        opciones.add(E_Horarios);
        
        
        E_enfermeras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
                TotalEnfermeras ventana2=new TotalEnfermeras();
                ventana2.setVisible(true);
            }
        });
        E_Horarios.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
               HorariosEdit ventana2=new HorariosEdit();
                ventana2.setVisible(true);
            }
        });
        ManejadorB m=new ManejadorB();
        
        panel.getInicio().addActionListener(m);
                
        
    }
    
    private class ManejadorB implements ActionListener {
        public void actionPerformed(ActionEvent evento) {
            if(evento.getActionCommand().equals("Iniciar")){    
                Horario_enfermeria x=new Horario_enfermeria();                
                setVisible(false);
            }			                       
        }
    }
    
    public static void main(String[] args)throws Exception {
        // TODO code application logic here
        Main ventana= new Main();
        ventana.setVisible(true);             
    } 
}

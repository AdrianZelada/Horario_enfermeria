/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario_enfermeria;

import enfermeria.AsignacionHorario;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Image;


import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Horario_enfermeria extends JFrame{

    /**
     * @param args the command line arguments
     */        
    JMenuBar menu;
    JMenu opciones;
    JMenuItem E_enfermeras, E_Horarios;
    PanelContent Content;      
    AsignacionHorario B;
    private Image imagen;
    public String []turno = new String [6];
    public String []horario = new String [6];
    public String anio="";
    public Horario_enfermeria(){                          
         try {
            inicializacion();
        } catch (Exception e) {
            e.printStackTrace();
        }                   
    }
    
    private void inicializacion() throws Exception{
                
        
        turno = ConexionBD.get_turno();
        horario = ConexionBD.get_horario();

        this.setTitle("Algoritmo Genetico");
        this.setVisible(true);
        this.setResizable(false);
        this.setBounds(400, 100,500,350);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Content =new PanelContent();
        this.add(Content);
        ManejadorB m=new ManejadorB();
        Content.getGenerar().addActionListener(m);
        Content.getCancelar().addActionListener(m);
        B=new AsignacionHorario();


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
        

        try {
            B.calcularHorario();

        } catch (Exception e) {
            
        }
    }
    
    private class ManejadorB implements ActionListener {
        public void actionPerformed(ActionEvent evento) {
            if(evento.getActionCommand().equals("Generar")){              
                String reto[] =new String [9];
                int x=Content.getMes();
                String y=Content.getAno();
                int y1=3;

                if(y.equals("2015")){
                    y1=0;
                }
                if(y.equals("2016")){                    
                    y1=1;
                }
                if(y.equals("2017")){                    
                    y1=2;
                }
                if(y.equals("2018")){                    
                    y1=3;
                }
                if(y.equals("2019")){                    
                    y1=4;
                }

                if(y.equals("202")){
                    y1=5;
                }
                int cont=0;
                if(x==0&&y1==0){cont=0;}
                if(x==1&&y1==0){cont=1;}
                if(x==2&&y1==0){cont=2;}
                if(x==0&&y1==1){cont=3;}
                if(x==1&&y1==1){cont=4;}
                if(x==2&&y1==1){cont=5;}
                if(x==0&&y1==2){cont=6;}
                if(x==1&&y1==2){cont=7;}
                if(x==2&&y1==2){cont=8;}                                
                reto=B.getArray(cont);
                //aqui enviamos el fitnness
                HorarrioGenerado ventana_Horario=new HorarrioGenerado(anio,turno, horario,reto,B.getTotal(),B.getTiempoFitnness(),B.getFitnness());
                
                setVisible(false);
            }	
            if(evento.getActionCommand().equals("Cancelar")){                    
                setVisible(false);
                dispose();
                System.exit(0);
            }	
        }
    }             
}    

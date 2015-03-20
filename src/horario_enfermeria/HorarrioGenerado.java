/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario_enfermeria;

import com.itextpdf.text.DocumentException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class HorarrioGenerado extends JFrame {        
    
    
   JButton Atras;
   JButton HorarioCompleto;
   JButton Enfermeras;
   JButton Guardar;
   String []turno1,horario1,grup1;
   private static int [][]totalH;
    public HorarrioGenerado(String x,String[] turno,String[]horario,String []grup,int [][]total,double tiempofitness,double fitness){
        totalH=total;
        try {
            inicializacion(x,turno,horario,grup,total,tiempofitness,fitness);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private class ManejadorB implements ActionListener {
        public void actionPerformed(ActionEvent evento) {
            if(evento.getActionCommand().equals("Atras")){
                Horario_enfermeria ventana=new Horario_enfermeria();                                
                ventana.setVisible(true);
                setVisible(false);                                               
                dispose();
            }		
            
            if(evento.getActionCommand().equals("Horarios")){
                HorarioGrupo ventana1=new HorarioGrupo("total",HorarrioGenerado.totalH,12);
                ventana1.setVisible(true);
            }
            
            if(evento.getActionCommand().equals("Enfermeras")){
                TotalEnfermeras ventana2=new TotalEnfermeras();
                ventana2.setVisible(true);
            }

            if(evento.getActionCommand().equals("Guardar")){
                System.out.println("Click");
                String RESULT = "D://HorariosAsignados.pdf";
                try {
                    new PDFexport(turno1,horario1,grup1).createPdf();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (DocumentException e) {
                    e.printStackTrace();
                }


            }
        }
    }
    
    public void inicializacion(String fecha,String[] turno,String[]horario,String []grup,int [][]total,double tiempofitness,double fitness)throws Exception{
        

        
        HorarioCompleto=new JButton("Horarios");
        HorarioCompleto.setBounds(30,550, 100, 30);
        
        Enfermeras=new JButton("Enfermeras");
        Enfermeras.setBounds(170,550, 100, 30);

        Guardar= new JButton("Guardar");
        Guardar.setBounds(310,550, 100, 30);

        Atras = new JButton("Atras");
        Atras.setBounds(450,550, 100, 30);
        System.out.println(fecha);
        
        this.setTitle("Horario Generado gestión "+fecha);
        this.setResizable(true);
        this.setBounds(400, 100,600,620);
        this.setLayout(null);         
        this.setVisible(true);
        turno1=turno;
        horario1=horario;
        grup1=grup;
        PanelContentHorario content =new PanelContentHorario(turno,horario,grup,total,tiempofitness,fitness);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(content);
        this.add(Atras);
        this.add(Enfermeras);
        this.add(HorarioCompleto);
        this.add(Guardar);

        ManejadorB m=new ManejadorB();
        Atras.addActionListener(m);
        Enfermeras.addActionListener(m);
        HorarioCompleto.addActionListener(m);
        Guardar.addActionListener(m);

    }            
}


package horario_enfermeria;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;




public class horario extends JPanel{    
    
    private Image imagen;
    JPanel Content_Nombre=new JPanel();
    JLabel L_Nombre=new JLabel();
    JPanel Content_Turno=new JPanel();
    JLabel L_Turno=new JLabel();  
    JPanel Content_Horario=new JPanel();
    JLabel L_Horario=new JLabel();
    
    private String nombrevar;
    private String turnovar;
    private String horariovar;
    

    public horario(String nombre,String turno,String horario,int y,int [][]total){

        try {
            inicializacion(nombre,turno,horario,y,total);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    
    private void inicializacion(String nombre,String turno,String horario,int y, final int[][] total)throws Exception {
        this.setLayout(null);
        int wi=40;
        int al =10;
        this.setBounds(20, y,530,wi);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        
        nombrevar=nombre;
        turnovar=turno;
        horariovar=horario;
        
        Color a=new Color(184, 207, 244);
        Color turno_color=new Color(233, 239, 248);               
                
        if(turno.equals("turno mañana")){
            turno_color=new Color(233, 239, 248);
        }
        if(turno.equals("turno tarde")){
            turno_color=new Color(191, 216, 241);
        }
        if(turno.equals("turno noche A")){
            turno_color=new Color(156, 202, 249);
        }
        if(turno.equals("turno noche B")){
            turno_color=new Color(108, 169, 231);
        }
        if(turno.equals("turno noche C")){
            turno_color=new Color(66, 140, 215);
        }
        if(turno.equals("turno volante")){
            turno_color=new Color(255, 248, 210);
        }
        
        Content_Nombre.setBounds(2, 2, 176, wi-4);
        Content_Nombre.setLayout(null);
        Content_Nombre.setBackground(turno_color);
                
        L_Nombre.setText(nombre);  
        L_Nombre.setBounds(10, al, 150, 20);
        L_Nombre.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        Content_Nombre.add(L_Nombre);
                        
        Content_Turno.setBounds(180, 2, 170, wi-4);       
        Content_Turno.setLayout(null);
        Content_Turno.setBackground(turno_color);
                                
        
        
        L_Turno.setText(turno);          
        L_Turno.setBounds(10, al, 120, 20);
        L_Turno.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        Content_Turno.add(L_Turno);
        
        
        Content_Horario.setBounds(352, 2, 175, wi-4);
        Content_Horario.setLayout(null);
        Content_Horario.setBackground(turno_color);
        L_Horario.setText(horario);
        L_Horario.setBounds(30, al, 150, 20);
        L_Horario.setFont(new java.awt.Font("Tahoma", 0, 16)); 
        Content_Horario.add(L_Horario);
        
        this.add(Content_Nombre);
        this.add(Content_Turno);
        this.add(Content_Horario);                
        
        this.addMouseListener(new MouseAdapter() {
          public void mousePressed(MouseEvent me) {
              System.out.println(nombrevar);
              System.out.println(total);
              HorarioGrupo ventana1=new HorarioGrupo(nombrevar,total,2);

          } 
        }); 
    }
    
    
    private class ManejadorB implements ActionListener {
        public void actionPerformed(ActionEvent evento) {
            if(evento.getActionCommand().equals("Atras")){
                Horario_enfermeria ventana=new Horario_enfermeria();                                
                ventana.setVisible(true);
                setVisible(false);                                                               
            }			                       
        }
    }
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario_enfermeria;

import java.awt.Color;
import java.awt.HeadlessException;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Zelada_Torrez
 */
 public class HorariosEdit extends JFrame{
    
    JPanel Content;
    JLabel Nombre;
    JLabel Inicio;
    JLabel Fin;
    JPanel LabelContent;

    public HorariosEdit() throws HeadlessException {
        try {
            inicializacion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void inicializacion()throws Exception{
        
        turnos[] Turnos= new turnos[6];
        
        this.setTitle("Edit Horarios");        
        this.setResizable(false);
        this.setBounds(400, 100,530,400);
        this.setLayout(null);         
        this.setVisible(true);
        Content=new JPanel();
        
        Content.setBounds(20, 20, 490, 330);
        Content.setLayout(null);
        
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Formulario.");      
        Content.setBorder(bordejpanel); 
        
        Turnos=ConexionBD.get_turnoCompleto();
        int y=60;
        Color LaberColor=new Color(92, 92, 92);
        
        LabelContent=new JPanel();
        LabelContent.setBounds(20, 15, 450,40);
        LabelContent.setBorder(BorderFactory.createLineBorder(Color.black));
        LabelContent.setBackground(LaberColor);
        LabelContent.setLayout(null);
        Nombre=new JLabel("Nombre");
        Inicio=new JLabel("Hora Inicio");
        Fin=new JLabel("Hora Fin");
        
        Nombre.setBounds(30, 5, 120, 40);
        Nombre.setForeground(Color.WHITE);
        Inicio.setBounds(200, 5, 120, 40);
        Inicio.setForeground(Color.WHITE);
        Fin.setBounds(320, 5, 80, 40);        
        Fin.setForeground(Color.WHITE);  
        LabelContent.add(Nombre);
        LabelContent.add(Inicio);
        LabelContent.add(Fin);
        
        for(int i=0;i<Turnos.length;i++){
            HorarioBlock Block=new HorarioBlock(Turnos[i], y,i);
            Content.add(Block);
            y=y+40;
        }      
        Content.add(LabelContent);
        
        this.add(Content);
    }

}

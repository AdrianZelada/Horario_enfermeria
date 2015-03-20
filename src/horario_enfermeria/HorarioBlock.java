/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario_enfermeria;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Zelada_Torrez
 */


public class HorarioBlock extends JPanel{

    public HorarioBlock(turnos ObjTurno,int y,int index) {
        
         try {
            inicializacion(ObjTurno,y,index);
        } catch (Exception e) {
            e.printStackTrace();
        }        
    }    
    JLabel Nombre;
    JLabel Inicio;
    JLabel Fin;
    JButton edit;
    Color Group_C[]=new Color[6];
    
    
    public void inicializacion(turnos ObjTurno,int y,int index){
        Nombre=new JLabel(ObjTurno.getNombre());
        Inicio=new JLabel(ObjTurno.getInicio());
        Fin=new JLabel(ObjTurno.getFin());                        
        edit=new JButton();
        Group_C[0]=new Color(194, 224, 245);
        Group_C[1]=new Color(174, 223, 249);
        Group_C[2]=new Color(160, 207, 238);
        Group_C[3]=new Color(129, 152, 228);
        Group_C[4]=new Color(100, 128, 221);
        Group_C[5]=new Color(92, 122, 219);
        
        
        ImageIcon IButton=new ImageIcon(getClass().getResource("editar.png"));        
        edit.setIcon(IButton);
        
        Color C_nom=new Color(27, 188, 155);
        Color C_Ini=new Color(34, 167, 240);
        Color C_Fin=new Color(37, 116, 169);
        
        Nombre.setBounds(30, 0, 120, 40);
        Nombre.setForeground(Color.WHITE);
        Inicio.setBounds(200, 0, 120, 40);
        Inicio.setForeground(Color.WHITE);
        Fin.setBounds(320, 0, 80, 40);        
        Fin.setForeground(Color.WHITE);
        edit.setBounds(410,0,40,40);
        
        
        edit.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {                
                FormUpTurno ventana=new FormUpTurno(ObjTurno.getNombre(),ObjTurno.getInicio(), ObjTurno.getFin(),index+1);
            }          
        });
        
        this.setBounds(20,y , 450,40);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setBackground(Group_C[index]);
        this.setLayout(null);
        this.add(Nombre);
        this.add(Inicio);
        this.add(Fin);
        this.add(edit);
        
    }
}


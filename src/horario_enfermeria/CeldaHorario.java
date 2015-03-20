/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario_enfermeria;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CeldaHorario extends JPanel{        
    JLabel Etiqueta;
    public CeldaHorario(String ticket,Color backgr) {        
        this.setLayout(null);        
        this.setSize(160, 35);
        this.setBackground(backgr);
        this.setBorder(BorderFactory.createLineBorder(Color.black));       
        Etiqueta=new JLabel(ticket);
        Etiqueta.setBounds(20, 20, 120, 20);
        Etiqueta.setForeground(Color.BLACK);
        Etiqueta.setFont(new java.awt.Font("Tahoma", 0, 16));                
        this.add(Etiqueta);        
    }
    
}

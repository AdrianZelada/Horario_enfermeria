/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario_enfermeria;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Zelada_Torrez
 */
public class PanelContentTrabajadores extends JPanel{

    Trabajadores tra[];
    JLabel nombreL;
    JLabel paterno;
    JLabel materno;
    JLabel cargo;
    JLabel item;
    JLabel grupo;
    JButton edit;
    
    
    public PanelContentTrabajadores(String nombre,int tam,int y,int wi,int x) {
        String enfer[] = new String[tam];
        enfer=ConexionBD.get_enfermera(nombre, tam);                
            
        nombreL=new JLabel("Nombre");
        nombreL.setBounds(30, 20, 120, 20);
        paterno=new JLabel("Ap. Paterno");
        paterno.setBounds(160, 20, 120, 20);
        materno=new JLabel("Ap. Materno");
        materno.setBounds(260, 20, 120, 20);
        cargo=new JLabel("Cargo");
        cargo.setBounds(390, 20, 120, 20);
        item=new JLabel("Item");
        item.setBounds(510, 20, 120, 20);                        
        
        grupo=new JLabel("Grupo");
        grupo.setBounds(610, 20, 120, 20);
                
        
        this.add(nombreL);
        this.add(paterno);
        this.add(materno);
        this.add(cargo);
        this.add(item);
        this.add(grupo);         
        
        tra=new Trabajadores[tam];
        
        this.setLayout(null);
        this.setBounds(x, y,715,wi);
        
        
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Trabajadores");      
        this.setBorder(bordejpanel); 
        int k=50;
        for (int i = 0; i < enfer.length; i++) {            
            tra[i]=new Trabajadores(enfer[i],k,i+1);
            k=k+35;
            this.add(tra[i]);
        }                
    }
    
}


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario_enfermeria;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelInicioFondo extends JPanel{
    JButton aceptar;
    private Image imagen;
    public PanelInicioFondo(){
    try {
            inicializacion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void inicializacion(){
        imagen = new ImageIcon(getClass().getResource("fondoInicio.jpg")).getImage();        
        this.setLayout(null);
        this.setBounds(10, 10,375,370);
        aceptar =new JButton("Iniciar");
        aceptar.setBounds(180, 250, 100, 30);
                
        this.add(aceptar);
    }
    
    public JButton getInicio(){
        return aceptar;
    } 
          
    public void paint(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(),
                              this);
            setOpaque(false);
        } else {
            setOpaque(true);
        }
 
        super.paint(g);
    }
}

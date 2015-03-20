/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario_enfermeria;

import java.awt.HeadlessException;
import javax.swing.JFrame;

/**
 *
 * @author Zelada_Torrez
 */
class TotalEnfermeras extends JFrame{

    public TotalEnfermeras() {
        this.setTitle("Lista Enfermeras");                
        this.setBounds(400, 100,760,590);    
        this.setLayout(null);         
        this.setVisible(true);           
        
        PanelContentTrabajadores contTra=new PanelContentTrabajadores("", 12, 20,500,20);
        
        this.add(contTra);
    }
    
    
    
}

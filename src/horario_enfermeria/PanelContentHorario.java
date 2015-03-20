/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario_enfermeria;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class PanelContentHorario extends JPanel{
    
    private Image imagen;
     /*horario test;
    horario test1;*/
    JLabel Enfermera=new JLabel();
    JLabel Turno=new JLabel();
    JLabel Horario=new JLabel();
    JLabel Fitness=new JLabel();
    JLabel TiempoFitness=new JLabel();

    public PanelContentHorario(String[] turno,String[]horario,String[] grup,int [][]total,double tiempofitness,double fitness){
        try {
            inicializacion(turno,horario,grup,total,tiempofitness,fitness);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void inicializacion(String[] turno,String[]horario,String[] grup,int [][]total,double tiempofitness,double fitness){
        this.setLayout(null);
        this.setBounds(10, 15,575,520);
        Enfermera.setText("Grupo de Enfermeras");
        Enfermera.setBounds(30, 10, 150, 20);        
        Turno.setText("Turno");
        Turno.setBounds(220, 10, 150, 20);
        Horario.setText("Horario");
        Horario.setBounds(400, 10, 150, 20);
        Border bordejpanel = new TitledBorder(new EtchedBorder(), "Horario Generado de la gestion");
        this.setBorder(bordejpanel);
        this.add(Enfermera);
        this.add(Turno);
        this.add(Horario);
        int y=35;
        
        for(int i=0;i<turno.length;i++){
            horario row_add=new horario(grup[i],turno[i],horario[i],y,total);
            y=y+42;
            this.add(row_add);
        }

        this.setBorder(bordejpanel);
        Fitness.setText("El valor de la aptitud es igual a "+fitness);
        Fitness.setBounds(30, 300, 220, 100);
        this.add(Fitness);

        TiempoFitness.setText("El tiempo de evoluvion es  "+tiempofitness+" ms");
        TiempoFitness.setBounds(30, 320, 220, 100);
        this.add(TiempoFitness);

    }        
}

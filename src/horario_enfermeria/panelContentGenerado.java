/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario_enfermeria;

import javax.swing.*;
import java.awt.*;


public class panelContentGenerado extends JPanel{

    CeldaHorario panels0[];
    CeldaHorario panels1[];
    CeldaHorario panels2[];
    CeldaHorario panels3[]; 
    CeldaHorario panels4[];
    CeldaHorario panels5[];
    public panelContentGenerado(String nombre,int[][] total) {
        try {
            inicializacion(nombre,total);
        } catch (Exception e) {
        }
    }
    
    public void inicializacion(String nombre,int[][]total){

        this.setLayout(new GridLayout(6, 9));
        this.setBounds(150, 80, 800, 350);
        
        panels0 = new CeldaHorario[3];
        panels1 = new CeldaHorario[3];
        panels2 = new CeldaHorario[3];
        panels3 = new CeldaHorario[3];
        panels4 = new CeldaHorario[3];
        panels5 = new CeldaHorario[3];

        //if(nombre.equals("total")){

                String texto1="Grupo "+Integer.toString(total[0][0]);
                Color turno_color1=new Color(233, 239, 248);

                if(nombre.equals(texto1)) {

                }
                else{
                    texto1="";
                }
                panels0[0] = new CeldaHorario(texto1,turno_color1);


                this.add(panels0[0]);
                String texto2="Grupo "+Integer.toString(total[1][0]);
                Color turno_color2=new Color(233, 239, 248);
                if(nombre.equals(texto2)) {
                }
                else{
                    texto2= "";
                }
        panels0[1] = new CeldaHorario(texto2,turno_color2);
                this.add(panels0[1]);
                String texto3="Grupo "+Integer.toString(total[2][0]);
                Color turno_color3=new Color(233, 239, 248);
                if(nombre.equals(texto3)) {
                }
                else{
                    texto3= "";
                }

                panels0[2] = new CeldaHorario(texto3,turno_color3);
               this.add(panels0[2]);

                String texto4="Grupo "+Integer.toString(total[0][1]);
                Color turno_color4=new Color(233, 239, 248);
        if(nombre.equals(texto4)) {
        }
        else{
            texto4= "";
        }
                panels1[0] = new CeldaHorario(texto4,turno_color4);
                this.add(panels1[0]);
                String texto5="Grupo "+Integer.toString(total[1][1]);
                Color turno_color5=new Color(233, 239, 248);
        if(nombre.equals(texto5)) {
        }
        else{
            texto5= "";
        }
                panels1[1] = new CeldaHorario(texto5,turno_color5);
                this.add(panels1[1]);
                String texto6="Grupo "+Integer.toString(total[2][1]);
                Color turno_color6=new Color(233, 239, 248);
        if(nombre.equals(texto6)) {
        }
        else{
            texto6= "";
        }
                panels1[2] = new CeldaHorario(texto6,turno_color6);
                this.add(panels1[2]);

                String texto7="Grupo "+Integer.toString(total[0][2]);
                Color turno_color7=new Color(233, 239, 248);
        if(nombre.equals(texto7)) {
        }
        else{
            texto7= "";
        }
                panels2[0] = new CeldaHorario(texto7,turno_color7);
                this.add(panels2[0]);
                String texto8="Grupo "+Integer.toString(total[1][2]);
                Color turno_color8=new Color(233, 239, 248);
        if(nombre.equals(texto8)) {
        }
        else{
            texto8= "";
        }
                panels2[1] = new CeldaHorario(texto8,turno_color8);
                this.add(panels2[1]);
                String texto9="Grupo "+Integer.toString(total[2][2]);
                Color turno_color9=new Color(233, 239, 248);
        if(nombre.equals(texto9)) {
        }
        else{
            texto9= "";
        }
                panels2[2] = new CeldaHorario(texto9,turno_color9);
                this.add(panels2[2]);

                String texto10="Grupo "+Integer.toString(total[0][3]);
                Color turno_color10=new Color(233, 239, 248);
        if(nombre.equals(texto10)) {
        }
        else{
            texto10= "";
        }
                panels3[0] = new CeldaHorario(texto10,turno_color10);
                this.add(panels3[0]);
                String texto11="Grupo "+Integer.toString(total[1][3]);
                Color turno_color11=new Color(233, 239, 248);
        if(nombre.equals(texto11)) {
        }
        else{
            texto11= "";
        }
                panels3[1] = new CeldaHorario(texto11,turno_color11);
                this.add(panels3[1]);
                String texto12="Grupo "+Integer.toString(total[2][3]);
                Color turno_color12=new Color(233, 239, 248);
        if(nombre.equals(texto12)) {
        }
        else{
            texto12= "";
        }
                panels3[2] = new CeldaHorario(texto12,turno_color12);
                this.add(panels3[2]);

                String texto13="Grupo "+Integer.toString(total[0][4]);
                Color turno_color13=new Color(233, 239, 248);
        if(nombre.equals(texto13)) {
        }
        else{
            texto13= "";
        }
                panels4[0] = new CeldaHorario(texto13,turno_color13);
                this.add(panels4[0]);
                String texto14="Grupo "+Integer.toString(total[1][4]);
                Color turno_color14=new Color(233, 239, 248);
        if(nombre.equals(texto14)) {
        }
        else{
            texto14= "";
        }
                panels4[1] = new CeldaHorario(texto14,turno_color14);
                this.add(panels4[1]);
                String texto15="Grupo "+Integer.toString(total[2][4]);
                Color turno_color15=new Color(233, 239, 248);
        if(nombre.equals(texto15)) {
        }
        else{
            texto15= "";
        }
                panels4[2] = new CeldaHorario(texto15,turno_color15);
                this.add(panels4[2]);

                String texto16="Grupo "+Integer.toString(total[0][5]);
                Color turno_color16=new Color(233, 239, 248);
        if(nombre.equals(texto16)) {
        }
        else{
            texto16= "";
        }
                panels5[0] = new CeldaHorario(texto16,turno_color16);
                this.add(panels5[0]);
                String texto17="Grupo "+Integer.toString(total[1][5]);
                Color turno_color17=new Color(233, 239, 248);
        if(nombre.equals(texto17)) {
        }
        else{
            texto17= "";
        }
                panels5[1] = new CeldaHorario(texto17,turno_color17);
                this.add(panels5[1]);
                String texto18="Grupo "+Integer.toString(total[2][5]);
                Color turno_color18=new Color(233, 239, 248);
        if(nombre.equals(texto18)) {
        }
        else{
            texto18= "";
        }
                panels5[2] = new CeldaHorario(texto18,turno_color18);
                this.add(panels5[2]);


        //}
    }    
}

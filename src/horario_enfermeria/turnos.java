/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package horario_enfermeria;

/**
 *
 * @author Zelada_Torrez
 */
public class turnos {
    private String Nombre;
    private String Inicio;
    private String Fin;
    
    public turnos(String Nom,String Ini,String Fin) {
        this.Nombre=Nom;
        this.Inicio=Ini;
        this.Fin=Fin;
    }        
    
    String getNombre(){
        return this.Nombre;
    }
    
    String getInicio(){
        return this.Inicio;
    }
    
     String getFin(){
        return this.Fin;
    }
     String getAll(){
        return this.Nombre+" "+this.Inicio+ " "+ this.Fin;
     }
    
     void setNombre(String Nom){
        this.Nombre=Nom;
    }
    
     void setInicio(String Ini){
        this.Inicio=Ini;
    }
     void setFin(String fin){
        this.Fin=fin;
    }
     
     
    
}

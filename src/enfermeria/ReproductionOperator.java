/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enfermeria;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.GeneticOperator;
import java.util.List;
import org.jgap.Population;
import org.jgap.impl.DefaultConfiguration;
public class ReproductionOperator {
    public void operate(final Population a_population, final List a_cantidadChromosome){
        int len=a_population.size();
        for(int i=0; i<len;i++){
            a_cantidadChromosome.add(a_population.getChromosome(i).clone());
    
        }
       
    }
          Configuration configuracion=new DefaultConfiguration();//Configuracion por defecto del JGAP (cruza, mutacion, seleccion, etc)
           
}

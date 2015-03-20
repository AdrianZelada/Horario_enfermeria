/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enfermeria;

import horario_enfermeria.HorarrioGenerado;
import java.io.File;
import java.util.Arrays;
import java.util.Random;
import java.util.StringTokenizer;
import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.DefaultFitnessEvaluator;
import org.jgap.FitnessFunction;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.data.DataTreeBuilder;
import org.jgap.data.IDataCreators;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
import org.jgap.xml.XMLDocumentBuilder;
import org.jgap.xml.XMLManager;
import org.w3c.dom.Document;
import org.jgap.impl.CrossoverOperator;
import org.jgap.impl.MutationOperator;
import org.jgap.InvalidConfigurationException;
import org.jgap.impl.SwappingMutationOperator;


public class AsignacionHorario {
  private static final int MAX_EVOLUCIONES_PERMITIDAS=50;
  private static final int NUMERO_GENES=54;
  private static final int TAMAÑO_POBLACION=50;
  private static int [][] retornar =new int[9][6];
  public  double valorFitnness;
  public  double valorTiempoFitnness;
  public static void mostrarTurno(IChromosome turnoSolucion){
        
        int[]newarray=arrayRand(1,6,6);
        int cont=0;
        int ce=0;
        for(int d=0;d<9;d++){

            for(int j=0;j<=5;j++){
                retornar[d][j]=newarray[cont];

                if(j!=5){
                    if(cont==5){
                        cont=-1;
                    }
                    cont++;
                }
            }
        }
         //System.out.println(Arrays.toString(newarray));
        System.out.println(Arrays.deepToString(retornar));
    }
  public int [][] getTotal(){
      return retornar;
  }
  public String [] getArray(int x){
      
      String retor[]=new String[12];
      for(int i=0;i<=5;i++){          
          retor[i]="Grupo "+Integer.toString(retornar[x][i]);          
      }
      return retor;
  }
  public void setFitnness(double fitnness){
      valorFitnness=fitnness;
  }
  public void setTiempoFitnness(double tiempoFitnness){
      valorTiempoFitnness=tiempoFitnness;
  }
  public double getFitnness(){
        return valorFitnness;
    }
  public double getTiempoFitnness(){
        return valorTiempoFitnness;
    }

   public void calcularHorario()throws Exception{
        // Agoritmo Genetico
        try{
            Configuration configuracion=new DefaultConfiguration();//Configuracion por defecto del JGAP (cruza, mutacion, seleccion, etc)
            configuracion.setPreservFittestIndividual(true);//Elitismo
            FitnessFunction funTur=new HorarioFuncionAptitud();// clase donde definimos la fcn de aptitud
            configuracion.setFitnessFunction(funTur);
            Gene[] sampleGenes=new Gene[NUMERO_GENES];
            for(int K=0; K<NUMERO_GENES;K++){
                sampleGenes[K]=new IntegerGene(configuracion, 1,6);
            }
            IChromosome cromosomaAsignacion=new Chromosome(configuracion,sampleGenes);
            configuracion.setSampleChromosome(cromosomaAsignacion);
            configuracion.setPopulationSize(TAMAÑO_POBLACION);
            Genotype Poblacion;
            Poblacion=Genotype.randomInitialGenotype(configuracion);
            long TiempoComienzo=System.currentTimeMillis();
            for(int i=0; i<MAX_EVOLUCIONES_PERMITIDAS; i++){
                Poblacion.evolve();
            }
            long TiempoFin=System.currentTimeMillis();
            System.out.println("Tiempo total de evoluciones:" + (TiempoFin-TiempoComienzo)+"ms");
            guardarPoblacion(Poblacion);
            IChromosome cromosomaMasApto=Poblacion.getFittestChromosome();//mejor individuo obtenido obtenemos el mejor individuo para esta generacion
            System.out.println("El cromosoma mas apto encontrado tiene un valor de aptitud " + cromosomaMasApto.getFitnessValue());
            System.out.println("Y esta formado por la siguiente distribucion de grupos de enfermeras");
            setFitnness( cromosomaMasApto.getFitnessValue());
            setTiempoFitnness(TiempoFin-TiempoComienzo);
            mostrarTurno(cromosomaMasApto);//Mostrar al individuo

        }
        catch (InvalidConfigurationException ex){
            System.out.println("No se pudo ejecutar el AG");
        }
    }
       
    public static void guardarPoblacion(Genotype Poblacion) throws Exception{
       DataTreeBuilder builder=DataTreeBuilder.getInstance();
       IDataCreators doc2=builder.representGenotypeAsDocument(Poblacion);
       XMLDocumentBuilder docbuilder=new XMLDocumentBuilder();
       Document xmlDoc=(Document)docbuilder.buildDocument(doc2);
       XMLManager.writeFile(xmlDoc, new File("PoblacionAsignacionHorario.xml"));
    }

    public static int[] arrayRand(int desde, int hasta, int tam) {
        int[] numeros = new int[tam];
        Random rnd = new Random();
        int n;
        for (int i = 0; i < numeros.length; i++) {
            do {
                n = rnd.nextInt(hasta - desde + 1) + desde;
            } while (iftake(numeros, i, n));
            numeros[i] = n;
        }
        return numeros;
    }

    public static boolean iftake(int[] numeros, int indice, int valor) {
        for (int i = 0; i < indice; i++) {
            if (numeros[i] == valor) {
                return true;
            }
        }
        return false;
    }
    
}

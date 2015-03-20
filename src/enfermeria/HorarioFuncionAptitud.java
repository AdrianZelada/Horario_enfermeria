

package enfermeria;
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;
public class HorarioFuncionAptitud extends FitnessFunction{
    private double fitness; //La variable que llevara el valor de aptitud
    public HorarioFuncionAptitud(){
        fitness=0;// la aptitud es 0
    }
    @Override
    protected double evaluate(IChromosome cromosoma){
            generarHorarios(cromosoma);
            return fitness;
    }

  /*  public void verificarRepetidos(IChromosome cromosoma){
        Integer c1=(Integer)cromosoma.getGene(0).getAllele();
        Integer c2=(Integer)cromosoma.getGene(1).getAllele();
        Integer c3=(Integer)cromosoma.getGene(2).getAllele();
        Integer c4=(Integer)cromosoma.getGene(3).getAllele();
        Integer c5=(Integer)cromosoma.getGene(4).getAllele();
        Integer c6=(Integer)cromosoma.getGene(5).getAllele();
        
        if((c1.compareTo(c2)!=0)&&(c1.compareTo(c3)!=0)&&(c1.compareTo(c4)!=0)&&(c1.compareTo(c5)!=0)&&(c1.compareTo(c6)!=0))
        {
            fitness=fitness+5;
        }
        if((c2.compareTo(c1)!=0)&&(c2.compareTo(c3)!=0)&&(c2.compareTo(c4)!=0)&&(c2.compareTo(c5)!=0)&&(c2.compareTo(c6)!=0))
        {
            fitness=fitness+5;
        }
        if((c3.compareTo(c1)!=0)&&(c3.compareTo(c2)!=0)&&(c3.compareTo(c4)!=0)&&(c3.compareTo(c5)!=0)&&(c3.compareTo(c6)!=0))
        {
            fitness=fitness+5;
        }
        if((c4.compareTo(c2)!=0)&&(c4.compareTo(c3)!=0)&&(c4.compareTo(c1)!=0)&&(c4.compareTo(c5)!=0)&&(c4.compareTo(c6)!=0))
        {
            fitness=fitness+5;
        }
        if((c5.compareTo(c2)!=0)&&(c5.compareTo(c3)!=0)&&(c5.compareTo(c4)!=0)&&(c5.compareTo(c1)!=0)&&(c5.compareTo(c6)!=0))
        {
            fitness=fitness+5;
        }
        if((c6.compareTo(c2)!=0)&&(c6.compareTo(c3)!=0)&&(c6.compareTo(c4)!=0)&&(c6.compareTo(c5)!=0)&&(c6.compareTo(c1)!=0))
        {
            fitness=fitness+5;
        }

    }
*/
    //public double evaluarVertical1(IChromosome cromosoma)
     public double evaluarHorizontal1(IChromosome cromosoma){
         int acumulado=0;
         int a,b,c,d,e,f;
         for(int i=0; i<6; i++){
             
             a=(Integer)cromosoma.getGene(i).getAllele();
             b=(Integer)cromosoma.getGene(i+1).getAllele();
             c=(Integer)cromosoma.getGene(i+2).getAllele();
             d=(Integer)cromosoma.getGene(i+3).getAllele();
             e=(Integer)cromosoma.getGene(i+4).getAllele();
             f=(Integer)cromosoma.getGene(i+5).getAllele();
             acumulado=a+b+c+d+e+f;
             if((a*2)==acumulado){
                 acumulado-=1;
                
             }
         }
         if(acumulado!=21) return (double)0.1;
         else return (double)0.9;
     }

    public void generarHorarios(IChromosome cromosoma){

        Integer c1=(Integer)cromosoma.getGene(0).getAllele();
        Integer c2=(Integer)cromosoma.getGene(1).getAllele();
        Integer c3=(Integer)cromosoma.getGene(2).getAllele();
        Integer c4=(Integer)cromosoma.getGene(3).getAllele();
        Integer c5=(Integer)cromosoma.getGene(4).getAllele();
        Integer c6=(Integer)cromosoma.getGene(5).getAllele();
        Integer c7=(Integer)cromosoma.getGene(6).getAllele();
        Integer c8=(Integer)cromosoma.getGene(7).getAllele();
        Integer c9=(Integer)cromosoma.getGene(8).getAllele();
        Integer c10=(Integer)cromosoma.getGene(9).getAllele();
        Integer c11=(Integer)cromosoma.getGene(10).getAllele();
        Integer c12=(Integer)cromosoma.getGene(11).getAllele();
        Integer c13=(Integer)cromosoma.getGene(12).getAllele();
        Integer c14=(Integer)cromosoma.getGene(13).getAllele();
        Integer c15=(Integer)cromosoma.getGene(14).getAllele();
        Integer c16=(Integer)cromosoma.getGene(15).getAllele();
        Integer c17=(Integer)cromosoma.getGene(16).getAllele();
        Integer c18=(Integer)cromosoma.getGene(17).getAllele();
        Integer c19=(Integer)cromosoma.getGene(18).getAllele();
        Integer c20=(Integer)cromosoma.getGene(19).getAllele();
        Integer c21=(Integer)cromosoma.getGene(20).getAllele();
        Integer c22=(Integer)cromosoma.getGene(21).getAllele();
        Integer c23=(Integer)cromosoma.getGene(22).getAllele();
        Integer c24=(Integer)cromosoma.getGene(23).getAllele();
        Integer c25=(Integer)cromosoma.getGene(24).getAllele();
        Integer c26=(Integer)cromosoma.getGene(25).getAllele();
        Integer c27=(Integer)cromosoma.getGene(26).getAllele();
        Integer c28=(Integer)cromosoma.getGene(27).getAllele();
        Integer c29=(Integer)cromosoma.getGene(28).getAllele();
        Integer c30=(Integer)cromosoma.getGene(29).getAllele();
        Integer c31=(Integer)cromosoma.getGene(30).getAllele();
        Integer c32=(Integer)cromosoma.getGene(31).getAllele();
        Integer c33=(Integer)cromosoma.getGene(32).getAllele();
        Integer c34=(Integer)cromosoma.getGene(33).getAllele();
        Integer c35=(Integer)cromosoma.getGene(34).getAllele();
        Integer c36=(Integer)cromosoma.getGene(35).getAllele();
        System.out.println("-------------");
        System.out.println("fitness init= "+fitness);
        //-------------------------
        if(!c1.equals(c2) && !c1.equals(c3) && !c1.equals(c4) && !c1.equals(c5) && !c1.equals(c6) ) {
            System.out.println("c1 a c6");
            if (!c2.equals(c3) && !c2.equals(c4) && !c2.equals(c5) && !c2.equals(c6)) {
                System.out.println("c2 a c6");
                if (!c3.equals(c4) && !c3.equals(c5) && !c3.equals(c6)) {
                    System.out.println("c3 a c6");
                    if (!c4.equals(c5) && !c4.equals(c6)) {
                        System.out.println("c4 a c6");
                        if (!c5.equals(c6)) {
                            fitness = fitness + 0.166;
                            System.out.println("c5 a c6");
                        }
                    }
                }
            }
        }

        if(!c7.equals(c8) && !c7.equals(c9) && !c7.equals(c10) && !c7.equals(c11) && !c7.equals(c12) ) {
            System.out.println("c7 a c12");
            if (!c8.equals(c9) && !c8.equals(c10) && !c8.equals(c11) && !c8.equals(c12)) {
                System.out.println("c8 a c12");
                if (!c9.equals(c10) && !c9.equals(c11) && !c9.equals(c12)) {
                    System.out.println("c9 a c12");
                    if (!c10.equals(c11) && !c13.equals(c12)) {
                        System.out.println("c10 a c12");
                        if (!c11.equals(c12)) {
                            fitness = fitness + 0.166;
                            System.out.println("c11 a c12");

                        }
                    }
                }
            }
        }

        if(!c13.equals(c14) && !c13.equals(c15) && !c13.equals(c16) && !c13.equals(c17) && !c13.equals(c18) ) {
            System.out.println("c13 a c18");
            if (!c14.equals(c15) && !c14.equals(c16) && !c14.equals(c17) && !c14.equals(c18)) {
                System.out.println("c14 a c18");
                if (!c15.equals(c16) && !c15.equals(c17) && !c15.equals(c18)) {
                    System.out.println("c15 a c18");
                    if (!c16.equals(c17) && !c16.equals(c18)) {
                        System.out.println("c16 a c18");
                        if (!c17.equals(c18)) {
                            fitness = fitness + 0.166;
                            System.out.println("c17 a c18");
                        }
                    }
                }
            }
        }

        if(!c19.equals(c20) && !c19.equals(c21) && !c19.equals(c22) && !c19.equals(c23) && !c19.equals(c24) ) {
            System.out.println("c19 a c24");
            if (!c20.equals(c21) && !c20.equals(c22) && !c20.equals(c23) && !c20.equals(c24)) {
                System.out.println("c20 a c24");
                if (!c21.equals(c22) && !c21.equals(c23) && !c21.equals(c24)) {
                    System.out.println("c21 a c24");
                    if (!c22.equals(c23) && !c22.equals(c24)) {
                        System.out.println("c22 a c24");
                        if (!c23.equals(c24)) {
                            fitness = fitness + 0.166;
                            System.out.println("c23 a c24");
                        }
                    }
                }
            }
        }

        if(!c25.equals(c26) && !c25.equals(c27) && !c25.equals(c28) && !c25.equals(c29) && !c25.equals(c30) ) {
            System.out.println("c25 a c30");
            if (!c26.equals(c27) && !c26.equals(c28) && !c26.equals(c29) && !c26.equals(c30)) {
                System.out.println("c26 a c30");
                if (!c27.equals(c28) && !c27.equals(c29) && !c27.equals(c30)) {
                    System.out.println("c27 a c30");
                    if (!c28.equals(c29) && !c28.equals(c30)) {
                        System.out.println("c28 a c30");
                        if (!c29.equals(c30)) {
                            fitness = fitness + 0.166;
                            System.out.println("c29 a c30");
                        }
                    }
                }
            }
        }

        if(!c31.equals(c32) && !c31.equals(c33) && !c31.equals(c34) && !c31.equals(c35) && !c31.equals(c36) ) {
            System.out.println("c31 a c36");
            if (!c32.equals(c33) && !c32.equals(c34) && !c32.equals(c35) && !c32.equals(c36)) {
                System.out.println("c32 a c36");
                if (!c33.equals(c34) && !c33.equals(c35) && !c33.equals(c36)) {
                    System.out.println("c33 a c36");
                    if (!c34.equals(c35) && !c34.equals(c36)) {
                        System.out.println("c34 a c36");
                        if (!c35.equals(c36)) {
                            fitness = fitness + 0.166;
                            System.out.println("c35 a c36");

                        }
                    }
                }
            }
        }

        fitness =(1/(1+fitness));
        System.out.println("fitness= "+fitness);



    }

}



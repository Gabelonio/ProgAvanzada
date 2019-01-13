package LogicaRutinas;

import LogicaEjercicios.Sentadilla;
import LogicaEjercicios.Dominada;
import LogicaEjercicios.Lagartija;
import LogicaEjercicios.Fondo;
import LogicaEjercicios.Aerobico;
import LogicaEjercicios.Trote;
import LogicaEjercicios.Abdominal;
import LogicaEjercicios.Plancha;
import LogicaEjercicios.Ejercicio;

/**
 *
 * @author Gabelonio
 */
public class RutinaTonificacion extends Rutina{

    @Override
    public void asignarEjercicios(float peso, int altura) {
        
        Ejercicio[] EJERCICIOS_DISPONIBLES={new Abdominal(),new Plancha(),   /*Establecimiento de ejercicios para esta rutina*/
                                            new Sentadilla(),new Aerobico(),
                                            new Trote(), new Dominada(),
                                            new Fondo(), new Lagartija()};
   
        Ejercicio[] ejercicios=new Ejercicio[(int)(Math.random() * 4)+5];    /*Asignación cantidad de ejercicios*/
        
        for(int i=0;i<ejercicios.length;i++)
        {
            ejercicios[i]=Ejercicio.Liskov(
                    EJERCICIOS_DISPONIBLES[(int)(Math.random() * 
                        EJERCICIOS_DISPONIBLES.length)],                    /*Asginación ejercicio a Realizar*/
                    RutinaTonificacion.determinarRepeticiones(
                            (int)(Math.random() * 10)+30, peso, altura));   /*Asignación cantidad de Repeticiones*/
        }    
        
        this.ejercicios=ejercicios;
    }
    
}

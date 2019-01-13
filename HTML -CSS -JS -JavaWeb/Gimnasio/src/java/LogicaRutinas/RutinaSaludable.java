package LogicaRutinas;

import LogicaEjercicios.Sentadilla;
import LogicaEjercicios.Lagartija;
import LogicaEjercicios.Aerobico;
import LogicaEjercicios.Trote;
import LogicaEjercicios.Plancha;
import LogicaEjercicios.Ejercicio;

/**
 *
 * @author Gabelonio
 */
public class RutinaSaludable extends Rutina{

    @Override
    public void asignarEjercicios(float peso, int altura) {
        
        Ejercicio[] EJERCICIOS_DISPONIBLES={new Plancha(),new Sentadilla(),
                                            new Aerobico(),new Trote(),
                                            new Lagartija()};
   
        Ejercicio[] ejercicios=new Ejercicio[(int)(Math.random() * 4)+1]; //asignación cantidad de ejercicios
        
        for(int i=0;i<ejercicios.length;i++)
        {
            ejercicios[i]=Ejercicio.Liskov(
                    EJERCICIOS_DISPONIBLES[(int)(Math.random() * 
                        EJERCICIOS_DISPONIBLES.length)],                 //asginación ejercicio a Realizar
                    RutinaSaludable.determinarRepeticiones(
                            (int)(Math.random() * 10)+10, peso, altura));                       //asignación cantidad de Repeticiones
        }    
        
        this.ejercicios=ejercicios;    
    }

}

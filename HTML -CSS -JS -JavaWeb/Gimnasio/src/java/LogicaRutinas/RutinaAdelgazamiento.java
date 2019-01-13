package LogicaRutinas;

import LogicaEjercicios.Sentadilla; 
import LogicaEjercicios.Aerobico;
import LogicaEjercicios.Trote;
import LogicaEjercicios.Abdominal;
import LogicaEjercicios.Plancha;
import LogicaEjercicios.Ejercicio; 

/**
 *
 * @author Gabelonio
 */
public class RutinaAdelgazamiento extends Rutina{

    @Override
    public void asignarEjercicios(float peso, int altura) {
        
        Ejercicio[] EJERCICIOS_DISPONIBLES={new Abdominal(),new Plancha(),
                                            new Sentadilla(),new Aerobico(),
                                            new Trote()};                   //Asignacion tipo de ejercicios
        
        Ejercicio[] ejercicios=new Ejercicio[(int)(Math.random() * 4)+3];   //Asignación cantidad de ejercicios
        
        for(int i=0;i<ejercicios.length;i++)
        {
            ejercicios[i]=Ejercicio.Liskov(
                    EJERCICIOS_DISPONIBLES[(int)(Math.random() * 
                        EJERCICIOS_DISPONIBLES.length)],                    //Asignación ejercicio a Realizar
                    RutinaAdelgazamiento.determinarRepeticiones(
                            (int)(Math.random() * 9)+15, peso, altura));    //Asignación cantidad de Repeticiones
        }
        
        this.ejercicios=ejercicios;
    }
    
}

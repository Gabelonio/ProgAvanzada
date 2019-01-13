package LogicaAgentes;

import LogicaEjercicios.Ejercicio;
import LogicaRutinas.Rutina;
/**
 *
 * @author Gabelonio
 */
public class Cliente {
    
    private Rutina[] rutinas;
    
    public void setRutinas(Rutina[] rutinas){
        this.rutinas=rutinas;
    }
    
    public Rutina[] getRutinas(){
        return this.rutinas;
    }
    /* Metodo para simplificar el llamado de los ejercicios de una rutina del 
     * cliente
    */
    public Ejercicio[] getEjerciciosdelDia(int dia){
        return rutinas[dia].getEjercicios();
    }
}

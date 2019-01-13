package LogicaAgentes;

import LogicaRutinas.Rutina;
/**
 *
 * @author Gabelonio
 */
public class Entrenador {
    
    private Rutina asignacion; 
    
    /*  Método usado para crear Rutinas aleatorias a partir de la rutina 
     *  previamente seleccionada por el usuario
    */
    public Rutina[] programarRutinas(int cantidadDias, float peso, int altura) 
                        throws InstantiationException, IllegalAccessException{
        
        Rutina[] rutinas=new Rutina[cantidadDias]; //Rutina a retornar
        for(int i=0;i<cantidadDias;i++)
        {
            /*Creación de una instancia de una rutina concreta*/
            rutinas[i]=asignacion.getClass().newInstance(); 
            /*Asignación de ejercicios tomando en cuenta los parametros*/
            rutinas[i].asignarEjercicios(peso,altura);      
        }
        return rutinas; 
    }
    
    public void asignarRutinas(Rutina rutina){
        this.asignacion=rutina;
    }
    
    
}

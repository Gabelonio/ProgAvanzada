package LogicaEjercicios;
/**
 *
 * @author Gabelonio
 */
public abstract class Ejercicio {
    
    protected String nombre;
    protected boolean repeticiones;
    private int cantidadRepeticiones; 
    
    /* Metodo usado para retornar la clase de ejercicio que necesita la rutina
     * la cual determinara dicha clase y su respectiva cantidad   
    */
    public static Ejercicio Liskov(Ejercicio ejercicio,int cantidadRepeticiones){
        ejercicio.crearEjercicio(cantidadRepeticiones);
        return ejercicio;
    }
    
    /* Metodo usado para crear el ejercicio, simplificando asi entendimiento 
     * de codigo utilizado en el metodo Liskov
    */
    private void crearEjercicio(int cantidadRepeticiones){
        this.setNombre();
        this.setRepeticiones();
        this.cantidadRepeticiones=cantidadRepeticiones;
    }
    
    public int getCantidadRepeticiones(){
        return this.cantidadRepeticiones;
    }
    
    /* Metodo que determina si el ejercicio es por repeticiones o por minutos*/
    public boolean isRepeticiones() {
        return repeticiones;
    }

    public String getNombre(){
        return this.nombre;
    }
    
    public abstract void setNombre();
    public abstract void setRepeticiones();
}

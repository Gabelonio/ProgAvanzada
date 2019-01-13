package LogicaRutinas;

import LogicaEjercicios.Ejercicio;

/**
 *
 * @author Gabelonio
 */
public abstract class Rutina {
    
    protected Ejercicio[] ejercicios;
    
    public Ejercicio[] getEjercicios(){
        return this.ejercicios;
    }
    /*
     * El metodo determinarRepeticiones realiza una consideración y cambia
     * la cantidad de ejercicios a realizar dependiendo del indice de masa
     * muscular de la persona
    */
    public static int determinarRepeticiones(int ejerciciosAsigandos,float peso, int altura){
        double IndiceMasaMuscular=(peso/Math.pow(((double)(altura))/100,2));
        if(IndiceMasaMuscular<16)
            return (int)(0.2*ejerciciosAsigandos);
        if(IndiceMasaMuscular>=16&&IndiceMasaMuscular<=16.99)
            return (int)(0.5*ejerciciosAsigandos);
        if(IndiceMasaMuscular>=17&&IndiceMasaMuscular<=18.49)
            return (int)(0.8*ejerciciosAsigandos);
        if(IndiceMasaMuscular>=18.5&&IndiceMasaMuscular<=24.99)
            return ejerciciosAsigandos;
        if(IndiceMasaMuscular>=25&&IndiceMasaMuscular<=29.99)
            return (int)(2*ejerciciosAsigandos);
        if(IndiceMasaMuscular>=30&&IndiceMasaMuscular<=34.99)
            return (int)(1.8*ejerciciosAsigandos);
        if(IndiceMasaMuscular>=35&&IndiceMasaMuscular<=40)
            return (int)(1.6*ejerciciosAsigandos);
        if(IndiceMasaMuscular>40)
            return (int)(1.3*ejerciciosAsigandos);
        return 0;
    }
    /*  metodo para asignar los ejercicios dependiendo de la necesidad del 
     *  cliente (Rutina)
    */
    public abstract void asignarEjercicios(float peso, int altura);
}

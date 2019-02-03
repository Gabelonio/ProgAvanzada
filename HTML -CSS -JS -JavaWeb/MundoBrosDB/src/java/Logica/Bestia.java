package Logica;

public abstract class Bestia extends Personaje {
    
    protected String CantidadExtremidades; 
   
    @Override
    public String getCaracteristica() {
       return this.CantidadExtremidades; 
    }
}

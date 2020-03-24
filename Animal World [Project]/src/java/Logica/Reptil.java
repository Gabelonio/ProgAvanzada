package Logica;

public abstract class Reptil extends Animal{
    
    private String cantidadExtremidades; 
    
    public void setCantidadExtremidades(String cantidadExtremidades) {
        this.cantidadExtremidades = cantidadExtremidades;
    }
    
    @Override
    public String getCaracteristica() {
        return cantidadExtremidades; 
    }
    
    @Override
    public void setCaracteristica() {
        this.setCantidadExtremidades(cantidadExtremidades);
    }
    
    @Override
    public void setClase() {
        this.Clase="Sauropsida";
    }
}

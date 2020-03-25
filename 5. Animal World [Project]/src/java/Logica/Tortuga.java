package Logica;

public class Tortuga extends Reptil {
    
    public Tortuga(){
        this.setCantidadExtremidades("4");
    }
    
    @Override
    public void setOrden() {
        this.Orden="Linnaeus";
    }

    @Override
    public void setEspecie() {
        this.Especie="Testudines";    
    }
}

package Logica;

public abstract class Ave extends Animal{
   
    private String ColorPlumas; 

    public void setColorPlumas() {
        String[] COLORES={"Negro","Naranja","Blanco con Negro","Azul Celeste"};
        this.ColorPlumas=COLORES[(int)(Math.random() * 4)];
    }

    @Override
    public void setCaracteristica() {
        this.setColorPlumas();    
    }

    @Override
    public String getCaracteristica() {
        return ColorPlumas;    
    }
    
    @Override
    public void setClase() {
        this.Clase="Ave";
    }
}

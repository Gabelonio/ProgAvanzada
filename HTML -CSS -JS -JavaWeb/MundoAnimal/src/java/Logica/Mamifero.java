package Logica;

public abstract class Mamifero extends Animal {
    
    private String ColorPelaje; 

    public void setColorPelaje() {
        String[] COLORES={"Negro","Blanco","Blanco con Negro","Gris","Cafe"};
        this.ColorPelaje=COLORES[(int)(Math.random() * 5)];
    }
    
    @Override
    public void setCaracteristica() {
        this.setColorPelaje();
    }

    @Override
    public String getCaracteristica() {
       return ColorPelaje; 
    }
    @Override
    public void setClase() {
        this.Clase="Mammalia";
    }
}

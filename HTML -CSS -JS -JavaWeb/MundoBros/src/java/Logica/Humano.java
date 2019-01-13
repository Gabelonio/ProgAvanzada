package Logica;

public abstract class Humano extends Personaje{
   
    private String ColorCabello; 

    public void setColorCabello() {
        String[] COLORES={"Negro","Cafe","Blanco","Rojizo"};
        this.ColorCabello=COLORES[(int)(Math.random() * 4)];
    }

    @Override
    public void setCaracteristica() {
        this.setColorCabello();    
    }

    @Override
    public String getCaracteristica() {
        return ColorCabello;    
    }
    
}

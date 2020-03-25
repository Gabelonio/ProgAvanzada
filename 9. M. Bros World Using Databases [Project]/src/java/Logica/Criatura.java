package Logica;

public abstract class Criatura extends Personaje{
    
    private String ColorPiel; 
    
    public void setColorPiel() {
        String[] COLORES={"Negro","Moreno","Blanco"};
        this.ColorPiel=COLORES[(int)(Math.random() * 3)];
    }
    
    @Override
    public String getCaracteristica() {
        return ColorPiel; 
    }
    
    @Override
    public void setCaracteristica() {
        this.setColorPiel();
    }

}

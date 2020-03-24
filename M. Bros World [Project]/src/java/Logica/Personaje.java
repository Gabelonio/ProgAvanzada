package Logica;

public abstract class Personaje {
   
    protected double Altura;
    protected String Color;  
    protected String Nombre; 

    public abstract String getCaracteristica();  //Obtiene la caracteristica especial del animal

    public abstract void setCaracteristica();
    
    public double getAltura() {
        return Altura;
    }

    public void setAltura(double Altura) {
        this.Altura = Altura;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }
       
    public void crearPersonaje(String color,double altura,String nombre){
        this.setCaracteristica();
        this.setAltura(altura);
        this.setColor(color);
        this.setNombre(nombre);
    }
}

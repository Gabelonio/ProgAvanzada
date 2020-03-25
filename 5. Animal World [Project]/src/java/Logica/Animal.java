package Logica;

public abstract class Animal {
   
    protected String Clase;
    protected String Orden; 
    protected String Especie; 
    protected String Nombre; 

    public abstract String getCaracteristica();  //Obtiene la caracteristica especial del animal
   
    public abstract void setOrden();
   
    public abstract void setClase(); 
    
    public abstract void setEspecie();
    
    public abstract void setCaracteristica();
    
    public String getNombre()
    {
        return Nombre;
    }
    
    public String getOrden()
    {
        return Orden;
    }
    
    public String getClase()
    {
        return Clase;
    }
    
    public String getEspecie()
    {
        return Especie;
    }
    
    public void setNombre(String nombre){
        this.Nombre=nombre;
    }
    
    public void crearAnimal(String nombre){
        this.setCaracteristica();
        this.setClase();
        this.setOrden();
        this.setEspecie();
        this.setNombre(nombre);
    }
}

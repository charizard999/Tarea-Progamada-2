import java.io.Serializable;

/**
 * Clase Actividad.
 * 
 * @author (Emilio José Romero) 
 * @version (08/06/2021)
 */
public class Recursos implements Serializable
{
   private String nombre;
   
   public Recursos(String nombre){
    this.nombre = nombre;
    }
    
     public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }

    
    
}

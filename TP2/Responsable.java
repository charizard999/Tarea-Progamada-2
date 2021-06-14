import java.io.Serializable;

/**
 * Clase Responsable.
 * 
 * @author (Emilio José Romero) 
 * @version (08/06/2021)
 */
public class Responsable implements Serializable{
    
    private String nombre;
    
    public Responsable(String nombre){
        this.nombre = nombre;
    }

    public void setNombre( String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }

}

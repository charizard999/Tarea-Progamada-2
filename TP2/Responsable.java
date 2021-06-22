import java.io.Serializable;

/**
 * Clase Responsable.
 * 
 * @author (Emilio José Romero) 
 * @version (08/06/2021)
 */
public class Responsable implements Serializable{
    
    private String nombre;
    /**
     * Constructor de objetos de la clase Responsable.
     */
    public Responsable(String nombre){
        this.nombre = nombre;
    }
      /**
     * Setear Nombre.
     *
     * @param nombre (String) .
     * 
     */
    public void setNombre( String nombre){
        this.nombre = nombre;
    }
           /**
     * Obtener Nombre.
     *
     * 
     * @return  nombre (String)
     */
    public String getNombre(){
        return nombre;
    }

}

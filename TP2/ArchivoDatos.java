import java.io.Serializable;

/**
 * Clase main.
 * 
 * @author (Emilio José Romero) 
 * @version (08/06/2021)
 */
public class ArchivoDatos implements Serializable {
    private String nombreCategoria;
     /**
     * Constructor de objetos de la clase ArchivoDatos.
     */
    public ArchivoDatos(String nombreCategoria){
        this.nombreCategoria = nombreCategoria;
    }
    /**
     * Setear NombreCategoria.
     *
     * @param nombreCategoria (String) .
     * 
     */
    public void setNombreCategoria(String nombreCategoria){
        this.nombreCategoria = nombreCategoria;
    }
         /**
     * Obtener NombreCategoria.
     *
     * 
     * @return  nombreCategoria (String)
     */
    public String getNombreCategoria(){
        return nombreCategoria;
    }

    @Override
    public String toString(){
        return nombreCategoria;
    }
    

}

import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;

/**
 * Clase Actividad.
 * 
 * @author (Emilio José Romero) 
 * @version (08/06/2021)
 */
public class Actividad implements Serializable{

    private int id;
    private String nombre;
    private Date fechaInicio;
    private Date fechaFinal;
    private Responsable responsable;
    private Estimacion estimacion;
    private int gradoAvancce;
    private String estado;//creada, iniciada, finalizada
    private Actividad actividadProxy;
    private ArrayList<Recursos> recursos;
      /**
     * Constructor de objetos de la clase Actividad.
     */
    public Actividad(int id, String nombre, Date fechaInicio, Date fechaFinal,  int gradoAvancce){
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.gradoAvancce = gradoAvancce;
        this.recursos = new ArrayList();
        

    }
       /**
     * Setear Id.
     *
     * @param id (int) .
     * 
     */
    public void setId( int id){
        this.id = id;
    }
            /**
     * Obtener Id.
     *
     * 
     * @return  id (int)
     */
    public int getId(){
        return id;
    }
      /**
     * Setear Recursos.
     *
     * @param recursos (ArrayList<Recursos>) .
     * 
     */
    public void setRecursos( ArrayList<Recursos> recursos){
        this.recursos = recursos;
    }
              /**
     * Obtener Recursos.
     *
     * 
     * @return  recursos (ArrayList<Recursos>)
     */
    public ArrayList<Recursos> getRecursos(){
        return recursos;
    }
       /**
     * Setear Nombre.
     *
     * @param nombre (String) .
     * 
     */
    public void setNombre(String nombre){
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
         /**
     * Setear GradoAvancce.
     *
     * @param gradoAvancce (int) .
     * 
     */
    public void setGradoAvancce(int gradoAvancce){
        this.gradoAvancce = gradoAvancce;
    }
             /**
     * Obtener GradoAvancce.
     *
     * 
     * @return  gradoAvancce (int)
     */
    public int getGradoAvancce(){
        return gradoAvancce;
    }
           /**
     * Setear FechaInicio.
     *
     * @param fechaInicio (Date) .
     * 
     */
    public void setFechaInicio(Date fechaInicio){
        this.fechaInicio = fechaInicio;
    }
               /**
     * Obtener FechaInicio.
     *
     * 
     * @return  fechaInicio (Date)
     */
    public Date getFechaInicio(){
        return fechaInicio;
    }
             /**
     * Setear FechaFinal.
     *
     * @param fechaFinal (Date) .
     * 
     */

    public void setFechaFinal(Date fechaFinal){
        this.fechaFinal = fechaFinal;
    }
                 /**
     * Obtener FechaInicio.
     *
     * 
     * @return  fechaFinal (Date)
     */
    public Date getFechaFinal(){
        return fechaFinal;
    }
              /**
     * Setear Responsable.
     *
     * @param responsable (Responsable) .
     * 
     */
    public void setResponsable(Responsable responsable){
        this.responsable = responsable;
    }             
    /**
     * Obtener Responsable.
     *
     * 
     * @return  responsable (Responsable)
     */
    public Responsable getResponsable(){
        return responsable;
    }
                /**
     * Setear Estimacion.
     *
     * @param estimacion (Estimacion) .
     * 
     */
    public void setEstimacion(Estimacion estimacion){
        this.estimacion = estimacion;
    }
               /**
     * Obtener Estimacion.
     *
     * 
     * @return  estimacion (Estimacion)
     */
    public Estimacion getEstimacion(){
        return estimacion;
    }
               /**
     * Setear Estado.
     *
     * @param estado (String) .
     * 
     */
    public void setEstado(String estado){
        this.estado = estado;
    }
    
              /**
     * Obtener ActividadProxy.
     *
     * 
     * @return  actividadProxy (Actividad)
     */
     public Actividad getActividadProxy(){
        return actividadProxy;
    }
                 /**
     * Setear ActividadProxy.
     *
     * @param actividadProxy (Actividad) .
     * 
     */
    public void setActividadProxy(Actividad ActividadProxy){
        this.actividadProxy = actividadProxy;
    }
               /**
     * Obtener Estado.
     *
     * 
     * @return  estado (String)
     */
    public String getEstado(){
        return estado;
    }
    /**
     * Imprime los recursos.
     */
     public void imprimirRecursos(){
        int contador = 1;
        for(Recursos r : recursos){
            System.out.println(contador + ". " + r.getNombre());
            contador++;
        }
    }
    /**
     * Imprime los  recursos en orden en el tablero.
     */
    public void imprimirRecursosTablero(){
        int contador = 1;
        for(Recursos r : recursos){
            System.out.println("                             "+contador + ". " + r.getNombre());
            contador++;
        }
    }
    /**
     * Comprueba que exista el recurso.
     * 
     * @param  nombreRecurso (String)
     * @return  boolean
     */
    public boolean buscarRecurso(String nombreRecurso){
        for(Recursos r: recursos){
               if(r.getNombre().toUpperCase().equals(nombreRecurso.toUpperCase())){
                    return true;
               }
            
        }
        return false;
    }
    /**
     * Obtiene el recurso por medio de un int.
     * 
     * @param  i (int)
     * @return  r (Recursos)
     */
     public Recursos getRecursoIndex(int i){
        int contador = 1 ; 
        for(Recursos r: recursos){
            if(contador == i){
                return r;
            }
            contador++;
        }
        return null;

    }
    
    
    
}

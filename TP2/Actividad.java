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
     * Constructor for objects of class xd
     */
    public Actividad(int id, String nombre, Date fechaInicio, Date fechaFinal,  int gradoAvancce){
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.gradoAvancce = gradoAvancce;
        this.recursos = new ArrayList();
        

    }
    
    public void setId( int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setRecursos( ArrayList<Recursos> recursos){
        this.recursos = recursos;
    }
    public ArrayList<Recursos> getRecursos(){
        return recursos;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }

    public void setGradoAvancce(int gradoAvancce){
        this.gradoAvancce = gradoAvancce;
    }
    public int getGradoAvancce(){
        return gradoAvancce;
    }

    public void setFechaInicio(Date fechaInicio){
        this.fechaInicio = fechaInicio;
    }
    public Date getFechaInicio(){
        return fechaInicio;
    }

    public void setFechaFinal(Date fechaFinal){
        this.fechaFinal = fechaFinal;
    }
    public Date getFechaFinal(){
        return fechaFinal;
    }

    public void setResponsable(Responsable responsable){
        this.responsable = responsable;
    }
    public Responsable getResponsable(){
        return responsable;
    }

    public void setEstimacion(Estimacion estimacion){
        this.estimacion = estimacion;
    }
    public Estimacion getEstimacion(){
        return estimacion;
    }

    public void setEstado(String estado){
        this.estado = estado;
    }
    
     public Actividad getActividadProxy(){
        return actividadProxy;
    }

    public void setActividadProxy(Actividad ActividadProxy){
        this.actividadProxy = actividadProxy;
    }
    public String getEstado(){
        return estado;
    }
    
     public void imprimirRecursos(){
        int contador = 1;
        for(Recursos r : recursos){
            System.out.println(contador + ". " + r.getNombre());
            contador++;
        }
    }
    
    public void imprimirRecursosTablero(){
        int contador = 1;
        for(Recursos r : recursos){
            System.out.println("                             "+contador + ". " + r.getNombre());
            contador++;
        }
    }
    
    public boolean buscarRecurso(String nombreRecurso){
        for(Recursos r: recursos){
               if(r.getNombre().toUpperCase().equals(nombreRecurso.toUpperCase())){
                    return true;
               }
            
        }
        return false;
    }
    
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

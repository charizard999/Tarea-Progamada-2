import java.io.Serializable;
import java.util.Date;

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

    /**
     * Constructor for objects of class xd
     */
    public Actividad(int id, String nombre, Date fechaInicio, Date fechaFinal,  int gradoAvancce){
        this.id = id;
        this.nombre = nombre;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.gradoAvancce = gradoAvancce;

        

    }
    
    public void setId( int id){
        this.id = id;
    }
    public int getId(){
        return id;
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

}

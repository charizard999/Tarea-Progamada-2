import java.io.Serializable;

/**
 * Clase Estimacion.
 * 
 * @author (Emilio José Romero) 
 * @version (08/06/2021)
 */
public class Estimacion implements Serializable{
    
    private int tiempo;
    private double dinero;
    private int esfuerzo;
     /**
     * Constructor de objetos de la clase Estimacion.
     */
    public Estimacion(int tiempo, double dinero, int esfuerzo ){
        this.tiempo = tiempo;
        this.dinero = dinero;
        this.esfuerzo = esfuerzo;

    }
    /**
     * Setear Tiempo.
     *
     * @param tiempo (int) .
     * 
     */
    public void setTiempo( int tiempo){
        this.tiempo = tiempo;
    }
         /**
     * Obtener Tiempo.
     *
     * 
     * @return  tiempo (int)
     */
    public int getTiempo(){
        return tiempo;
    }
     /**
     * Setear Dinero.
     *
     * @param dinero (double) .
     * 
     */
    public void setDinero( double dinero){
        this.dinero = dinero;
    }
        /**
     * Obtener Dinero.
     *
     * 
     * @return  dinero (int)
     */
    public double getDinero(){
        return dinero;
    }
    /**
     * Setear Esfuerzo.
     *
     * @param esfuerzo (int) .
     * 
     */
    public void setEsfuerzo( int esfuerzo){
        this.esfuerzo = esfuerzo;
    }
        /**
     * Obtener Esfuerzo.
     *
     * 
     * @return  esfuerzo (int)
     */
    public int getEsfuerzo(){
        return esfuerzo;
    }
    
}

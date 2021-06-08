/**
 * Clase Estimacion.
 * 
 * @author (Emilio José Romero) 
 * @version (08/06/2021)
 */
public class Estimacion {
    
    private int tiempo;
    private double dinero;
    private int esfuerzo;

    public Estimacion(int tiempo, double dinero, int esfuerzo ){
        this.tiempo = tiempo;
        this.dinero = dinero;
        this.esfuerzo = esfuerzo;

    }

    public void setTiempo( int tiempo){
        this.tiempo = tiempo;
    }
    public int getTiempo(){
        return tiempo;
    }

    public void setDinero( double dinero){
        this.dinero = dinero;
    }
    public double getDinero(){
        return dinero;
    }

    public void setEsfuerzo( int esfuerzo){
        this.esfuerzo = esfuerzo;
    }
    public int getEsfuerzo(){
        return esfuerzo;
    }
    
}

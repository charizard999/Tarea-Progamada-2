import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;

public class Categoria implements Serializable{

    private String nombre;
    private int id;
    private ArrayList<Actividad> listaActividades;

    public Categoria(String nombre, int id){
        this.nombre = nombre;
        this.id = id;
        listaActividades = new ArrayList<>();

    }

    public Categoria(){

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

    public void setListaActividades(ArrayList<Actividad> listaActividades){
        this.listaActividades = listaActividades;
    }
    public ArrayList<Actividad> getListaActividades(){
        return listaActividades;
    }

    public void eliminarActividad(String nombre){
        Actividad aux  = null;
        for(Actividad a: listaActividades){
            if(a.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                aux = a;
            }
        }
        listaActividades.remove(aux);

    }


    public boolean existeActividad(String nombre){
        for(Actividad actividad : listaActividades){
            if(actividad.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                return true;
            }
        }
        return false;


    }

    public void imprimirActividades(){
        for(Actividad actividad : listaActividades){
            System.out.println();
            System.out.println("Id: "+ actividad.getId());
            System.out.println("Nombre: "+ actividad.getNombre());
            System.out.println("Fecha de inicio: "+ actividad.getFechaInicio());
            System.out.println("Fecha Final: "+ actividad.getFechaFinal());
            System.out.println("Responsable : "+ actividad.getResponsable().getNombre());
            System.out.println("Presupuesto : "+ actividad.getEstimacion().getDinero() + "$.");
            System.out.println("Esfuerzo : "+ actividad.getEstimacion().getEsfuerzo()+ "/10");
            System.out.println("Tiempo : "+ actividad.getEstimacion().getTiempo()+ " horas.");
            System.out.println("Grado de avance : "+ actividad.getGradoAvancce()+ "%.");
            System.out.println("Estado : "+ actividad.getEstado());
        }
        
    }

    public void mostrarActividad(String nombre){
        for(Actividad actividad : listaActividades){
            if(actividad.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                System.out.println();
                System.out.println("Id: "+ actividad.getId());
                System.out.println("Nombre: "+ actividad.getNombre());
                System.out.println("Fecha de inicio: "+ actividad.getFechaInicio());
                System.out.println("Fecha Final: "+ actividad.getFechaFinal());
                System.out.println("Responsable : "+ actividad.getResponsable().getNombre());
                System.out.println("Presupuesto : "+ actividad.getEstimacion().getDinero() + "$.");
                System.out.println("Esfuerzo : "+ actividad.getEstimacion().getEsfuerzo()+ "/10");
                System.out.println("Tiempo : "+ actividad.getEstimacion().getTiempo()+ " horas.");
                System.out.println("Grado de avance : "+ actividad.getGradoAvancce()+ "%.");
                System.out.println("Estado : "+ actividad.getEstado());
                
            }
        }
    }

    public boolean buscarResponsable(String nombreResponsable){
        for(Actividad actividad : listaActividades){
            if( actividad.getResponsable().getNombre().toUpperCase().equals(nombreResponsable.toUpperCase())){
                return true;
            }
        }
        return false;
    }

    public void modificarActividad(Actividad actividad ){
        System.out.println("Desea modificar el nombre?(Si/No)");
        Scanner sc = new Scanner(System.in);
        if(){

        }
    }


}

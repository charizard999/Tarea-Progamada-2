import java.util.ArrayList;
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

    public void agregarActividad(Actividad actividad){
        

    }


    public boolean existeActividad(String nombre){
        for(Actividad actividad : listaActividades){
            if(actividad.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                return true;
            }
        }
        return false;
    }
}

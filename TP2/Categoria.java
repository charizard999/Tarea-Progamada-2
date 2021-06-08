import java.util.ArrayList;

public class Categoria {

    private String nombre;
    private int id;
    private ArrayList<Actividad> listaActividades;

    public Categoria(String nombre, int id){
        this.nombre = nombre;
        this.id = id;

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
}

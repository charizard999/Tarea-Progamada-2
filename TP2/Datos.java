import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Datos {

    private ArrayList<Categoria>categorias;
    private ArrayList<ArchivoDatos> archivoDatos;
    

    public Datos(){
        categorias = new ArrayList<>();
        archivoDatos = new ArrayList<>();
    }

    public void setCategorias(ArrayList<Categoria> categorias){
        this.categorias = categorias;
    }
    public ArrayList<Categoria> getCategorias(){
        return categorias;
    }

    public void setArchivoDatos(ArrayList<ArchivoDatos> archivoDatos){
        this.archivoDatos = archivoDatos;
    }
    public ArrayList<ArchivoDatos> getArchivoDatos(){
        return archivoDatos;
    }


    public Categoria recuperarCategoria(String nombre){
        for(Categoria ct: categorias){
            if(ct.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                return ct;
            }
        }
        return null;
    }

    public void escribirFichero(Object ob, String nombreArchivo){
        try{
            ObjectOutputStream escribiendoFichero = new ObjectOutputStream( 
            new FileOutputStream(nombreArchivo + ".txt") );
            escribiendoFichero.writeObject(ob);
            escribiendoFichero.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Object leerFichero(String nombreArchivo){
        try{
            ObjectInputStream leyendoFichero = new ObjectInputStream( 
            new FileInputStream(nombreArchivo + ".txt") );
            Object object = (Object)leyendoFichero.readObject();
            leyendoFichero.close();
            return object;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    

}

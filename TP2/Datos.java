import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Datos {

    private ArrayList<Categoria>categorias;
    private ArrayList<ArchivoDatos> archivoDatos;
    

    public Datos(){
        categorias = new ArrayList<>();
        Object object = (Object)leerFichero("nombreDeListas");
        archivoDatos = (ArrayList<ArchivoDatos>)object;
        if(archivoDatos == null){
            archivoDatos = new ArrayList<>();
        }else{
            for (ArchivoDatos archivoDatos2 : archivoDatos) {
                Object object2 = (Object)leerFichero(archivoDatos2.getNombreCategoria());
                Categoria ct = (Categoria)object2;
                categorias.add(ct);
            }
        }
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
            //e.printStackTrace();
            return null;
        }
    }

    public boolean existeLista(String nombre){
        for(Categoria categoria : categorias){
            if(categoria.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                return true;
            }
        }
        return false;
    }
    
    public Date parseDate(String fecha){
        try {
            Date date = new SimpleDateFormat("dd/mm/yyyy").parse(fecha);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

}

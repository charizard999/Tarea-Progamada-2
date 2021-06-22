import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;
/**
 * Clase Datos.
 * 
 * @author (Emilio Romero) 
 * @version (08/06/2021)
 */
public class Datos implements Serializable {

    private ArrayList<Categoria>categorias;
    private ArrayList<ArchivoDatos> archivoDatos;
    private ArrayList<Responsable>responsables;
    
    /**
     * Constructor de objetos de la clase Datos.
     */
    public Datos(){
        categorias = new ArrayList<>();
        responsables = new ArrayList<>();
        archivoDatos = new ArrayList<>();
    }
    
    /**
     * Setear categorías.
     *
     * @param categorias (ArrayList<Categoria>) .
     * 
     */
    public void setCategorias(ArrayList<Categoria> categorias){
        this.categorias = categorias;
    }
       /**
     * Obtener categorías.
     *
     * 
     * @return  categorias (ArrayList<Categoria>)
     */
    public ArrayList<Categoria> getCategorias(){
        return categorias;
    }
    /**
     * Setear ArchivoDatos.
     *
     * @param archivoDatos (ArrayList<ArchivoDatos>) .
     * 
     */
    public void setArchivoDatos(ArrayList<ArchivoDatos> archivoDatos){
        this.archivoDatos = archivoDatos;
    }
      /**
     * Obtener ArchivoDatos.
     *
     * 
     * @return  archivoDatos (ArrayList<ArchivoDatos>)
     */
    public ArrayList<ArchivoDatos> getArchivoDatos(){
        return archivoDatos;
    }
    /**
     * Setear Responsable.
     *
     * @param responsables (ArrayList<Responsable>) 
     * 
     */
    public void setResponsables(ArrayList<Responsable> responsables){
        this.responsables = responsables;
    }
      /**
     * Obtener Responsable.
     *
     * 
     * @return  responsables (ArrayList<Responsable>)
     */
    public ArrayList<Responsable> getResponsables(){
        return responsables;
    }
     /**
     * Verifica que exista el responsable.
     * 
     * @param  nombre (String)
     * @return  boolean
     */
    public boolean existeResponsable(String nombre){
        for(Responsable r : responsables){
            if(r.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                return true;
            }
        }
        return false;
    }
     /**
     * Se obtinene el responsable.
     * 
     * @param  nombre (String)
     * @return  r (Responsable)
     */
    public Responsable recuperarResponsable(String nombre){
        for(Responsable r: responsables){
            if(r.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                return r;
            }
        }
        return null;
    }
      /**
     * Se obtinene la categoría.
     * 
     * @param  nombre (String)
     * @return  ct (Categoria)
     */
    public Categoria recuperarCategoria(String nombre){
        for(Categoria ct: categorias){
            if(ct.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                return ct;
            }
        }
        return null;
    }
      /**
     * Escribe en el fichero.
     * 
     * @param  ob (Object), nombreArchivo (String)
     * 
     */
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
     /**
     * Lee el fichero.
     * 
     * @param  nombreArchivo (String)
     * 
     */
    public Object leerFichero(String nombreArchivo){
        try{
            ObjectInputStream leyendoFichero = new ObjectInputStream( 
            new FileInputStream(nombreArchivo + ".txt") );
            Object object = (Object)leyendoFichero.readObject();
            leyendoFichero.close();
            return object;
        }catch(Exception e){
            return null;
        }
    }
     /**
     * Comprueba que exista una lista.
     * 
     * @param  nombre (String)
     * 
     */
    public boolean existeLista(String nombre){
        for(Categoria categoria : categorias){
            if(categoria.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                return true;
            }
        }
        return false;
    }
     /**
     * Pasa un String a Date.
     * 
     * @param  fecha (String)
     * @return  date (Date)
     */
    public Date parseDate(String fecha){
        try {
            Date date = new SimpleDateFormat("dd/mm/yyyy").parse(fecha);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }
    /**
     * Imprime responsables.
     */
    public void imprimirResponsables(){
        int contador = 1 ; 
        for(Responsable r : responsables){
            System.out.println(contador + ". " + r.getNombre());
            contador++;
        }
    }
    /**
     * Busca por medio de un int el respectivo responsable.
     * 
     * @param  i (int)
     * @return  responsables (Responsable)
     */
    public Responsable responsableIndex(int i){
        int contador= 1 ;
        for(Responsable r : responsables){
            if(contador == i){
                System.out.println(r.getNombre());
                return r;
            }
            contador ++;
        }
        return null;
    }
     /**
     * Elimina el fichero.
     * 
     * @param  nombre (String)
     * @return  boolean
     */
    public boolean eliminarFichero(String nombre){
        File fichero = new File(nombre + ".txt");
        return fichero.delete();
    } 
    /**
     * Elimina la categaría.
     * 
     * @param  nombre (String)
     */
    public void eliminarCategoria(String nombre){
        Categoria aux  = null;
        for(Categoria c: categorias){
            if(c.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                aux = c;
            }
        }
        categorias.remove(aux);
    } 
    public void eliminarArchivoDatos(String nombre){
        ArchivoDatos aux  = null;
        for(ArchivoDatos a: archivoDatos){
            if(a.getNombreCategoria().toUpperCase().equals(nombre.toUpperCase())){
                aux = a;
            }
        }
        archivoDatos.remove(aux);
    } 
    /**
     * Recupera ArchivoDatos.
     * 
     * @param  nombre (String)
     * @return  a (ArchivoDatos)
     */
    public ArchivoDatos recuperarArchivoDatos(String nombre){
        for(ArchivoDatos a: archivoDatos){
            if(a.getNombreCategoria().toUpperCase().equals(nombre.toUpperCase())){
                return a;
            }
        }
        return null;
    }
     /**
     * Imprime las categorías.
     */
    public void imprimirCategarias(){
        int cont = 1;
        for(Categoria a: categorias){
            System.out.println(cont + ". " + a.getNombre());
            cont++;
        }
    }
     /**
     * Busca si existe el responsable.
     * 
     * @param  nombreResponsable (String)
     * @return  boolean
     */
    public boolean buscarResponsable(String nombreResponsable){
        for(Categoria c: categorias){
               if(c.buscarResponsable(nombreResponsable)){
                    return true;
               }
            
        }
        return false;
    }
    /**
     * Obtiene el responsable por medio de un int.
     * 
     * @param  i (int)
     * @return  r (Responsable)
     */
    public Responsable getResponsableIndex(int i){
        int contador = 1 ; 
        for(Responsable r : responsables){
            if(contador == i){
                return r;
            }
            contador++;
        }
        return null;

    }
        /**
     * Muestra el tablero.
     */
    public void mostrarTablero(){
        String titulos[]={"TAREAS", "HACIENDO","FINALIZADAS"};
        for(int i=0; i<titulos.length;i++){
            System.out.print(titulos[i]+"                      ");
        }
            System.out.println(); 
        for(Categoria c: categorias){
              System.out.println("Nombre de la lista: "+c.getNombre()); 
            for(Actividad a: c.getListaActividades()){
                if(a.getEstado().equals("Creada")){
                    System.out.print(a.getNombre()+"                       ");  
                    
                }else{
                    System.out.print("                             ");  
                }
                if(a.getEstado().equals("Iniciada")){
                   System.out.println(a.getNombre()+"                       ");  
                   System.out.println("                             RECURSOS                        ");  
                   a.imprimirRecursosTablero();
                   System.out.println("                             DATOS ADMINSTRATIVOS                        ");  
                   System.out.println("                             Inicio: "+a.getFechaInicio());  
                   System.out.println("                             Responsable: "+a.getResponsable().getNombre());  
                   System.out.println("                             Duracion: "+a.getEstimacion().getTiempo());  
                }else{
                    System.out.print("                                    ");  
                }
                
                if(a.getEstado().equals("Finalizada")){
                    System.out.print(a.getNombre()+"                       ");  
                }else{
                    System.out.print("                           ");  
                }
                 System.out.println(""); 
            }
            System.out.println(""); 
        }
    }
}

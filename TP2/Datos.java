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

public class Datos implements Serializable {

    private ArrayList<Categoria>categorias;
    private ArrayList<ArchivoDatos> archivoDatos;
    private ArrayList<Responsable>responsables;

    public Datos(){
        categorias = new ArrayList<>();
         responsables = new ArrayList<>();
            archivoDatos = new ArrayList<>();
        /*Object object = (Object)leerFichero("nombreDeListas");
        archivoDatos = (ArrayList<ArchivoDatos>)object;
        if(archivoDatos == null){
            archivoDatos = new ArrayList<>();
        }else{
            System.out.println(archivoDatos);
            for (ArchivoDatos archivoDatos2 : archivoDatos) {
                Object object2 = (Object)leerFichero(archivoDatos2.getNombreCategoria());
                Categoria ct = (Categoria)object2;
                if(ct != null){
                    System.out.println(archivoDatos2.getNombreCategoria());
                    System.out.println(ct.getNombre());
                    categorias.add(ct);
                }
               

            }
        }
        Object object2 = (Object)leerFichero("Responsables");
        responsables = (ArrayList<Responsable>)object2;
        if(responsables == null){
            responsables = new ArrayList<>();
        }*/
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

    public void setResponsables(ArrayList<Responsable> responsables){
        this.responsables = responsables;
    }
    public ArrayList<Responsable> getResponsables(){
        return responsables;
    }

    public boolean existeResponsable(String nombre){
        for(Responsable r : responsables){
            if(r.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                return true;
            }
        }
        return false;
    }

    public Responsable recuperarResponsable(String nombre){
        for(Responsable r: responsables){
            if(r.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                return r;
            }
        }
        return null;
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

    public void imprimirResponsables(){
        int contador = 1 ; 
        for(Responsable r : responsables){
            System.out.println(contador + ". " + r.getNombre());
            contador++;
        }
    }

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

    public boolean eliminarFichero(String nombre){
        File fichero = new File(nombre + ".txt");
        return fichero.delete();
    } 
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

    public ArchivoDatos recuperarArchivoDatos(String nombre){
        for(ArchivoDatos a: archivoDatos){
            if(a.getNombreCategoria().toUpperCase().equals(nombre.toUpperCase())){
                return a;
            }
        }
        return null;
    }

    public void imprimirCategarias(){
        int cont = 1;
        for(Categoria a: categorias){
            System.out.println(cont + ". " + a.getNombre());
            cont++;
        }
    }

    public boolean buscarResponsable(String nombreResponsable){
        for(Categoria c: categorias){
               if(c.buscarResponsable(nombreResponsable)){
                    return true;
               }
            
        }
        return false;
    }

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

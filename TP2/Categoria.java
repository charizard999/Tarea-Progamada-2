import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

    public void modificarActividad(Actividad actividad, ArrayList<Responsable> responsables){
        System.out.println("Desea modificar el nombre?(S/N)");
        Scanner sc = new Scanner(System.in);
        String respuesta = sc.next();
        if( respuesta.toUpperCase().equals("S")){
            System.out.println("Digite el nuevo nombre de la actividad.");
            sc.nextLine();
            String nuevoNombre = sc.nextLine();
            actividad.setNombre(nuevoNombre);
        }
        System.out.println("Desea modificar la fecha de inicio?(S/N)");
        String respuesta2 = sc.next();
        if( respuesta2.toUpperCase().equals("S")){
            System.out.println("Digite la nueva fecha de inicio de la actividad.");
            sc.nextLine();
            String nuevoFecha = sc.nextLine();
            actividad.setFechaInicio(parseDate(nuevoFecha));
        }
        System.out.println("Desea modificar la fecha de final?(S/N)");
        String respuesta3 = sc.next();
        if( respuesta3.toUpperCase().equals("S")){
            System.out.println("Digite la nueva fecha de final de la actividad.");
            sc.nextLine();
            String nuevoFecha = sc.nextLine();
            actividad.setFechaFinal(parseDate(nuevoFecha));
        }
        System.out.println("Desea modificar el grado de avance?(S/N)");
        String respuesta4 = sc.next();
        if( respuesta4.toUpperCase().equals("S")){
            System.out.println("Digite el nuevo grado de avance de la actividad.");
            int nuevoGradoDeAvance = sc.nextInt();
            actividad.setGradoAvancce(nuevoGradoDeAvance);
        }
        System.out.println("Desea modificar la duracion de la actividad?(S/N)");
        String respuesta5 = sc.next();
        if( respuesta5.toUpperCase().equals("S")){
            System.out.println("Defina la duracion de la actividad (Horas).");
            int duracion = sc.nextInt();
            actividad.getEstimacion().setTiempo(duracion);
        }
        System.out.println("Desea modificar el presupuesto de la actividad?(S/N)");
        String respuesta6 = sc.next();
        if( respuesta6.toUpperCase().equals("S")){
            System.out.println("Defina  el presupuesto (Dolares).");
            double dinero = sc.nextDouble();
            actividad.getEstimacion().setDinero(dinero);
        }
        System.out.println("Desea modificar el esfuerzo realizado en la actividad?(S/N)");
        String respuesta7 = sc.next();
        if( respuesta7.toUpperCase().equals("S")){
            System.out.println("Defina esfuerzo realizado en la actividad en un rango de 0 a 10.");
            int esfuerzo = sc.nextInt();
            actividad.getEstimacion().setEsfuerzo(esfuerzo);
        }
        System.out.println("Desea modificar el  responsble de la actividad?(S/N)");
        String respuesta8 = sc.next();
        if( respuesta8.toUpperCase().equals("S")){

            System.out.println("Escoja el numero del responsable para la actividad.");
            imprimirResponsables(responsables);
            int responsable = sc.nextInt();
            actividad.setResponsable(responsableIndex(responsable, responsables));
        }
        System.out.println("Actividad modificada correctamente.");
    }
    
    
    
    public Date parseDate(String fecha){
        try {
            Date date = new SimpleDateFormat("dd/mm/yyyy").parse(fecha);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }

    public void imprimirResponsables(ArrayList<Responsable> responsables){
        int contador = 1 ; 
        for(Responsable r : responsables){
            System.out.println(contador + ". " + r.getNombre());
            contador++;
        }
    }

    
    public Responsable responsableIndex(int i, ArrayList<Responsable> responsables ){
        int contador= 1 ;
        for(Responsable r : responsables){
            if(contador == i){
                return r;
            }
            contador++;
        }
        return null;
    }

    public Actividad recuperarActividad(String nombre){
        for(Actividad actividad : listaActividades){
            if(actividad.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                return actividad;
            }
        }
        return null;


    }

    
    public Actividad actividadIndex(int i){
        int contador= 1 ;
            for(Actividad a : listaActividades){
            if(contador == i){
                return a;
            }
        }
        return null;
    }
    
     public int getIndexActividad(String nombre){
        int contador= 1 ;
            for(Actividad actividad : listaActividades){
            if(actividad.getNombre().toUpperCase().equals(nombre.toUpperCase())){
                return contador;
            }
            contador++;
        }
        return contador;
    }
}

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * Clase main.
 * 
 * @author (Emilio José Romero) 
 * @version (08/06/2021)
 */
public class App {

    /**
     * Este metodo limpia la consola.
     */
    public static void limpiarConsola(){
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
    
     /**
     * Este metodo limpia el menu.
     */
    public static void limpiarMenu(Scanner sc){
        String readString = sc.nextLine();
        System.out.println(readString);
        if (readString.equals(""))
            System.out.println("Presione enter" );
        if (sc.hasNextLine())
            readString = sc.nextLine();
        else
            readString = null;
        limpiarConsola();
    }

   
    
    public static void main(String[] args) throws Exception {
       
        
        Datos datos= new Datos();
        
        Scanner sc = new Scanner(System.in);
        int opc = 0;
        do{
            
            System.out.println("1. Crear Lista.");
            System.out.println("2. Agregar Responsables.");
            System.out.println("3. Agregar Actividad.");
            System.out.println("4. Modificar Lista.");
            System.out.println("5. Consultar Lista.");
            System.out.println("6. Guardar datos.");
            System.out.println("7. Buscar Lista.");
            System.out.println("8. Salir.");
            opc = sc.nextInt();
            switch(opc){
                case 1 :{
                    System.out.println("Defina el nombre de la categoria : ");
                    String nombreCategoria = sc.next();
                    if(!datos.existeLista(nombreCategoria)){
                        Categoria ct = new Categoria(nombreCategoria, datos.getCategorias().size());
                        System.out.println("nombre nuevo "+ ct.getNombre());
                        datos.escribirFichero((Object)ct, nombreCategoria);
                        Object ob = datos.leerFichero(nombreCategoria);
                        Categoria ct2 = (Categoria)ob;
                        System.out.println(ct2.getNombre());
                        ArchivoDatos ad = new ArchivoDatos(nombreCategoria);
                        datos.getArchivoDatos().add(ad);
                        datos.escribirFichero((Object)datos.getArchivoDatos(), "nombreDeListas"); 
                        System.out.println("La categoría se guardó correctamente.");
                    }else{
                        System.out.println("La categoría ya existe.");
                    }   
                    limpiarMenu(sc); 
                break;
            }
                case 2 :{
                    System.out.println("Defina el nombre del responsable: ");
                    String nombreResponsable = sc.next();
                    if(!datos.existeResponsable(nombreResponsable)){
                        Responsable responsable = new Responsable(nombreResponsable);
                        datos.getResponsable().add(responsable);
                        datos.escribirFichero((Object)datos.getResponsable(), "Responsables");
                        System.out.println("Se agrego correctamente.");
                    }else{
                        System.out.println("El responsable ya existe.");
                    }
                    limpiarMenu(sc);   
                break;
                }
                case 3 :{
                    System.out.println("Cual es la categoria de la actividad?");
                    String nombreCategoria = sc.next();
                    if(datos.existeLista(nombreCategoria)){
                        Categoria ct = datos.recuperarCategoria(nombreCategoria);
                        System.out.println("Defina el nombre de la actividad.");
                        String nombre = sc.next();
                        if(!ct.existeActividad(nombre)){
                            System.out.println("Defina la fecha de inicio.");
                            String date = sc.next();
                            System.out.println("Defina la fecha de final.");
                            String date2 = sc.next();
                            System.out.println("Defina el porcentaje de avance de la tarea.");
                            int gradoAvance = sc.nextInt();
                            System.out.println("Defina la duracion de la actividad.");
                            int duracion = sc.nextInt();
                            System.out.println("Defina  el presupuesto.");
                            double dinero = sc.nextDouble();
                            System.out.println("Defina de la actividad en un rango de 0 a 10.");
                            int esfuerzo = sc.nextInt();
                            Actividad actividad = new Actividad(ct.getListaActividades().size(), nombreCategoria, datos.parseDate(date), datos.parseDate(date2), gradoAvance);
                            actividad.setEstimacion(new Estimacion(duracion, dinero, esfuerzo));
                            ct.getListaActividades().add(actividad);
                            System.out.println("Escoja el numero del responsable para la actividad.");
                            datos.imprimirResponsables();
                            int responsable = sc.nextInt();
                            actividad.setResponsable(datos.responsableIndex(responsable));
                            datos.escribirFichero((Object)ct, ct.getNombre());
                            System.out.println("Se agregó correctamente.");
                        }
                       
                    }else{
                        System.out.println("La categoria no existe.");
                    }
                    
                   

                break;
                }
                case 4 :

                break;
                case 5 :

                break;
                case 6 :

                break;
                case 7 :

                break;
            }
        }while(opc != 8);
    }

}

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
            System.out.println("2. Definir Lista.");
            System.out.println("3. Agregar Actividad.");
            System.out.println("4. Modificar Lista.");
            System.out.println("5. Consultar Lista.");
            System.out.println("6. Guardar datos.");
            System.out.println("7. Buscar Lista.");
            System.out.println("8. Salir.");
            opc = sc.nextInt();
            switch(opc){
                case 1 :
                System.out.println("Defina el nombre de la categoria : ");
                String nombreCategoria = sc.next();
                Categoria ct = new Categoria(nombreCategoria, datos.getCategorias().size());
                datos.getCategorias().add(ct);
                datos.escribirFichero((Object)datos.getCategorias(), nombreCategoria);
                datos.getArchivoDatos();//dasfadafdadfafd                
                break;
                case 2 :
              
                break;
                case 3 :
                System.out.println("Cual es la categaria de la actividad?");
                String nombreActividad = sc.next();
                //verificar que la categoria existe
                System.out.println("Defina el nombre de la actividad.");
                String nombre = sc.next();
                System.out.println("Defina la fecha de inicio.");
                String date = sc.next();
                System.out.println("Defina la fecha de final.");
                String date2 = sc.next();
                System.out.println("Defina el porcentaje de avance de la tarea.");
                int gradoAvance = sc.nextInt();
                

                break;
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

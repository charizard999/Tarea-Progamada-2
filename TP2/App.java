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
     * Limpia la consola.
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
     * lee el fichero.
     * 
     * @param  nombreArchivo (String)
     * @return  object (Object)
     */

    public static Object leerFichero(String nombreArchivo){
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
     *Limpia el menu.
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
        Datos datos= (Datos)leerFichero("Datos");
        if(datos==null){
            datos =new Datos();
        }
        Categoria categoria = new Categoria();
        
        Scanner sc = new Scanner(System.in);
        int opc = 0;

        do{
            System.out.println("1. Crear Lista.");//
            System.out.println("2. Agregar Responsables.");//
            System.out.println("3. Agregar Actividad.");//
            System.out.println("4. Iniciar Actividad.");//revisar
            System.out.println("5. Consultar Actividades.");//
            System.out.println("6. Modificar Lista.");//
             System.out.println("7. Consultar Lista.");//
            System.out.println("8. Consultar Actividad en especifico.");//
            System.out.println("9. Eliminar categoría.");//
            System.out.println("10. Eliminar actividad.");//
            System.out.println("11. Eliminar responsable.");//
            System.out.println("12. Mostrar Tablero");
            System.out.println("13. Mostrar Responsables");//
            System.out.println("14. Modificar actividad.");//
            System.out.println("15. Agregar recursos de la Actividad.");//
            System.out.println("16. Eliminar recursos de la Actividad.");//
            System.out.println("17. Finalizar actividad.");//
            System.out.println("18. Salir.");
            opc = sc.nextInt();
            switch(opc){
                case 1 :{//agregar lsita
                    System.out.println("Defina el nombre de la categoria : ");
                    sc.nextLine();
                    String nombreCategoria = sc.nextLine();
                    if(!datos.existeLista(nombreCategoria)){
                        Categoria ct = new Categoria(nombreCategoria, datos.getCategorias().size());
                        datos.getCategorias().add(ct);
                        datos.escribirFichero((Object)datos, "Datos");
                        System.out.println("La categoría se guardó correctamente.");
                    }else{
                        System.out.println("La categoría ya existe.");
                    }   
                    limpiarMenu(sc); 
                break;
                }
                case 2 :{//Agregar Responsables
                    System.out.println("Defina el nombre del responsable: ");
                    sc.nextLine();
                    String nombreResponsable = sc.nextLine();
                    if(!datos.existeResponsable(nombreResponsable)){
                        Responsable responsable = new Responsable(nombreResponsable);
                        datos.getResponsables().add(responsable);
                        datos.escribirFichero((Object)datos, "Datos");
                        System.out.println("Se agrego correctamente.");
                    }else{
                        System.out.println("El responsable ya existe.");
                    }
                    limpiarMenu(sc);   
                break;
                }
                case 3 :{//Agregar Actividad
                    if(datos.getResponsables() != null && !datos.getResponsables().isEmpty()){
                        System.out.println("Cual es la categoria de la actividad?");
                        sc.nextLine();
                        String nombreCategoria =sc.nextLine();
                        if(datos.existeLista(nombreCategoria)){
                            Categoria ct = datos.recuperarCategoria(nombreCategoria);
                            System.out.println("Defina el nombre de la actividad.");
                            String nombre = sc.nextLine();
                            if(!ct.existeActividad(nombre)){
                                System.out.println("Defina la fecha de inicio (dd/mm/yyyy).");
                                String date = sc.next();
                                System.out.println("Defina la fecha de final  (dd/mm/yyyy).");
                                String date2 = sc.next();
                                System.out.println("Defina el porcentaje de avance de la tarea.");
                                int gradoAvance = sc.nextInt();
                                System.out.println("Defina la duracion de la actividad (Horas).");
                                int duracion = sc.nextInt();
                                System.out.println("Defina  el presupuesto (Dolares).");
                                double dinero = sc.nextDouble();
                                System.out.println("Defina esfuerzo realizado en la actividad en un rango de 0 a 10.");
                                int esfuerzo = sc.nextInt();
                                Actividad actividad = new Actividad(ct.getListaActividades().size(), nombre, datos.parseDate(date), datos.parseDate(date2), gradoAvance);
                                actividad.setEstado("Creada");
                                actividad.setEstimacion(new Estimacion(duracion, dinero, esfuerzo));
                                ct.getListaActividades().add(actividad);
                                System.out.println("Escoja el numero del responsable para la actividad.");
                                datos.imprimirResponsables();
                                int responsable = sc.nextInt();
                                actividad.setResponsable(datos.responsableIndex(responsable));
                                datos.escribirFichero((Object)datos, "Datos");
                                System.out.println("Se agregó correctamente.");
                            }else{
                                System.out.println("La actividad ya existe.");
                            }
                        }else{
                            System.out.println("La categoria no existe.");
                        }
                    }else{
                        System.out.println("Debe agregar primero responsables.");
                    }
                    limpiarMenu(sc);
                break;
                }
                case 4 :{//Iniciar Actividad
                     System.out.println("Cual es la categoria de la actividad?");
                        sc.nextLine();
                        String nombreCategoria =sc.nextLine();
                        if(datos.existeLista(nombreCategoria)){
                            Categoria ct = datos.recuperarCategoria(nombreCategoria);
                            System.out.println("Defina el nombre de la actividad.");
                            String nombre = sc.nextLine();
                            if(ct.existeActividad(nombre)){
                                   int i = ct.getIndexActividad(nombre);
                                    if(i !=1){
                                    Actividad actividadModificada = ct.recuperarActividad(nombre);
                                    Actividad actividad = ct.actividadIndex(i-1);
                                    if(actividad.getEstado().equals("Finalizado")){
                                        actividadModificada.setEstado("Iniciada");
                                    }else{
                                        Actividad actividadProxy = new Actividad(actividad.getId(), actividad.getNombre()+" Proxy", actividad.getFechaInicio(), actividad.getFechaFinal(), actividad.getGradoAvancce());
                                        actividadProxy.setEstado("Finalizada");
                                        actividadProxy.setResponsable(actividad.getResponsable());
                                        actividadProxy.setEstimacion(actividad.getEstimacion());
                                        actividadModificada.setActividadProxy(actividadProxy);
                                        actividadModificada.setEstado("Iniciada");
                                        ct.getListaActividades().add(i,actividadProxy);
                                        System.out.println("Se ha acreado un proxy para remplazar la tarea anterior que no ha finalizado.");
                                    }
                                }else{
                                    Actividad actividad = ct.recuperarActividad(nombre);
                                    actividad.setEstado("Iniciada");
                                }
                                
                                    datos.escribirFichero((Object)datos, "Datos");
                                    System.out.println("La actividad se ha iniciado");
                            }else{
                                System.out.println("La actividad no existe");
                            }
                        }else{
                             System.out.println("La categoria no existe");
                        }
                       limpiarMenu(sc);     
                break;
                }
                case 5 :{// Consultar Actividades.
                    System.out.println("Cual es la categoria de la actividad?");
                    sc.nextLine();
                    String nombreCategoria = sc.nextLine();;
                    if(datos.existeLista(nombreCategoria)){
                        Categoria ct = datos.recuperarCategoria(nombreCategoria);
                        System.out.println("Lista de actividades: ");
                        ct.imprimirActividades();
                        
                    }else{
                        System.out.println("La categoria no existe.");
                    }
                    limpiarMenu(sc);

                break;
                }
                case 6 :{//Modificar Lista   
                    System.out.println("Cual categoria desea modificar?");
                    sc.nextLine();
                    String nombre = sc.nextLine();
                    if(datos.existeLista(nombre)){
                        Categoria ct = datos.recuperarCategoria(nombre);
                        System.out.println("Defina el nuevo nombre de la categoria.");
                        sc.nextLine();
                        String nombreNuevo = sc.nextLine();;
                        ct.setNombre(nombreNuevo);
                        if(datos.eliminarFichero(nombre)){
                            ArchivoDatos archivoDatos = datos.recuperarArchivoDatos(nombre);
                            archivoDatos.setNombreCategoria(nombreNuevo);
                            datos.escribirFichero((Object)datos, "Datos");
                            System.out.println("Se agregó correctamente.");
                        }else{
                            System.out.println("Hubo un error al modificar el fichero.");
                        }
                        
                    }else{
                        System.out.println("La categoria no existe.");
                    }
                    limpiarMenu(sc);
                break;
                }
                case 7 :{//Consultar Lista.
                    System.out.println("Lista de categorias: ");
                    datos.imprimirCategarias();
                    limpiarMenu(sc);
                break;
                }
                case 8 :{
                    System.out.println("Cual es la categoria de la actividad?");
                        sc.nextLine();
                        String nombreCategoria = sc.nextLine();;
                        if(datos.existeLista(nombreCategoria)){
                            Categoria ct = datos.recuperarCategoria(nombreCategoria);
                            System.out.println("Digite el nombre de la actividad que desea ver.");
                            String nombreActividad = sc.nextLine();
                            if(ct.existeActividad(nombreActividad)){
                                ct.mostrarActividad(nombreActividad);
                            }else{
                                System.out.println("La actividad no existe.");
                            }
                        }else{
                            System.out.println("La categoria no existe.");
                        }
                        limpiarMenu(sc);
                   
                break;
                 }
                case 9 :{// Eliminar categoría
                    System.out.println("Cual categoria desea eliminar?");
                    sc.nextLine();
                    String nombre =sc.nextLine();;
                    if(datos.existeLista(nombre)){
                            datos.eliminarCategoria(nombre);
                            datos.escribirFichero((Object)datos, "Datos");
                            System.out.println("Se elimino correctamente.");
                    }else{
                        System.out.println("La categoria no existe.");
                    }
                    limpiarMenu(sc);
                break;
                }
                case 10 :{//eliminar actividad.
                    System.out.println("Cual es el nombre de la categoria a la que pertenece la actividad que desea eliminar?");
                    sc.nextLine();
                    String nombreCategoria =sc.nextLine();;
                    if(datos.existeLista(nombreCategoria)){
                        System.out.println("Cual es el nombre de la actividad que desea eliminar?");
                        String nombreActividad =sc.nextLine();
                        Categoria ct = datos.recuperarCategoria(nombreCategoria);
                        if(ct.existeActividad(nombreActividad)){
                            ct.eliminarActividad(nombreActividad);
                            datos.escribirFichero((Object)datos, "Datos");
                            System.out.println("Se elimino correctamente.");
                        }else{
                            System.out.println("La actividad no existe.");
                        }
                    }else{
                        System.out.println("La categoria no existe.");
                    }
                    limpiarMenu(sc);

                break;
                }
                case 11 :{//eliminar responsable
                    System.out.println("Escoja el numero del responsable que desea eliminar.");
                    datos.imprimirResponsables();
                    int responsable = sc.nextInt();
                    if(responsable >= 0){
                       if(!datos.buscarResponsable(datos.getResponsableIndex(responsable).getNombre())){
                            datos.getResponsables().remove(datos.getResponsableIndex(responsable));
                            datos.escribirFichero((Object)datos, "Datos");
                            System.out.println("Se elimino correctamente.");
                        }else{
                            System.out.println("No se puede eliminar el responsable porque esta relacionado con una actividad.");
                        }
                    }
                    limpiarMenu(sc);
                break;
                }
                case 12 :{
                    System.out.println("Tablero de tareas: ");
                    datos.mostrarTablero();
                     limpiarMenu(sc);
                break;
                }
                case 13 :{//mostrar responsables
                    System.out.println("Responsables: ");
                    datos.imprimirResponsables();
                     limpiarMenu(sc);
                break;
                }
                case 14 :{//modificar actividad
                    System.out.println("Cual es la categoria de la actividad que desea modificar?");
                    sc.nextLine();
                    String nombreCategoria =sc.nextLine();
                    if(datos.existeLista(nombreCategoria)){
                        Categoria ct = datos.recuperarCategoria(nombreCategoria);
                        System.out.println("Cual es la actividad que desea modificar.");
                        String nombre = sc.nextLine();
                        if(ct.existeActividad(nombre)){
                            Actividad actividad = ct.recuperarActividad(nombre);
                            ct.modificarActividad(actividad, datos.getResponsables());
                            datos.escribirFichero((Object)datos, "Datos");
                        }else{
                            System.out.println("La actividad no existe.");
                        }
                    }else{
                        System.out.println("La categoria no existe.");
                    }
                    limpiarMenu(sc);
                break;
                }
                case 15:{//agregar recursos
                    System.out.println("Cual es el nombre de la categoria a la que pertenece la actividad?");
                    sc.nextLine();
                    String nombreCategoria =sc.nextLine();
                    if(datos.existeLista(nombreCategoria)){
                        System.out.println("Cual es el nombre de la actividad?");
                        String nombreActividad =sc.nextLine();
                        Categoria ct = datos.recuperarCategoria(nombreCategoria);
                        if(ct.existeActividad(nombreActividad)){
                            Actividad actividad = ct.recuperarActividad(nombreActividad);
                            System.out.println("Cual recurso desea agregar?");
                            String nombreRecursos = sc.nextLine();
                            actividad.getRecursos().add(new Recursos(nombreRecursos));
                            datos.escribirFichero((Object)datos, "Datos");
                            System.out.println("Los recursos se agregaron correctamente.");
                        }else{
                              System.out.println("La actividad no existe.");
                        }
                    }else{
                        System.out.println("La categoria no existe.");
                    }
                    limpiarMenu(sc);
                    
                break;
            
                }
                case 16:{//eliminar recursos
                    System.out.println("Cual es el nombre de la categoria a la que pertenece los recursos que desea eliminar?");
                    sc.nextLine();
                    String nombreCategoria =sc.nextLine();;
                    if(datos.existeLista(nombreCategoria)){
                        System.out.println("Cual es la actividad del recurso que desea eliminar?");
                        String nombreActividad =sc.nextLine();
                        Categoria ct = datos.recuperarCategoria(nombreCategoria);
                        if(ct.existeActividad(nombreActividad)){
                            System.out.println("Seleccione el numero del recurso que desea eliminar?");
                            Actividad actividad = ct.recuperarActividad(nombreActividad);
                            actividad.imprimirRecursos();
                            int numeroRecurso = sc.nextInt();
                            if(actividad.buscarRecurso(actividad.getRecursoIndex(numeroRecurso).getNombre())){
                                actividad.getRecursos().remove(actividad.getRecursoIndex(numeroRecurso));
                                datos.escribirFichero((Object)datos, "Datos");
                                System.out.println("Se elimino correctamente.");
                            }else{
                                 System.out.println("El recurso no existe.");
                            }
                           
                        }else{
                            System.out.println("El recurso no existe.");
                        }
                    }else{
                        System.out.println("La categoria no existe.");
                    }
                    limpiarMenu(sc);
                break;
                }
                case 17:{
                     System.out.println("Cual es la categoria de la actividad?");
                        sc.nextLine();
                        String nombreCategoria =sc.nextLine();
                        if(datos.existeLista(nombreCategoria)){
                            Categoria ct = datos.recuperarCategoria(nombreCategoria);
                            System.out.println("Defina el nombre de la actividad.");
                            String nombre = sc.nextLine();
                            if(ct.existeActividad(nombre)){
                                    Actividad actividad = ct.recuperarActividad(nombre);
                                    actividad.setEstado("Finalizada");
                                    datos.escribirFichero((Object)datos, "Datos");
                                    System.out.println("La actividad se ha finalizado");
                            }else{
                                System.out.println("La actividad no existe");
                            }
                        }else{
                            System.out.println("La categoria no existe");
                        }
                       limpiarMenu(sc);     
                break;
                }
                
                default:
                
                break;
            }
            
        }while(opc != 18);
    }

}

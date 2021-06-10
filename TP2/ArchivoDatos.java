import java.io.Serializable;

public class ArchivoDatos implements Serializable {
    private String nombreCategoria;

    public ArchivoDatos(String nombreCategoria){
        this.nombreCategoria = nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria){
        this.nombreCategoria = nombreCategoria;
    }
    public String getNombreCategoria(){
        return nombreCategoria;
    }

    @Override
    public String toString(){
        return nombreCategoria;
    }
    

}

package modelo;

public class Comic{
    private String titulo;
    private String autor;
    private int precio;
    private boolean disponible;

    public Comic(String titulo, String autor, int precio, boolean disponible){
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.disponible = disponible;
    }

    public String getTitulo(){return titulo;}
    public String getAutor(){return autor;}
    public int getPrecio(){return precio;}
    public boolean isDisponible(){return disponible;}

    public void setDisponible(boolean disponible){this.disponible = disponible;}

    @Override
    public String toString(){
        return titulo + "," + autor + "," + precio + "," + disponible;
    }
}
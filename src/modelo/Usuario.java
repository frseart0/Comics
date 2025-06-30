package modelo;

public class Usuario{
    private int id;
    private String nombreApellido;

    public Usuario(int id, String nombreApellido){
        this.id = id;
        this.nombreApellido = nombreApellido;
    }

    public int getId(){return id;}
    public String getNombreApellido(){return nombreApellido;}

    @Override
    public String toString(){
        return id + "," + nombreApellido;
    }
}
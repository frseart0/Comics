package app;

import modelo.Comic;
import modelo.Usuario;
import servicios.BibliotecaService;
import servicios.UsuariosService;

public class Main {
    public static void main(String[] args) {
        BibliotecaService biblioteca = new BibliotecaService();
        UsuariosService usuarios = new UsuariosService();

        biblioteca.agregarComic(new Comic("El eternauta", "Hector Oesterheld ", 15000, true));
        biblioteca.venderComic("Berserk Vol 1");

        usuarios.agregarUsuario(new Usuario(1, "Juan Pavez"));
        usuarios.agregarUsuario(new Usuario(2, "Francisco Arellano"));
    }
}
package servicios;

import modelo.Usuario;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UsuariosService {
    private Map<Integer, Usuario> usuarios = new HashMap<>();
    private final String archivo = "src/colecciones/usuarios.csv";

    public UsuariosService() {
        cargarUsuarios();
    }

    private void cargarUsuarios() {
        usuarios.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine(); // saltar headers
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                int id = Integer.parseInt(datos[0]);
                usuarios.put(id, new Usuario(id, datos[1]));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios: " + e.getMessage());
        }
    }

    private void guardarUsuarios() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            pw.println("id,nombreApellido");
            for (Usuario u : usuarios.values()) {
                pw.println(u);
            }
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios: " + e.getMessage());
        }
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getId(), usuario);
        guardarUsuarios(); // Sobrescribir archivo
    }

    public boolean eliminarUsuario(int id) {
        if (usuarios.remove(id) != null) {
            guardarUsuarios(); // Sobrescribir archivo
            return true;
        }
        return false;
    }

    public Usuario buscarUsuario(int id) {
        return usuarios.get(id);
    }

    public Map<Integer, Usuario> listarUsuarios() {
        return usuarios;
    }
}
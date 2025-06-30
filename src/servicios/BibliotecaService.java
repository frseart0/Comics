package servicios;

import modelo.Comic;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    private List<Comic> comics = new ArrayList<>();
    private final String archivo = "src/colecciones/comics.csv";

    public BibliotecaService() {
        cargarComics();
    }

    private void cargarComics() {
        comics.clear();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                comics.add(new Comic(
                        datos[0],
                        datos[1],
                        Integer.parseInt(datos[2]),
                        Boolean.parseBoolean(datos[3])
                ));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar comics: " + e.getMessage());
        }
    }

    private void guardarComics() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo))) {
            pw.println("titulo,autor,precio,disponible");
            for (Comic comic : comics) {
                pw.println(comic);
            }
        } catch (IOException e) {
            System.out.println("Error al guardar comics: " + e.getMessage());
        }
    }

    public void agregarComic(Comic comic) {
        comics.add(comic);
        guardarComics();
    }

    public boolean eliminarComic(String titulo) {
        boolean eliminado = comics.removeIf(c -> c.getTitulo().equalsIgnoreCase(titulo));
        if (eliminado) {
            guardarComics();
        }
        return eliminado;
    }

    public Comic buscarComic(String titulo) {
        return comics.stream()
                .filter(c -> c.getTitulo().equalsIgnoreCase(titulo))
                .findFirst()
                .orElse(null);
    }

    public boolean venderComic(String titulo) {
        Comic comic = buscarComic(titulo);
        if (comic != null && comic.isDisponible()) {
            comic.setDisponible(false);
            return true;
        }
        return false;
    }

    public List<Comic> listarComics() {
        return comics;
    }
}
package logica;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public interface ISistema 
{
	// Interfaz de sistema, se comunica con él, nada más.
	void iniciar() throws FileNotFoundException;
	
	// CRUD
    void agregarMago(Mago mago) throws IOException;
    void modificarMago() throws IOException;
    boolean eliminarMago(String nombre) throws IOException;

    void agregarHechizo(Hechizo hechizo) throws IOException;
    void modificarHechizo() throws IOException;
    boolean eliminarHechizo(String nombre) throws IOException;

    Mago buscarMago(String nombre);
    
    // Menú analista.
    ArrayList<Hechizo> mostrarTotalHechizos(); // Este de aquí retorna una lista porque se me olvidó que existen los getters :3
    void mostrarMagos();
    void mostrarPMagos();
    void mostrarPHechizos();
    void mostrarTopHechizos();
    void mostrarTopMagos();

    ArrayList<Hechizo> getCatalogoHechizos();
    ArrayList<Mago> getMagos();
}


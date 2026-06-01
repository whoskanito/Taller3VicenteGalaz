package logica;
// Vicente Renato Galaz Palacios, 21.831.202-0, Ingeniería en Tecnologías de Información.
import java.io.FileNotFoundException;
import java.io.IOException;

public class App 
{

	public static void main(String[] args) 
	{
		try { Sistema sistema = new Sistema(); sistema.iniciar(); } 
	    catch ( FileNotFoundException e ) { System.out.println("Archivo no encontrado"); } 
		catch ( IOException e ) { System.out.println("Error al sobreescribir datos: " + e.getMessage()); }
        catch ( Exception e ) { System.out.println("Ha ocurrido un error: " + e.getMessage()); }
		
	}

}

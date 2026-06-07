package logica;
// Vicente Renato Galaz Palacios, 21.831.202-0, Ingeniería en Tecnologías de Información.

public class App 
{
	//	La explicación de toda la lógica del código se encuentra en las respectivas clases.
	//	En App solo iniciamos sistema.
	public static void main(String[] args) 
	{
		try { ISistema sistema = new Sistema(); sistema.iniciar(); } 	  
        catch ( Exception e ) { System.out.println("Ha ocurrido un error: " + e.getMessage()); }		
	}

}
package logica;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Sistema 
{
    private static ArrayList<Hechizo> catalogoHechizos;
    private static ArrayList<Mago> magos;
    private Menu menu;

    public Sistema() 
    {
        Sistema.catalogoHechizos = new ArrayList<>();
        Sistema.magos = new ArrayList<>();
        this.menu = new Menu(this);
    }

    // Con el método iniciar comienza el programa, necesita cargar los archivos y mostrar el menú el cual se comunicará con todo el sistema.
    public void iniciar() throws FileNotFoundException 
    {        	
    	cargarHechizos();
    	cargarMagos();
        menu.mostrarMenuPrincipal();
    }
    
    /*
     * 	En este método usamos un toString y gracias al polimorfismo el objeto mostrará su respectivo toString con todos sus datos.
     */
    public void mostrarTotalHechizos()
    {
    	System.out.println("Catálogo de hechizos disponibles: ");
    	System.out.println();
    	for (int i = 0; i < catalogoHechizos.size(); i++)
    	{
    		System.out.println((i + 1) + ") " + catalogoHechizos.get(i).toString());
    	}
    	System.out.println();
    }
    
    public void mostrarMagos()
    {
    	System.out.println("Magos registrados: ");
    	System.out.println();
    	for (int i = 0; i < magos.size(); i++)
    	{
    		System.out.println((i + 1) + ") " + magos.get(i).toString());
    	}
    	System.out.println();
    }
    
    public void agregarMago() throws FileNotFoundException
    {
    	
    }
    
    
    /*
     * 	La lectura de los hechizos es por donde tiene que emepzar el programa ya que más adelante usaremos el catálogo
     * 	para que los magos puedan buscar sus hechizos al momento de cargar el programa, gracias a la herencia ponemos el filtro del tipo 
     * 	y creamos los hechizos con sus respectivos tipos, luego de eso los agregamos al catálogo de hechizos.
     */
    
    public void cargarHechizos() throws FileNotFoundException
    {
    	File arch = new File("Hechizos.txt");
    	Scanner lector = new Scanner(arch);
    	while (lector.hasNextLine())
    	{
    		String linea = lector.nextLine();
    		String[] partes = linea.split(";");   		
    		if (partes[1].equals("Agua"))
    		{	
    			String[] partes2 = partes[3].split(",");
    			HechizoAgua h = new HechizoAgua(partes[0], partes[1], Integer.parseInt(partes[2]), Integer.parseInt(partes2[0]), Integer.parseInt(partes2[1]));
    			catalogoHechizos.add(h);
    		}
    		else if (partes[1].equals("Fuego"))
    		{
    			HechizoFuego h = new HechizoFuego(partes[0], partes[1], Integer.parseInt(partes[2]), Integer.parseInt(partes[3]));
    			catalogoHechizos.add(h);
    		}
    		else if (partes[1].equals("Planta"))
    		{
    			String[] partes2 = partes[3].split(",");
    			HechizoPlanta h = new HechizoPlanta(partes[0], partes[1], Integer.parseInt(partes[2]), Integer.parseInt(partes2[0]), Integer.parseInt(partes2[1]));
    			catalogoHechizos.add(h);
    		}
    		else if (partes[1].equals("Tierra"))
    		{
    			HechizoTierra h = new HechizoTierra(partes[0], partes[1], Integer.parseInt(partes[2]), Integer.parseInt(partes[3]));
    			catalogoHechizos.add(h);
    		}
    	}    	
    	lector.close();    	
    }
    
    
    /*
     *  Debido a que el constructor de magos nos pide un nombre y una array list, hacemos una Array dentro de la carha de archivos, y gracias
     *  al método buscarHechizo() buscamos en nuestro catálogo ya cargado si ese mago lo sabe o no, si lo sabe, lo agregamos a la array, si no, pasa
     *  al siguiente índice para seguir verificando, al final, creamos al mago y lo agregamos a los magos del programa
     */
    
    public void cargarMagos() throws FileNotFoundException
    {
    	File arch = new File("Magos.txt");
    	Scanner lector = new Scanner(arch);
    	while (lector.hasNextLine())
    	{
            String linea = lector.nextLine();
            String[] partes = linea.split(";");
            String nombre = partes[0];
            String[] nombresHechizos = partes[1].split("\\|");    		
    		ArrayList<Hechizo> hechizosMago = new ArrayList<>();
    		
    		for (String nombreHechizo : nombresHechizos) 
    		{
                Hechizo encontrado = buscarHechizo(nombreHechizo.trim());
                if (encontrado != null) 
                {
                    hechizosMago.add(encontrado);
                }
            }
    		Mago m = new Mago(nombre, hechizosMago);
    		magos.add(m);
    	}
    	lector.close();
    }       
    
    
    /*
     * 	Aquí hacemos un método para buscar encontrar, no tiene mucho brillo, si lo encuentra devuelve 
     *	el nombre, si no, no retorna nada.
     */    
    private Hechizo buscarHechizo(String nombre) 
    {
        for (Hechizo h : catalogoHechizos) 
        {
            if (h.getNombre().equals(nombre)) 
            {
                return h;
            }
        }
        return null;
    }
    
    public void mostrarPMagos()
    {
    	System.out.println("Magos con sus respectivos puntajes: ");
    	System.out.println();
    	for (int i = 0; i < magos.size(); i++)
    	{
    		System.out.println((i + 1) + ") Mago " + magos.get(i).getNombre() + " | Puntuación: " + magos.get(i).calcularPuntuacion());
    	}
    	System.out.println();
    }
    
    public void mostrarPHechizos()
    {
    	System.out.println("Hechizos con sus respectivos puntajes: ");
    	System.out.println();
    	for (int i = 0; i < catalogoHechizos.size(); i++)
    	{
    		System.out.println((i + 1) + ") " + catalogoHechizos.get(i).getNombre() + " | Puntuación: " + catalogoHechizos.get(i).calcularPuntuacion());
    	}
    	System.out.println();
    }
    
    
}

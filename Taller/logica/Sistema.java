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
        this.catalogoHechizos = new ArrayList<>();
        this.magos = new ArrayList<>();
        this.menu = new Menu(this);
    }

    public void iniciar() throws FileNotFoundException 
    {        	
    	cargarHechizos();
        menu.mostrarMenuPrincipal();
    }
    
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
    
    	
    
    
    public void agregarMago()
    {
    	
    }
    
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
    
    public void cargarMagos()
    {
    	
    }
    
    
    
    
    
}

package logica;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileNotFoundException;

public class Sistema implements ISistema
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
    @Override
    public void iniciar() throws FileNotFoundException 
    {  
    	try 
    	{
    	cargarHechizos();
    	cargarMagos();
        menu.mostrarMenuPrincipal();
        }    
        catch ( FileNotFoundException e ) { System.out.println("Archivo no encontrado"); } 
		catch ( IOException e ) { System.out.println("Error al sobreescribir datos: " + e.getMessage()); }
    }	
        
    //Aquí abrimos el bw y tomamos los hechizos de catálogo que ya está actualizado, y reescribimos todo el archivo.       
    public void guardarHechizos() throws IOException
    {
    	BufferedWriter escritor = new BufferedWriter(new FileWriter("Hechizos.txt"));   
    	for (Hechizo h : catalogoHechizos)
    	{
    		// "toFileFormat()" es un método que cree para que el objeto sepa su formato al momento de escribirse en un archivo, es como un     	
    		// toString pero para el objeto.
    		escritor.write(h.toFileFormat());
    		escritor.newLine();
    	}
    	escritor.close();
    }
    
    /*
     * 	Igual que con los hechizos, abrimos el bw y tomamos el catálogo actualizado y reescribimos todo el txt.
     */
    public void guardarMagos() throws IOException
    {
    	BufferedWriter escritor = new BufferedWriter(new FileWriter("Magos.txt"));   
    	for (Mago m : magos)
    	{
    		escritor.write(m.toFileFormat());
    		escritor.newLine();
    	}
    	escritor.close();
    }
    
    // Aquí solo añadimos el objeto del menu al catálogo de sistema y llamamos a guardarMagos().
    public void agregarMago(Mago mago) throws IOException
    {
    	magos.add(mago);
    	guardarMagos();
    }  
    
    public void modificarMago() throws FileNotFoundException
    {
    	
    }
    
    public boolean modificarNombreMago(String nombreActual, String nuevoNombre) throws IOException 
    {
        Mago m = buscarMago(nombreActual);
        if (m == null) return false;
        m.setNombre(nuevoNombre);
        guardarMagos();
        return true;
    }
    
    /* El método toma nombre y hechizo y los busca con los métodos usados anteriormente, si funciona y 
     * el hechizo existe retorna true. 
     */
    public boolean agregarHechizooAMago(String nombreMago, String nombreHechizo) throws IOException
    {
        Mago m = buscarMago(nombreMago);
        Hechizo h = buscarHechizo(nombreHechizo);
        if (m == null || h == null) return false;
        m.getHechizosMago().add(h);
        guardarMagos();
        return true;
    }
    
    /*
     * 	Al igual que agregar hechizo, quitar hace lo mismo pero a la inversa, toma el hechizo y si existe, lo 
     * 	borra y retorna true.
     */
    public boolean quitarHechizoDeMago(String nombreMago, String nombreHechizo) throws IOException 
    {
        Mago m = buscarMago(nombreMago);
        Hechizo h = buscarHechizo(nombreHechizo);
        if (m == null || h == null) return false;
        m.getHechizosMago().remove(h);
        guardarMagos();
        return true;
    }
    // Método para buscar a un mago y que retorne al mago...
    public Mago getMagoPorNombre(String nombre) 
    {
        return buscarMago(nombre);
    }
    
    public boolean eliminarMago(String n) throws IOException
    {    	
    	Mago m = buscarMago(n);   
    	if (m == null) { return false; }
    	magos.remove(m);
    	guardarMagos(); 
    	return true;
    }
    
    // Este método solo agrega el hechizo creado en el menú al catálogo.
    public void agregarHechizo(Hechizo hechizo) throws IOException 
    {
        catalogoHechizos.add(hechizo);
        guardarHechizos();
    }
    
    public void modificarHechizo() throws FileNotFoundException
    {
    	
    }
    
    // Toma el nmbre de hechizo, si existe lo borra y retorna true.
    public boolean eliminarHechizo(String n) throws IOException
    {
    	Hechizo h = buscarHechizo(n);
    	if (h == null) { return false; }
    	catalogoHechizos.remove(h);
    	for (Mago m : magos)
    	{
    		m.getHezchizosMago().remove(h);
    	}
    	guardarHechizos();
    	guardarMagos();
    	return true;
    }   
        
    // Lo mismo que buscarHechizo, busca al mago en el Array, si está, lo deuvuelve, si no, no retorna nada.
    public Mago buscarMago(String nombre)
    {
    	for (Mago m : magos)
    	{
    		if (m.getNombre().equals(nombre))
    		{
    			return m;
    		}
    	}    	
    	return null;
    }    
    
    /*
     * 	En este método usamos un toString y gracias al polimorfismo el objeto mostrará su respectivo toString con todos sus datos.
     */
    public ArrayList<Hechizo> mostrarTotalHechizos()
    {
    	System.out.println();
    	System.out.println("Catálogo de hechizos disponibles: ");
    	System.out.println();
    	for (int i = 0; i < catalogoHechizos.size(); i++)
    	{
    		System.out.println((i + 1) + ") " + catalogoHechizos.get(i).toString());
    	}
    	System.out.println();
    	return catalogoHechizos;
    }
    
    /*
     * 	Aquí simplemente tomamos la lista de magos y la mostramos con un for y el toString de mago.
     */
    public void mostrarMagos()
    {
    	System.out.println();
    	System.out.println("Magos registrados: ");
    	System.out.println();
    	for (int i = 0; i < magos.size(); i++)
    	{
    		System.out.println((i + 1) + ") " + magos.get(i).toString());
    	}
    	System.out.println();    	
    }    
    
    /*
     * 	La lectura de los hechizos es por donde tiene que emepzar el programa ya que más adelante usaremos el catálogo
     * 	para que los magos puedan buscar sus hechizos al momento de cargar el programa, gracias a la herencia ponemos el filtro del tipo 
     * 	y creamos los hechizos con sus respectivos tipos, luego de eso los agregamos al catálogo de hechizos.
     */
    
    public ArrayList<Hechizo> cargarHechizos() throws FileNotFoundException
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
    	return catalogoHechizos;
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
    
    /*
     *	En esta parte agarramos la lista de magos y la mostramos con su nombre y su puntaje con sus métodos correspondientes. 
     */
    public void mostrarPMagos()
    {
    	System.out.println();
    	System.out.println("Magos con sus respectivos puntajes: ");
    	System.out.println();
    	for (int i = 0; i < magos.size(); i++)
    	{
    		System.out.println((i + 1) + ") Mago " + magos.get(i).getNombre() + " | Puntuación: " + magos.get(i).calcularPuntuacion());
    	}
    	System.out.println();
    }
    
    /*
     * 	Al igual que como hicimos con el método para mostrar magos, tomamos lalista de hechizos y la mostramos con nombre y puntaje, con sus
     * 	respectivos métodos
     */
    public void mostrarPHechizos()
    {
    	System.out.println();
    	System.out.println("Hechizos con sus respectivos puntajes: ");
    	System.out.println();
    	for (int i = 0; i < catalogoHechizos.size(); i++)
    	{
    		System.out.println((i + 1) + ") " + catalogoHechizos.get(i).getNombre() + " | Puntuación: " + catalogoHechizos.get(i).calcularPuntuacion());
    	}
    	System.out.println();    	
    }
    
    /*
     * 	Para calcular el top de hechizos nos ayudaremos del método sort, primero creamos una lista para meter ahi la misma lista de hecizos, solo que ordenada, asi
     * 	solo la usaremos para este propósito, el de mostrarla ordenada, luego agarramos los primeros 10 elementos y los mostramos.
     */    
    public void mostrarTopHechizos()
    {
    	System.out.println();
    	System.out.println("Top 10 mejores hechizos según su puntuación: ");
    	System.out.println();    	
    	List<Hechizo> ordenados = new ArrayList<>(catalogoHechizos);    	
    	ordenados.sort((h1, h2) -> Double.compare(h2.calcularPuntuacion(), h1.calcularPuntuacion()));
    	
    	for (int i = 0; i < 10; i++)
    	{
    		Hechizo h = ordenados.get(i);
    		System.out.println((i + 1) + ") " + h.getNombre() + " | Puntaje: " + h.calcularPuntuacion());
    	}
    	System.out.println();
    }    
    
    /*
     * 	Aquí igual que el de hechizos, creamos una lista propia, la ordenamos con sort, y tomamos los primeros 3 magos de la lista ordenada.
     */
    public void mostrarTopMagos()
    {
    	System.out.println();
    	System.out.println("Top 3 Magos según su puntuación: ");
    	System.out.println();  
    	List<Mago> ordenados = new ArrayList<>(magos);    
    	
    	ordenados.sort((m1, m2) -> Double.compare(m2.calcularPuntuacion(), m1.calcularPuntuacion()));
    	
    	for (int i = 0; i < 3; i++)
    	{
    		Mago m = ordenados.get(i);
    		System.out.println((i + 1) + ") " + m.getNombre() + " | Puntaje: " + m.calcularPuntuacion());    	
    	}
    	System.out.println();    	
    }
    
    // No sé por qué me demoré tnto en hacer los getters XD
	public ArrayList<Hechizo> getCatalogoHechizos() 
	{
		return catalogoHechizos;
	}

	public ArrayList<Mago> getMagos() 
	{
		return magos;
	}
    
    
}

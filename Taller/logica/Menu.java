package logica;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu 
{
    private Sistema sistema;
    private Scanner teclado;

    public Menu(Sistema sistema) 
    {
        this.sistema = sistema;
        this.teclado = new Scanner(System.in);
    }

    public void mostrarMenuPrincipal() throws IOException 
    {
        int opcion;
        do {
            System.out.println("1) Panel Administrador");
            System.out.println("2) Panel Analista");
            System.out.println("3) Salir");
            System.out.print("--> ");
            opcion = teclado.nextInt();
            switch (opcion) 
            {
                case 1 -> mostrarMenuAdministrador();
                case 2 -> mostrarMenuAnalista();
            }
        } while (opcion != 3);
    }

    private void mostrarMenuAdministrador() throws IOException 
    {
    	int opcion;   
    	do 
    	{      		
    		System.out.println("1) Agregar Mago");
    		System.out.println("2) Modificar Mago");
    		System.out.println("3) Eliminar Mago");
    		System.out.println("4) Agregar Hechizo");
    		System.out.println("5) Modificar Hechizo");
    		System.out.println("6) Eliminar Hechizo");
    		System.out.println("7) Volver al menú principal");
    		System.out.print("--> ");
    		opcion = teclado.nextInt();    		
    		switch (opcion)
    		{
    			case 1 -> menuAgregarMago();
    			case 2 -> sistema.modificarMago();
    			case 3 -> sistema.eliminarMago();
    			case 4 -> menuAgregarHechizo();
    			case 5 -> sistema.modificarHechizo();
    			case 6 -> sistema.eliminarHechizo();
    			
    		}
    	} while (opcion != 7);
    }

    private void mostrarMenuAnalista() 
    {
    	int opcion;    	
    	do
    	{    		
    		System.out.println("1) Top 10 Mejores Hechizos");
    		System.out.println("2) Top 3 Mejores Magos");
    		System.out.println("3) Mostrar todos los Hechizos");
    		System.out.println("4) Mostrar todos los magos");
    		System.out.println("5) Mostrar todos los Hechizos junto a su puntuacion");
    		System.out.println("6) Mostrar todos los magos junto a su puntuacion");
    		System.out.println("7) Volver al menú principal");
    		System.out.print("--> ");    		
    		opcion = teclado.nextInt();    		
    		switch (opcion)
    		{
    			case 1 -> sistema.mostrarTopHechizos();
    			case 2 -> sistema.mostrarTopMagos();
    			case 3 -> sistema.mostrarTotalHechizos();
    			case 4 -> sistema.mostrarMagos();
    			case 5 -> sistema.mostrarPHechizos();
    			case 6 -> sistema.mostrarPMagos();
    		}
    	} while (opcion != 7);
    }
    
    /*
     * 	Para el menu de agregar mago hacemos exactamente lo mismo que para agregar hechizos, pedimos los datos necesarios, creamos el
     * 	objeto y llamamos a que sistema haga la sobreescritura del archivo, sin embargo mago pide una arraylist asi que hacemos que 
     * 	pase el catálogo y le damos a elejir, puede elejir tantos como quiera, luego se crea el objeto y se sobreescribe automáticamente
     * 	en el txt de magos.
     */
    private void menuAgregarMago() throws IOException
    {
    	teclado.nextLine();
    	System.out.print("Nombre del nuevo mago: ");
    	String nombre = teclado.nextLine();	    	      
    	ArrayList<Hechizo> catalogo = sistema.mostrarTotalHechizos();
    	System.out.println();
    	System.out.println("Escribe el nombre de los hechizos para el mago (ingresa 0 para no darle más hechizos al mago): ");    	    	
    	ArrayList<Hechizo> hechizosMago = new ArrayList<>();
    	
    	boolean ejecucion = true;
    	do
    	{	
    		String opcion = teclado.nextLine();    
    		if (opcion.equals("0"))
    		{
    			ejecucion = false;
    		}
    		else
    		{
    			for (int i = 0; i < catalogo.size(); i++)
        		{
        			if (catalogo.get(i).getNombre().equals(opcion))
        			{
        				hechizosMago.add(catalogo.get(i));
        				System.out.println("Hechizo guardado");
        			}
        		}
    		}
    		
    	} while (ejecucion);    	
    	Mago m = new Mago(nombre, hechizosMago);
    	sistema.agregarMago(m);
    	System.out.println("Mago creado correctamente.");
    	System.out.println();    	
    }
    
    /*
     * 	Esa parte es media complicada pero intentaré explicarla lo mejor posible, en esta parte solo mostramos el menú al usuario
     *  y creamos el objeto que le daremos a sistema, debido a que cadaclase tiene su formato, no es necesario nada má que crear el objeto
     *  con los valores correctos.
     */
    private void menuAgregarHechizo() throws IOException 
    {
    	teclado.nextLine();
        System.out.print("Nombre del hechizo: ");
        String nombre = teclado.nextLine();
        System.out.print("Tipo (Fuego/Tierra/Planta/Agua): ");
        String tipo = teclado.nextLine().trim().toUpperCase();
        System.out.print("Daño: ");
        int daño = teclado.nextInt();
        teclado.nextLine();
        Hechizo nuevoH = null;
        
        // En esta parte filtramos según qué hechizo queremos crear. 
        switch (tipo) 
        {
            case "FUEGO":
                System.out.print("Duración Quemadura: ");
                int duracion = teclado.nextInt();
                nuevoH = new HechizoFuego(nombre, tipo, daño, duracion);
                break;
            case "TIERRA":
                System.out.print("Mejora Defensa: ");
                int defensa = teclado.nextInt();
                nuevoH = new HechizoTierra(nombre, tipo, daño, defensa);
                break;
            case "PLANTA":
                System.out.print("Duración Stun: ");
                int stun = teclado.nextInt();
                System.out.print("Cantidad Plantas: ");
                int plantas = teclado.nextInt();
                nuevoH = new HechizoPlanta(nombre, tipo, daño, stun, plantas);
                break;
            case "AGUA":
                System.out.print("Cantidad de Heal: ");
                int heal = teclado.nextInt();
                System.out.print("Presión del Agua: ");
                int presion = teclado.nextInt();
                nuevoH = new HechizoAgua(nombre, tipo, daño, heal, presion);
                break;
            default:
                System.out.println("Tipo inválido.");
                return;
        }
        // Aquí invocamos a agregarHechizo() que es de sistema.
        teclado.nextLine();
        sistema.agregarHechizo(nuevoH);
        System.out.println("Hechizo agregado correctamente.");
        System.out.println();
    }
    

}

package logica;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu 
{
    private ISistema sistema;
    private Scanner teclado;

    public Menu(ISistema sistema) 
    {
        this.sistema = sistema;
        this.teclado = new Scanner(System.in);
    }
    
    // Menú principal, no tiene mucho brillo.
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
    
    // Este menú es el CRUD, permite cambiar todo como admin. 
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
    			case 2 -> menuModificarMago();
    			case 3 -> menuEliminarMago();
    			case 4 -> menuAgregarHechizo();
    			case 5 -> menuModificarHechizo();
    			case 6 -> menuEliminarHechizo();
    			
    		}
    	} while (opcion != 7);
    }
    
    // Menú analista, analiza..
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
     *  y creamos el objeto que le daremos a sistema, debido a que cadaclase tiene su formato, no es necesario nada más que crear el objeto
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
    
    /*
     * 	Me costó hacer este método pq no sabia que un objeto usaba == en vez de .equals para comparar.
     * 	Aquí buscamos en una lista de magos el nombre que se ingresó, si el nombre coincide se elimina del catálogo 
     * 	original de magos, si no encuentra el nombre no hace nada. 
     */
    private void menuEliminarMago() throws IOException
    {    	
    	if (sistema.getMagos().isEmpty()) 
    	{
            System.out.println("No hay magos registrados.");
            return;
        }    	
    	System.out.println();
        System.out.println("=== Magos registrados ===");   
        ArrayList<Mago> magos = sistema.getMagos();
        for (int i = 0; i < magos.size(); i++) 
        {
            System.out.println((i + 1) + ") " + magos.get(i).getNombre());
        }

        System.out.print("Escribe el nombre del mago a eliminar: ");
        teclado.nextLine(); // --> Este teclado.nextLine() es importante
        /*
         * 	Sin él, el buffer del teclado se queda pillado en algún teclado.nextInt, eso hace que al momento de 
         * 	querer ingresar algo el teclado se salte el ingreso de datos y se quede en null, haciendo que se caiga
         * 	todo el programa, no sé sies problema de eclipse pero me tomó harto darme cuenta de ese detalle...
         */
        String nombre = teclado.nextLine().trim();
        boolean eliminado = sistema.eliminarMago(nombre);        

        if (eliminado)
        {
            System.out.println("Mago " + nombre + " eliminado correctamente.");
            System.out.println();
        } 
        else 
        {
            System.out.println("No se encontró un mago con ese nombre.");
            System.out.println();
        }
    }
    
    /*
     * 	Este método sigue exactamente la misma lógica que eliminar mago, agarra el nombre que ingresas, lo revisa en el catálogo que toma
     * 	de sistema, si está, lo borra, si no, no hace nada.
     */  
    private void menuEliminarHechizo() throws IOException 
    {
        if (sistema.getCatalogoHechizos().isEmpty()) 
        {
            System.out.println("No hay hechizos registrados.");
            return;
        }
        System.out.println("=== Hechizos registrados ===");
        ArrayList<Hechizo> catalogo = sistema.getCatalogoHechizos();
        for (int i = 0; i < catalogo.size(); i++) 
        {
            System.out.println((i + 1) + ". " + catalogo.get(i).getNombre());
        }

        System.out.print("Escribe el nombre del hechizo a eliminar: ");
        teclado.nextLine();
        String nombre = teclado.nextLine().trim();
        boolean eliminado = sistema.eliminarHechizo(nombre);

        if (eliminado) 
        {
            System.out.println("Hechizo " + nombre + " eliminado correctamente.");   
            System.out.println("Los magos que hayan aprendido ese hechizo ya no lo saben.");
            System.out.println();
        } 
        else 
        {
            System.out.println("No se encontró ningún hechizo con ese nombre.");
            System.out.println();
        }
    }
   
    /*
     * 	El menú para modificar magos es medio complicado, para empezar se asegura de ver si hay magos en el sistema, si no, te devuelve
     * 	para el menú, despés toma el nombre del mago que quieras modificar y lo busca, si lo encuentra te da a elegir que 
     * 	lo que quiera modificar del mago, según lo que elijas hay un método para eso en sistema.
     */
    private void menuModificarMago() throws IOException 
    {
        if (sistema.getMagos().isEmpty()) 
        {
            System.out.println("No hay magos registrados.");
            return;
        }
        
        System.out.println("=== Magos registrados ===");
        for (Mago m : sistema.getMagos()) 
        {
            System.out.println("- " + m.getNombre());
        }
        teclado.nextLine();
        System.out.print("Nombre del mago que quieres modificar: ");
        String nombre = teclado.nextLine().trim();
        System.out.println();
        
        // Hice un método solo pa buscar al mago por su nombre xd
        Mago mago = sistema.getMagoPorNombre(nombre);
        if (mago == null) 
        {
            System.out.println("No se encontró ese mago.");
            System.out.println();
            return;
        }

        System.out.println("¿Qué deseas modificar?");
        System.out.println("1. Cambiar nombre");
        System.out.println("2. Agregar hechizo");
        System.out.println("3. Quitar hechizo");
        System.out.print("--> ");
        int opcion = teclado.nextInt();
        teclado.nextLine();

        switch (opcion) 
        {
            case 1:
                System.out.print("Nuevo nombre: ");
                String nuevoNombre = teclado.nextLine().trim();
                sistema.modificarNombreMago(nombre, nuevoNombre);
                System.out.println("Nombre actualizado.");
                System.out.println();
                break;

            case 2:
                System.out.println("=== Hechizos disponibles ===");
                for (Hechizo h : sistema.getCatalogoHechizos()) 
                {
                    System.out.println("- " + h.getNombre());
                }
                System.out.print("Nombre del hechizo a agregar: ");
                String nombreAgregar = teclado.nextLine().trim();
                boolean agregado = sistema.agregarHechizooAMago(nombre, nombreAgregar);                
                if (agregado) 
                {
                	System.out.println("Hechizo agregdo. "); 
                	System.out.println();
                } 
                else 
                { 
                	System.out.println("Hechizo no encontrado en el catálogo"); 
                	System.out.println();
                }                
                break;
                
            case 3:
                System.out.println("=== Hechizos actuales de " + mago.getNombre() + " ===");
                for (Hechizo h : mago.getHechizosMago()) 
                {
                    System.out.println("- " + h.getNombre());
                }
                System.out.print("Nombre del hechizo a quitar: ");
                String nombreQuitar = teclado.nextLine().trim();
                boolean quitado = sistema.quitarHechizoDeMago(nombre, nombreQuitar);                
                if (quitado)
                {
                	System.out.println("Hechizo removido.");
                	System.out.println();
                }
                else 
                {
                	System.out.println("El mago no tenía ese hechizo.");
                	System.out.println();
                }
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }    
    
    /*
     * 	El funcionamiento en el menú es que toma los datos de los hechizos y los guarda, luego invoca
     * 	el constructor correpondiente según el tipo.
     */  
    private void menuModificarHechizo() throws IOException 
    {
        if (sistema.getCatalogoHechizos().isEmpty()) 
        {
            System.out.println("No hay hechizos registrados.");
            return;
        }

        System.out.println("=== Hechizos registrados ===");
        for (Hechizo h : sistema.getCatalogoHechizos()) 
        {
            System.out.println("- " + h.getNombre());
        }
        teclado.nextLine();
        System.out.print("Nombre del hechizo a modificar: ");
        String nombre = teclado.nextLine().trim();
     
        String tipo = sistema.getTipoHechizo(nombre);
        if (tipo == null) 
        {
            System.out.println("No se encontró ese hechizo.");
            return;
        }
        System.out.print("Nuevo nombre: ");
        String nuevoNombre = teclado.nextLine().trim();
        System.out.print("Nuevo daño: ");
        int nuevoDaño = teclado.nextInt();
        teclado.nextLine();

        switch (tipo) 
        {
            case "Fuego":
                System.out.print("Nueva duración quemadura: ");
                int duracion = teclado.nextInt();
                teclado.nextLine();
                sistema.modificarHechizo(nombre, nuevoNombre, nuevoDaño, duracion);
                break;

            case "Tierra":
                System.out.print("Nueva mejora defensa: ");
                int defensa = teclado.nextInt();
                teclado.nextLine();
                sistema.modificarHechizo(nombre, nuevoNombre, nuevoDaño, defensa);
                break;

            case "Planta":
                System.out.print("Nueva duración stun: ");
                int stun = teclado.nextInt();
                System.out.print("Nueva cantidad plantas: ");
                int plantas = teclado.nextInt();
                teclado.nextLine();
                sistema.modificarHechizo(nombre, nuevoNombre, nuevoDaño, stun, plantas);
                break;

            case "Agua":
                System.out.print("Nueva cantidad heal: ");
                int heal = teclado.nextInt();
                System.out.print("Nueva presión del agua: ");
                int presion = teclado.nextInt();
                teclado.nextLine();
                sistema.modificarHechizo(nombre, nuevoNombre, nuevoDaño, heal, presion);
                break;
        }
        System.out.println("Hechizo modificado correctamente.");
    }
    
}

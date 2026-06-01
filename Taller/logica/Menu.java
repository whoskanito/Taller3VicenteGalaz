package logica;
import java.io.FileNotFoundException;
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

    public void mostrarMenuPrincipal() throws FileNotFoundException 
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

    private void mostrarMenuAdministrador() throws FileNotFoundException 
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
    			case 1 -> sistema.agregarMago();
    			case 2 -> System.out.println("En proceso");
    			case 3 -> System.out.println("En proceso");
    			case 4 -> System.out.println("En proceso");
    			case 5 -> System.out.println("En proceso");
    			case 6 -> System.out.println("En proceso");
    			
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
    

}

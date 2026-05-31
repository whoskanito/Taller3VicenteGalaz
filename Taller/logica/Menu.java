package logica;
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

    public void mostrarMenuPrincipal() 
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

    private void mostrarMenuAdministrador() 
    {
    	System.out.println("Hola, estoy mostrando el menú administrador");
    }

    private void mostrarMenuAnalista() 
    {
    	System.out.println("Hola, estoy mostrando el menú analista");
    }
    

}

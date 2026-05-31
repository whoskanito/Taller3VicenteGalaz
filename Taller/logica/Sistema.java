package logica;
import java.util.ArrayList;

public class Sistema 
{
    private ArrayList<Hechizo> catalogoHechizos;
    private ArrayList<Mago> magos;
    private Menu menu;

    public Sistema() 
    {
        this.catalogoHechizos = new ArrayList<>();
        this.magos = new ArrayList<>();
        this.menu = new Menu(this);
    }

    public void iniciar() 
    {
        menu.mostrarMenuPrincipal();
    }
    
}

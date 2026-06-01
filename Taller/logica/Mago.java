package logica;
import java.util.ArrayList;

public class Mago 
{
	private String nombre;
	private ArrayList<Hechizo> hechizosMago;
	
	public Mago(String nombre, ArrayList<Hechizo> hechizosMago) 
	{
		this.nombre = nombre;
		this.hechizosMago = hechizosMago;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public ArrayList<Hechizo> getHezchizosMago() 
	{
		return hechizosMago;
	}

	
	// Aquí los magos calculan su puntuación basada en la sumatoria de los puntajes de los hechizos que conocen.
	public int calcularPuntuacion()
	{
		int puntuacion = 0;
		for (int i = 0; i < this.hechizosMago.size(); i++)
		{
			puntuacion += hechizosMago.get(i).calcularPuntuacion();
		}
		return puntuacion;
	}	
	
	/*
	 * 	Aquí tuve que hacer el toString para que específicamente se vieran sólo los nombres de los hechizos ya que 
	 * 	al llamar al toString en sistema se tiraba el de hechizos y quedaba una salida gigante :p
	 */
	@Override
	public String toString() 
	{
	    String nombresHechizos = "";	    
	    for (int i = 0; i < this.hechizosMago.size(); i++) 
	    {
	        nombresHechizos += this.hechizosMago.get(i).getNombre();
	        
	        if (i < this.hechizosMago.size() - 1) 
	        {
	            nombresHechizos += " | ";
	        }
	    }	   
	    return "Mago " + nombre + " | Hechizos: " + nombresHechizos;
	}

}

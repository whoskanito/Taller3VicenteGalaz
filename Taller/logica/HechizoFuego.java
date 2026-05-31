package logica;

public class HechizoFuego extends Hechizo 
{
	private int duracionQuemadura;

	public HechizoFuego(String nombre, String tipo, int daño, int duracionQuemadura) 
	{
		super(nombre, tipo, daño);
		this.duracionQuemadura = duracionQuemadura;
	}

	public int getDuracionQuemadura() 
	{
		return duracionQuemadura;
	}

	@Override
	public String calcularPuntuacion() 
	{
		return null;
	}
	
	
	
}

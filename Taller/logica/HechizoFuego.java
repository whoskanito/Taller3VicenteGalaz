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
	public String toString() 
	{
		return getNombre() +
				" | Tipo: " + getTipo() +
				" | Daño: " + getDaño() +
				" | Duración de Quemadura: "  + duracionQuemadura;
	}
	
	@Override
	public int calcularPuntuacion() 
	{
		return getDaño() * duracionQuemadura;
	}

	@Override
	public String toFileFormat() 
	{
		return getNombre() + ";Fuego;" + getDaño() + ";" + duracionQuemadura;
	}	
	
}

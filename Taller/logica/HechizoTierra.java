package logica;

public class HechizoTierra extends Hechizo 
{
	private int mejoraDefensa;

	public HechizoTierra(String nombre, String tipo, int daño, int mejoraDefensa)
	{
		super(nombre, tipo, daño);
		this.mejoraDefensa = mejoraDefensa;
	}

	public int getMejoraDefensa() 
	{
		return mejoraDefensa;
	}

	@Override
	public String toString() 
	{
		return getNombre() +
				" | Tipo: " + getTipo() +
				" | Daño: " + getDaño() +
				" | Mejora de defensa: "  + mejoraDefensa;
	}
	
	@Override
	public int calcularPuntuacion() 
	{
		return (getDaño() * mejoraDefensa) / 2;
	}
	
	
	
}

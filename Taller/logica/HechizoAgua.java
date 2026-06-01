package logica;

public class HechizoAgua extends Hechizo 
{
	private int cantHeal, presionDelAgua;

	public HechizoAgua(String nombre, String tipo, int daño, int cantHeal, int presionDelAgua) 
	{
		super(nombre, tipo, daño);
		this.cantHeal = cantHeal;
		this.presionDelAgua = presionDelAgua;
	}

	public int getCantHeal() 
	{
		return cantHeal;
	}

	public int getPresionDelAgua() 
	{
		return presionDelAgua;
	}

	@Override
	public String toString() 
	{
		return getNombre() +
				" | Tipo: " + getTipo() +
				" | Daño: " + getDaño() +
				" | Cantidad de curación: "  + cantHeal +
				" | Presión del Agua: " + presionDelAgua; 
	}
	
	@Override
	public int calcularPuntuacion() 
	{
		return (getDaño() + cantHeal + presionDelAgua) * 2;
	}

	@Override
	public String toFileFormat() 
	{
		return getNombre() + ";Agua;" + getDaño() + ";" + cantHeal + ";" + presionDelAgua;
	}
	
}

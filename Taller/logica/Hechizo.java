package logica;

public abstract class Hechizo
{
	private String nombre;
	private String tipo;
	private int daño;
	
	public Hechizo(String nombre, String tipo, int daño) 
	{
		this.nombre = nombre;
		this.tipo = tipo;
		this.daño = daño;
	}

	public String getNombre() 
	{
		return nombre;
	}

	public String getTipo() 
	{
		return tipo;
	}

	public int getDaño() 
	{
		return daño;
	}

	public abstract int calcularPuntuacion();

	@Override
	public String toString() 
	{
		return "Hechizo [nombre =" + nombre + ", tipo =" + tipo + ", daño =" + daño + "]";
	}
	
	
}

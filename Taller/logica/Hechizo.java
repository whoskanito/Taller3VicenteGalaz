package logica;

public abstract class Hechizo
{
	
	/*
	 * 	Clase abstracta de hechizo, no hay mucho que comentar, la base de los hechizos, comparten nombre, tipo y daño, pero todas tienen atributos que 
	 * 	las diferencian en algo.
	 */
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

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public void setTipo(String tipo) 
	{
		this.tipo = tipo;
	}

	public void setDaño(int daño) 
	{
		this.daño = daño;
	}

	public abstract int calcularPuntuacion();

	@Override
	public String toString() 
	{
		return "Hechizo [nombre =" + nombre + ", tipo =" + tipo + ", daño =" + daño + "]";
	}
	
	public abstract String toFileFormat();
	
}

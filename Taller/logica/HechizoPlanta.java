package logica;

public class HechizoPlanta extends Hechizo
{
	private int duracionStun, cantPlantas;

	public HechizoPlanta(String nombre, String tipo, int daño, int duracionStun, int cantPlantas) 
	{
		super(nombre, tipo, daño);
		this.duracionStun = duracionStun;
		this.cantPlantas = cantPlantas;
	}

	public int getDuracionStun() 
	{
		return duracionStun;
	}

	public int getCantPlantas() 
	{
		return cantPlantas;
	}

	@Override
	public String toString() 
	{
		return getNombre() +
				" | Tipo: " + getTipo() +
				" | Daño: " + getDaño() +
				" | Duaración Stun: "  + duracionStun +
				" | Cantidad de Plantas: " + cantPlantas; 
	}
	
	@Override
	public int calcularPuntuacion() 
	{
		return getDaño() + (duracionStun * cantPlantas);
	}

	@Override
	public String toFileFormat() 
	{	
		return getNombre() + ";Planta;" + getDaño() + ";" + duracionStun + "," + cantPlantas;
	}	 		
	
}

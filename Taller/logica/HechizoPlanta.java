package logica;

public class HechizoPlanta extends Hechizo
{
	private int duarcionStun, cantPlantas;

	public HechizoPlanta(String nombre, String tipo, int daño, int duarcionStun, int cantPlantas) 
	{
		super(nombre, tipo, daño);
		this.duarcionStun = duarcionStun;
		this.cantPlantas = cantPlantas;
	}

	public int getDuarcionStun() 
	{
		return duarcionStun;
	}

	public int getCantPlantas() 
	{
		return cantPlantas;
	}

	@Override
	public String calcularPuntuacion() 
	{
		return null;
	}
	
	
	
}

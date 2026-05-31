package logica;

public interface IVisitorHechizo 
{
	double visit(HechizoAgua hechizo);
	double visit(HechizoFuego hechizo);
	double visit(HechizoPlanta hechizo);
	double visit(HechizoTierra hechizo);
}

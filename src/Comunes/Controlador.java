package Comunes;

public class Controlador {
	 public int casoPrueba =0;
	 public String nombre ="";
	 public String dato ="";
	 public String valor ="";
	 public String selector ="";
	 int   tipoSelector=0;
	 public String   descripcion  ="";
	 public String   paso="";
	 public int   takeScreen=0;
	 public int   tiempoEsperaExtra=3000;
	 public int   tiempoEsperaExtraSig=1000;
	 public int    pasoNumero =0;
	public String TestCase="";
public Controlador ObtenerControlador(String casoPrueba,int paso)
{
	
	Controlador nuevoControlador=	new Controlador();
	//TODO conexion a base de datos.
	
	return nuevoControlador;
}
}

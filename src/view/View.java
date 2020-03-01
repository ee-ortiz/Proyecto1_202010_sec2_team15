package view;

import model.logic.Modelo;

public class View 
{
	/**
	 * Metodo constructor
	 */
	public View()
	{

	}

	public void printMenu()
	{
		System.out.println("1. Cargar Datos");
		System.out.println("2. Consultar el primer comparendo que aparezca en el archivo que tiene una LOCALIDAD dada");
		System.out.println("3. Consultar los comparendos registrados en el archivo dada una FECHA_HORA");
		System.out.println("4. Comparar los comparendos, por cada código INFRACCION, en dos FECHA_HORA dadas");
		System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return:");

	}

	public void printMessage(String mensaje) {

		System.out.println(mensaje);
	}		

	public void printModelo(Modelo modelo)
	{
		System.out.println(modelo);
	}
}

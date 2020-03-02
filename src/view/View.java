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
		System.out.println("1.  Cargar Datos");
		System.out.println("2.  Consultar el primer comparendo que aparezca en el archivo que tiene una LOCALIDAD dada");
		System.out.println("3.  Consultar los comparendos registrados en el archivo dada una FECHA_HORA");
		System.out.println("4.  Comparar los comparendos, por cada código INFRACCION, en dos FECHA_HORA dadas");
		System.out.println("5.  Consultar el primer comparendo que aparece en el archivo que tiene una INFRACCION dada");
		System.out.println("6.  Consultar los comparendos registrados en el archivo dado un código INFRACCION");
		System.out.println("7.  Comparar los comparendos por cada código INFRACCION en los TIPO_SERVI Particular y Púbico");
		System.out.println("8.  Mostrar el número de comparendos por cada código INFRACCION en una LOCALIDAD dada, para un periodo de tiempo dado por: FECHA_HORA inicial y FECHA_HORA final");
		System.out.println("9.  Consultar la información de los N códigos INFRACCION con más infracciones ordenados de mayor a menor en un periodo de tiempo dado por: FECHA_HORA inicial y FECHA_HORA final");
		System.out.println("10. Generar una gráfica ASCII (Histograma) que muestre el número total de comparendospor cada LOCALIDAD representados por un String de caracteres ‘*’");
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

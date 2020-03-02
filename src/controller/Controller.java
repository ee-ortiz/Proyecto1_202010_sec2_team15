package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.data_structures.Comparendo;
import model.logic.Modelo;
import view.View;

public class Controller {

	/* Instancia del Modelo*/
	private Modelo modelo;

	/* Instancia de la Vista*/
	private View view;

	private boolean cargado;
	public static String PATH = "./data/comparendos_dei_2018_small.geojson";
	public static String PATH2 = "./data/comparendos_dei_2018.geojson";

	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new View();
		modelo = new Modelo();
		cargado = false;
	}

	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;


		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
			case 1:
				if(cargado == false){
					modelo = new Modelo();

					long start = System.currentTimeMillis();
					String rta = modelo.cargar(PATH);
					long end = System.currentTimeMillis();

					view.printMessage("Tiempo de carga (s): " + (end-start)/1000.0);
					view.printMessage(rta);
					cargado = true;
				}

				else{

					view.printMessage("Los datos contenidos en los archivos sólo se pueden leer una vez");
				}

				break;	

			case 2:
				view.printMessage("Ingresa el nombre de la localidad");
				String localidad = lector.next();
				view.printMessage(modelo.requerimiento1EstudianteA(localidad));
				break;

			case 3: 
				String rta = "Los comparendos resultantes son: \n";
				view.printMessage("Ingresa una fecha con la siguiente forma: (2018/12/10)");
				SimpleDateFormat parser= new SimpleDateFormat("yyyy/MM/dd");
				String fecha = lector.next();

				try {

					Date fechaFinal1 = parser.parse(fecha);

					Comparable [] a = modelo.requerimiento2EstudianteA(fechaFinal1);

					int i = 0;

					if(a.length>0){
						while(i<a.length){
							Comparendo aMostar = (Comparendo) a[i];
							rta += "- " + modelo.RetornarDatos(aMostar) + "\n";
							i++;
						}
						view.printMessage("El total de comparendos registrados en el archivo dada una FECHA_HORA es: " + a.length + "\n" );
						view.printMessage(rta);
					}
					else{
						view.printMessage("No se encontraron comparendos con esa fecha en los archivos");
					}
				}

				catch (Exception e) {
					e.printStackTrace();
				}

				break;

			case 4:
				view.printMessage("Ingresa una fecha con la siguiente forma: (2018/12/10)");
				SimpleDateFormat parser1= new SimpleDateFormat("yyyy/MM/dd");
				String fecha2 = lector.next();
				view.printMessage("Ingresa una segunda fecha con la siguiente forma: (2018/12/10)");
				String fecha3 = lector.next();

				try {

					Date fechaFinal2 = parser1.parse(fecha2);
					Date fechaFinal3 = parser1.parse(fecha3);

					view.printMessage("Infraccion | "+ fecha2 + " | " + fecha3);
					view.printMessage(modelo.requerimiento3EstudianteA(fechaFinal2, fechaFinal3));

				}


				catch (Exception e) {
					e.printStackTrace();
				}

				break;

			case 5:
				// parte andrés
				break;

			case 6: 

				// parte andrés
				break;

			case 7:

				// parte andrés
				break;			

			case 8: 

				// parte andrés


				break;

			case 9:

				view.printMessage("Ingresa una fecha inicial con la siguiente forma: (2018/12/10)");
				SimpleDateFormat parser2= new SimpleDateFormat("yyyy/MM/dd");
				String fecha4 = lector.next();
				view.printMessage("Ingresa una fecha final con la siguiente forma: (2018/12/10)");
				String fecha5 = lector.next();
				view.printMessage("Ingresa el numero de codigos de infraccion que deseas ver");
				int numCods = lector.nextInt();

				try {

					Date fechaFinal4 = parser2.parse(fecha4);
					Date fechaFinal5 = parser2.parse(fecha5);

					view.printMessage("Ranking de las " + numCods+ " mayores infracciones del " + fecha4 + " al " + fecha5); 
					view.printMessage("Infraccion | "+ "# Comparendos");
					view.printMessage(modelo.requerimiento2C(fechaFinal4, fechaFinal5, numCods));

				}


				catch (Exception e) {
					e.printStackTrace();
				}
				break;

			case 10:

				view.printMessage("Aproximación del número de comparendos por localidad.");
				modelo.requerimiento3C();
				int tam =modelo.darArreglo().darTamano();
				System.out.println();
				view.printMessage("Total comparendos: " + tam);
				break;

			default: 
				view.printMessage("--------- \n Opcion Invalida !! \n---------");
				break;
			}
		}

	}

}

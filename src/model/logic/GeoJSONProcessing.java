package model.logic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;


import model.data_structures.Comparendo;
import model.data_structures.IArregloDinamico;




public class GeoJSONProcessing {

	public static String PATH = "./data/comparendos_dei_2018_small.geojson";
	public static String PATH2 = "./data/comparendos_dei_2018.geojson";

	//Al final de la carga hay que reportar los siguientes datos:
	//1. Total de comparendos en el archivo.
	//2. Mostrar la información del comparendo (OBJECTID, FECHA_HORA, INFRACCION,
	//	 CLASE_VEHI, TIPO_SERVI, LOCALIDAD) con el mayor OBJECTID encontrado.
	//3. La zona Minimax de los comparendos definida como los límites inferior y superior
	//	 de latitud y longitud en todo el archivo. El Minimax se define como una zona
	//	 rectangular con dos puntos extremos: (la menor latitud, la menor longitud) y (la
	//	 mayor latitud, la mayor longitud).

	// Solucion de carga de datos publicada al curso Estructuras de Datos 2020-10

	public String cargarDatos(IArregloDinamico<Comparendo> pComp){

		String rta = null;
		JsonReader reader;
		try {
			reader = new JsonReader(new FileReader(PATH));
			JsonElement elem = JsonParser.parseReader(reader);
			JsonArray e2 = elem.getAsJsonObject().get("features").getAsJsonArray();
			int objectIDMayor = 0;
			double mayorLatitud = 2;
			double mayorLongitud = -76;
			double menorLatitud = 6;
			double menorLongitud = -72;

			Comparendo mayor = null;


			SimpleDateFormat parser=new SimpleDateFormat("yyyy/MM/dd");

			for(JsonElement e: e2) {
				Comparendo c = new Comparendo();
				c.OBJECTID = e.getAsJsonObject().get("properties").getAsJsonObject().get("OBJECTID").getAsInt();

				String s = e.getAsJsonObject().get("properties").getAsJsonObject().get("FECHA_HORA").getAsString();	
				c.FECHA_HORA = parser.parse(s); 

				c.MEDIO_DETE = e.getAsJsonObject().get("properties").getAsJsonObject().get("MEDIO_DETE").getAsString();
				c.CLASE_VEHI = e.getAsJsonObject().get("properties").getAsJsonObject().get("CLASE_VEHI").getAsString();
				c.TIPO_SERVI = e.getAsJsonObject().get("properties").getAsJsonObject().get("TIPO_SERVI").getAsString();
				c.INFRACCION = e.getAsJsonObject().get("properties").getAsJsonObject().get("INFRACCION").getAsString();
				c.DES_INFRAC = e.getAsJsonObject().get("properties").getAsJsonObject().get("DES_INFRAC").getAsString();	
				c.LOCALIDAD = e.getAsJsonObject().get("properties").getAsJsonObject().get("LOCALIDAD").getAsString();

				c.longitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(0).getAsDouble();

				c.latitud = e.getAsJsonObject().get("geometry").getAsJsonObject().get("coordinates").getAsJsonArray()
						.get(1).getAsDouble();

				pComp.agregar(c);
				if(c.OBJECTID>objectIDMayor){
					objectIDMayor = c.OBJECTID;
					mayor = c;
				}
				if(c.latitud>mayorLatitud){
					mayorLatitud = c.latitud;
				}
				if(c.latitud<menorLatitud){
					menorLatitud = c.latitud;
				}
				if(c.longitud>mayorLongitud){
					mayorLongitud = c.longitud;
				}
				if(c.longitud<menorLongitud){
					menorLongitud = c.longitud;
				}


			}

			rta = "El total de comparendos en el arhivo es " + pComp.darTamano() + "\n" 
					+ "El comparendo con el mayor ObjectID encontrado es:\n-" + RetornarDatos(mayor) + 
					"\n" + "La zona Minimax del archivo es: \n" +
					"-Menor Latitud: " + menorLatitud + "                     -Menor Longitud: " + menorLongitud +"\n" +
					"-Mayor Latitud: " + mayorLatitud + "                     -Mayor Longitud: " + mayorLongitud +"\n";

		} catch (FileNotFoundException | ParseException e) {

			e.printStackTrace();
			rta = "No se pudo encontrar el archivo de comparendos";
		}

		return rta;	


	}

	public String RetornarDatos(Comparendo comp){
		//	Mostrar la información del comparendo (OBJECTID, FECHA_HORA, INFRACCION, CLASE_VEHI, TIPO_SERVI, LOCALIDAD) 

		String rta = "OBJECTID: "+comp.OBJECTID +" FECHA_HORA: " + comp.FECHA_HORA + " INFRACCION: " + comp.INFRACCION + " CLASE_VEHI: "+comp.CLASE_VEHI + " TIPO_SERVI: " +
				comp.TIPO_SERVI + " LOCALIDAD: "+ comp.LOCALIDAD;
		return rta;
	}



}
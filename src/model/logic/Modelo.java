package model.logic;

import model.data_structures.ArregloDinamico;
import model.data_structures.Comparendo;
import model.data_structures.IArregloDinamico;

/**
 * Definicion del modelo del mundo
 *
 */
public class Modelo {
	/**
	 * Atributos del modelo del mundo
	 */
	// La estructura de datos que se utilizará en este proyecto es el ARREGLO DINÁMICO
	private IArregloDinamico<Comparendo> comps;
	private GeoJSONProcessing objetoJsonGson;
	private boolean cargado;

	/**
	 * Constructor del modelo del mundo con capacidad predefinida
	 */
	public Modelo()
	{
		comps = new ArregloDinamico<Comparendo>(600000);
		objetoJsonGson = new GeoJSONProcessing();
		cargado = false;
	}

	/**
	 * Requerimiento buscar dato
	 * @param dato Dato a buscar
	 * @return dato encontrado
	 */
	public Comparendo buscar(Comparendo dato)
	{
		return comps.buscar(dato);
	}

	/**
	 * Requerimiento eliminar dato
	 * @param dato Dato a eliminar
	 * @return dato eliminado
	 */
	public Comparendo eliminar(Comparendo dato)
	{
		return comps.eliminar(dato);
	}

	public String darElemento(int numero){
		return null;

	}

	public String cargar(){

		return objetoJsonGson.cargarDatos(comps);

	}


	public IArregloDinamico<Comparendo> darArreglo(){

		return comps;
	}

}

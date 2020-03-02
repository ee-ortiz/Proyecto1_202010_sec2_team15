package model.data_structures;

public class Localidades implements Comparable<Localidades> {

	private String nombre;

	private int numVecesRepite;

	public Localidades(String pNombre, int pNumVeces){

		nombre = pNombre;
		numVecesRepite = pNumVeces;
	}

	public String darNombre(){

		return nombre;

	}

	public int darNumVeces(){

		return numVecesRepite;
	}

	public String retornarCadenaDeStrings (){

		if(numVecesRepite==0){

			return "sin comparendos";
		}

		else{

			String respuesta = "";
			int rta = numVecesRepite/50;
			if(numVecesRepite%50 != 0){
				rta++;
			}

			for(int i = 0; i<rta; i++){

				respuesta+= "*";
			}

			return respuesta;
		}

	}

	public String retornarCadenaDeStrings2 (){

		if(numVecesRepite==0){

			return "sin comparendos";
		}

		else{

			String respuesta = "";
			int rta = numVecesRepite/2;
			if(numVecesRepite%2 != 0){
				rta++;
			}

			for(int i = 0; i<rta; i++){

				respuesta+= "*";
			}

			return respuesta;
		}

	}

	public void cambiarNumVeces(int numVeces){

		numVecesRepite = numVeces;
	}

	public int compareTo(Localidades o) {

		return nombre.compareToIgnoreCase(o.darNombre());
	}


}

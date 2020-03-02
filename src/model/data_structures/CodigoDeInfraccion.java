package model.data_structures;

public class CodigoDeInfraccion implements Comparable<CodigoDeInfraccion> {

	private String nombre;

	private int vecesQueSeRepite;

	public CodigoDeInfraccion(String pNombre, int pVeces){

		nombre = pNombre;
		vecesQueSeRepite = pVeces;
	}

	public String darNombre(){

		return nombre;

	}

	public int darVecesRepite(){

		return vecesQueSeRepite;
	}


	public int compareTo(CodigoDeInfraccion o) {

		return vecesQueSeRepite - o.darVecesRepite();
	}

}

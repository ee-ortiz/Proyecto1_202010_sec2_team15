package model.data_structures;

import java.util.Comparator;
import java.util.Date;

public class Comparendo implements Comparable<Comparendo> {

	public int OBJECTID;
	public Date FECHA_HORA;
	public String DES_INFRAC;
	public String MEDIO_DETE;
	public String CLASE_VEHI;
	public String TIPO_SERVI;
	public String INFRACCION;
	public String LOCALIDAD;

	public double latitud;
	public double longitud;


	public String toString() {
		return "Comparendo [OBJECTID=" + OBJECTID + ", FECHA_HORA=" + FECHA_HORA + ", DES_INFRAC=" + DES_INFRAC
				+ ", MEDIO_DETE=" + MEDIO_DETE + ", CLASE_VEHI=" + CLASE_VEHI + ", TIPO_SERVI=" + TIPO_SERVI
				+ ", INFRACCION=" + INFRACCION + ", LOCALIDAD=" + LOCALIDAD + ", latitud=" + latitud + ", longitud="
				+ longitud + "]";
	}


	public int compareTo(Comparendo comp) {

		return INFRACCION.compareTo(comp.INFRACCION);

	}

	public static class ComparadorXCodigoInfraccion implements Comparator<Comparendo> {

		public int compare(Comparendo c1, Comparendo c2) {
			return c1.INFRACCION.compareTo(c2.INFRACCION);
		}
	}
	public static class ComparadorXCodigoFecha implements Comparator<Comparendo> {

		public int compare(Comparendo c1, Comparendo c2) {
			return c1.FECHA_HORA.compareTo(c2.FECHA_HORA);
		}
		
	}
	public static class ComparadorXCodigoLocalidad implements Comparator<Comparendo> {

		public int compare(Comparendo c1, Comparendo c2) {
			return c1.LOCALIDAD.compareTo(c2.LOCALIDAD);
		}
	}
}

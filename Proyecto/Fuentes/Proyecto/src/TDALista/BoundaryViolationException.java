package TDALista;

@SuppressWarnings("serial")
public class BoundaryViolationException extends Exception{
	/**
	 * Excepcion que se lanza cuando uno trata de realizar la accion next o prev en una lista y las posiciones recibidas como
	 * parametro corresponden al ultimo o al primer elemento de la lista respectivamente.
	 */
	public BoundaryViolationException(String err){
		super(err);
	}
}

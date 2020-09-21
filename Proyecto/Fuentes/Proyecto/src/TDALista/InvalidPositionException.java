package TDALista;

@SuppressWarnings("serial")
public class InvalidPositionException extends Exception {
	/**
	 * Excepcion que se lanza cuando uno trata de realizar la accion next, prev, addAfter, addBefore,
	 * remove, set en una lista vacia o utilizando una pocicion invalida recibida como parametro.
	 */
	public InvalidPositionException(String err){
		super(err);
	}
}
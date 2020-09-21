package TDALista;

@SuppressWarnings("serial")
public class NoSuchElementException extends Exception {
	/**
	 * Excepcion que se lanza cuando uno trata de realizar la accion next en un iterador 
	 * y no existe ningun elemento siguiente.
	 */
	public NoSuchElementException(String err){
		super(err);
	}
}
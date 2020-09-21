package TDALista;

@SuppressWarnings("serial")
public class EmptyListException extends Exception{
	/**
	 * Excepcion que se lanza cuando uno trata de realizar la accion first o last en una lista vacia.
	 */
	public EmptyListException (String err){
		super(err);
	}
}
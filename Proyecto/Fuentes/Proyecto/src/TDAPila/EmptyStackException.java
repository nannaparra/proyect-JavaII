package TDAPila;
@SuppressWarnings("serial")
public class EmptyStackException extends Exception{
	/**
	 * Excepcion que se lanza cuando uno trata de realizar la accion pop o top en una pila vacia.
	 */
	public EmptyStackException (String err){
		super (err);
	}
}
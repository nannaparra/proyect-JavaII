package TDAArbolBinario;

@SuppressWarnings("serial")
public class EmptyTreeException extends Exception{
	/**
	 * Excepcion que se lanza cuando uno trata de realizar la accion root en un arbol vacio.
	 */
	public EmptyTreeException (String err){
		super(err);
	}
}
package TDAArbolBinario;

@SuppressWarnings("serial")
public class BoundaryViolationException extends Exception{
	/**
	 * Excepcion que se lanza cuando uno trata de realizar la accion right, left o parent en un arbol y las posiciones a nodos
	 * recibidas como parametro no tienen hijo izquierdo, hijo derecho o corresponde a la raiz, respectivamente.
	 */
	public BoundaryViolationException(String err){
		super(err);
	}
}
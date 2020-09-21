package TDAArbolBinario;

@SuppressWarnings("serial")
public class InvalidOperationException extends Exception {
	/**
	 * Excepcion que se lanza cuando uno trata de realizar la accion createRoot, addLeft, addRight o remove 
	 * y el rabol ya tiene raiz, el nodo ya tiene hijo izqquierdo, el nodo ya tiene hijo derecho o el nodo a eliminar
	 * tiene mas de un hijo, respectivamente.
	 */
	public InvalidOperationException (String err){
		super(err);
	}
}
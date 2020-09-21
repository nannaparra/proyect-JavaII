package TDAArbolBinario;


@SuppressWarnings("serial")
public class InvalidPositionException extends Exception {
	/**
	 * Excepcion que se lanza cuando uno trata de realizar la accion replace, parent, childer, isInternal, isExternal, 
	 * isRoot,left, right, hasLeft, hasRight, createRoot, addLeft, addRight, remove, o Attach en un arbol vacio o utilizando 
	 * una posicion invalida recibida como parametro.
	 */
	public InvalidPositionException(String err){
		super(err);
	}
}
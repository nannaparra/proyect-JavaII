package TDAPila;

/**
 * Interface Stack
 * @author Nadina Parra, Gabriela Salina. Estructura de datos 1er cuatrimestre 2017. UNS.
 */

public interface Stack<E> {
	
	/**
	 * Consulta si la pila est� vac�a.
	 * @return Verdadero si la pila est� vac�a, falso en caso contrario.
	 */
	public boolean isEmpty();
	
	/**
	 * Inserta un elemento en el tope de la pila.
	 * @param element Elemento a insertar.
	 */
	public void push(E item);
	
	/**
	 * Remueve el elemento que se encuentra en el tope de la pila.
	 * @return Elemento removido.
	 * @throws EmptyStackException si la pila est� vac�a. 
	 */
	public E pop() throws EmptyStackException;
	
	/**
	 * Examina el elemento que se encuentra en el tope de la pila.
	 * @return Elemento que se encuentra en el tope de la pila.
	 * @throws EmptyStackException si la pila est� vac�a. 
	 */
	public E top() throws EmptyStackException;
	
	/**
	 * Consulta la cantidad de elementos de la pila.
	 * @return Cantidad de elementos de la pila.
	 */
	public int size();
	
}

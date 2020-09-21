package TDAArbolBinario;
import TDALista.Position;

public interface BTPosition<E> extends Position<E> {
	
	/**Setea el atributo elemento con el elemento pasado por parametro.
	 * @param elemento valor a asignarle al atributo elemento. 
	 */
	public void setElement(E elemento);
	
	/**Setea el atributo padre con la posicion pasada por parametro.
	 * @param padre valor a asignarle al atributo padre.
	 */
	public void setParent(BTPosition<E> padre);
	
	
	/**Setea el atributo izquierdo con la posicion pasada por parametro.
	 * @param izquierdo valor a asignarle al atributo izquierdo.
	 */
	public void setLeft(BTPosition<E> izquierdo);
	
	/**Setea el atributo derecho con la posicion pasada por parametro.
	 * @param derecho valor a asignarle al atributo derecho.
	 */
	public void setRight(BTPosition<E> derecho);
	
	/**Retorna el atributo padre
	 * @return atributo padre del nodo.
	 */
	public BTPosition<E> getParent();
	
	/**Retorna el atributo izquierdo
	 * @return atributo izquierdo del nodo.
	 */
	public BTPosition<E> getLeft();
	
	/**Retorna el atributo derecho
	 * @return atributo derecho del nodo.
	 */
	public BTPosition<E> getRight();
	
	/**Retorna el atributo elemento
	 * @return atributo elemento del nodo.
	 */
	public E element();	
}

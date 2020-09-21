package TDAPila;

public class Nodo<E> {
	private E elem;
	private Nodo<E> siguiente;

	public Nodo(){
	    this(null,null);
	}
	public Nodo(E item){
		this(item,null);
	}
	public Nodo(E item, Nodo<E> sig){
		elem=item;
		siguiente=sig;
	}
	public E getElemento(){
		return elem;
		
	}
	public void setElemento(E elemento){
		this.elem=elemento;
		
	}
	public Nodo<E> getSiguiente(){
		return siguiente;
	}
	public void setSiguiente(Nodo<E> siguiente){
		this.siguiente=siguiente;
	}
}

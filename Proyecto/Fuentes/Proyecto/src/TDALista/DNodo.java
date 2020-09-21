package TDALista;

public class DNodo<E> implements Position<E> {
	protected E elemento;
	protected DNodo<E> ant;
	protected DNodo<E> sig;
	
	public DNodo(){
		elemento=null;
		ant=null;
		sig=null;		
	}
	
	
	public DNodo(E e,DNodo<E> anterior,DNodo<E> siguiente){
		elemento=e;
		ant=anterior;
		sig=siguiente;
	}
	
	public E element(){
		return elemento;
	}
	
	public void setElement(E e){
		elemento=e;
	}
	
	public void setSiguiente(DNodo<E> siguiente){
		sig=siguiente;
	}
	
	public DNodo<E> getSiguiente(){
		return sig;
	}
	
	public void setAnterior(DNodo<E> anterior){
		ant=anterior;
	}
	
	public DNodo<E> getAnterior(){
		return ant;
	}

}

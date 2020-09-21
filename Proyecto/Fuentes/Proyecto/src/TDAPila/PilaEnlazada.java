package TDAPila;



public class PilaEnlazada <E> implements Stack<E> {
	protected Nodo<E> head;
	protected int tamaño;
	
	public PilaEnlazada (){
		head =null;
		tamaño=0;
	}
	
	public boolean isEmpty(){
	return (tamaño==0);
	}
	public void push(E item){
		Nodo<E> aux= new Nodo<E>();
		aux.setElemento(item);
		aux.setSiguiente(head);
		head=aux;
		tamaño++;
	}
	public E pop() throws EmptyStackException{
		if (isEmpty()) throw new EmptyStackException ("Pila Vacia");
		E aux=head.getElemento();
		head=head.getSiguiente();
		tamaño--;
		return aux;
	}
	public E top()throws EmptyStackException{
		if (isEmpty()) throw new EmptyStackException ("Pila vacia");
		return head.getElemento();
	}
	public int size(){
		return tamaño;
		
	}
	

}

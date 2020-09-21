package TDAPila;



public class PilaEnlazada <E> implements Stack<E> {
	protected Nodo<E> head;
	protected int tama�o;
	
	public PilaEnlazada (){
		head =null;
		tama�o=0;
	}
	
	public boolean isEmpty(){
	return (tama�o==0);
	}
	public void push(E item){
		Nodo<E> aux= new Nodo<E>();
		aux.setElemento(item);
		aux.setSiguiente(head);
		head=aux;
		tama�o++;
	}
	public E pop() throws EmptyStackException{
		if (isEmpty()) throw new EmptyStackException ("Pila Vacia");
		E aux=head.getElemento();
		head=head.getSiguiente();
		tama�o--;
		return aux;
	}
	public E top()throws EmptyStackException{
		if (isEmpty()) throw new EmptyStackException ("Pila vacia");
		return head.getElemento();
	}
	public int size(){
		return tama�o;
		
	}
	

}

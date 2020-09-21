package TDALista;

import java.util.Iterator;

public class ListaDoblementeEnlazada<E> implements PositionList<E>{
	
	protected DNodo<E> head,tail;
	protected int tamaño;
	
	public ListaDoblementeEnlazada(){
		head=new DNodo<E>();
		tail=new DNodo<E>();
		tamaño=0;
		head.setSiguiente(tail);
		tail.setAnterior(head);
	}
	
    public int size(){
    	return tamaño;
    }
	
	public boolean isEmpty(){
		return (tamaño==0);
	}
	
	public Position<E> first() throws EmptyListException{
		if(isEmpty()) throw new EmptyListException("La lista esta vacia.");
		return head.getSiguiente();
	}
	
	public Position<E> last() throws EmptyListException{
		if (isEmpty()) throw new EmptyListException("La lista esta vacia");
		return tail.getAnterior();
	}
	
	public Position<E> prev(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNodo<E> nuevo=checkPosition(p);
		try {
			if (nuevo.equals(first())) throw new BoundaryViolationException("El primer elemento no tiene previo");
		} catch (EmptyListException e) {System.out.println(e.getMessage());}
		return nuevo.getAnterior();
	}
	
	public Position<E> next(Position<E> p) throws InvalidPositionException, BoundaryViolationException{
		DNodo<E> nuevo=checkPosition(p);
		if(nuevo.equals(tail.getAnterior())) throw new BoundaryViolationException("El ultimo elemento no tiene siguiente");
		return nuevo.getSiguiente();
	}
	
	public void addFirst(E e){
		DNodo<E> nuevo=new DNodo<E>(e,head,head.getSiguiente());
		(head.getSiguiente()).setAnterior(nuevo);
		head.setSiguiente(nuevo);
		tamaño++;
	}
	
	public void addLast(E e){
		DNodo<E> nuevo=new DNodo<E>(e,tail.getAnterior(),tail);
		(tail.getAnterior()).setSiguiente(nuevo);
		tail.setAnterior(nuevo);
		tamaño++;
	}
	
	public void addAfter(Position<E> p, E e) throws InvalidPositionException{
		DNodo<E> nodo=checkPosition(p);
		DNodo<E> nuevo=new DNodo<E>(e,nodo,nodo.getSiguiente());
		(nodo.getSiguiente()).setAnterior(nuevo);
		nodo.setSiguiente(nuevo);
		tamaño++;
	}
	
	public void addBefore(Position<E> p, E e) throws InvalidPositionException{
		DNodo<E> nodo=checkPosition(p);
		DNodo<E> nuevo=new DNodo<E>(e,nodo.getAnterior(),nodo);
		(nodo.getAnterior()).setSiguiente(nuevo);
		nodo.setAnterior(nuevo);
		tamaño++;
	}
	
	public E remove(Position<E> p) throws InvalidPositionException{
		DNodo<E> v=checkPosition(p);
		if(isEmpty())
			throw new InvalidPositionException("La Posicion es invalida.");
		DNodo<E> sig = v.getSiguiente();
		DNodo<E> ant = v.getAnterior();
		E elem = v.element();
		sig.setAnterior(ant);
		ant.setSiguiente(sig);
		v.setSiguiente(null);
		v.setAnterior(null);
		tamaño--;
		return elem;
	}

	public E set(Position<E> p, E element) throws InvalidPositionException{
		DNodo<E> v = checkPosition(p);
		if(isEmpty())
			throw new InvalidPositionException("La Posicion es invalida.");
		E toReturn = v.element();
		v.setElement(element);
		return toReturn;	
	}
		
	public Iterator<E> iterator(){
		return new ElementIterator<E>(this);
	}
		
	public Iterable<Position<E>> positions(){			
		PositionList<Position<E>> lista=new ListaDoblementeEnlazada<Position<E>>();
		try{
			if(!this.isEmpty()){
			Position<E> pos=first();
			while(pos!=null){
				lista.addLast(pos);
				if(pos==last())
					pos=null;
				else pos=next(pos);
			}
			}
		}
		catch(InvalidPositionException ipe){System.out.println(ipe.getMessage());}
		catch(BoundaryViolationException bve){System.out.println(bve.getMessage());}
		catch(EmptyListException ele){System.out.println(ele.getMessage());}
		return lista;
	}
	
	private DNodo<E> checkPosition(Position<E> p) throws InvalidPositionException{
		if (p==null) throw new InvalidPositionException("La posicion no es valida.");
		if (p==head) throw new InvalidPositionException("La cabeza no es una posicion valida.");
		if (p==tail) throw new InvalidPositionException("La cola no es una posicion valida.");
		try{
			DNodo<E> temp = (DNodo<E>) p;
			if ((temp.getAnterior() == null) || (temp.getSiguiente()==null))
					throw new InvalidPositionException("La posicion no es valida.");
			return temp;
		}
		catch(ClassCastException e){
			throw new InvalidPositionException("La posicion no es valida");
		}

}
}
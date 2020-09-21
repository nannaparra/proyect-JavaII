package TDAArbolBinario;
import java.util.Iterator;

import TDALista.*;

public class ArbolBinario<E> implements BinaryTree<E> {
	protected BTPosition<E> raiz;
	protected int size;
	
	public ArbolBinario(){
		raiz=null;
		size=0;
	}
	
	public int size(){return size;}
	public boolean isEmpty() {return size == 0;}

	public Position<E> left(Position<E> v) throws InvalidPositionException,BoundaryViolationException{
		BTPosition<E> vv = checkPosition(v);
		BTPosition<E> leftPos = vv.getLeft();
		if(leftPos == null)
			throw new BoundaryViolationException ("El nodo pasado por parametro es el izquierdo.");
		
		return (Position<E>)leftPos;
	}
	
	public Position<E> right(Position<E> v) throws InvalidPositionException,BoundaryViolationException{
		BTPosition<E> vv = checkPosition(v);
		BTPosition<E> rightPos = vv.getRight();
		if(rightPos == null)
			throw new BoundaryViolationException ("El nodo pasado por parametro es el derecho.");
		return (Position<E>)rightPos;
	}

	public boolean hasLeft(Position<E> v) throws InvalidPositionException{
		BTPosition<E> vv = checkPosition(v);
		return (vv.getLeft()!= null);
	}

	public boolean hasRight(Position<E> v) throws InvalidPositionException{
		BTPosition<E> vv = checkPosition(v);
		return (vv.getRight()!= null);
	}
	
	public Iterator<E> iterator(){
		Iterable<Position<E>> positions = positions();
		PositionList<E> elements = new ListaDoblementeEnlazada<E>();
		for(Position<E> pos : positions)
			elements.addLast(pos.element());			
		return elements.iterator();
		}
	
	public Iterable<Position<E>> positions(){
		PositionList<Position<E>> positions = new ListaDoblementeEnlazada<Position<E>>();
		if(size != 0)
			try {
				preorderPositions(positions, root());
			} catch (EmptyTreeException ete) {System.out.println(ete.getMessage());}
		      catch (InvalidPositionException ipe) {System.out.println(ipe.getMessage());}
		return positions;
	}
	
	public E replace(Position<E> v, E e) throws InvalidPositionException{
		BTPosition<E> vv = checkPosition(v);
		E temp = v.element();
		vv.setElement(e);
		return temp;
	}
	
	public BTPosition<E> root() throws EmptyTreeException{
		return raiz; 		
	}
	
	public Position<E> parent(Position<E> v) throws InvalidPositionException, BoundaryViolationException{
		BTPosition<E> vv = checkPosition(v);
		Position <E> parentPos = vv.getParent();
		if(parentPos == null)
			throw new BoundaryViolationException ("No hay padre.");
		return parentPos;
	}

	public Iterable<Position<E>> children(Position<E> v) throws InvalidPositionException{
		checkPosition(v);
		PositionList<Position<E>> hijos = new ListaDoblementeEnlazada<Position<E>>();
		try{
		if (hasLeft(v)) hijos.addLast(left(v));
		if (hasRight(v)) hijos.addLast(right(v));
		}catch (InvalidPositionException ipe) {System.out.println(ipe.getMessage());}
		 catch (BoundaryViolationException bve){System.out.println(bve.getMessage());}
		return hijos;
	}

	public boolean isInternal(Position<E> v) throws InvalidPositionException{
		checkPosition(v);
		return (hasLeft(v) || hasRight(v));
	}

	public boolean isExternal(Position<E> v) throws InvalidPositionException{
		checkPosition(v);
		return (!(hasLeft(v)) && !(hasRight(v)));
	}
	
	public boolean isRoot(Position<E> v) throws InvalidPositionException{
		checkPosition(v);
		boolean esRaiz;
		try {
			esRaiz = (v == root());
		} 
		catch (EmptyTreeException e) {throw new InvalidPositionException("La posicion no es valida"); }
		return esRaiz;
	}
	
	private BTPosition<E> checkPosition(Position<E> v) throws InvalidPositionException{
		try{
			if ((v == null) || !(v instanceof BTPosition))throw new InvalidPositionException("El arbol esta vacio.");
			return (BTPosition<E>) v;
		}
		catch(ClassCastException e){throw new InvalidPositionException("La posicion no es valida");}
	}
	public E remove (Position<E> v) throws InvalidPositionException {
		BTPosition<E> vv = checkPosition(v);
		BTPosition<E> leftPos = vv.getLeft();
		BTPosition<E> rightPos = vv.getRight();
		if (leftPos != null && rightPos != null)
			throw new InvalidPositionException("No se puede remover nodo con dos hijos");
		BTPosition<E> ww;
		if (leftPos != null)
			ww = leftPos;
		else if (rightPos != null)
			ww = rightPos;
		else
			ww = null;
		if (vv == raiz){
			if (ww != null)
				ww.setParent(null);
			raiz = ww;
		}
		else {
			BTPosition<E> uu = vv.getParent();
			if (vv == uu.getLeft())
				uu.setLeft(ww);
			else
				uu.setRight(ww);
			if(ww != null)
				ww.setParent(uu);
		}
		size--;
		return v.element();
	}
	public void Attach(Position<E> v, BinaryTree<E> T1, BinaryTree<E> T2) throws InvalidPositionException{
		BTPosition<E> vv = checkPosition(v);
		if (isInternal(v))
			throw new InvalidPositionException("No se puede usar el metodo attach desde un nodo interno");
		try{
			if (!T1.isEmpty()){
				BTPosition<E> r1 = checkPosition(T1.root());
				vv.setLeft(r1);
				r1.setParent(vv);
			}
			if (!T2.isEmpty()) {
				BTPosition<E> r2 = checkPosition(T2.root()); 
				vv.setRight(r2);
				r2.setParent(vv);
			}
			size=size+T1.size()+T2.size();
		}
		catch (EmptyTreeException e) {throw new InvalidPositionException("Uno de los arboles esta vacio.");}
	}
	
	public void createRoot(E e) throws InvalidOperationException{
		if (!isEmpty())
			throw new InvalidOperationException("El arbol ya tiene nodo.");
		size = 1;
		raiz = createNode(e,null,null,null);
		
		
	}
	public Position<E> addLeft(Position<E> v, E e) throws InvalidOperationException, InvalidPositionException{
		BTPosition<E> vv = checkPosition(v);
		Position<E> leftPos = vv.getLeft();
		if (leftPos != null)
			throw new InvalidPositionException("El nodo ya tiene un hijo izquierdo.");
		BTPosition<E> ww = createNode(e, vv, null, null);
		vv.setLeft(ww);
		size++;
		return ww;
	}
	
	public Position<E> addRight(Position<E> v, E e) throws InvalidOperationException, InvalidPositionException{
		BTPosition<E> vv = checkPosition(v);
		Position<E> rightPos = vv.getRight();
		if (rightPos != null)
			throw new InvalidPositionException("El nodo ya tiene un hijo derecho.");
		BTPosition<E> ww = createNode(e, vv, null, null);
		vv.setRight(ww);
		size++;
		return ww;
	}
	
	//Metodos privados
	private void preorderPositions(PositionList<Position<E>> pos,Position<E> v)throws InvalidPositionException{
		try{
		pos.addLast(v);
		if (hasLeft(v)) preorderPositions(pos, left(v));
		if (hasRight(v)) preorderPositions(pos, right(v));
	}catch (InvalidPositionException ipe) {System.out.println(ipe.getMessage());}
	 catch (BoundaryViolationException bve){System.out.println(bve.getMessage());}
	}
	
	private BTPosition<E> createNode (E element, BTPosition<E> parent, BTPosition<E> left, BTPosition<E> right){
		return new BTNodo<E> (element,parent,left,right);
	}

}

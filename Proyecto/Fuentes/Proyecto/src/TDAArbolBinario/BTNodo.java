package TDAArbolBinario;

public class BTNodo<E> implements BTPosition<E> {
	
	protected E elem;
	protected BTPosition<E> der, izq, p;
	
	public BTNodo(E element,BTPosition<E> parent,BTPosition<E> left,BTPosition<E> right){
		elem = element;
		der = right;
		izq = left;
		p = parent;
	}
	
	public void setElement(E elemento){elem=elemento;}
	
	public void setParent(BTPosition<E> padre){
		p=padre;}
	
	public void setLeft(BTPosition<E> izquierdo){izq=izquierdo;}
	
	public void setRight(BTPosition<E> derecho){der=derecho;}
	
	public BTPosition<E> getParent(){return p;}
	
	public BTPosition<E> getLeft(){return izq;}
	
	public BTPosition<E> getRight(){return der;}
	
	public E element(){return elem;} 
}

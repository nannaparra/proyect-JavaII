package Proyecto;

import TDAArbolBinario.*;
import TDAArbolBinario.BoundaryViolationException;
import TDAArbolBinario.InvalidPositionException;
import TDALista.*;
import TDAPila.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;




/**
 * Clase Logica.
 * @author Nadina Parra, Gabriela Salina. Estructura de datos 1er cuatrimestre 2017. UNS.
 */

public class Logica {
	
	ArbolBinario<String> arbol;
	ListaDoblementeEnlazada<String> listaPreguntas;
	PilaEnlazada<String> p; 
	String nodosinternos;
	BTPosition<String> nodo;
	String hoja;
	int cantP;
	int cantO;
	
	
	public Logica(){
		arbol=new ArbolBinario<String> ();
		listaPreguntas=new ListaDoblementeEnlazada<String>();
		p=new PilaEnlazada<String>();
		hoja="";
		cantP=0;
		cantO=0;
		crearArchivo();
	}
	
	/**
	 * Crea la raiz del árbol.
	 */
	public void crearArbol(){
		try{
			arbol.createRoot("un auto");
		}
		catch (InvalidOperationException ioe){ioe.getMessage();}
	}
	
	/**
	 * Crea un archivo en el disco.
	 */
	private void crearArchivo(){
		File archivo;
		   try{
			   archivo = new File( "proyecto.txt" );
			   
			   if (archivo.createNewFile()){
				   System.out.println("Se ha creado el archivo.");
			   }
		   }catch(IOException e){
			   System.out.println("No se ha podido crear el archivo.");
		   }
	}
	
	/**
	 * Borra todo el contenido del archivo.
	 */
	public void borrarArchivo(){
		try{
		    BufferedWriter inw = new BufferedWriter(new FileWriter("proyecto.txt"));
		    inw.write("");
		    inw.close();
			}catch(IOException e){
				e.getMessage();
			}
	}
	
	/**
	 * Agrega un nodo como padre del parametro ult y otro como hijo del parametro preg.
	 * @param preg rotulo del nodo padre a asignar como padre de ult y obj
	 * @param obj rotulo del nodo hijo a asignar a preg.
	 * @param ult rotulo del nodo hijo al que se le asigna el padre y hermano
	 */
	public void agregarNodo(String preg, String obj, String ult){
		BTPosition<String> nodoult=Buscar(ult);
		try {
		String aux=nodoult.element();
		nodoult.setElement(preg);
		arbol.addLeft(nodoult,aux);
		arbol.addRight(nodoult, obj);
		
		}catch (InvalidOperationException e) {e.printStackTrace();}
		 catch (InvalidPositionException e) {e.printStackTrace();}
	}
	
	/**
	 * Muestra los nodos internos del árbol en pantalla.
	 * @return devuelve una cadena de string con los elementos de los nodos internos.
	 */
	public String mostrarPreguntas(){
		String nodosInternos="";
		while(!p.isEmpty()){
			try {
				nodosInternos=nodosInternos+p.pop()+"\n";
			} catch (EmptyStackException e) {e.printStackTrace();}
			
		}
	return nodosInternos;
	}
	/**
	 * Guarda las preguntas del árbol.
	 */
	public void guardarPreguntas(){
		try {
			preorderNodosInternos(arbol.root());
		} catch (EmptyTreeException e) {e.printStackTrace();}
	}
	/**
	 * Recorre el árbol, si es una pregunta la guarda en una lista y una pila.
	 * @param pos la posición de la raiz del árbol.
	 */
	private void preorderNodosInternos(BTPosition<String> pos){
		try{
		if(arbol.isInternal(pos)){
			listaPreguntas.addLast(pos.element());
			p.push(pos.element());
		}
		if (arbol.hasLeft(pos)) preorderNodosInternos(pos.getLeft());
	    if (arbol.hasRight(pos)) preorderNodosInternos(pos.getRight());
		}
		catch(InvalidPositionException ipe){System.out.println(ipe.getMessage());}
	
	}
	/**
	 * Mustra el elemento del hijo derecho del nodo pasado como parametro.
	 * @param v rotulo del ultimo nodo mostrado en pantalla.
	 * @return devuelve una cadena de string con el elemento del nodo hijo derecho.
	 */
	public String respuestaSi(String v) {
		BTPosition<String> nodo;
		String hijo="";
		try{
		nodo=Buscar(v);
		if (arbol.isExternal(nodo)){
			
			return ("Adivino");
		}
		else{
			BTPosition<String> hd=nodo.getRight();
		    hijo=hd.element();
		}		
		}catch(InvalidPositionException ipe){System.out.println(ipe.getMessage());}
		return hijo;
	}
	
	/**
	 * Muestra el elemento del hijo izquierdo del nodo pasado como parametro.
	 * @param v rotulo del ultimo nodo mostrado en pantalla.
	 * @return devuelve una cadena de String con el elemento del hijo izquierdo.
	 */
	public String respuestaNo(String v){
		BTPosition<String> nodo;
		String hijo="";
		try {
		nodo = Buscar(v);
		if(arbol.isExternal(nodo)) {
			return("No Adivino");
		}
		else{
		BTPosition<String> hi=nodo.getLeft();
	    hijo=hi.element();
		}
	   }catch(InvalidPositionException ipe){System.out.println(ipe.getMessage());}
		return hijo;
	}
	
	/**
	 * Muestra el elemento de la raiz del árbol.
	 * @return devuelve una cadena de string con el rotulo del nodo raiz.
	 */
	public String mostrarObjeto(){
		String ob="";
		try{
		ob=((arbol.root()).element());
		}catch(EmptyTreeException ete){System.out.println(ete.getMessage());}
		return ob;
	}
	/**
	 * Guarda los rotulos de los nodos del árbol en un archivo.
	 */
	public void guardarDatosEnArchivo () {
		try{
		PositionList<String> lista = crearListaDelArbol();
			String ruta = "proyecto.txt";
			BufferedReader inr = new BufferedReader(new FileReader(ruta));
		    BufferedWriter inw = new BufferedWriter(new FileWriter(ruta));
		    int contador = 1;
		    Position<String> p =null;
		   
			while (lista.size()>contador)
	    	{
				if (contador == 1)
			    {
				   inw.write(lista.first().element()+"");
				   p =  (Position<String>) lista.first();
				   
				}
				inw.write(lista.next((TDALista.Position<String>) p).element());
				contador++;
				p = (Position<String>) lista.next((TDALista.Position<String>) p);
				
	    	}
			inr.close();
		    inw.close();
	   }catch (IOException err) {err.getMessage();}
		catch (TDALista.InvalidPositionException e) {e.printStackTrace();}
		catch (TDALista.BoundaryViolationException e) {e.printStackTrace();}
		catch (EmptyListException ele){ele.getMessage();}

	}
	
	/**
	 * Crea una lista de String con los rotulos de los nodos del árbol.
	 * @return retorna la lista.
	 */
	private PositionList<String> crearListaDelArbol(){
		PositionList<String> lista = new ListaDoblementeEnlazada<String>();
		try{
			
		lista.addLast(arbol.root().element()+"");
		lista.addLast(".");
	    int longitud = altura();
	    int contador = 1;
	    Stack<String> pila = new PilaEnlazada<String>();
	    Position<String> padre = null;
	   
		    while(longitud>=contador)
		    {
		    	for (Position<String> v: arbol.positions())
				if (profundidad(v)==contador)
		         {
					//nod = checkPosition(v);
					padre =  (Position<String>)(((BTNodo<String>)v).getParent());
					if (arbol.hasLeft(padre) && arbol.hasRight(padre))
					{
						pila.push(v.element());
		    	        pila.push("-");
					}
					else if (!arbol.hasLeft(padre) && arbol.hasRight(padre))
					{
						pila.push("#");
		    	        pila.push("-");
					}
					else if ((arbol.left(padre)).element()=="#" && arbol.hasRight(padre))
					{
						pila.push("#");
		    	        pila.push("-");
					}
					else if (!arbol.hasRight(padre) && arbol.hasLeft(padre))
					{
						pila.push("#");
		    	        pila.push("-");
					}
					else if ((arbol.right(padre)).element()=="#" && arbol.hasLeft(padre))
					{
						pila.push("#");
		    	        pila.push("-");
					}
		        }	
		    	while (!pila.isEmpty())
		    		lista.addLast(pila.pop()+"");
			   	contador++;
			   	lista.addLast("-");
			   	lista.addLast(".");
		    }
		    lista.addLast("*");
		    }catch(EmptyStackException e){e.getMessage();}
		    catch(InvalidPositionException e){e.getMessage();}
		    catch(BoundaryViolationException e){e.getMessage();}
		    catch (EmptyTreeException ete){ete.getMessage();}
	    	return lista;
	}
	
	/**
	 * Vacia el arbol.
	 */
	public void resetArbol(){
		ArbolBinario<String> aux=new ArbolBinario<String>();
		arbol=aux;
	}
	
     /**
      * Arma el árbol con los rotulos guardados en el archivo.
      */
	 public void armarArbol(){
		String ruta = "proyecto.txt";
		ArbolBinario<String> arbol2= new ArbolBinario<String>();
		
		try {
			BufferedReader inr = new BufferedReader(new FileReader(ruta));
			
		    String str = "";		
		    String strI = "";
		    String strD = "";
            
            char c = '-';
            int guion = (int)c;
            char p = '.';
            int punto = (int)p;
            int ch = 0;
            String hijoIzq = "";
            String hijoDer = "";
            char a = '*';
            int asterisco = (int)a;
            
        
            while (punto != (ch = inr.read())){//mientras sea distinto de punto
			str = str + (char)ch + "";
			}
            
	        arbol2.createRoot(str);
	        str = "";
            
            while (asterisco != (ch = inr.read())){
            	
					while (guion != (ch = inr.read())){//mientras sea distinto de guion
					str = str + (char)ch + "";					
					}
					
					hijoDer = str;
					str = "";
					
					while (guion != (ch = inr.read())){//mientras sea distinto de guion
					str = str + (char)ch + "";
					}
					
					hijoIzq = str;
					str = "";
					arbol2.addLeft(arbol2.root(), hijoIzq);
					arbol2.addRight(arbol2.root(), hijoDer);					
			        inr.read();//el elemento va a ser un guion(esto es para que pase el guion)
			        inr.read();//el elemento va a ser un punto(esto es para que pase el punto)
					
					
				if (arbol2.size()>3){
					
					for(Position<String> w : arbol2.positions()){
						    strI = "";
						    strD = "";
					    	if (arbol2.isExternal(w)){					    		
					  			while (guion != (ch = inr.read())) //mientras sea distinto de guion
								    strI = strI + (char)ch + "";
					  			hijoIzq = strI;
								
								while (guion != (ch = inr.read()))//mientras sea distinto de guion
									strD = strD + (char)ch + "";
								hijoDer = strD;
								arbol2.addLeft(w,hijoIzq);
								arbol2.addRight(w, hijoDer);
																		
							}
					}
			    }
		   guardarDatosEnArchivo();
		   inr.close();
		}
            arbol=arbol2;
		}catch (IOException err) {System.out.println ("Error al leer el archivo");}
		catch (InvalidOperationException e) {e.printStackTrace();}
		catch (InvalidPositionException ipe){ipe.getMessage();}
		catch (EmptyTreeException ete){ete.getMessage();}
	}
	
	 
	/**
	 * Cuenta la altura del árbol.
	 * @return int altura del árbol.
	 */
	public int obtenerAltura(){
		return altura();
	}
	
	/**
	 * Cuenta la cantidad de objetos almacenados en el árbol.
	 * @return int cantidad de objetos.
	 */
	public int cantObjetosAlm(){	
		cantO=0;
		try {
			contObj(arbol.root());
		} catch (EmptyTreeException e) {e.printStackTrace();}		
		return cantO;
	}
	
	/**
	 * Recorre el árbol, si es un objeto incrementa el contador.
	 * @param pos posición de la raiz del árbol.
	 */
	private void contObj(BTPosition<String> pos){
		try{
		    if(arbol.isExternal(pos)) cantO++;
			if (arbol.hasLeft(pos)) contObj(pos.getLeft());
		    if (arbol.hasRight(pos)) contObj(pos.getRight());
	        } catch (InvalidPositionException ipe) {System.out.println(ipe.getMessage());}
	}

	/**
	 * Cuenta la cantidad de preguntas almacenadas en el árbol.
	 * @return int cantidad de preguntas.
	 */
	public int cantPregAlm(){	
		cantP=0;
		try {
			contPreg(arbol.root());
		} catch (EmptyTreeException e) {e.printStackTrace();}		
		return cantP;
	}
	
	/**
	 * Recorre el árbol, si es una pregunta incrementa el contador.
	 * @param pos posicion de la raiz del árbol.
	 */
	private void contPreg(BTPosition<String> pos){
		try{
		    if(arbol.isInternal(pos)) cantP++;
			if (arbol.hasLeft(pos)) contPreg(pos.getLeft());
		    if (arbol.hasRight(pos)) contPreg(pos.getRight());
	        } catch (InvalidPositionException ipe) {System.out.println(ipe.getMessage());}
	}
	
	/**
	 * Muestra la descripcion de los objetos del árbol
	 * @return devuelve una cadena de String con la descripcion de cada objeto.
	 */
	
	public String mostrarDescripcion() {
		String str = "";
		String str2="";
		try{
		for (Position<String> w : arbol.positions())
		{
			
			if (arbol.isExternal(w))
			{
				str = str + "\n" + w.element() + " es un medio de transporte que ";
				str = str + mostrarDescObj(w,str2);
			}
		}
		}catch (InvalidPositionException ipe){ipe.getMessage();}
		return str;
		}
	
	private String mostrarDescObj(Position<String> v,String str){
		try{
		if (arbol.isRoot(v))
			if ((arbol.left(arbol.parent(v))).element().compareTo(v.element())== 0)
			    str = str + " y no" + arbol.root().element();
			else
				str = str + " y " + arbol.root().element();
				
		else
			if ((arbol.left(arbol.parent(v))).element().compareTo(v.element())== 0)
			    str = str +	" no " + arbol.parent(v).element() + mostrarDescObj(arbol.parent(v),str);
			else
				str = str + arbol.parent(v).element() + mostrarDescObj(arbol.parent(v),str);
		
		}catch (BoundaryViolationException bve){bve.getMessage();}
		catch (InvalidPositionException ipe){ipe.getMessage();}
		catch (EmptyTreeException ete){ete.getMessage();}
				
		return str;
	}
		
	/**
	 * Busca el nodo que tenga el elemento equivalente al pasado como parametro.
	 * @param v rotulo del nodo a buscar.
	 * @return posicion del nodo equivalente al string.
	 */
	private BTPosition<String> Buscar(String v){
		try{
			preorder(arbol.root(),v);
		} catch (EmptyTreeException ete){System.out.println(ete.getMessage());}
		return nodo;
	}
	
	/**
	 * Recorre el árbol, si es equivalente al String devuelve su posicion.
	 * @param pos posicion del nodo con rotulo v.
	 * @param v rotulo del nodo a buscar.
	 */
	private void preorder(BTPosition<String> pos,String v) {
		if((pos.element()).equals(v))  nodo=pos; 
		try{
		
			if (arbol.hasLeft(pos)) preorder(pos.getLeft(),v);
		    if (arbol.hasRight(pos)) preorder(pos.getRight(),v);
	        } catch (InvalidPositionException ipe) {System.out.println(ipe.getMessage());}
	}
	
	/**
	 * Crea un arreglo de String con los rotulos de las raices de los subArbol.
	 * @return el arreglo de String.
	 */
	public String[] crearString(){
		String cadena = "";
		try{
			PositionList<String> lista = obtenerNodosInternos(); 
			Position<String> p = lista.first();
			Position<String> ultima = lista.last();            
			
			//cadena = cadena +"[" ;
			while( p != null ) {    
				cadena = cadena +( p.element());  
				if( p == ultima ) { 
					//cadena = cadena +( "]" ); 
					p = null;  
					}   
				else
				{ 
					cadena  =  cadena + ( ":" );
					p = lista.next(p);  
					}       
				}
			
		}catch(EmptyListException e){e.getMessage();}
		 catch(TDALista.BoundaryViolationException e){e.getMessage();}
	     catch(TDALista.InvalidPositionException e){e.getMessage();}
	
     return cadena.split(":");
	}
	
	
	/**
	 * Recorre el árbol, si es una raiz del subArbol lo agrega al arreglo.
	 * @return una lista de posiciones con los nodos internos.
	 */
	private PositionList<String> obtenerNodosInternos(){
		PositionList<String> lista = new ListaDoblementeEnlazada<String>();
		try{
		for (Position<String> w : arbol.positions())
			if (arbol.isInternal(w) && !arbol.isRoot(w)){
				lista.addLast(w.element());
			}
		}catch(InvalidPositionException e){e.getMessage();}
		return lista;
	}
	
	
	/**
	 * Elimina un subarbol elegido por el usuario
	 * @param nodo rotulo del nodo que el usuario eligio.
	 */
	public void eliminarSubarbol(String nodo){
		BTPosition<String> raizsub=Buscar(nodo);
	    buscarHoja(raizsub);
	    raizsub.setElement(hoja);
	    borrarHijos(raizsub,hoja);
	}
	
	/**
	 * Busca la primera hoja del subArbol.
	 * @param pos posicion de la raiz del subarbol elegido.
	 */
	private void buscarHoja(BTPosition<String> pos) {
		try {
			if(arbol.isExternal(pos)) hoja=pos.element()+"";
		
			if (arbol.hasLeft(pos)) buscarHoja(pos.getLeft());
		    if (arbol.hasRight(pos)) buscarHoja(pos.getRight());
	        } catch (InvalidPositionException ipe) {System.out.println(ipe.getMessage());}
	
	}
	
	/**
	 * Elimina los hijos del subarbol elegido.
	 * @param pos posicion de la raiz del subArbol.
	 * @param hoja rotulo de la raiz del subArbol.
	 */
	private void borrarHijos(BTPosition<String> pos, String hoja) {
		try {
			if (arbol.hasLeft(pos)) borrarHijos(pos.getLeft(),hoja);
		    if (arbol.hasRight(pos)) borrarHijos(pos.getRight(),hoja);
		    
		    if(pos.element()!=hoja) arbol.remove(pos);
	        } catch (InvalidPositionException ipe) {System.out.println(ipe.getMessage());}
		
	}    
	
	/**
	 * Calcula la altura del árbol.
	 * @return int altura del árbol.
	 */
	private int altura(){
		int h=0;
		try{
			for(Position<String> v:arbol.positions())
		       if (arbol.isExternal(v))h=Math.max(h,profundidad(v));
			return h;
		 
		}catch(InvalidPositionException ipe){ipe.getMessage();}
	    return h;
	}
	
	/**
	 * Calcula la profundidad del árbol.
	 * @param v 
	 * @return int profundidad del árbol.
	 */
	private int profundidad(Position<String> v){
		int x=0;
		try {
			if (arbol.isRoot(v))
				return x;
			else
				return x=1 + profundidad(arbol.parent(v));
		} catch (InvalidPositionException e) {e.printStackTrace();} 
		  catch (BoundaryViolationException e) {e.printStackTrace();}
		return x;
	}
	
	
	
	



}

package mainapp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

import exceptions.ColaExceededSizeException;
import exceptions.ElementBlockedException;
import exceptions.LlevateTuNullDeAquiException;

public class ColaDelCastigo<E>{
	private Comparator<E> comparador;
	private ArrayList<E> elementos;
	

	public ColaDelCastigo(Comparator<E> comparador) {
		super();
		this.comparador = comparador;
		this.elementos = new ArrayList<>();
	}

	/**
	 * Devuelve el tamaño de la cola
	 * @return
	 */
	public int size() {
		return elementos.size();
	}

	/**
	 * Dice si la cola se encuentra vacia o no
	 * @return
	 */
	public boolean isEmpty() {
		if(elementos.size()==0)
		{
			return true;
		}
		return false;
	}

	/**
	 * Dice si el elemento se encuentra en la cola
	 * @param o
	 * @return
	 */
	public boolean contains(Object o) {
		
		return elementos.contains(o);
	}

	/**
	 * Crea un iterador de la cola
	 * @return
	 */
	public Iterator iterator() {
		// TODO Auto-generated method stub
		return elementos.iterator();
	}

	/**
	 * Devuelve la cola en formato array
	 * @return
	 */
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return elementos.toArray();
	}

	/**
	 * Saca todos los elementos del objeto a
	 * @param a
	 * @return
	 */
	public Object[] toArray(Object[] a) {
		// TODO Auto-generated method stub
		return elementos.toArray(a);
	}

	/**
	 * Elimina el objeto o de la lista
	 * @param o
	 * @return
	 * @throws ElementBlockedException
	 */
	public boolean remove(Object o) throws ElementBlockedException {
		if(elementos.size()==1)
		{
			throw new ElementBlockedException("No puedes vaciar la cola");
		}
		else
		{
			return elementos.remove(o);
		}
	}

	/**
	 * Dice si todos los elementos de la colección c se encuentran en la cola
	 * @param c
	 * @return
	 */
	public boolean containsAll(Collection c) {
		
		return elementos.containsAll(c);
	}

	/**
	 * Añade todos los elementos de la colección c a la cola solo si al hacerlo no supera los 10 elementos
	 * @param c
	 * @return
	 * @throws ColaExceededSizeException
	 */
	public boolean addAll(Collection c) throws ColaExceededSizeException, LlevateTuNullDeAquiException {

		if(c.contains(null))
		{
			throw new LlevateTuNullDeAquiException("Ahí hay un null que no me gusta");
		}
		if(this.elementos.size()<10)
		{
			this.elementos.addAll(c);
			this.elementos.sort(this.comparador);
			return true;
		}
		else
		{
			throw new ColaExceededSizeException("No puedo meter ese troncho");
		}
	}

	/**
	 * Elimina todos los elementos de la colección c de la cola
	 * @param c
	 * @return
	 * @throws ElementBlockedException
	 */
	public boolean removeAll(Collection c) throws ElementBlockedException {
		if(elementos.size()<=c.size())
		{
			throw new ElementBlockedException("No puedes vaciar la cola");
		}
		return elementos.removeAll(c);
	}

	/**
	 * Borra de la cola todos los elementos de la cola que no estén en la colección c
	 * @param c
	 * @return
	 * @throws ElementBlockedException
	 */
	public boolean retainAll(Collection c) throws ElementBlockedException {
		if(c.isEmpty())
		{
			throw new ElementBlockedException("No puedes vaciar la cola");
		}
		return elementos.retainAll(c);
	}

	/**
	 * Lanza una excepción porque no se puede vaciar la lista
	 * @throws Exception
	 */
	public void clear() throws Exception{
		throw new ElementBlockedException("No puedes vaciar la lista");
		
	}

	/**
	 * Añade un elementos a la cola
	 * @param e
	 * @return
	 * @throws Exception
	 */
	public boolean add(E e) throws ColaExceededSizeException, LlevateTuNullDeAquiException {
		if(Objects.isNull(e))
		{
			throw new LlevateTuNullDeAquiException("De nulls nanay");
		}
		else if(this.elementos.size()<10)
		{
			this.elementos.add(e);
			this.elementos.sort(this.comparador);
			return true;
		}
		else
		{
			throw new ColaExceededSizeException("Cusha que no cabe");
		}
	}

	/**
	 * Intenta añadir un elemento a la cola
	 * @param e
	 * @return
	 */
	public boolean offer(E e) {
		// TODO Auto-generated method stub
		if(this.elementos.size()<10)
		{
			this.elementos.add(e);
			this.elementos.sort(this.comparador);
			return true;
		}
		else
			return false;
	}

	/**
	 * Elimina el elemento indexado con i de la cola solo si al hacerlo no vacia la cola
	 * @param i
	 * @return
	 * @throws Exception
	 */
	public Object remove(int i) throws Exception {
		if(this.elementos.size()==1)
		{
			throw new ElementBlockedException("La cola no puede quedar vacía");
		}
		if(this.elementos.size()-1<i)
		{
			throw new Exception("Te has slid de la lista");
		}
		else
		{
			this.elementos.remove(i);
		}
		return null;
	}

	/**
	 * Elimina el primer elemento de la cola
	 * @return
	 * @throws Exception
	 */
	public Object poll() throws Exception {
		return this.remove(0);
	}

	/**
	 * Muestra el primer elemento de la cola
	 * @return
	 */
	public Object element() {
		// TODO Auto-generated method stub
		return elementos.get(0);
	}

	/**
	 * Muestra el primer elemento de la cola
	 * @return
	 */
	public Object peek() {
		// TODO Auto-generated method stub
		return this.element();
	}
	
}

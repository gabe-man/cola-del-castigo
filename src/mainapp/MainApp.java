package mainapp;

import java.util.ArrayList;
import java.util.Iterator;

public class MainApp {

	public static void main(String[] args) throws Exception {
		ColaDelCastigo<Integer> cola = new ColaDelCastigo<>((Integer n1,Integer n2) -> {
			return n1-n2;
		});
		
		cola.add(3);
		cola.add(9);
		cola.add(-5);
		
		/*Esto debe mostrar la excepción de ElementBlockedException
		for (int i = 0; i < 3; i++) {
			cola.remove(0);
		}
		*/
		
		cola.add(7);
		cola.add(1);
		cola.add(0);
		cola.add(2);
		cola.add(4);
		cola.add(-6);
		cola.add(-4);
		
		/*Al añadir este elemento lanzará la excepción ColaExceededSizeException
		cola.add(-7);
		*/
		
		/*Al añadir este null saltará la excepción LlevateTuNullDeAquiException
		cola.add(null);
		*/
		
		/*Aqui también saltará la excepción LlevateTuNullDeAquiException
		ArrayList<Integer> lista = new ArrayList<>();
		lista.add(null);
		
		cola.addAll(lista);
		*/
		
		Iterator<Integer> iterador=cola.iterator();
		
		while(iterador.hasNext())
		{
			System.out.println(iterador.next());
		}

	}

}

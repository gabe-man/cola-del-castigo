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
		
		/*Esto debe mostrar la excepci�n de ElementBlockedException
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
		
		/*Al a�adir este elemento lanzar� la excepci�n ColaExceededSizeException
		cola.add(-7);
		*/
		
		/*Al a�adir este null saltar� la excepci�n LlevateTuNullDeAquiException
		cola.add(null);
		*/
		
		/*Aqui tambi�n saltar� la excepci�n LlevateTuNullDeAquiException
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

package robo;

import java.util.List;

/** Este programa sirve para ordenar n elementos 
	con un algoritmo de los "malos" (cuadr�tico) 
	Es la BURBUJA Y QUICKSORT */
public class Ordenacion
{
	
	/**
	 * Intercambia los elementos de las posiciones i, j en el array a
	 */
	private static void intercambiar (List<Botin> robo, int i, int j)
	{
		Botin t;
		t= robo.get(i);
		robo.set(i, robo.get(j));
		robo.set(j,t);
	}

	/**
	 * Ordenaci�n por el m�todo de Burbuja
	 * @param a array de enteros, despu�s de la llamada quedar�a ordenado
	 */
	public List<Botin> burbuja (List<Botin> robo) 
	{
		int n= robo.size();
		for (int i=0;i<=n-2;i++) 
			for (int j=n-1;j>i;j--)
				if (robo.get(j-1).getProporcion()<robo.get(j).getProporcion())
					intercambiar (robo,j-1,j);
		
		return robo;
		
	}

	/** Deja el	pivote en una posicion tal que a su izquierda no 
	hay ning�n mayor, ni a la derecha ning�n menor.
	Es un proceso lineal O(n).  
	 */
	private static int particion(List<Botin> robo,int iz,int de) 
	{
		int centro = (de + iz) / 2;

		if (robo.get(iz).getProporcion() < robo.get(de).getProporcion())
			intercambiar(robo, iz, de);
		if (robo.get(iz).getProporcion() < robo.get(centro).getProporcion())
			intercambiar(robo, iz, centro);
		if (robo.get(centro).getProporcion() < robo.get(de).getProporcion())
			intercambiar(robo, centro, de);
		return centro;
	}

	/**
	 * Ordenaci�n por el m�todo R�pido (Quicksort)
	 * M�todo divide y vencer�s de complejidad estudiada en clase
	 */  
	private List<Botin>  rapirec (List<Botin> robo, int iz, int de) 
	{
		double pivote;
		int i = iz;
		int j = de - 1;


		if (iz < de) { 
			int centro = particion(robo, iz, de);

			if ((de - iz) >= 3) { 
				pivote = robo.get(centro).getProporcion(); 
				intercambiar(robo, centro, de); 

				do {
					while (robo.get(i).getProporcion() >= pivote && i < de)
						i++; 
					while (robo.get(j).getProporcion() <= pivote && j > iz)
						j--; 
					if (i < j)
						intercambiar(robo, i, j);
				} while (i < j); 


				intercambiar(robo, i, de);
				rapirec(robo, iz, i - 1);
				rapirec(robo, i + 1, de);
			} 
		}
		
		return robo;
	}



	public  List<Botin> rapido (List<Botin> robo) 
	{
		rapirec(robo,0,robo.size() -1);
		return robo;

	}

}





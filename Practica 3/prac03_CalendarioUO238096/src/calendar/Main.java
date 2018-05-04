package calendar;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final String FICHERO_PARTICIPANTES = "files/jugadores04.txt";
	
	private static List<String> jugadores = new ArrayList<String>();
	
	
	private static void cargarParticipantes(){
	    String linea = "";	   
	    try {
	      BufferedReader fichero = new BufferedReader(new FileReader(FICHERO_PARTICIPANTES));
	      while (fichero.ready()) {
	        linea = fichero.readLine();	        
	        jugadores.add(linea);
	      }
	      fichero.close();
	    }
	    catch (FileNotFoundException fnfe) {
	      System.out.println("El archivo no se ha encontrado.");
	    }
	    catch (IOException ioe) {
	      new RuntimeException("Error de entrada/salida.");
	    } 
	  }

		public static void main(String[] args) {
		cargarParticipantes();
		int n= Integer.parseInt(jugadores.get(0));
		int[][] tabla = new int[n][n-1];
		Calendar c= new Calendar();
		tabla=c.calendar(tabla,jugadores);
		c.mostrarTabla(tabla);
		//c.medirTiempos(1000000);

		}
		
		

		
}

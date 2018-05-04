package robo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final String FICHERO_BOTIN = "files/botin02.txt";

	private static List<String> botin = new ArrayList<String>();

	private static void cargarBotin() {
		String[] linea = null;
		try {
			BufferedReader fichero = new BufferedReader(new FileReader(FICHERO_BOTIN));
			while (fichero.ready()) {
				linea = fichero.readLine().split(" ");
				botin.add(new String(linea[0]));
				if (linea.length > 1)
					botin.add(new String(linea[1]));
			}
			fichero.close();
		} catch (FileNotFoundException fnfe) {
			System.out.println("El archivo no se ha encontrado.");
		} catch (IOException ioe) {
			new RuntimeException("Error de entrada/salida.");
		}
	}

	public static void medir() {

		Tiempos t = new Tiempos();
		t.medirTiemposImplementacion1(1000);
		t.medirTiemposImplementacion2(1000);
		t.medirTiemposImplementacion3(1000);

	}

	public static void main(String[] args) {
		cargarBotin();
		Robo robo = new Robo(botin);
		
		robo.implementacion1();
		robo.mostrarRobo();		
		robo.implementacion2();
		robo.mostrarRobo();
		robo.implementacion3();
		robo.mostrarRobo();
		
		 medir();

	}

}
package robo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	private static final String FICHERO_BOTIN = "files/botin03.txt";

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

	public static void main(String[] args) {
		cargarBotin();
		Robo robo = new Robo(botin);

		robo.crearBotin();
		robo.robar();
		robo.print();
		robo.medirTiempos(10000);

	}

}
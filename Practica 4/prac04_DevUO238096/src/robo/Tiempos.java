package robo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tiempos {

	Robo r = new Robo();
	private List<Botin> robo = new ArrayList<Botin>();

	
	
	/** Metodo que crea aleatoriamente un botin**/
	public void crearRobo(int tamaño) {
		robo.clear();
		for (int i = 0; i < tamaño; i++)
			robo.add(new Botin(generarAleatorio(), generarAleatorio()));
		r.setCargaMax(25 * tamaño);
		r.setBotinMax(tamaño);

	}
	
	/** Metodo que genera aleatorios**/
	public int generarAleatorio() {
		Random r = new Random();
		return r.nextInt(Integer.MAX_VALUE);

	}

	/** Metodos para medir los tiempos de las diferentes implementaciones**/
	public void medirTiemposImplementacion1(int n) {

		long t1, t2;

		for (int i = 10; i <= 80000; i *= 2) {

			crearRobo(i);
			t1 = System.currentTimeMillis();
			for (int repeticion = 1; repeticion <= n; repeticion++) {
				r.implementacion1Tiempos(robo);
			}
			t2 = System.currentTimeMillis();
			System.out.println(i + "," + (t2 - t1));
		}
	}

	public void medirTiemposImplementacion2(int n) {

		long t1, t2;

		for (int i = 10; i <= 80000; i *= 2) {

			crearRobo(i);

			t1 = System.currentTimeMillis();
			for (int repeticion = 1; repeticion <= n; repeticion++) {
				r.implementacion2Tiempos(robo);
			}
			t2 = System.currentTimeMillis();

			System.out.println(i + "," + (t2 - t1));
		}
	}
	
	public void medirTiemposImplementacion3(int n) {

		long t1, t2;

		for (int i = 10; i <= 80000; i *= 2) {

			crearRobo(i);

			t1 = System.currentTimeMillis();
			for (int repeticion = 1; repeticion <= n; repeticion++) {
				r.implementacion3Tiempos(robo);
			}
			t2 = System.currentTimeMillis();

			System.out.println(i + "," + (t2 - t1));
		}
	}

}

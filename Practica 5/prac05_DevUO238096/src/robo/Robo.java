package robo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Robo {

	private List<String> botin = null;
	private List<Botin> robo = new ArrayList<Botin>();
	private int cargaMax;
	private int botinMax;
	private int[][] matriz;

	public Robo(List<String> botin) {
		super();
		this.botin = botin;
		setCargaMax(Integer.parseInt(botin.get(1)));
		setBotinMax(Integer.parseInt(botin.get(0)));
		matriz = new int[botinMax][cargaMax + 1];

	}

	public Robo() {
		super();
	}

	public int getCargaMax() {
		return cargaMax;
	}

	public void setCargaMax(int cargaMax) {
		this.cargaMax = cargaMax;
	}

	public int getBotinMax() {
		return botinMax;
	}

	public void setBotinMax(int botinMax) {
		this.botinMax = botinMax;
	}

	public void crearBotin() {

		for (int i = 2; i < botin.size(); i = i + 2)
			robo.add(new Botin(Integer.parseInt(botin.get(i)), (Integer.parseInt(botin.get(i + 1)))));

	}

	private int getMax(int a, int b) {
		if (a > b) {
			return a;
		}
		return b;
	}

	public void robar() {
		for (int i = 0; i < botinMax; i++) {
			for (int j = 0; j <= cargaMax; j++) {
				if (i == 0) {
					if (j < robo.get(0).getPeso()) {
						matriz[i][j] = 0;
					} else {
						matriz[i][j] = robo.get(0).getValor();
					}
				}
				if (i >= 1) {
					if (j < robo.get(i).getPeso()) {
						matriz[i][j] = matriz[i - 1][j];
					} else {
						matriz[i][j] = getMax(matriz[i - 1][j],
								matriz[i - 1][j - robo.get(i).getPeso()] + robo.get(i).getValor());
					}
				}
			}
		}
	}

	/** Metodo que crea aleatoriamente un botin **/
	public void crearRobo(int tamaño) {
		robo.clear();
		for (int i = 0; i < tamaño; i++)
			robo.add(new Botin(generarAleatorio(), generarAleatorio()));
		setCargaMax(25 * tamaño);
		setBotinMax(tamaño);
		matriz = new int[botinMax][cargaMax + 1];

	}

	/** Metodo que genera aleatorios **/
	public int generarAleatorio() {
		Random r = new Random();
		return r.nextInt(Integer.MAX_VALUE);

	}

	/** Metodos para medir los tiempos de las diferentes implementaciones **/
	public void medirTiempos(int n) {

		long t1, t2;

		for (int i = 10; i <= 80000; i *= 2) {

			crearRobo(i);
			t1 = System.currentTimeMillis();
			for (int repeticion = 1; repeticion <= n; repeticion++) {
				robar();
			}
			t2 = System.currentTimeMillis();
			System.out.println(i + "," + (t2 - t1));
		}
	}

	public void print() {
		System.out.println("Problema de la mochila 0|1");
		for (int i = 0; i < matriz.length; i++) {
			System.out.print("|");
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]);
				if (j != matriz[i].length - 1)
					System.out.print("\t"); // para el ultimo que no tabule
			}
			System.out.println("|");
		}
	}

}

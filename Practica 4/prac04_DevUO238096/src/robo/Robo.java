package robo;

import java.util.ArrayList;
import java.util.List;

public class Robo {

	private List<String> botin = null;
	private List<Botin> robo = new ArrayList<Botin>();
	private int cargaMax;
	private int botinMax;
	private Ordenacion ordenados = new Ordenacion();

	public Robo(List<String> botin) {
		super();
		this.botin = botin;
		setCargaMax(Integer.parseInt(botin.get(1)));
		setBotinMax(Integer.parseInt(botin.get(0)));
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

	/** Metodo que nos devuelve el mayor porcentaje de la lista**/
	private double getMax(double limite, List<Botin> visitados, List<Botin> r) {
		if (limite == 0.0)
			limite = Double.MAX_VALUE;
		double mayor = 0.0;
		for (Botin b : r) {
			if (b.getProporcion() >= mayor && b.getProporcion() <= limite && !visitados.contains(b))
				mayor = b.getProporcion();
		}
		return mayor;
	}

	/** Metodo que nos devuelve el mayor porcentaje de la lista**/
	public void robar(List<Botin> r) {
		List<Botin> visitados = new ArrayList<Botin>();
		int carga = cargaMax;
		double mayor = getMax(0.0, visitados, r);

		for (int i = 0; i < r.size(); i++) {
			
			if (r.get(i).getProporcion() == mayor && !visitados.contains(r.get(i))) 
			{
				if (r.get(i).getPeso() <= carga && carga > 0) 
				{
					carga = carga - r.get(i).getPeso();
					r.get(i).setPesoSeleccionado(r.get(i).getPeso());
					visitados.add(r.get(i));
					mayor = getMax(mayor, visitados, r);
					i = -1;
				} 
				else 
				{
					if (carga > 0) {
						r.get(i).setPesoSeleccionado(carga);
						carga = 0;
			}}}}
		robo = r;
	}

	///Implementacion sin ordenar
	public void implementacion1Tiempos(List<Botin> r) {

		robar(r);
	}

	///Implementacion con ordenacion MALA burbuja
	public void implementacion2Tiempos(List<Botin> r) {

		r = ordenados.burbuja(r);
		robar(r);

	}

	///Implementacion con ordenacion BUENA quicksort
	public void implementacion3Tiempos(List<Botin> r) {

		r = ordenados.rapido(r);
		robar(r);

	}

	public void implementacion1() {
		robo.clear();
		crearBotin();
		robar(robo);
	}

	public void implementacion2() {
		robo.clear();
		crearBotin();
		robo = ordenados.burbuja(robo);
		robar(robo);

	}

	public void implementacion3() {
		robo.clear();
		crearBotin();
		robo = ordenados.rapido(robo);
		robar(robo);

	}

	public void mostrarRobo() {

		System.out.println("\t Numero de joyas " + botinMax);
		System.out.println("\t Peso maximo a rellenar " + cargaMax);

		for (int i = 0; i < robo.size(); i++) {

			System.out.println("\t Joya con peso seleccionado " + robo.get(i).getPesoSeleccionado() + " y valor "
					+ robo.get(i).getValor() + "-->PROPORCION: " + robo.get(i).getProporcion());

		}

	}

}

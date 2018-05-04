package robo;

public class Botin {

	private int peso;
	public int getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	private int valor;
	
	private double pesoSeleccionado;
	
	private double proporcion;

	public double getPesoSeleccionado() {
		return pesoSeleccionado;
	}
	public void setPesoSeleccionado(double pesoSeleccionado) {
		this.pesoSeleccionado = pesoSeleccionado;
	}
	public Botin(int peso, int valor) {
		super();
		this.peso = peso;
		this.valor = valor;
		this.proporcion= (double)valor/peso;
	}
    public double getProporcion() {
		
		return proporcion;
	}
    public void setProporcion(double proporcion) {
		this.proporcion =proporcion ;
	}
    
}

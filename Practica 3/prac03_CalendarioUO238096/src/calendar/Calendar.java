package calendar;


import java.util.List;

public class Calendar {
	
	private  List<String> jugadores = null;

	
		public int [][] calendar(int[][] tabla, List<String> jugadores) {
			this.jugadores=jugadores;			
			torneo(jugadores.size()-1, tabla);			
			return tabla;			
		}
		
		

		private void torneo(int numeroJugadores, int [][] tabla)
		{
			if(numeroJugadores == 2){
				tabla[0][0] = 1;
				tabla[1][0] = 0; 
			
			}else
			{
				torneo(numeroJugadores/2, tabla);
				
				for(int i = 0; i < numeroJugadores/2; i++){
					for ( int j = (numeroJugadores/2)-1 ; j < numeroJugadores - 1; j++){
						tabla[i][j] = i+j+1;
						if(tabla[i][j] >= numeroJugadores)
							tabla[i][j] -= numeroJugadores/ 2; 
					}}
				
				for (int i = numeroJugadores/2; i < numeroJugadores; i++){
					for ( int j = (numeroJugadores/2)-1 ; j < numeroJugadores - 1; j++){
						tabla[i][j] = i-(j+1);
						if(tabla[i][j] < 0)
							tabla[i][j] += numeroJugadores/ 2; 
					}}
				
				for (int i = numeroJugadores/2; i < numeroJugadores; i++){
					for ( int j = 0; j < (numeroJugadores/2)-1; j++){
						int aux = i - numeroJugadores/2;
						tabla[i][j] = tabla[aux][j] +numeroJugadores /2;
					}}
			}
		}


	public void mostrarTabla(int[][] tabla) {
		System.out.println();
		System.out.println("                TABLA DEL TORNEO \n ");
		System.out.print("    PLAYER/OPONENT  " + "\t");
		
		for (int x = 0; x < jugadores.size() - 2; x++) {
			System.out.print("DAY " + (x + 1) + "\t"+ "\t");
		}
		System.out.println(" ");
		
		for (int i = 0; i < jugadores.size() - 1; i++) {

			System.out.print("\t" + jugadores.get(i + 1) + "\t" + "\t");

			for (int j = 0; j < tabla.length - 1; j++) {
				System.out.print(jugadores.get(tabla[i][j] + 1) + "\t"+ "\t");}
			System.out.println(" ");

		}}
	
	
	
	
	public void medirTiempos(int n) {
		
		long t1,t2;
		int[][] tabla = new int[0][0];		
		
		for( int i=2; i<= 100000 ; i*=2) {
			
			tabla =new int[i][i-1];
			
			t1=System.currentTimeMillis();
			for (int repeticion=1;repeticion<=n;repeticion++){ 
				torneo(i,tabla);}
			t2=System.currentTimeMillis();

			System.out.println (" TAMAÑO = "+i+"**"+"TIEMPO = "+(t2-t1)+"**");} 
		}
		
	
}

		


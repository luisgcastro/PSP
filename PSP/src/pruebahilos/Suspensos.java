package pruebahilos;

public class Suspensos extends Thread{
	private int [] notas;

	public Suspensos(int[] notas) {
		super();
		this.notas = notas;
	}
	
	@Override 
	public void run() {
		int contador = 0;
		
		for (int nota : notas) {
			if (nota > 0 && nota < 5) {
				contador++;
			}
			System.out.println("Los suspensos son: " + contador);
		}
	}

}

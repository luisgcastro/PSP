package pruebahilos;

public class Sobresalientes extends Thread {
	private int [] notas;

	public Sobresalientes(int[] notas) {
		super();
		this.notas = notas;
	}
	@Override
	public void run() {
		int contador = 0;
		
		for (int nota : notas) {
			if (nota >= 9  && nota <= 10) {
				contador++;
			}
		
		System.out.println("Los sobresalientes son: " + contador);
		}
		
	}
	

}

package pruebahilos;

import java.util.Random;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int [] notas;
		Random notasAleatoriasRandom = new Random();
		
		notas = new int [200];
		
		for (int i = 0; i < notas.length; i++) {
			notas[i] = notasAleatoriasRandom.nextInt(11);
			
		}
		
		Media hilo_media = new Media(notas);
		Sobresalientes hilo_sobresalientes = new Sobresalientes(notas);
		Suspensos hilo_suspensos = new Suspensos(notas);
		
		hilo_media.start();
		hilo_sobresalientes.start();
		hilo_suspensos.start();
		
	}

}

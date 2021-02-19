package hilos1;

import java.util.ArrayList;

public class ProcesadorNumeros {
	
	private int id;

	public ProcesadorNumeros() {
		super();
	}

	public ProcesadorNumeros(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void procesar(ArrayList<Integer> numeros, int posicionInicial, int posicionFinal) {

		
		System.out.println("Hola, soy " + id + " y empiezo.");
		for(int i=posicionInicial; i<=posicionFinal;i++) {
			System.out.println("Hola, soy " + id + " proceso " + i);
			
		}
		
	}
	
	
	

}

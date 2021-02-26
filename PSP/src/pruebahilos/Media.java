package pruebahilos;

public class Media extends Thread {
	
	private int [] notas;

	public Media(int[] notas) {
		super();
		this.notas = notas;
	}
	
	@Override
	public void run () {
		int resultado = 0;
		for (int nota : notas) {
			resultado += nota;
		}
		
		System.out.println("La nota media es: "+ resultado/notas.length);
		
	}

}

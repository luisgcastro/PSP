package hilos1;

import java.util.ArrayList;

public class Principal implements Runnable {

	private ProcesadorNumeros cuenta;
	private ArrayList<Integer> numeros;
	private int inicio;
	private int fin;
	
	
	public Principal(ProcesadorNumeros cuenta, ArrayList<Integer> numeros, int inicio, int fin) {
		super();
		this.cuenta = cuenta;
		this.numeros = numeros;
		this.inicio = inicio;
		this.fin = fin;
	}



	public static void main(String[] args) {
		
		ArrayList<Integer> numeros=new ArrayList<Integer>();
		
		for(int i=0; i<100;i++){
			
			numeros.add(i);
			
		}
		
		ProcesadorNumeros cuenta1=new ProcesadorNumeros(1);
		ProcesadorNumeros cuenta2=new ProcesadorNumeros(2);
		
		
		Runnable proceso1=new Principal(cuenta1,numeros,0,49);
		Runnable proceso2=new Principal(cuenta2,numeros,50,99);		
		
		new Thread(proceso1).start();
		new Thread(proceso2).start();
		
	}
	
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.cuenta.procesar(numeros, inicio, fin);
	

	}

}

package filosofos;

public class Contador {
	
	int cont;
	
	int tope;
	
	Contador (int tope) {
		
		cont = 0;
		
		tope = tope;
		
	}
	
	
	public void inc () {
		
		while (cont == tope) {
			
			try {wait();}
			
			catch (Exception e) {}
			
			
		}
		
		cont++;
		
		
	}
	
	synchronized public void dec () {
		
		cont --;
		
		notifyAll();
		
		
	}
	
	synchronized public int valor () {
		
		
		return cont;
		
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	



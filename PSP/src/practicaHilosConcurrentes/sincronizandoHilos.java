package practicaHilosConcurrentes;

public class sincronizandoHilos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		hilosVarios hilo1 = new hilosVarios();
		
		hilosVarios hilo2 = new hilosVarios();
		
		hilo1.start();
		
		hilo2.start();
		
		
	}
	
}
	
	
	class hilosVarios extends Thread{
		
		public void run() {
			
			for( int i=0;i<15;i++) {
				
				System.out.println("Ejecutando hilo " + getName());
				
				try { 
				Thread.sleep(700);
				
				} catch (InterruptedException e) {
					
					e.printStackTrace();
				
			}
			
			
			
		}
		
	}

	}


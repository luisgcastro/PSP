package filosofos;

public class Filosofo extends Thread {
	
	int quienSoy = 0;
	
	palillo palDer, palIzq;
	
	Contador cont;
	
	int numeroOperaciones = 10;
	
	public Filosofo (int quienSoy, Contador cont, palillo palDer, palillo palIzq) {
		
		
		quienSoy = quienSoy;
		
		palDer = palDer;
		
		palIzq = palIzq;
		
		cont = cont;
		
	}
	
	
	public void run () {
		
		for (int i=0;1<numeroOperaciones;i++) {
			
			System.out.println("Filósofo "+quienSoy+" pensando");
			
			cont.inc();
			
			palDer.coger(quienSoy);
			
			palIzq.coger(quienSoy);
			
			System.out.println("Filósofo "+quienSoy+" comiendo");
			
			palDer.soltar();
			
			palIzq.soltar();
			
			cont.dec();
			
		}
		
		
	}
	
}
	
	



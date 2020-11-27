package filosofos;

public class MainFilosofos {
	
	Filosofo f[] = new Filosofo[5];
	
	palillo palillos[] = new palillo[5];
	
	Contador contador;
	
	int numFil = 5;
	
	public MainFilosofos () {
		
		contador = new Contador (numFil-1);
		
		for (int i=0;i<numFil;i++) {
			
			palillos[i] = new palillo(); 
			
			
		}
		
for (int i=0;i<numFil;i++) {
			
		f[i] = new Filosofo(i, contador, palillos[i], palillos[(i+1)%numFil]);
		
		f[i].start();
			
		}

for (int i= 0;i<numFil;i++) {
	
	try {
		
		f[i].join();
	}
	
	catch (Exception e) {}
	
}
		
	}
	

	public static void main(String[] args) {
	
		new MainFilosofos();

	}

}

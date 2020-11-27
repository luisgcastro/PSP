package hilosConcurrentes;

public class MainRunnable implements Runnable {

 
	IPrograma programa1;
	IPrograma programa2;
	
	public MainRunnable(IPrograma programa) {
		this.programa1 = programa;
		this.programa2 = programa;
		
	}
	
	public static void main(String[] args) {
		
		Runnable proceso1 = new MainRunnable(new  Programa1());
		Runnable proceso2 = new MainRunnable(new  Programa2());
		
		Thread P1 = new Thread(proceso1);
		P1.start();
		
		Thread P2 = new Thread(proceso2);
		P2.start();
		
	}
	
	@Override
	public void run() {
		if (Thread.currentThread().getName().equals("Thread-0")) {
			
			this.programa1.cuenta(Thread.currentThread().getName());
			} else {
				this.programa1.cuenta(Thread.currentThread().getName());
			}
		
	}

}

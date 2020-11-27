package filosofos;

public class palillo {
	
	boolean libre;
	
	palillo(){
		
		libre = true;
		
	}
	
	synchronized public void coger (int quien) {
		
		while (!libre) {
			
			try {wait();}
			
			catch (Exception e) {}
			
			
		}
		
		libre = false;
		
		
	}
	
	synchronized public void soltar () {
		
		libre = true;
		
		notifyAll();
		
		
	}
	
}

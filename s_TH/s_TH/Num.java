package s_TH;



public class Num {
	private int x, counter;
	
	public int AumentoCounter() {	//conta da 0 fino a x (numero casuale)	
		return ++counter;	//prima aumento il counter, poi faccio il return
	}
	
	public int getX() {
		return x;
	}
	
	public int getCounter() {
		return counter;
	}
	
	public Num(int n) {		//T conta fino a un numero casuale (x)
		counter = 0;
		x = (int) (Math.random() * n);
	}
}


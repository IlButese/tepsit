package pizzeria;

public class Forno implements Runnable {//perche [ un task
	private Buffer_pizzeria bp;
	public Forno(Buffer_pizzeria bp) {//inzializzo il bufffer
		this.bp = bp;
	}

	public void run(){//fa il forno
		int a = 0;// Variabile per memorizzare quante pizze il forno deve preparare
		while((a = bp.preparaPizze()) >= 0) {// Prepara le pizze finché il valore di 'A' è maggiore o uguale a 0
			
			try {//attesa preaparazione pizze simulazione cottura
				Thread.sleep((int)(Math.random() * 5000));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			bp.prontePizze(a);// Comunica al buffer che le pizze sono pronte
		}
		
	}
}

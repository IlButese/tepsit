package pizzeria;

public class Cameriere implements Runnable {
	private Buffer_Sala t;
	private Buffer_pizzeria r;
	private Tavoli tt;
	private int ordine;
	public Cameriere(Buffer_Sala t, Buffer_pizzeria r) {
		this.t = t;
		this.r = r;
	}
	public void run(){
		while((tt = t.inAttesa())!= null) {// Ciclo fino a quando ci sono tavoli in attesa
			ordine = tt.ordinareServire();//reutrna il numreo di ordini 
			if(ordine > 0) {//deve ordinare
				System.out.println("CAMERIERE - prendo l'ordine dal tavolo:" + tt);
				r.riceviComanda(ordine);//do la comanda alla pizzeria
				try {//simulazione arrivo comanda
					Thread.sleep((int)(Math.random() * 5000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else if(ordine < 0) { // consegnamre
				System.out.println("CAMERIERE - porto le pizze al tavolo:" + tt);
				r.ritiro((-1)*ordine);//ritiro pizza e servo do -1 pk senno sevo il negativo
				try {//simulkazione pizze da portare al tavolo
					Thread.sleep((int)(Math.random() * 5000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		//festa
			//qualcuno avra gia servito quidni faccio altr richieste
		}
		System.out.println("CAMERIERE - ho servito tutti i tavoli capo!!");
		r.riceviComanda(-1);//cosi posso fermare il forno mandandolo in negativo 
	}
	
}

package pizzeria;

public class Tavoli {
	private boolean attesaOrdine = true;//tavolo in atteas ordine
	private boolean attesaServizio = false;//tavolo in attesa servizio
	private int nPersone;//numero di persone seduto al tavolo
	public Tavoli(int x) {//prendo varibile del numero di  persone ad un tavolo
		// TODO Auto-generated constructor stub
		nPersone = x;
	}
	public synchronized int ordinareServire() {//mi devono dire se ordinati o meno o serviti o meno
		if(attesaOrdine) {//se e' tavolo da ordine
			//prendiamo l'ordine
			attesaOrdine = false;
			attesaServizio = true;
			System.out.println("TAVOLO - sono il tavolo: " + this + " do l'ordine al cameriere, di queste pizze:" + nPersone );
			return nPersone; //persone
		}else if(attesaServizio) {//se vero camerire porta pizzse
			//diamo il servizio
			attesaServizio = false;
			System.out.println("TAVOLO - sono il tavolo: " + this + " il cameriere ci porta, queste pizze:" + nPersone );
			return (-1)*nPersone;//invertioamo il numero cosi da farlo negativo cosi possiamo togliere tot persone
		}else {
			return 0;
		}
	}
	// Metodo sincronizzato che verifica se il tavolo è in attesa di fare un ordine
	public synchronized boolean getAttOrd() {
		return attesaOrdine;
	}
	 // Metodo sincronizzato che verifica se il tavolo è in attesa di essere servito
	public synchronized boolean getAttServ() {
		return attesaServizio;
	}
	/*
	camerire--> buffer (metodo che racchiude n_pizze, e tavoli da ordinare)
	metodo = --> tavoli (serviti o ordinare, attesa)
	
*/	
}

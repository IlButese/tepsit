package s_TH;


public class cons implements Runnable { 	//classe che fa incrementare 
	Num conservatore;
	
	public cons(Num num) {		//gli passoggio oggetto num che mi serve per asseghnare ad un valore a conservatre
		conservatore = num;
	}
	
	public void run() {
		int x = conservatore.getX();
		while(conservatore.AumentoCounter() != x) { //controllo se counter è != da X	 
		}
	}
	
	public Num getNum() {//get
		return conservatore;
	}

}


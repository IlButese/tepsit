package pizzeria;
import java.util.ArrayList;


public class Buffer_Sala {//gestisce i camarieri
    private ArrayList<Tavoli> tavolo; // Creazione di un ArrayList con capacità iniziale 20

    public Buffer_Sala() {//inizializzo array
    	tavolo = new ArrayList<>(20);
    	for (int i = 0; i < 20; i++) {
            int x = (int) (Math.random() * 6); // Numero di persone da 0 a 5
            tavolo.add(new Tavoli(x)); // Sostituisce l'oggetto alla posizione i
        }
    }
    public synchronized Tavoli inAttesa() {//cerca e restituisce un tavolo che è in uno stato di attesa, sia per ordinare che per essere serviti.
    	for(int i = 0; i < 20; i++) {
    		if(tavolo.get(i).getAttOrd()) {// Controlla se un tavolo è in attesa di ordinare
    			return tavolo.get(i); // Se sì, ritorna quel tavolo
    		}
    	}
    	for(int i = 0; i < 20; i++) {
    		if(tavolo.get(i).getAttServ()) {// Controlla se un tavolo è in attesa di essere servito
    			return tavolo.get(i);// Se sì, ritorna quel tavolo
    		}
    	}
		return null;
    }
}

//camerire--> buffer (metodo che racchiude n_pizze, e tavoli da ordinare)
//metodo = --> tavoli (serviti o ordinare, attesa)




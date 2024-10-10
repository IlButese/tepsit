package pizzeria;
import java.util.*;

public class Buffer_pizzeria {//pila dei foglietti nel chiodo
	private int countPizzeFatte;// conta pizze fatte
	private int countPizzeDaFare;// conta pizze da fare
	public Buffer_pizzeria() {//colstrutture
		countPizzeFatte = 0;//setto a 0
		countPizzeDaFare = 0;//setto a 0
	}
    // pizze da fare e fatte
	public synchronized void riceviComanda(int ordine) {//il cameriere appoggia la comanda nei foglietti del forno
		//aggiugne tra le pizze da fare, le nuove comande
		countPizzeDaFare =  countPizzeDaFare + ordine;//aumento le pizze da fare 
		System.out.println("PIZZERIA - ho da fare: " + countPizzeDaFare+ " pizze");//stampa
		notifyAll();// Risveglia i thread in attesa (come il forno) perché ci sono pizze da preparare
	}
	
	public synchronized int preparaPizze() {//prepara le pizze
		//il forno preparar le pizze e simula attesa
		while(countPizzeDaFare == 0) {//attesa se non ci sono pizze
			System.out.println("PIZZERIA - forno aspetta comande");
			try {
				wait();// Il forno si mette in attesa finché non arrivano nuove comande
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		int appoggio = countPizzeDaFare;//salvo il numerodelle pizze da fare
		if(countPizzeDaFare <= 8 ) {//se ho da fare - 8 pizze le faccio 
			countPizzeDaFare = 0;//setto le pizze a 0 pizze fatte
			System.out.println("PIZZERIA - il forno ne fa " + appoggio +" ed ho ancora da fare 0 pizze");
			return  appoggio;//returno le pizze fatte
		}else{//se maggiori sottraggo
			countPizzeDaFare = countPizzeDaFare - 8;
			System.out.println("PIZZERIA - il forno sta facendo " + "8 pizze" + "ed ha ancora da fare:" + countPizzeDaFare + "pizze");
			return 8;//returno le pizze fatte
		}
	}
	public synchronized void prontePizze(int pizzeFatta) {
		//il forno aggiunge il numero di pizze fatte al contatorePizzeFatte
		countPizzeFatte = countPizzeFatte + pizzeFatta;
		System.out.println("PIZZERIA - ho fatto: " + countPizzeFatte+ " pizze");
		notifyAll();// Risveglia i thread (come i camerieri) che potrebbero essere in attesa di pizze pronte
	}
	public synchronized void ritiro(int ordine) {
		//il camerire ritira lr pizze fatte, assciurandosi che sinao abbastanza per servire il tavolo
		System.out.println("PIZZERIA - il cameriere vuole ritirare " + ordine + " pizze");
		while(countPizzeFatte < ordine) {
			System.out.println("PIZZERIA - le pizze sono in preparazione");
			try {
				wait();// Attende finché il numero di pizze pronte non è sufficiente
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		countPizzeFatte = countPizzeFatte - ordine;// Sottrae il numero di pizze ritirate dal contatore delle pizze fatte
	}
}

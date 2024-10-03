package Produttori_Consumatori;

import java.util.concurrent.Semaphore;

public class Consumatore implements Runnable {
	private Semaphore mutex; // Per la mutua esclusione
	private Semaphore empty;  // Tiene traccia delle posizioni vuote
	private Semaphore full; // Tiene traccia delle posizioni piene
	private Buffer buffer;
	
	
     
	public Consumatore( Semaphore mutex, Semaphore empty, Semaphore full, Buffer buffer){
		this.mutex = mutex; // Per la mutua esclusione
		this.empty = empty; // Tiene traccia delle posizioni vuote
		this.full = full; // Tiene traccia delle posizioni piene
		this.buffer = buffer;
	}
	public void run(){
		int count_pari = 0;
		int count_dispari = 0;
		int x;
		while(true) {
			try {
				full.acquire();//mi assicuro che ho dello spazio per leggere e lo prenoto
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();//stampa errore
			}
			try {
				mutex.acquire();//acquisisce l-accesso al buffer
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			x = buffer.poll();//prendo nel buffer
			mutex.release();// //rilascio accesso al buffer
			empty.release();//ce spazio per scrivere
			System.out.println(x);
			if(x%2 == 0) {//pari
				count_pari++;
				
			}else {//dispari
				count_dispari++;
			}
			//statistica
			System.out.println("pari:" + count_pari);
			System.out.println("dispari:" + count_dispari);
		}
	}
}

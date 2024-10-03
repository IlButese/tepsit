package Produttori_Consumatori;

import java.util.concurrent.Semaphore;

public class Produttore implements Runnable{
//generatore di numeri N
//semaforo
	
	
	private Semaphore mutex; // Per la mutua esclusione
	private Semaphore empty;  // Tiene traccia delle posizioni vuote
	private Semaphore full; // Tiene traccia delle posizioni piene
	private Buffer buffer;
	
     
	public Produttore( Semaphore mutex, Semaphore empty, Semaphore full, Buffer buffer){
		this.mutex = mutex; // Per la mutua esclusione
		this.empty = empty; // Tiene traccia delle posizioni vuote
		this.full = full; // Tiene traccia delle posizioni piene
		this.buffer = buffer;
	}
	public void run(){
		int R_Max= 1024;//numero max random
		int R_Max_n2= 901;//numero max random
		int x_r = 0;//numero che porend rand
		while(true) {
			x_r = (int) (Math.random()*R_Max);
			try {
				empty.acquire();//mi assicuro che ho dello spazio per scirvere e lo prenoto
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
			buffer.add(x_r);//inserisco nel buffer
			mutex.release();// //rilascio accesso al buffer
			full.release();//ce rova da legger
			x_r = (int) (Math.random()*R_Max_n2+100);//da 100 a 1000
			try {
				Thread.sleep(x_r);//metto in attesa
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

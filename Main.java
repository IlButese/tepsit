package Produttori_Consumatori;

import java.util.Scanner;
import java.util.concurrent.Semaphore;


public class Main {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Prodottore:");
		int p = scanner.nextInt();
		
		System.out.println("Consumatore:");
		int c = scanner.nextInt();
		System.out.println("Capacity:");
		int l = scanner.nextInt();
		scanner.close();
		//semafori gli 1 sono come si 0 come no pieno o no
		 Semaphore mutex = new Semaphore(1); // Per la mutua esclusione con valore 1 pk slo 1 pouo entrrare
	     Semaphore empty = new Semaphore(l); // Tiene traccia delle posizioni vuote inzialmente tutte
	     Semaphore full = new Semaphore(0); // Tiene traccia delle posizioni piene che inzialmente nessuna
	     Buffer buffer = new Buffer(l);//creato il buffer con la capacity ovvero la l
	     //si vanno a creare i task e i thread
	     Thread[] a = new Thread[p];//dichiaro array e alloco, un array di threadche andranno a prendere i task produttori 
	     Produttore[] pp = new Produttore[p];//dichiaro array e alloco, array di task produttori
	     Thread[] b = new Thread[c];//come a ma per cons
	     Consumatore[] cc = new Consumatore[c];//come pp ma per cons
		for(int i = 0; i < p; i++) {//lancio produttori
			pp[i]=new Produttore(mutex, empty, full, buffer);//istanzio il task produttor, creo oggetto runnable, populo gli array
			a[i] = new Thread(pp[i]);//do in pasto al thread il task 
			a[i].start();//starto
		}
		for(int i = 0; i < c; i++) {//lancio consumatori
			cc[i]=new Consumatore(mutex, empty, full, buffer);
			b[i] = new Thread(cc[i]);
			b[i].start();
		}

	}
}

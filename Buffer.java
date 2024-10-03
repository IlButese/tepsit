package Produttori_Consumatori;
import java.util.*;

public class Buffer {
    // una specie di pila con push e pop con FIFO
    private ArrayList<Integer> mem; // array estendibile di Java
    private int i = 0, f = 0, capacity, size = 0;

    public Buffer(int n) {
        mem = new ArrayList<Integer>(n);
        capacity = n;
        
        // Inizializza l'ArrayList con "null" fino alla capacità
        for (int j = 0; j < n; j++) {
            mem.add(null); // Aggiunge elementi vuoti (null) all'inizio
        }
    }

    // Metodo per rimuovere un elemento (FIFO)
    public Integer poll() {
        if (size > 0) {
            Integer z = mem.get(i); // Prende l'elemento alla posizione i
            i = (i + 1) % capacity; // Sposta l'indice per il prossimo prelievo
            size--;
            return z; // Restituisce l'elemento prelevato
        }
        return null; // Restituisce null se il buffer è vuoto
    }

    // Metodo per aggiungere un elemento
    public void add(int x) {
        if (size < capacity) {
            mem.set(f, x); // Imposta l'elemento alla posizione f
            f = (f + 1) % capacity; // Sposta l'indice per la prossima aggiunta
            size++;
        }
    }
}

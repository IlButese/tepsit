package pizzeria;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int t = 3;//numero di camerieri
		Buffer_Sala bs = new Buffer_Sala();//creo il buffer sala
		Buffer_pizzeria bp = new Buffer_pizzeria(); //creo il buffer pizzeria
		Thread[] th = new Thread[t];//crea array di theread
		Cameriere c = new Cameriere(bs, bp);//creo il task di camerieri
		Forno f = new Forno(bp);//creo task forno e lo lancio 
		Thread ts = new Thread(f);//creo e lancio 
		ts.start();//faccio il forno
		for(int i = 0; i < t; i++) {
			th[i] = new Thread(c);//gli dimao in pasto i camerieri la nostra task 
			th[i].start();//starto
		}
		System.out.println("i thread sono partiti");
		
		
		

	}

}

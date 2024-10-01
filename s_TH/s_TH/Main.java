package s_TH;


import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("T:");
		int t = scanner.nextInt();
		
		System.out.println("N:");
		int n = scanner.nextInt();
		scanner.close();
				
		cons[] num = new cons[t];	//
		Thread[] c = new Thread[t];		//assegna un thread a far runnare un processore 
		
		th_Principale s = new th_Principale(num, c);
		Thread c2 = new Thread(s);
		c2.start();
		
		for(int i = 0; i < t; i++) {
			num[i] = new cons(new Num(n));			
			c[i] = new Thread(num[i]);
			c[i].start();
			
			
		}
		
		
	}

}

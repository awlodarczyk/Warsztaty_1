package Zadanie3;

import java.util.Scanner;
 

public class GuessMyMind {
	static int min = 0;
	static int max = 1000;
	static void start(){ 
		System.out.println("Pomyśl liczbę z zakresu od "+(min+1)+" do "+(max-1)+", a ja zgadnę "
				+ "ją max. w 10 próbach");
		int counter = 0;
		boolean finished = false;
		Scanner scan = new Scanner(System.in);
		while(!finished){
			int guess = ((max-min)/2)+min;
			System.out.println("Zgaduję: "+guess); 
			counter++;
			System.out.println("Za mało (1)? Za dużo (2)? Trafiłem (3)?");
			int x = scan.nextInt();
			if(x==3){
				System.out.println("Wygrałem!");
				finished = true;
			}else if(x==2 && min!=max){
				System.out.println("Za dużo");
				max=guess;
			}else if(x==1 && min!=max){
				System.out.println("Za mało");
				min=guess;
			}else{
							  
				System.out.println("Nie oszukuj!!!!");
			}
		}
		scan.close();
	}
	
	static void setMin(int i){
		min = i-1;
	}
	static void setMax(int i){
		max = i+1;
	}
}

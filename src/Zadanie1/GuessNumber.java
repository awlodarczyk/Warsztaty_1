package Zadanie1;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

	static int min,max,guess = 0;
	
	static void setMin(int i){
		min = i;
	}
	static void setMax(int i){
		max = i;
	}
	static void setGuess(int i){
		if(i<=max && i>=min){
			guess = i;
		}else{
			System.out.println("Nieprawidłowo ustawiona szukana. Z poza zakresu min max. Kończę aplikację.");
			System.exit(0);
		}
	}
	static void setGuess(){
		guess = new Random().nextInt(max)+min;
	}
	static void start(){
		System.out.println("Zgadnij liczbę z zakresu od "+min+" do "+max);
		System.out.println("Wylosowana: "+guess);
		Scanner scaner= new Scanner(System.in);
		boolean found = false;
		while(!found){
			System.out.println("Podaj twój strzał: ");
			while(!scaner.hasNextInt()){
				scaner.next();
				System.out.println("To nie jest liczba. Spróbuj ponownie!");
			}
			int myGuess = scaner.nextInt();
			if(myGuess>guess){
				System.out.println("Za dużo!");
			}else if(myGuess<guess){
				System.out.println("Za mało!");
			}else{
				System.out.println("Wygrałeś!");
				found = true;
			}
		}
		scaner.close();
	}
}

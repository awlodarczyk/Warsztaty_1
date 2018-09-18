package Zadanie2;

import java.util.ArrayList;
import java.util.Scanner;

public class LottoScanner {

	
	static ArrayList<Integer> startGettingNumbers(){
		Scanner scan = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>(); 
		boolean isFinished = false; 
		while(!isFinished){
			System.out.println("Podaj liczbę w zakresie od 1-49: ");
			while(!scan.hasNextInt()){
				scan.next();
				System.out.println("Podana wartość nie jest liczbą, spróbuj ponownie: ");
			}
			int number = scan.nextInt();
			if(number>0 && number<50){
				if(!LottoChecker.checkNumbers(list,number)){
					System.out.println("Liczba podana została już wcześniej podana, spróbuj z inną.");
				}else{
					list.add(number);
				}
			}else{
				System.out.println("Podana liczba nie jest z zakresu od 1-49");
			}
			if(list.size()==6){
				isFinished=true;
			}
		}
		scan.close();
		return list;
	}
	
}

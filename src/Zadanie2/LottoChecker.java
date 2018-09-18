package Zadanie2;

import java.util.ArrayList;
import java.util.Arrays; 
import java.util.Collections;
import java.util.Random;

public class LottoChecker {

	static ArrayList<Integer> getNumbers(){
		ArrayList<Integer> ints = new ArrayList<>();
		while(ints.size() <= 6){
			int pseudo = new Random().nextInt(48)+1;
			if(checkNumbers(ints, pseudo)){
				ints.add(pseudo);
			}
		}
		return ints;
	}
	static boolean checkNumbers(ArrayList<Integer> list,int num){
		for(int n:list){
			if(num==n){
				return false;
			}
		}
		return true;
	}
	static String getUserScore(ArrayList<Integer> userList){
		ArrayList<Integer> found = new ArrayList<>();
		ArrayList<Integer> pseudo = getNumbers();
		for(int userType: userList){
			for(int num : pseudo){
				if(userType==num){
				 found.add(num);
				}
			}
		}
		String result = "";
		switch (found.size()) {
		case 0:
			result = "Brak wyników ";
			break;
		case 1:
			result = "Masz jedno trafienie: ";
			break;
		case 2:
			result = "Masz dwa trafienia: ";
			break;
		case 3:
			result = "Masz trzy trafienia: ";
			break;
		case 4:
			result = "Masz cztery trafienia: ";
			break;
		case 5:
			result = "Masz pięć trafień: ";
			break;
		case 6:
			result = "Masz sześć trafień: ";
			break;
		default:
			break;
		}
		Collections.sort(pseudo);
		Collections.sort(userList);
		Collections.sort(found);
		
		System.out.println("Wyniki lotto: "+Arrays.toString(pseudo.toArray()));
		System.out.println("Twoje liczby: "+Arrays.toString(userList.toArray()));
		return result+Arrays.toString(found.toArray());
	}
}

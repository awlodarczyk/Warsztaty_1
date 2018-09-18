package Zadanie4;

import java.util.Random;
import java.util.Scanner;

public class DiceSimulator {

	static void start(){
		Scanner scan = new Scanner(System.in);
		boolean isCorrect = false;
		String str = "";
		while(!isCorrect){
			System.out.println("Podaj kombinacje rzutów kostką (xDy+z | x=liczba rzutów | y=rodzaj kostek | z=wartość dodana po rzutach). ");
			System.out.println("Typy kostek występujące w grach: D3, D4, D6, D8, D10, D12, D20, D100.");
			str = scan.nextLine();
			if(checkInput(str)){
				isCorrect=true;
			}else{
				System.out.println("Podałeś nieprawidłową kombinację, spróbuj ponownie.");
			}
		}
		if(isCorrect){
			System.out.println("Rzucam kostką");
			int sum = shuffleDice(getValues(str));
			System.out.println("Twój wynik rzutu to: "+ sum);
		}
		scan.close();
	}
	static boolean checkInput(String str){
		if(str.contains("D3") || str.contains("D4") || str.contains("D6") || str.contains("D8") 
				|| str.contains("D10") || str.contains("D12") || str.contains("D20") || str.contains("D100")){
			int[] vals = getValues(str);
			for (int i: vals){
				if(i==-1) return false;
			}
			return true;
		}
		return false;
	}
	static int shuffleDice(int[] values){
		int sum = 0;
		for(int i=0;i<values[0];i++){
			sum += new Random().nextInt(values[1]-1)+1;
		}
		sum+=values[2];
		return sum;
	}
	static int[] getValues(String str){
		int[] values = new int[3];
		String[] splitted = str.split("D");
		if(splitted.length>0){
			try{
				values[0] = Integer.valueOf(splitted[0]);
			}catch (NumberFormatException e) {
				values[0] = -1;
			}
			if(splitted[1].contains("+")){
				String[] subsplitted = splitted[1].split("\\+");
				
				try{
					values[1] = Integer.valueOf(subsplitted[0]);
				}catch (NumberFormatException e) {
					values[1] = -1;
				}
				try{
					values[2] = Integer.valueOf(subsplitted[1]);
				}catch (NumberFormatException e) {
					values[2] = -1;
				}
				
			}else{
				try{
					values[1] = Integer.valueOf(splitted[1]);
					values[2] = 0;
				}catch (NumberFormatException e) {
					values[1] = -1;
					values[2] = -1;
				}
			}
		}
		return values;
	}
}

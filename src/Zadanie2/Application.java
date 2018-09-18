package Zadanie2;

import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> userList = LottoScanner.startGettingNumbers();
		System.out.println(LottoChecker.getUserScore(userList));
	}

}

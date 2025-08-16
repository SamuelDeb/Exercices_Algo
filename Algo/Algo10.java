package fr.fs.algo;

import java.util.Scanner;

public class Algo10 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("Saisissez le premier nom : ");
		String firstName = myScanner.nextLine();
		System.out.print("Saisissez le deuxième nom : ");
		String secondName = myScanner.nextLine();
		System.out.print("Saisissez le troisième nom : ");
		String thirdName = myScanner.nextLine();
		
		boolean isFirstBeforeSecond = firstName.compareToIgnoreCase(secondName) <= 0;
		boolean isSecondBeforeThird = secondName.compareToIgnoreCase(thirdName) <= 0;
		
		if (isFirstBeforeSecond && isSecondBeforeThird)
			System.out.printf("%s, %s, %s sont dans l'ordre alphabétique !",firstName, secondName, thirdName);
		else
			System.out.printf("%s, %s, %s ne sont pas dans l'ordre alphabétique !",firstName, secondName, thirdName);
	}

}

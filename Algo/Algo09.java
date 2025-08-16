package fr.fs.algo;

import java.util.Scanner;

public class Algo09 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		System.out.print("Dans quelle ville habite Alain ? ");
		String villeAlain = myScanner.nextLine();
		System.out.print("Dans quelle ville habite Léa ? ");
		String villeLea = myScanner.nextLine();

		if (villeAlain.toLowerCase().equals(villeLea.toLowerCase()))
			System.out.printf("Alain et Léa habitent dans la même ville");
		else
			System.out.printf("Alain et Léa habitent dans des villes différentes");

		System.out.printf("%n%nComparaison : %d", 
				villeAlain.toLowerCase().compareTo(villeLea.toLowerCase()));
	}

}

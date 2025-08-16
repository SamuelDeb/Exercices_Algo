package fr.fs.algo;

import java.util.Locale;
import java.util.Scanner;

public class Algo28 {
	static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		int value = saisirUnEntier("Saisissez une valeur", 0, 20);
		System.out.printf("%nFactorielle(%d) = %d", value, calculerFactorielleRecursif(value));
	}

	private static long calculerFactorielle(int value) {
		long resultat = 1;
		for (int n = 2 ; n <= value; n++)
			resultat *= n;
		return resultat;
	}
	private static long calculerFactorielleRecursif(int value) {
		if (value < 2) return 1;
		return calculerFactorielleRecursif(value - 1) * value;
		
	}
	private static int saisirUnEntier(String question, int min, int max) {
		int value;
		do {
			System.out.printf("%n%s (%d-%d)", question, min, max);
			value = myScanner.nextInt();
		} while (value < min || value > max);
		return value;
	}

}

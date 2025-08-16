package fr.fs.algo;

import java.util.Scanner;

public class Algo30 {
	static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {

		int value = saisirUnEntier("Saisissez un entier", 0, 100000);
		if (isPremier(value))
			System.out.printf("%d est un nombre premier", value);
		else
			System.out.printf("%d n'est pas un nombre premier", value);
	}

	private static boolean isPremier(int value) {
		boolean isPremier = value >= 2;
		int compteur = 2;
		while (isPremier && compteur * compteur <= value)
			isPremier = value % compteur++ > 0;

		return isPremier;
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

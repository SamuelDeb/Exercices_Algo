package fr.fs.algo;

import java.util.Scanner;

public class Algo29 {
	static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		int value = saisirUnEntier("Saisissez une valeur", 0, 20);
		System.out.printf("%nSomme(%d) = %d", value, calculerSomme(value));
	}

	private static long calculerSomme(int value) {
		return (value + 1) * value / 2;
	}
	private static long calculerSommeRecursif(int value) {
		if (value < 2) return value;
		return calculerSommeRecursif(value - 1) + value;
		
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

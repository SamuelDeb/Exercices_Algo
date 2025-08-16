package fr.fs.algo;

import java.util.Scanner;

public class Algo35 {
	static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		int [] notes = new int[9];
		for (int i= 0; i < notes.length ; i++) {
			notes[i] = saisirUnEntier("Entrez la note n°" + (i+1), 0, 20);
		}
	}

	private static int saisirUnEntier(String question, int min, int max) {
		int value;
		do {
			System.out.printf("%s (%d-%d)", question, min, max);
			value = myScanner.nextInt();
		} while (value < min || value > max);
		return value;
	}
}

package fr.fs.algo;

import java.util.Scanner;

public class Algo24 {
	static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		short nbLigne = saisirUnShort("Combien de lignes", 1, 20);
		afficherLignes(nbLigne);
	}

	private static void afficherLignes(short nbLigne) {
		for (int ligne = 1; ligne <= nbLigne; ligne++) {
			afficherEtoiles(ligne);
		}
	}

	private static void afficherEtoiles(int ligne) {
		for (int etoile = 1; etoile <= ligne; etoile++) {
			System.out.print("*");
		}
		System.out.println();
	}

	private static short saisirUnShort(String question, int min, int max) {
		short value;
		do {
			System.out.printf("%n%s (%d-%d)", question, min, max);
			value = myScanner.nextShort();
		} while (value < min || value > max);
		return value;
	}
}

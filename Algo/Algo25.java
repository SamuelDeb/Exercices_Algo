package fr.fs.algo;

import java.util.Scanner;

public class Algo25 {
	static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {

		short nbLigne = saisirUnShort("Combien de lignes", 1, 20);
		afficherTriangle(nbLigne);
	}

	private static void afficherTriangle(short nbLigne) {
		for (int ligne = 1; ligne <= nbLigne; ligne++) {
			afficherEspaces(nbLigne - ligne);
			afficherEtoiles(ligne* 2 - 1);
			System.out.println();
		}
	}

	private static void afficherEspaces(int nombre) {
		for (int i = 1; i <= nombre; i++) {
			System.out.print(" ");
		}
	}

	private static void afficherEtoiles(int nombre) {
		for (int i = 1; i <= nombre ; i++) {
			System.out.print("*");
		}
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

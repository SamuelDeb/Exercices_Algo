package fr.fs.algo;

import java.util.Scanner;

public class Algo27 {
	static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {

		short largeur = saisirUnShort("Largeur du losange", 2, 10);
		afficherLosange(largeur);
	}

	private static void afficherLosange(short largeur) {
		for (int ligne = 1; ligne <= largeur; ligne++) 
			afficherLigne(largeur, ligne);
	
		for (int ligne = largeur - 1 ; ligne >= 1 ; ligne--)
			afficherLigne(largeur, ligne);
	}

	private static void afficherLigne(short largeur, int ligne) {
		afficherEspaces((largeur - ligne));
		System.out.print("*");
		afficherEspaces(ligne * 2 - 3);
		if (ligne > 1)
			System.out.print("*");
		System.out.println();
	}

	private static void afficherEspaces(int nbEspaces) {
		for (int espace = 1; espace <= nbEspaces; espace++) {
			System.out.print(" ");
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

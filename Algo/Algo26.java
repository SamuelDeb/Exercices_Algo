package fr.fs.algo;

import java.util.Scanner;

public class Algo26 {
	static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {

		short hauteur = saisirUnShort("Hauteur du rectangle", 1, 10);
		short largeur = saisirUnShort("largeur du rectangle", 1, 60);
		afficherRectangle(hauteur, largeur);
	}

	private static void afficherRectangle(short hauteur, short largeur) {
		afficherLignePleine(largeur);
		for (int ligne = 2; ligne <= hauteur - 1; ligne++)
			afficherLigneVide(largeur);
		afficherLignePleine(largeur);
	}

	private static void afficherLignePleine(short largeur) {
		for (short etoile = 1; etoile <= largeur; etoile++)
			System.out.print("*");
		System.out.println();
	}

	private static void afficherLigneVide(int largeur) {
		System.out.print("*");
		afficherEspaces(largeur - 2);
		System.out.println("*");
	}

	private static void afficherEspaces(int largeur) {
		for (short espace = 1; espace <= largeur ; espace++)
			System.out.print(" ");
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

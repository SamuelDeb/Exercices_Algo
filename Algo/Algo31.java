package fr.fs.algo;

import java.util.Scanner;

public class Algo31 {
	static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		int prixAPayer = calculerPanier();
		System.out.printf("%n%nVous nous devez   : %d €%n", prixAPayer);
		int paiementMaxi = calculerPaiementMax(prixAPayer);
		int paiement = saisirUnEntier("Entrez votre réglement : ", prixAPayer, paiementMaxi);
		rendreMonnaie(paiement, prixAPayer);
	}

	private static int calculerPaiementMax(int prixAPayer) {
		int coupureMax = 500;
		int nombreCoupures = prixAPayer / coupureMax ;
		if (prixAPayer % coupureMax > 0)
			nombreCoupures++;
		return nombreCoupures * coupureMax;
	}

	private static int calculerPanier() {
		int prix;
		int prixTotal = 0;
		int compteur = 1;
		do {
			prix = saisirUnEntier("Entrez le prix de l'article " + compteur + " :", 0, 999);
			prixTotal += prix;
			compteur++;
		} while (prix > 0);
		return prixTotal;
	}

	private static void rendreMonnaie(int paiement, int prixAPayer) {
		int aRendre = paiement - prixAPayer;
		aRendre = rendre(aRendre, 100);
		aRendre = rendre(aRendre, 20);
		aRendre = rendre(aRendre, 10);
		aRendre = rendre(aRendre, 5);
		rendre(aRendre, 1);
	}

	private static int rendre(int aRendre, int coupure) {
		while (aRendre >= coupure) {
			System.out.printf("%nJe rends %d €", coupure);
			aRendre -= coupure;
		}
		return aRendre;
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

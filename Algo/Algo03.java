package fr.fs.algo;

import java.util.Scanner;

public class Algo03 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		float prixUnitaireHT;
		final float TAUX_TVA = 0.2f;
		int quantite;
		float prixUnitaireTTC;
		float prixTotal;

		System.out.print("Saisissez le prix unitaire hors taxes : ");
		prixUnitaireHT = myScanner.nextFloat();
		System.out.print("Saisissez la quantité : ");
		quantite = myScanner.nextInt();
		prixUnitaireTTC = prixUnitaireHT * (1 + TAUX_TVA);
		prixUnitaireTTC = Math.round(prixUnitaireTTC*100)/100f;
		prixTotal = Math.round(prixUnitaireTTC * quantite * 100);
		prixTotal = prixTotal / 100f;
		System.out.printf("Prix unitaire TTC : %.2f%n", prixUnitaireTTC);
		System.out.printf("Vous devez %.2f", prixTotal);
	}
}

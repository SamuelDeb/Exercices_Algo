package fr.fs.algo;

import java.util.Scanner;

public class Algo07 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		System.out.print("Saisissez la première valeur : ");
		int firstValue = myScanner.nextInt();
		System.out.print("Saisissez la seconde valeur : ");
		int secondValue = myScanner.nextInt();

		boolean valuesArePositive = firstValue > 0 && secondValue > 0;
		boolean valuesAreNegative = firstValue < 0 && secondValue < 0;

		if (valuesArePositive || valuesAreNegative)
			System.out.println("Le produit de ces deux nombres est positif");
		else
			System.out.println("Le produit de ces deux nombres est négatif");
	}

}

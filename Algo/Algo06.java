package fr.fs.algo;

import java.util.Scanner;

public class Algo06 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		System.out.print("Entrez l'âge de votre enfant : ");
		short age = myScanner.nextShort();

		boolean isNotTropJeune = age >= 10;
		boolean isNotTropVieux = age <= 18;

		if (isNotTropJeune && isNotTropVieux)
			System.out.println("Ok, je prends son inscription !");
		else
			System.out.println("Désolé, aucune catégorie d'âge n'existe pour votre enfant !");

		boolean isTropJeune = age < 10;
		boolean isTropVieux = age > 18;
		if (isTropJeune || isTropVieux)
			System.out.println("Désolé, aucune catégorie d'âge n'existe pour votre enfant !");
		else
			System.out.println("Ok, je prends son inscription !");
	}

}

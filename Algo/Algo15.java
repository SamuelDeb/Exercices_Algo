package fr.fs.algo;

import java.util.Scanner;

public class Algo15 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		System.out.print("Quel est votre âge : ");
		byte age = myScanner.nextByte();
		myScanner.nextLine();


		System.out.print("Quel est votre genre ? (F / M) : ");
		String genre = myScanner.nextLine().toUpperCase();

		
		if (isImposable(genre, age))
			System.out.println("Vous êtes soumis à l'impôt !");
		else
			System.out.println("Vous êtes exonéré !");
	}

	private static boolean isImposable(String genre, byte age) {
		if (genre.equals("F"))
			return age >= 18 && age <= 35;
		return (age > 20);
	}
}

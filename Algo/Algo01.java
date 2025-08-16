package fr.fs.algo;

import java.util.Scanner;

public class Algo01 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		String nom;
		System.out.print("Entrez votre nom :");
		nom = myScanner.nextLine();
		System.out.printf("Bonjour %s, vous avez %d ans !" , nom,10);
	}

}

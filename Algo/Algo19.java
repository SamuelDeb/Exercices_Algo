package fr.fs.algo;

import java.util.Scanner;

public class Algo19 {
	static Scanner myScanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String reponse = repondreON();
		
		if (reponse.equals("O"))
			System.out.println("Ok, je prépare !");
		else
			System.out.println("Une autre fois, peut-être !");
	}

	private static String repondreON() {
		

		String reponse = "";

		while (!(reponse.equals("O") || reponse.equals("N"))) {
			System.out.print("Voulez vous un café ? (O/N) ");
			reponse = myScanner.nextLine().toUpperCase();
		}
		return reponse;
	}
}

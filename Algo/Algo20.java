package fr.fs.algo;

import java.util.Scanner;

public class Algo20 {

	static Scanner myScanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		int choix = saisirUnEntier(1,3);
		System.out.printf("Vous avez choisi l'option %d",choix);
	}

	private static int saisirUnEntier(int min, int max) {
		int value ;
		do {
			System.out.printf("Saisissez un entier (%d-%d)",min,max);
			value = myScanner.nextInt();
		} while (value < min || value > max) ;
		return value;
	}
}

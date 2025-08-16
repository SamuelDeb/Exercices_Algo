package fr.fs.algo;

import java.util.Scanner;

public class Algo11v3 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		short age;

		System.out.print("Entrez l'âge de votre enfant : ");
		age = myScanner.nextShort();
		switch (age) {
		case 4, 5, 6, 7:
			System.out.println("Inscription en MiniBad !");
			break;
		case 8, 9:
			System.out.println("Inscription en Poussins !");
			break;
		case 10, 11:
			System.out.println("Inscription en Benjamins !");
			break;
		case 12, 13:

			System.out.println("Inscription en Minimes !");
			break;
		case 14, 15:
			System.out.println("Inscription en Cadets !");
			break;
		case 16, 17:
			System.out.println("Inscription en Juniors !");
			break;
		default:
			System.out.println("Inscription impossible !");
		}
	}
}

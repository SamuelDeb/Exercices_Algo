package fr.fs.algo;

import java.util.Scanner;

public class Algo11v4 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		short age;

		System.out.print("Entrez l'âge de votre enfant : ");
		age = myScanner.nextShort();

		switch (age) {
		case 4, 5, 6, 7 -> {
			System.out.println("Inscription en MiniBad !");
		}
		case 8, 9 -> System.out.println("Inscription en Poussins !");
		case 10, 11 -> System.out.println("Inscription en Benjamins !");
		case 12, 13 -> System.out.println("Inscription en Minimes !");
		case 14, 15 -> System.out.println("Inscription en Cadets !");
		case 16, 17 -> System.out.println("Inscription en Juniors !");
		default -> System.out.println("Inscription impossible !");
		}
	}
}

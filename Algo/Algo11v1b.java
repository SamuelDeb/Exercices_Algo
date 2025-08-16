package fr.fs.algo;

import java.util.Scanner;

public class Algo11v1b {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		short age;
		System.out.print("Entrez l'âge de votre enfant : ");
		age = myScanner.nextShort();
		if (age < 4 || age > 17)
			System.out.println("Inscription impossible !");
		if (age >= 4 && age <= 7)
			System.out.println("Inscription en MiniBad !");
		if (age > 7 && age <= 9)
			System.out.println("Inscription en Poussins !");
		if (age > 9 && age <= 11)
			System.out.println("Inscription en Benjamins !");
		if (age > 11 && age <= 13)
			System.out.println("Inscription en Minimes !");
		if (age > 13 && age <= 15)
			System.out.println("Inscription en Cadets !");
		if (age > 15 && age <= 17)
			System.out.println("Inscription en Juniors !");
	}
}

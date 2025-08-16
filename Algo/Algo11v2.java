package fr.fs.algo;

import java.util.Scanner;

public class Algo11v2 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		short age;
		System.out.print("Entrez l'âge de votre enfant : ");
		age = myScanner.nextShort();
		if (age < 4)
			System.out.println("Inscription impossible !");
		else if (age <= 7)
			System.out.println("Inscription en MiniBad !");
		else if (age <= 9)
			System.out.println("Inscription en Poussins !");
		else if (age <= 11)
			System.out.println("Inscription en Benjamins !");
		else if (age <=13)
			System.out.println("Inscription en Minimes !");
		else if (age <=15)
			System.out.println("Inscription en Cadets !");
		else if (age <=17)
			System.out.println("Inscription en Juniors !");
		else
			System.out.println("Inscription impossible !");
			
	}

}

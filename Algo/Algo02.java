package fr.fs.algo;

import java.util.Scanner;

public class Algo02 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		int price;
		int quantity;
		int prixTotal;
		System.out.print("Entrez le prix : ");
		price = myScanner.nextInt();
		System.out.print("Entrez la quantité : ");
		quantity = myScanner.nextInt();
		prixTotal = price * quantity;
		System.out.println("Le prix total est de " + prixTotal);

	}

}

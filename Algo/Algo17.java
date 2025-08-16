package fr.fs.algo;

import java.util.Scanner;

public class Algo17 {

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		System.out.print("Entrez le jour : ");
		byte jour = myScanner.nextByte();
		System.out.print("Entrez le mois : ");
		byte mois = myScanner.nextByte();
		System.out.print("Entrez l'année : ");
		short annee = myScanner.nextShort();

		if (isValidDate(jour, mois, annee))
			System.out.printf("le %02d/%02d/%04d est une date valide !", jour, mois, annee);
		else
			System.out.printf("le %02d/%02d/%04d n'est pas une date valide !", jour, mois, annee);
	}

	private static boolean isValidDate(byte jour, byte mois, short annee) {
		int nombreJour = calculerNbJours(mois, annee);
		return jour >= 1 && jour <= nombreJour;
	}

	private static short calculerNbJours(byte mois, short annee) {
		short nbJours;
		switch (mois) {
		case 1, 3, 5, 7, 8, 10, 12 -> nbJours = 31;
		case 4, 6, 9, 11 -> nbJours = 30;
		case 2 -> nbJours = calculerNbJoursFevrier(annee);
		default -> nbJours = 0;
		}
		return nbJours;
	}

	private static short calculerNbJoursFevrier(short annee) {
		boolean divBy4 = annee % 4 == 0;
		boolean divBy100 = annee % 100 == 0;
		boolean divBy400 = annee % 400 == 0;
		boolean isBissextile = divBy4 && !divBy100 || divBy400;
		if (isBissextile)
			return 29;
		return 28;
	}
}
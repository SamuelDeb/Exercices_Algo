package fr.fs.algo;

import java.util.Scanner;

public class Algo18 {
	
	static final String BLUE = "Bleu";
	static final String GREEN = "Vert";
	static final String ORANGE = "Orange";
	static final String RED = "Rouge";
	static final String REFUSED = "Exclu";
		
	static byte ageConducteur;
	static byte agePermis;
	static byte nombreAccidents;
	static byte ancienneteAssure;
	
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		System.out.print("Entrez l'âge du conducteur : ");
		ageConducteur = myScanner.nextByte();
		System.out.print("Entrez l'âge du permis : ");
		agePermis = myScanner.nextByte();
		System.out.print("Entrez le nombre d'accident  : ");
		nombreAccidents = myScanner.nextByte();
		System.out.print("Entrez l'ancienneté de l'assuré  : ");
		ancienneteAssure = myScanner.nextByte();

		String tarif = calculerTarif();
		System.out.printf("Vous êtes admissible au tarif %s !",tarif);
	}

	private static String calculerTarif() {

		byte cotation = calculerCotation();
		
		String tarif;
		switch (cotation) {
		case 0 -> tarif = RED;
		case 1 -> tarif = ORANGE;
		case 2 -> tarif = GREEN;
		case 3 -> tarif = BLUE;
		default -> tarif = REFUSED;
		}
		return tarif;
	}

	private static byte calculerCotation() {
		byte cotation = 0;
		if (ageConducteur >= 25)
			cotation++;
		if (agePermis >= 2)
			cotation++;
		cotation -= nombreAccidents;
		if (cotation >= 0 && ancienneteAssure > 5)
			cotation++;
		return cotation;
	}

}

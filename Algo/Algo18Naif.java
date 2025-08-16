package fr.fs.algo;

import java.util.Scanner;

public class Algo18Naif {

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
		System.out.printf("Vous êtes admissible au tarif %s !", tarif);
	}

	private static String calculerTarif() {
		String tarif;
		if (ageConducteur < 25 && agePermis < 2) {
			if (nombreAccidents == 0)
				tarif = RED;
			else
				tarif = REFUSED;
		} else if (ageConducteur >= 25 && agePermis < 2 || ageConducteur < 25 && agePermis >= 2)
			switch (nombreAccidents) {
			case 0 -> tarif = ORANGE;
			case 1 -> tarif = RED;
			default -> tarif = REFUSED;
			}
		else
			switch (nombreAccidents) {
			case 0 -> tarif = GREEN;
			case 1 -> tarif = ORANGE;
			case 2 -> tarif = RED;
			default -> tarif = REFUSED;
			}
		if (ancienneteAssure > 5) {
			if (tarif.equals(GREEN))
				tarif = BLUE;
			else if (tarif.equals(ORANGE))
				tarif = GREEN;
			else if (tarif.equals(RED))
				tarif = ORANGE;
		}
		return tarif;
	}

}

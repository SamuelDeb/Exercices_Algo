package fr.fs.algo;

import java.util.Random;
import java.util.Scanner;

public class Algo21 {
	static Scanner myScanner = new Scanner(System.in);
	static Random myRandom = new Random();
	static final short NB_ESSAI = 10;
	static final int MIN = 10000;
	static final int MAX = 50000;

	static int justePrix;
	static int proposition;
	static short essai;

	public static void main(String[] args) {
		do {
			jouerUnePartie();
		} while (repondreON("Voulez-vous rejouer").equals("O"));
	}

	private static String repondreON(String question) {

		String reponse = "";
		while (!(reponse.equals("O") || reponse.equals("N"))) {
			System.out.printf("%n%s ? (O/N) ", question);
			reponse = myScanner.nextLine().toUpperCase();
		}
		return reponse;
	}

	private static void jouerUnePartie() {
		initialiser();
		proposerDesValeurs();
		afficherResultat();
	}

	private static void initialiser() {
		essai = 1;
		genererJustePrix();
	}

	private static void proposerDesValeurs() {
		do {
			proposition = saisirUnEntier("Votre proposition", MIN, MAX);
			evaluer();
		} while (proposition != justePrix && essai++ < NB_ESSAI);
	}

	private static void genererJustePrix() {

		justePrix = myRandom.nextInt(MIN, MAX);
	}

	private static int saisirUnEntier(String question, int min, int max) {
		int value;
		do {
			System.out.printf("%n%s (%d-%d)", question, min, max);
			value = myScanner.nextInt();
		} while (value < min || value > max);
		return value;
	}

	private static void evaluer() {
		if (proposition < justePrix)
			System.out.println("C'est plus Grand !");
		else if (proposition > justePrix)
			System.out.println("C'est plus Petit !");
	}

	private static void afficherResultat() {
		if (proposition == justePrix)
			System.out.printf("Bravo vous avez gagner en %d essais !", essai);
		else
			System.out.printf("Vous avez perdu, il fallait trouver : %d !", justePrix);
	}
}

package fr.fs.algo;

import java.util.Scanner;

public class Algo13 {
static short heure;
static short minute;
static short seconde;

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		System.out.print("Entrez les heures : ");
		heure = myScanner.nextShort();
		System.out.print("Entrez les minutes : ");
		minute = myScanner.nextShort();
		System.out.print("Entrez les secondes : ");
		seconde = myScanner.nextShort();

		incrementSeconds();
		System.out.printf("Dans 1 minute, il sera exactement %02d:%02d:%02d", heure, minute, seconde);
	}

	private static void incrementSeconds() {
		if (seconde == 59) {
			seconde = 0;
			incrementMinutes();
		} else
			seconde++;
	}

	private static void incrementMinutes() {
		if (minute == 59) {
			minute = 0;
			incrementHours();
		} else
			minute++;
	}

	private static void incrementHours() {
		if (heure == 23)
			heure = 0;
		else
			heure++;
	}

}

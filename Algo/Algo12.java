package fr.fs.algo;

import java.util.Scanner;

public class Algo12 {
	static short heure;
	static short minute;
	
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		System.out.print("Entrez les heures : ");
		heure = myScanner.nextShort();
		System.out.print("Entrez les minutes : ");
		minute = myScanner.nextShort();

		incrementMinute();
		System.out.printf("Dans 1 minute, il sera exactement %02d:%02d", heure,minute);
	}

	private static void incrementMinute() {
		if (minute == 59) {
			minute = 0;
			incrementHours();
		} else
			++minute;
	}

	private static void incrementHours() {
		if (heure == 23)
			heure = 0;
		else
			heure++;
	}

}

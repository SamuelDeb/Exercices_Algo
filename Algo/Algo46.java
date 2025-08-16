package fr.fs.algo;

import java.util.Scanner;

public class Algo46 {
	static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Entrez une phrase : ");
		String phrase = myScanner.nextLine();
		analyser(phrase);
	}

	private static void analyser(String phrase) {
		System.out.printf("%nLa phrase : \"%s\", contient :", phrase);
		System.out.printf("%n   - %2d mots", compterMots(phrase));
		System.out.printf("%n   - %2d lettres", compterLettres(phrase));
		System.out.printf("%n   - %2d consonnes", compterConsonnes(phrase));
		System.out.printf("%n   - %2d voyelles", compterVoyelles(phrase));
	}

	public static int compterVoyelles(String string) {
		String voyelles = "aàäâeéèëêiïîoöôuùüûy";
		return compterOccurences(voyelles, string.toLowerCase());
	}

	private static int compterOccurences(String searchedChars, String string) {
		int nbOccurences = 0;
		for (int index = 0; index < string.length(); index++) {
			String currentChar = string.substring(index, index + 1);
			nbOccurences += incrementIf(searchedChars.contains(currentChar));
		}
		return nbOccurences;
	}

	public static int incrementIf(boolean bool) {
		if (bool)
			return 1;
		return 0;
	}

	public static int compterConsonnes(String string) {
		String consonnes = "bcçdfghjklmnpqrstvwxz";
		return compterOccurences(consonnes, string.toLowerCase());
	}

	public static int compterLettres(String string) {
		return compterConsonnes(string) + compterVoyelles(string);
	}

	public static int compterMots(String string) {
		int nbMots = 0;
		boolean isPreviousCharLetter = false;
		for (int index = 0; index < string.length(); index++) {
			String currentChar = string.substring(index, index + 1);
			boolean isCurrentCharLetter = isLetter(currentChar);
			nbMots += incrementIf(!isPreviousCharLetter && isCurrentCharLetter);
			if (!currentChar.equals("-") || nbMots == 1)
				isPreviousCharLetter = isCurrentCharLetter;
		}
		return nbMots;
	}

	private static boolean isLetter(String currentChar) {
		return compterLettres(currentChar) == 1;
	}
}

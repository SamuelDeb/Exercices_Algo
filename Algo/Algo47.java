package fr.fs.algo;

import java.util.Scanner;

public class Algo47 {
	static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.print("Entrez une phrase : ");
		String phrase = myScanner.nextLine();
		analyser(phrase);
	}

	private static void analyser(String phrase) {
		System.out.printf("%nLa phrase : \"%s\", ", phrase);
		if (isPalindrome(phrase))
			System.out.println("est un palindrome !");
		else
			System.out.println("n'est pas un palindrome !");
	}

	public static boolean isPalindrome(String phrase) {
		phrase = supprimerAccents(phrase.toLowerCase());
		phrase = garderLettres(phrase);
		boolean isPalindrome = true;
		int index = 0;
		while (isPalindrome && index < phrase.length() / 2) {
			char currentChar = phrase.charAt(index);
			char mirrorChar = phrase.charAt(phrase.length() - index - 1);
			isPalindrome = currentChar == mirrorChar;
			index++;
		}
		return isPalindrome;
	}

	public static String supprimerAccents(String phrase) {
		String carAccents = "àâçéèëêïîôùüûÿ";
		String carSubstit = "aaceeeeiiouuuÿ";
		StringBuilder resultat = new StringBuilder();
		for (int index = 0; index < phrase.length(); index++) {
			char currentChar = phrase.charAt(index);
			int position = carAccents.indexOf(currentChar);
			if (position == -1)
				resultat.append(transformerLigatures(currentChar));
			else {
				resultat.append(carSubstit.charAt(position));

			}

		}
		return resultat.toString();
	}

	private static String transformerLigatures(char currentChar) {
		return switch (currentChar) {
		case 'æ' -> "ae";
		case 'œ' -> "oe";
		default -> Character.toString(currentChar);
		};
	}

	public static String garderLettres(String phrase) {
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder resultat = new StringBuilder();
		for (int index = 0; index < phrase.length(); index++) {
			String currentChar = phrase.substring(index, index + 1);
			if (alphabet.contains(currentChar))
				resultat.append(currentChar);
		}
		return resultat.toString();
	}

}

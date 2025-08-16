package fr.fs.algo;

import java.util.Scanner;

public class Algo44 {
	static Scanner myScanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.print("Saisissez un prénom : ");
		String prenom = myScanner.nextLine();
		System.out.printf("%nBonjour %s !", toNomProprewithString(prenom));
	}

	public static String toNomProprewithString(String prenom) {
		StringBuilder nomPropre =new StringBuilder(prenom.substring(0, 1).toUpperCase());
		
		for (int index = 1; index < prenom.length(); index++) {
			String previousChar = prenom.substring(index - 1, index);
			String currentChar = prenom.substring(index, index + 1);
			if (" -".contains(previousChar))
				nomPropre.append(currentChar.toUpperCase());
			else
				nomPropre.append(currentChar.toLowerCase());
		}
		return nomPropre.toString();
	}

	public static String toNomProprewithChar(String prenom) {
		String nomPropre = prenom.substring(0, 1).toUpperCase();
		for (int index = 1; index < prenom.length(); index++) {
			char previousChar = prenom.charAt(index - 1);
			char currentChar = prenom.charAt(index);
			if (" -".indexOf(previousChar) >= 0)
				nomPropre += Character.toUpperCase(currentChar);
			else
				nomPropre += Character.toLowerCase(currentChar);
		}
		return nomPropre;
	}
}

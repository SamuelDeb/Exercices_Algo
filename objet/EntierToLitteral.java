package fr.fs.algo;

import java.math.BigDecimal;
import java.util.Scanner;

public class EntierToLitteral {
	static Scanner myScanner = new Scanner(System.in);
	private static final int DIX = 10;
	private static final int CENT = 100;
	private static final String[] UNITES = { "zéro", "un", "deux", "trois", "quatre", "cinq", "six", "sept", "huit", "neuf" };
	private static final String[] UNITES_SPE = { "dix", "onze", "douze", "treize", "quatorze", "quinze", "seize", "dix-sept", "dix-huit", "dix-neuf" };
	private static final String[] DIZAINES = { "", "", "vingt", "trente", "quarante", "cinquante", "soixante", "soixante", "quatre-vingt", "quatre-vingt" };

	private static final long[] E_VALEUR = { calculerE(18), calculerE(15), calculerE(12), calculerE(9), calculerE(6), calculerE(3) };
	private static final String[] E_TEXTE = { "trillion", "billiard", "billion", "milliard", "million", "mille" };
	private static final Boolean[] E_IS_VARIABLE = { true, true, true, true, true, false };
	private static String separateur;

	public static void main(String[] args) {
		System.out.print("Saisissez le montant à payer : ");
		String montant = myScanner.nextLine();
		System.out.println("Montant  : " + montant);
		System.out.println("         : " + libellerCheque(montant));
	}

	public static String libellerCheque(String valeur) {
		valeur = valeur.replace(",", ".");
		long partieEntiere = calculerPartieEntiere(valeur);
		int partieDecimale = calculerPartieDecimale(valeur);
		StringBuilder resultat = new StringBuilder("***");
		resultat.append(convertLongToLitteral(partieEntiere, false));
		resultat.append(afficherEuro(resultat.toString()));
		resultat.append(afficherSi(partieEntiere > 1, "s"));
		resultat.append(" et " + convertLongToLitteral(partieDecimale, false));
		resultat.append(" centime" + afficherSi(partieDecimale > 1, "s"));
		resultat.append("***");
		return resultat.toString();
	}

	public static long calculerE(int exposant) {
		if (exposant == 0)
			return 1;
		return 10 * calculerE(exposant - 1);
	}

	private static long calculerPartieEntiere(String valeur) {
		return new BigDecimal(valeur).longValue();
	}

	private static int calculerPartieDecimale(String valeur) {
		int partieDecimale = 0;
		int indexSeparateur = valeur.indexOf(".");
		if (indexSeparateur != -1) {
			String partieDecimaleString = valeur.substring(indexSeparateur + 1) + "0";
			partieDecimale = Integer.parseInt(partieDecimaleString.substring(0, 2));
		}
		return partieDecimale;
	}

	private static String afficherEuro(String stringValue) {
		return switch (stringValue.substring(stringValue.length() - 3)) {
		case "ion", "ons", "ard", "rds" -> " d'euro";
		default -> " euro";
		};
	}

	private static String afficherSi(boolean bool, String chaine) {
		if (bool)
			return chaine;
		return "";
	}

	public static String convertLongToLitteral(long reste, boolean norme90) {
		separateur = choisirSeparateur(norme90);
		if (reste == 0)
			return UNITES[0];
		StringBuilder resultat = new StringBuilder();
		for (int indice = 0; indice < E_VALEUR.length; indice++) {
			short quantite = (short) (reste / E_VALEUR[indice]);
			reste -= quantite * E_VALEUR[indice];
			resultat.append(calculerPuissanceMille(reste == 0, indice, quantite));
		}
		return resultat.append(calculerCentaine((int) reste, true)).toString();
	}

	private static String choisirSeparateur(boolean norme90) {
		if (norme90)
			return "-";
		return " ";
	}

	private static String calculerPuissanceMille(boolean isLastValue, int indice, short quantite) {
		return switch (quantite) {
		case 0 -> "";
		case 1 -> afficherSi(E_IS_VARIABLE[indice], "un" + separateur) + E_TEXTE[indice]
				+ afficherSi(!isLastValue, separateur);
		default -> calculerCentaine(quantite, E_IS_VARIABLE[indice]) + separateur + E_TEXTE[indice]
				+ afficherSi(E_IS_VARIABLE[indice], "s") + afficherSi(!isLastValue, separateur);
		};
	}

	private static String calculerCentaine(int reste, boolean variable) {
		int quantite = reste / CENT;
		reste -= quantite * CENT;
		if (reste == 0)
			return switch (quantite) {
			case 0 -> "";
			case 1 -> "cent";
			default -> UNITES[quantite] + separateur + "cent" + afficherSi(variable, "s");
			};

		return switch (quantite) {
		case 0 -> calculerDizaine(reste, variable);
		case 1 -> "cent" + separateur + calculerDizaine(reste, variable);
		default -> UNITES[quantite] + separateur + "cent" + separateur + calculerDizaine(reste, variable);
		};
	}

	private static String calculerDizaine(int nombre, boolean variable) {
		int dizaine = nombre / DIX;
		int unite = nombre - dizaine * DIX;
		return DIZAINES[dizaine] + switch (dizaine) {
		case 0 -> UNITES[unite];
		case 1 -> UNITES_SPE[unite];
		case 7 -> calculerUniteParDefaut(unite, UNITES_SPE);
		case 8 -> calculerUniteForEight(unite, variable);
		case 9 -> "-" + UNITES_SPE[unite];
		default -> calculerUniteParDefaut(unite, UNITES);
		};
	}

	private static String calculerUniteForEight(int unite, boolean variable) {
		if (unite == 0)
			return afficherSi(variable, "s");
		return "-" + UNITES[unite];
	}

	private static String calculerUniteParDefaut(int unite, String[] unites) {
		return switch (unite) {
		case 0 -> "";
		case 1 -> separateur + "et" + separateur + unites[unite];
		default -> "-" + unites[unite];
		};
	}
}

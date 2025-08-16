package fr.fs.outils;

public class Base {

	private static final String SYMBOLES = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public static long convertBaseToDecimal(String stringValue, int base) {
		stringValue = stringValue.trim();
		long longvalue = 0;
		int length = stringValue.length();
		for (int indice = 0; indice < length; indice++) {
			int indiceSymbole = SYMBOLES.indexOf(stringValue.charAt(length - indice - 1));
			longvalue += pow(base, indice) * indiceSymbole;
		}
		return longvalue;
	}

	public static String convertDecimalToBase(long value, int base) {
		StringBuilder resultat = new StringBuilder();
		while (value >= base) {
			int reste = (int) (value % base);
			value /= base;
			resultat.insert(0, SYMBOLES.charAt(reste));
		}
		resultat.insert(0, SYMBOLES.charAt((int) value));
		return resultat.toString();
	}

	public static String convertFromBaseToBase(String stringValue, int baseOrigine, int baseDestination) {
		return convertDecimalToBase(convertBaseToDecimal(stringValue, baseOrigine), baseDestination);

	}

	private static long pow(int value, int exposant) {
		if (exposant == 0)
			return 1;
		return value * pow(value, exposant - 1);
	}

}

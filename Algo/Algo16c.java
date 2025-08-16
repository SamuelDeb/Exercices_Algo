package fr.fs.algo;

public class Algo16c {
	static int variableGobale = 5;

	public static void main(String[] args) {

		int variableInterne = 10;
		methodeAvecUnParametreQuiNeRenvoitRien(variableInterne);
	}

	private static void methodeSansParametreQuiNeRenvoitRien() {
		variableGobale += 5;
	}

	private static int methodeSansParametreQuiRenvoitUneValeur() {
		int variableInterne = 7;
		return variableGobale * 3 + variableInterne;
	}

	private static int methodeAvecUnParametreQuiRenvoitUneValeur(int parametre) {
		return parametre * variableGobale;
	}

	private static void methodeAvecUnParametreQuiNeRenvoitRien(int parametre) {
		System.out.printf("Le paramètre est égal à %d", parametre);

	}

	private static int methodeAvecDeuxParametreQuiNeRenvoitRien(int param1, int param2) {
		return variableGobale * (param1 + param2);

	}
}

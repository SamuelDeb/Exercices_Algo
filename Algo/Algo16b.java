package fr.fs.algo;

import java.util.Scanner;

public class Algo16b {
	static float scoreCandidatA;
	static float scoreCandidatB;
	static float scoreCandidatC;
	static float scoreCandidatD;

	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		System.out.print("Quel est le score du candidat A ? ");
		scoreCandidatA = myScanner.nextFloat();
		System.out.print("Quel est le score du candidat B ? ");
		scoreCandidatB = myScanner.nextFloat();
		System.out.print("Quel est le score du candidat C ? ");
		scoreCandidatC = myScanner.nextFloat();
		System.out.print("Quel est le score du candidat D ? ");
		scoreCandidatD = myScanner.nextFloat();

		System.out.printf("Le candidat A est %s", calculerResultatA());
	}

	private static String calculerResultatA() {
		if (isWinner())
			return "élu au premier tour !";
		if (isLooser())
			return "battu !";
		if (isInFirstPosition())
			return "en ballotage favorable !";
		return "en ballotage défavorable !";
	}

	private static boolean isInFirstPosition() {
		return scoreCandidatA > scoreCandidatB && scoreCandidatA > scoreCandidatC && scoreCandidatA > scoreCandidatD;
	}

	private static boolean isLooser() {
		return isEliminated() || isAnotherWinner();
	}

	private static boolean isAnotherWinner() {
		boolean isBWinner = scoreCandidatB > 50;
		boolean isCWinner = scoreCandidatC > 50;
		boolean isDWinner = scoreCandidatD > 50;
		return isBWinner || isCWinner || isDWinner;
	}

	private static boolean isEliminated() {
		return scoreCandidatA < 12.5f;
	}

	private static boolean isWinner() {
		return scoreCandidatA > 50;
	}
}

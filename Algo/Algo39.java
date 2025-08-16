package fr.fs.algo;

import java.util.Random;
import java.util.Scanner;

public class Algo39 {
	static Scanner myScanner = new Scanner(System.in);
	static Random myRandom = new Random();
	static final int NB_FACES = 6;
	static int[] diceList;
	static int[] distributionList;

	public static void main(String[] args) {
		System.out.print("Combien de lancers voulez-vous effectuer ? ");
		int nbDiceRoll = myScanner.nextInt();
		rollDices(nbDiceRoll);
		System.out.printf("%n%d valeurs ont été tirées.%n", diceList.length);
		displayDistribution();
	}

	private static void rollDices(int nbDicesRoll) {
		diceList = new int[nbDicesRoll];
		for (int indexOfDice = 0; indexOfDice < diceList.length; indexOfDice++)
			diceList[indexOfDice] = myRandom.nextInt(1, NB_FACES + 1);
	}

	private static void displayDistribution() {
		calculateDistribution();
		for (int indexOfSide = 0; indexOfSide < distributionList.length; indexOfSide++) {
			int side = indexOfSide + 1;
			System.out.printf("%nLe %d est sorti : %5d fois", side, distributionList[indexOfSide]);
			float percent = (float) distributionList[indexOfSide] / diceList.length * 100;
			System.out.printf(" (%.2f%%)", percent);
		}
	}

	private static void calculateDistribution() {
		distributionList = new int[NB_FACES];
		for (int indexOfDice = 0; indexOfDice < diceList.length; indexOfDice++) {
			int diceSide = diceList[indexOfDice];
			int diceSideIndex = diceSide - 1;
			distributionList[diceSideIndex]++;
		}
	}

}

package fr.fs.algo;

import java.util.Random;
import java.util.Scanner;

public class Algo36 {
	static Scanner myScanner = new Scanner(System.in);
	static Random myRandom = new Random();

	public static void main(String[] args) {
		int[] dices = tirer();
		System.out.print("Tirages : ");
		afficherTirage(dices);
	}

	private static void afficherTirage(int[] values) {
		for (int i = 0; i < values.length; i++)
			System.out.printf("%3d", values[i]);
	}

	private static int[] tirer() {
		int nbValues = 6;
		int[] values = new int[nbValues];
		for (int i = 0; i < values.length; i++) {
			values[i] = myRandom.nextInt(1, nbValues + 1);
		}
		return values;
	}

}

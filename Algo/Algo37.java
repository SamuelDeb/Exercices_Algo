package fr.fs.algo;

import java.util.Random;
import java.util.Scanner;

public class Algo37 {
	static Scanner myScanner = new Scanner(System.in);
	static Random myRandom = new Random();
	static final int NB_VALUES = 6;

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
		int[] values = new int[NB_VALUES];
		for (int i = 0; i < values.length; i++)
			tirerElement(values, i);
		return values;
	}

	private static void tirerElement(int[] values, int i) {
		do
			values[i] = myRandom.nextInt(1, NB_VALUES + 1);
		while (isIn(values, i));
	}

	private static boolean isIn(int[] values, int indiceLimite) {
		boolean isIn = false;
		int i = 0;
		while (!isIn && (i < indiceLimite)) {
			isIn = (values[i] == values[indiceLimite]);
			i++;
		}
		return isIn;
	}

}

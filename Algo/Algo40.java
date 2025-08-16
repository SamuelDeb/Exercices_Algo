package fr.fs.algo;

import java.util.Random;
import java.util.Scanner;

public class Algo40 {
	static Scanner myScanner = new Scanner(System.in);
	static Random myRandom = new Random();
	
	public static void main(String[] args) {
		int[] values = new int[20];
		System.out.println(values);
		
		generate(values);
		afficher(values);
		inverser(values);
		afficher(values);
	}

	
	
	private static void afficher(int[] values) {
		System.out.println(values);
		for (int value : values) {
			System.out.printf("|%2d", value);
		}
	}
	
	
	private static void generate(int[] values) {
		for (int value : values){
			value = myRandom.nextInt(100);
		}
	}

	

	private static void inverser(int[] values) {
		for (int index = 0 ; index < values.length / 2 ; index++) {
			int temp = values[index];
			values [index] = values [values.length - index -1];
			values [values.length - index -1]= temp;	
		}

	}
}

package fr.fs.algo;

import java.util.Random;
import java.util.Scanner;

public class Algo42 {
	static Scanner myScanner = new Scanner(System.in);
	static Random myRandom = new Random();
	static int[][] twoDimensionList;

	public static void main(String[] args) {
		twoDimensionList = new int[10][5];
		System.out.println(twoDimensionList.length);
		randomizeList();
	}

	private static void randomizeList() {
		for (int firstIndex = 0 ; firstIndex < twoDimensionList.length ; firstIndex++) {
			for (int secondIndex = 0; secondIndex < twoDimensionList[firstIndex].length ; secondIndex++)
			{
				twoDimensionList[firstIndex][secondIndex] = myRandom.nextInt(1,7);
			}
		}	
	}
}

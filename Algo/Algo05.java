package fr.fs.algo;

import java.util.Scanner;

public class Algo05 {

	public static void main(String[] args) {

		Scanner myScanner = new Scanner(System.in);
		int anciennete;
		boolean isSenior;
		System.out.print("Quelle est votre ancienneté ? ");
		anciennete = myScanner.nextInt();
		isSenior = anciennete >= 3;
		if (isSenior) 
			System.out.println("Vous serez embauché comme développeur sénior ");
		 else 
			System.out.println("Vous serez embauché comme développeur junior ");
		
	}
}

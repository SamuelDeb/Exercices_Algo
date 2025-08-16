package fr.fs.algo;

import java.util.Scanner;

public class Algo14 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);

		System.out.println("Combien de photocopie voulez-vous ? ");
		int nombrePhotocopie = myScanner.nextInt();
		float aPayer = calculerTarif(nombrePhotocopie);

		System.out.printf("Vous devez %.2f euros", aPayer);

	}

	private static float calculerTarif(int nombrePhotocopie) {

		if (nombrePhotocopie <= 10)
			return nombrePhotocopie * 0.1f;
		if (nombrePhotocopie <= 30)
			return nombrePhotocopie * 0.09f + 0.10f;
		return nombrePhotocopie * 0.08f + 0.40f;

	}

}

package fr.fs.algo;

import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

public class Tris {
	private static final String CHAINE_FORMAT = "%n %34s : %,12d ns en %,12d comparaisons et %,12d échanges";
	static Random alea = new Random();
	private static final int LIMIT_OPTIMISATION = 20;
	static final int NB_VALUES = 1000000;
	static final int LIMIT_SLOW_SORT = 10000;
	static int[] values;
	static int nbOfSwap;
	static int nbOfIteration;

	public static void main(String[] args) {
		values = new int[NB_VALUES];
		remplirTableau();
		if (NB_VALUES <= LIMIT_SLOW_SORT) {
			testInsertion();
			testSelection();
			testBulleAsc();
			testBulleDesc();
			testBulleBidirect();
		}
		testPeigne();
		testQuickSort();
		testQuickSortOptimizeBulle();
		testQuickSortOptimizeInsertion();
	}

	private static void remplirTableau() {
		for (int i = 0; i < values.length; i++) {
			values[i] = alea.nextInt(NB_VALUES);
		}
	}

	private static void afficherResultat(String titre, long time, int[] entiers) {
		System.out.printf(Locale.CANADA_FRENCH, CHAINE_FORMAT, titre, time, nbOfIteration, nbOfSwap);
		if (entiers.length < 10)
			afficherValeurs(entiers);
	}

	private static void afficherValeurs(int[] tableau) {
		for (int valeur : tableau)
			System.out.printf("%3d", valeur);
	}

	private static void testInsertion() {
		intialize();
		long debut;
		long fin;
		int[] tableau = Arrays.copyOf(values, NB_VALUES);
		debut = System.nanoTime();
		trierInsertion(tableau, 0, tableau.length);
		fin = System.nanoTime();
		afficherResultat("Insertion", fin - debut, tableau);
	}

	private static void testSelection() {
		intialize();
		long debut;
		long fin;
		int[] tableau = Arrays.copyOf(values, NB_VALUES);
		debut = System.nanoTime();
		trierParSelection(tableau);
		fin = System.nanoTime();
		afficherResultat("Sélection", fin - debut, tableau);
	}

	private static void testPeigne() {
		intialize();
		long debut;
		long fin;
		int[] tableau = Arrays.copyOf(values, NB_VALUES);
		debut = System.nanoTime();
		trierPeigne(tableau);
		fin = System.nanoTime();
		afficherResultat("Peigne", fin - debut, tableau);
	}

	private static void testBulleBidirect() {
		intialize();
		long debut;
		long fin;
		int[] tableau = Arrays.copyOf(values, NB_VALUES);
		debut = System.nanoTime();
		trierBulleBidirectionnelle(tableau, 0, tableau.length);
		fin = System.nanoTime();
		afficherResultat("Bulle bi-directionnelle", fin - debut, tableau);
	}

	private static void testBulleDesc() {
		intialize();
		long debut;
		long fin;
		int[] tableau = Arrays.copyOf(values, NB_VALUES);
		debut = System.nanoTime();
		trierBulleDescendante(tableau);
		fin = System.nanoTime();
		afficherResultat("Bulle descendante", fin - debut, tableau);
	}

	private static void testBulleAsc() {
		intialize();
		long debut;
		long fin;
		int[] tableau = Arrays.copyOf(values, NB_VALUES);
		debut = System.nanoTime();
		trierBulleMontante(tableau);
		fin = System.nanoTime();
		afficherResultat("Bulle ascendante", fin - debut, tableau);
	}

	private static void intialize() {
		nbOfIteration = 0;
		nbOfSwap = 0;
	}

	private static void testQuickSort() {
		intialize();
		long debut;
		long fin;
		int[] tableau = Arrays.copyOf(values, NB_VALUES);
		debut = System.nanoTime();
		trierQuickSort(tableau, 0, tableau.length - 1);
		fin = System.nanoTime();
		afficherResultat("Rapide", fin - debut, tableau);
	}

	private static void testQuickSortOptimizeBulle() {
		intialize();
		long debut;
		long fin;
		int[] tableau = Arrays.copyOf(values, NB_VALUES);
		debut = System.nanoTime();
		trierQuickSortOptimiseBulle(tableau, 0, tableau.length - 1);
		fin = System.nanoTime();
		afficherResultat("Rapide Optimisé par Bulle Bidirect", fin - debut, tableau);
	}

	private static void testQuickSortOptimizeInsertion() {
		intialize();
		long debut;
		long fin;
		int[] tableau = Arrays.copyOf(values, NB_VALUES);
		debut = System.nanoTime();
		trierQuickSortOptimiseInsertion(tableau, 0, tableau.length - 1);
		fin = System.nanoTime();
		afficherResultat("Rapide Optimisé par insertion ", fin - debut, tableau);
	}

	private static void trierBulleDescendante(int[] values) {
		int firstIndex = 0;
		int lastIndex = values.length - 1;
		while (descendreBulle(values, firstIndex++, lastIndex))
			;
	}

	private static boolean descendreBulle(int[] values, int firstIndex, int lastIndex) {
		boolean isEchange = false;
		for (int index = lastIndex; index > firstIndex; index--) {
			nbOfIteration++;
			if (values[index] < values[index - 1]) {
				echangerValeurs(values, index, index - 1);
				isEchange = true;
			}
		}
		return isEchange;
	}

	private static void echangerValeurs(int[] values, int firstIndex, int secondIndex) {
		nbOfSwap++;
		int temp = values[firstIndex];
		values[firstIndex] = values[secondIndex];
		values[secondIndex] = temp;
	}

	private static void trierBulleMontante(int[] values) {
		int firstIndex = 0;
		int lastIndex = values.length - 1;
		while (monterBulle(values, firstIndex, lastIndex--))
			;
	}

	private static boolean monterBulle(int[] values, int firstIndex, int lastIndex) {
		boolean isEchange;
		isEchange = false;
		for (int index = firstIndex; index < lastIndex; index++) {
			nbOfIteration++;
			if (values[index] > values[index + 1]) {
				echangerValeurs(values, index, index + 1);
				isEchange = true;
			}
		}
		return isEchange;
	}

	private static void trierBulleBidirectionnelle(int[] values, int firstIndex, int lastIndex) {
		boolean isEchange;
		boolean desc = true;
		lastIndex--;
		do {
			if (desc)
				isEchange = monterBulle(values, firstIndex, lastIndex--);
			else
				isEchange = descendreBulle(values, firstIndex++, lastIndex);
			desc = !desc;
		} while (isEchange);
	}

	private static void trierQuickSortOptimiseBulle(int[] values, int firstIndex, int lastIndex) {
		if (firstIndex < lastIndex - LIMIT_OPTIMISATION) {
			int pivotIndex = partitionner(values, firstIndex, lastIndex);
			trierQuickSortOptimiseBulle(values, firstIndex, pivotIndex - 1);
			trierQuickSortOptimiseBulle(values, pivotIndex + 1, lastIndex);
		} else {
			trierBulleBidirectionnelle(values, firstIndex, lastIndex + 1);
		}
	}

	private static void trierQuickSort(int[] values, int firstIndex, int lastIndex) {
		if (firstIndex < lastIndex) {
			int pivotIndex = partitionner(values, firstIndex, lastIndex);
			trierQuickSort(values, firstIndex, pivotIndex - 1);
			trierQuickSort(values, pivotIndex + 1, lastIndex);
		}
	}

	private static int partitionner(int[] values, int firstIndex, int lastIndex) {
		int pivotValue = values[firstIndex];
		int saveFirstIndex = firstIndex;
		firstIndex++;
		while (firstIndex < lastIndex) {
			while (firstIndex < lastIndex && values[lastIndex] >= pivotValue) {
				lastIndex--;
				nbOfIteration++;
			}
			while (firstIndex < lastIndex && values[firstIndex] <= pivotValue) {
				firstIndex++;
				nbOfIteration++;
			}
			echangerValeurs(values, firstIndex, lastIndex);
		}
		if (values[firstIndex] > pivotValue)
			firstIndex--;
		values[saveFirstIndex] = values[firstIndex];
		values[firstIndex] = pivotValue;
		return firstIndex;
	}

	private static void trierParSelection(int[] values) {
		for (int index = 0; index < values.length - 1; index++) {
			int smallestValueIndex = trouverPlusPetiteValeur(values, index);
			if (index != smallestValueIndex)
				echangerValeurs(values, index, smallestValueIndex);
		}
	}

	private static int trouverPlusPetiteValeur(int[] values, int firstIndex) {
		for (int index = firstIndex + 1; index < values.length; index++) {
			nbOfIteration++;
			if (values[index] < values[firstIndex])
				firstIndex = index;
		}
		return firstIndex;
	}

	private static void trierPeigne(int[] values) {
		int intervalle = values.length;
		boolean isEchange = true;
		while (intervalle > 1 || isEchange) {
			intervalle = Math.max(1, (int) (intervalle / 1.3));
			isEchange = peigner(values, intervalle);
		}
	}

	private static boolean peigner(int[] values, int intervalle) {
		boolean isEchange = false;
		for (int index = 0; index < values.length - intervalle; index++) {
			nbOfIteration++;
			if (values[index] > values[index + intervalle]) {
				echangerValeurs(values, index, index + intervalle);
				isEchange = true;
			}
		}
		return isEchange;
	}

	private static void trierQuickSortOptimiseInsertion(int[] values, int firstIndex, int lastIndex) {
		if (firstIndex < lastIndex - LIMIT_OPTIMISATION) {
			int pivotIndex = partitionner(values, firstIndex, lastIndex);
			trierQuickSortOptimiseInsertion(values, firstIndex, pivotIndex - 1);
			trierQuickSortOptimiseInsertion(values, pivotIndex + 1, lastIndex);
		} else {
			trierInsertion(values, firstIndex, lastIndex + 1);
		}
	}

	private static void trierInsertion(int[] values, int firstIndex, int lastIndex) {
		for (int index = firstIndex + 1; index < lastIndex; index++) {
			inserer(values, firstIndex, index);
		}
	}

	private static void inserer(int[] values, int firstIndex, int index) {

		int temp = values[index];
		while (index > firstIndex && values[index - 1] > temp) {
			values[index] = values[index - 1];
			nbOfSwap++;
			nbOfIteration++;
			index--;
		}
		values[index] = temp;
	}
}
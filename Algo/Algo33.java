package fr.fs.algo;

public class Algo33 {

	public static void main(String[] args) {
		char [] alphabet = new char[26];
		
		for ( char i = 0 ; i < alphabet.length;i++) {
			alphabet[i] = (char) (65 + i); 
			System.out.printf(" %s",alphabet[i]);
		}
	}
}

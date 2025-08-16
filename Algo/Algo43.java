package fr.fs.algo;


public class Algo43 {

	public static void main(String[] args) {
		
		String phrase = "Le petit chat est mort !";

		System.out.printf("%nen majuscule                    : %s","phrase.toUpperCase()");
		System.out.printf("%nen minuscule                    : %s",phrase.toLowerCase());
		System.out.printf("%nLongueur                        : %d",phrase.length());
		System.out.printf("%nsous-chaîne de 3 jusqu'à la fin : %s",phrase.substring(3));
		System.out.printf("%nsous-chaîne 3 à 12              : %s",phrase.substring(3,12));
		System.out.printf("%nsous-chaîne 3 à 4               : %s",phrase.substring(3,4));
		System.out.printf("%ncaractère en position 3         : %s",phrase.charAt(3));
		System.out.printf("%nPosition 1er caractère t        : %d",phrase.indexOf('t'));
		System.out.printf("%nPosition 1ére sous-chaine t     : %d",phrase.indexOf("t"));
		System.out.printf("%nPosition 1er t (à partir de)    : %d",phrase.indexOf('t',10));
		System.out.printf("%nPosition 1er t (à partir de)    : %d",phrase.indexOf("t",10));
		System.out.printf("%nPosition dernier caractère t    : %d",phrase.lastIndexOf('t'));
		System.out.printf("%nCommence par Je                 : %s",phrase.startsWith("Je"));
		System.out.printf("%nCommence par petit              : %s",phrase.startsWith("petit",3));

	   
	}

}

package fr.fs.guignolo.model;

import fr.fs.outils.Alea;

public class ComposantJeu {

	private String nom;
	private short nombreElements;
	private short[] numeros;
	private short[] numerosComplementaires;

	public ComposantJeu(String nom, int nombreElements, int nombreTirage, int nombreComplementaire) {

		if (nombreElements < nombreTirage + nombreComplementaire)
			throw new ComposantException("Le nombre d'éléments doit être supérieur au nombre d'éléments à tirer !");
		this.nom = nom;
		this.nombreElements = (short) nombreElements;
		numeros = new short[nombreTirage];
		numerosComplementaires = new short[nombreComplementaire];
	}

	public String getNom() {
		return nom;
	}

	public short[] getNumeros() {
		return numeros;
	}

	public short[] getNumerosComplementaires() {
		return numerosComplementaires;
	}

	protected void tirer() {

		for (short indice = 0; indice < numeros.length; indice++) {
			numeros[indice] = tirer(indice);
		}
		for (short indice = 0; indice < numerosComplementaires.length; indice++) {
			numerosComplementaires[indice] = tirerComplementaire(indice);
		}
	}

	private short tirer(short indice) {
		short numero;
		do {
			numero = Alea.tirerUnNumeroParmi(nombreElements);
		} while (isIn(numeros, numero, indice ));
		return numero;
	}

	private short tirerComplementaire(short indice) {
		short numero;
		do {
			numero = Alea.tirerUnNumeroParmi(nombreElements);
		} while (isIn(numeros, numero, numeros.length) || isIn(numerosComplementaires, numero, indice));
		return numero;
	}

	private short indexOf(short[] values, short numero, int lastIndex) {
		short indexOf = -1;
		short index = 0;
		while (indexOf == -1 && index < lastIndex) {
			if (numero == values[index])
				indexOf = index;
			index++;
		}
		return indexOf;
	}

	private boolean isIn(short[] values, short numero, int lastIndex) {
		return indexOf(values, numero, lastIndex) >= 0;
	}
}

package fr.fs.guignolo.model;

import fr.fs.guignolo.observer.Observable;

public class Jeu extends Observable {

	private String nom;
	private short nbreComposants;
	private ComposantJeu[] composants;

	public Jeu(String nom, int nbreComposants) {
		this.nom = nom;
		composants = new ComposantJeu[nbreComposants];
		nbreComposants = 0;
	}

	public String getNom() {
		return nom;
	}

	public ComposantJeu[] getComposants() {
		return composants;
	}

	public void addComposant(ComposantJeu composant) {
		if (nbreComposants < composants.length)
			composants[nbreComposants++] = composant;
	}

	public void tirer() {
		if (nbreComposants != composants.length)
			return;
		for (ComposantJeu composant : composants) {
			composant.tirer();
		}
		notifyObservers();
	}
}

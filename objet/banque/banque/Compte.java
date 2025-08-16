package fr.fs.banque;

import fr.fs.observer.Observable;
import fr.fs.vue.EnvoiMail;
import fr.fs.vue.EnvoiSMS;

public class Compte extends Observable {

	private String nom;
	private int solde;
	private Personne titulaire;
	private boolean anomalie;

	public Compte(String nom, Personne titulaire) {
		super();
		this.nom = nom;
		this.titulaire = titulaire;
		solde = 0;
		anomalie = false;
	}

	public String getNom() {
		return nom;
	}

	public int getSolde() {
		return solde;
	}

	public Personne getTitulaire() {
		return titulaire;
	}

	public boolean isAnomalie() {
		return anomalie;
	}

	public void deposer(int montant) {
		anomalie = false;
		solde += montant;
		notifyObservers();
	}

	public void retirer(int montant) {

		if (solde >= montant) {
			anomalie = false;
			solde -= montant;
		} else
			anomalie = true;
		notifyObservers();
	}

	public void virer(int montant, Compte autreCompte) {
		if (this.equals(autreCompte))
			return;
		if (solde >= montant) {
			retirer(montant);
			autreCompte.deposer(montant);
		} else {
			anomalie = true;
			notifyObservers();
		}
	}

	public void abonnerMail() {
		addObserver(EnvoiMail.getInstance());
	}

	public void desabonnerMail() {
		removeObserver(EnvoiMail.getInstance());
	}

	public void abonnerSMS() {
		addObserver(EnvoiSMS.getInstance());
	}

	public void desabonnerSMS() {
		removeObserver(EnvoiSMS.getInstance());
	}
}

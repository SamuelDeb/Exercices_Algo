package fr.fs.vue;

import fr.fs.banque.Compte;
import fr.fs.banque.Personne;
import fr.fs.observer.Observable;
import fr.fs.observer.Observer;

public class EnvoiMail implements Observer {

	private static EnvoiMail envoiMail;

	private EnvoiMail() {

	}

	public static EnvoiMail getInstance() {
		if (envoiMail == null)
			envoiMail = new EnvoiMail();
		return envoiMail;
	}

	private void envoyerMail(Compte compte) {
		Personne titulaire = compte.getTitulaire();
		if (titulaire.getEmail().isEmpty())
			return;
		System.out.printf("%nMail to : %s", titulaire.getEmail());
		if (compte.isAnomalie()) {
			System.out.printf("%nObjet : Anomalie");
			System.out.printf("%nBonjour %s %s,", titulaire.getPrenom(), titulaire.getNom());
			System.out.printf("%nUne opération sur votre %s, a été rejetée faute de solde suffisant.%n",
					compte.getNom());
		} else {
			System.out.printf("%nObjet : Modification de solde");
			System.out.printf("%nBonjour %s %s,", titulaire.getPrenom(), titulaire.getNom());
			System.out.printf("%nLe nouveau solde de votre %s est de %d euros%n", compte.getNom(), compte.getSolde());
		}
	}

	@Override
	public void actualiser(Observable observable) {

		if (observable instanceof Compte compte)
			envoyerMail(compte);
	}
}

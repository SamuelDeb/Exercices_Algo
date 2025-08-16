package fr.fs.vue;

import fr.fs.banque.Compte;
import fr.fs.banque.Personne;
import fr.fs.observer.Observable;
import fr.fs.observer.Observer;

public class EnvoiSMS implements Observer {

	private static EnvoiSMS envoiSMS;

	private EnvoiSMS() {

	}

	public static EnvoiSMS getInstance() {
		if (envoiSMS == null)
			envoiSMS = new EnvoiSMS();
		return envoiSMS;
	}

	private void envoyerSMS(Compte compte) {
		Personne titulaire = compte.getTitulaire();
		if (titulaire.getTelephone().isEmpty())
			return;
		System.out.printf("%nSMS to : %s", titulaire.getTelephone());
		if (compte.isAnomalie()) {
			System.out.printf("%nBonjour %s %s,", titulaire.getPrenom(), titulaire.getNom());
			System.out.printf("%nUne opération  sur votre %s, a été rejetée faute de solde suffisant.%n",
					compte.getNom());
		} else {
			System.out.printf("%nBonjour %s %s,", titulaire.getPrenom(), titulaire.getNom());
			System.out.printf("%nLe nouveau solde de votre %s est de %d euros%n", compte.getNom(), compte.getSolde());
		}
	}

	@Override
	public void actualiser(Observable observable) {

		if (observable instanceof Compte compte)
			envoyerSMS(compte);
	}
}

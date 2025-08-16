package fr.fs.guignolo.vue;

import fr.fs.guignolo.model.Journal;
import fr.fs.guignolo.model.ComposantJeu;
import fr.fs.guignolo.model.Jeu;
import fr.fs.guignolo.observer.Observable;
import fr.fs.guignolo.observer.Observer;

public class AbonnementMail implements Observer {

	Journal abonne;

	public AbonnementMail(Journal abonne) {
		super();
		this.abonne = abonne;
	}

	@Override
	public void actualiser(Observable observable) {
		if (observable instanceof Jeu jeu)
			envoyerMail(jeu);

	}

	private void envoyerMail(Jeu jeu) {

		System.out.printf("Mail à  %s (%s) :%n", abonne.getEmail(), abonne.getNom());
		System.out.printf("Le tirage %s vient d'avoir lieu : %n", jeu.getNom());
		for (ComposantJeu composant : jeu.getComposants()) {
			System.out.println();
			afficherComposant(composant);
		}
		System.out.println("\n\n");
	}

	private void afficherComposant(ComposantJeu composant) {

		afficherNumeros(composant.getNom(), composant.getNumeros());
		if (! (composant.getNumerosComplementaires().length ==0)) {
			afficherNumeros("   " + composant.getNom() + " Complémentaires", composant.getNumerosComplementaires());
		}
	}

	private void afficherNumeros(String nom, short [] numeros) {
		System.out.printf("%30s : ", nom);
		for (int numero : numeros) {
			System.out.printf("%4d ", numero);
		}
	}

}

package fr.fs.vue;

import fr.fs.banque.Compte;
import fr.fs.banque.Personne;

public class Main {

	public static void main(String[] args) {

		Personne lui = new Personne("dupont", "jean");
		lui.setEmail("jean.dupont@gmail.com");
		lui.setTelephone("0607080910");

		Personne elle = new Personne("dupont", "marie");
		elle.setEmail("marie.dupont@gmail.com");
		elle.setTelephone("0708091011");

		Compte compteLui = new Compte("compte courant", lui);
		Compte compteElle = new Compte("compte courant", elle);

		compteLui.abonnerMail();
		compteElle.abonnerSMS();

		compteLui.deposer(500);
		compteLui.abonnerSMS();
		compteLui.virer(100, compteElle);
		compteLui.retirer(500);

		EnvoiMail envoiMail = EnvoiMail.getInstance();
		System.out.println(envoiMail);
		EnvoiMail envoiMail2 = EnvoiMail.getInstance();
		System.out.println(envoiMail2);

	}

}

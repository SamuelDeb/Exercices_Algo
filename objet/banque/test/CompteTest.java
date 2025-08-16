package fr.fs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import fr.fs.banque.Compte;
import fr.fs.banque.Personne;

@TestMethodOrder(OrderAnnotation.class)
class CompteTest {
	private static Personne lui;
	private static Personne elle;
	private static Compte compteLui;
	private static Compte compteElle;

	@Test
	@Order(1)
	void testNewCompte() {
		lui = new Personne("dupont", "jean");
		elle = new Personne("dupont", "marie");
		compteLui = new Compte("compte courant", lui);
		compteElle = new Compte("compte courant", elle);
		assertEquals(0, compteLui.getSolde());
		assertEquals(0, compteElle.getSolde());
	}

	@Test
	@Order(2)
	void testDeposer() {
		compteLui.deposer(500);
		assertEquals(500, compteLui.getSolde());
	}

	@Test
	@Order(3)
	void testRetirer() {
		compteLui.retirer(1000);
		assertEquals(500, compteLui.getSolde());
		compteLui.retirer(100);
		assertEquals(400, compteLui.getSolde());
	}

	@Test
	@Order(4)
	void testVirer() {
		compteLui.virer(500, compteElle);
		assertEquals(400, compteLui.getSolde());
		assertEquals(0, compteElle.getSolde());
		compteLui.virer(200, compteElle);
		assertEquals(200, compteLui.getSolde());
		assertEquals(200, compteElle.getSolde());
	}

}

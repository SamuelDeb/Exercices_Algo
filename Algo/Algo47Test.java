package fr.fs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.fs.algo.Algo47;

class Algo47Test {

	@Test
	void testIsPalindrome() {
		assertFalse(Algo47.isPalindrome("Lille"));
		assertTrue(Algo47.isPalindrome("Laval"));
		assertFalse(Algo47.isPalindrome("La mariée va mal"));
		assertTrue(Algo47.isPalindrome("La mariée ira mal"));
		assertTrue(Algo47.isPalindrome("Eric, notre valet, alla te laver ton ciré !"));
		assertTrue(Algo47.isPalindrome("Arete, acte et cætera !"));
	}

	@Test
	void testSupprimerAccents() {
		assertEquals("Fenetree", Algo47.supprimerAccents("Fenêtrée"));
		assertEquals("Francais", Algo47.supprimerAccents("Français"));
		assertEquals("caetera", Algo47.supprimerAccents("cætera"));
	}

	@Test
	void testGarderLettres() {
		assertEquals("abcdef", Algo47.garderLettres("a!/?bc%*d+-ef"));
	}

}

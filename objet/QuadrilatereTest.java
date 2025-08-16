package fr.fs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.fs.poo.*;

class QuadrilatereTest {
Quadrilatere ligne =new Quadrilatere(point(0,0), point(0,1), point(0,2), point(0,3));
	Quadrilatere triangle = new Quadrilatere(point(0, 0), point(2, 0), point(4,0), point(4, 4));
	Quadrilatere convexe = new Quadrilatere(point(0,0), point(1,3), point(3, 4), point(5, 0));
	Quadrilatere concave = new Quadrilatere(point(0,0), point(1,3), point(3, 2), point(5, 0));
	Quadrilatere trapeze1 = new Quadrilatere(point(0, 3), point(2, 6), point(6, 6), point(2, 0));
	Quadrilatere trapeze2 = new Quadrilatere(point(2, 6), point(6, 6), point(2, 0), point(0, 3));
	Quadrilatere losange1 = new Quadrilatere(point(2, 6), point(4, 3), point(2, 0), point(0, 3));
	Quadrilatere losange2 = new Quadrilatere(point(4, 3), point(2, 0), point(0, 3), point(2, 6));
	Quadrilatere rectangle1 = new Quadrilatere(point(0, 0), point(0, 3), point(4, 3), point(4, 0));
	Quadrilatere rectangle2 = new Quadrilatere(point(0, 3), point(4, 3), point(4, 0), point(0, 0));
	Quadrilatere carre1 = new Quadrilatere(point(0, 0), point(0, 3), point(3, 3), point(3, 0));
	Quadrilatere carre2 = new Quadrilatere(point(0, 3), point(3, 3), point(3, 0), point(0, 0));
	Quadrilatere carre3 = new Quadrilatere(point(0, 2), point(2, 4), point(4, 2), point(2, 0));
	Quadrilatere cerfVolant1 = new Quadrilatere(point(2, 7), point(4, 3), point(2, 0), point(0, 3));
	Quadrilatere cerfVolant2 = new Quadrilatere(point(0,20), point(1,21), point(2,20), point(1,0));
	Quadrilatere deltoide1 = new Quadrilatere(point(2, 2), point(4, 3), point(2, 0), point(0, 3));
	Quadrilatere deltoide2 = new Quadrilatere(point(0,20), point(1,19), point(2,20), point(1,0));
	private Point point(int x, int y) {
		return new Point(x, y);
	}

	@Test
	void testIsQuadrilatere() {
		assertFalse(ligne.isQuadrilatere());
		assertFalse(triangle.isQuadrilatere());
		assertTrue(convexe.isQuadrilatere());
		assertTrue(trapeze1.isQuadrilatere());
		assertTrue(trapeze2.isQuadrilatere());
		assertTrue(losange1.isQuadrilatere());
		assertTrue(losange2.isQuadrilatere());
		assertTrue(rectangle1.isQuadrilatere());
		assertTrue(rectangle2.isQuadrilatere());
		assertTrue(carre1.isQuadrilatere());
		assertTrue(carre2.isQuadrilatere());
		assertTrue(carre3.isQuadrilatere());
		assertTrue(cerfVolant1.isQuadrilatere());
		assertTrue(cerfVolant2.isQuadrilatere());
		assertTrue(deltoide1.isQuadrilatere());
		assertTrue(deltoide2.isQuadrilatere());
	}
	
	
	@Test
	void testIsTrapeze() {
		assertFalse(triangle.isTrapeze());
		assertFalse(convexe.isTrapeze());
		assertTrue(trapeze1.isTrapeze());
		assertTrue(trapeze2.isTrapeze());
		assertTrue(losange1.isTrapeze());
		assertTrue(losange2.isTrapeze());
		assertTrue(rectangle1.isTrapeze());
		assertTrue(rectangle2.isTrapeze());
		assertTrue(carre1.isTrapeze());
		assertTrue(carre2.isTrapeze());
		assertTrue(carre3.isTrapeze());
		assertFalse(cerfVolant1.isTrapeze());
		assertFalse(cerfVolant2.isTrapeze());
		assertFalse(deltoide1.isTrapeze());
		assertFalse(deltoide2.isTrapeze());
	}

	@Test
	void testIsParallelogramme() {

		assertFalse(triangle.isParallelogramme());
		assertFalse(convexe.isParallelogramme());
		assertFalse(trapeze1.isParallelogramme());
		assertFalse(trapeze2.isParallelogramme());
		assertTrue(losange1.isParallelogramme());
		assertTrue(losange2.isParallelogramme());
		assertTrue(rectangle1.isParallelogramme());
		assertTrue(rectangle2.isParallelogramme());
		assertTrue(carre1.isParallelogramme());
		assertTrue(carre2.isParallelogramme());
		assertTrue(carre3.isParallelogramme());
		assertFalse(cerfVolant1.isParallelogramme());
		assertFalse(cerfVolant2.isParallelogramme());
		assertFalse(deltoide1.isParallelogramme());
		assertFalse(deltoide2.isParallelogramme());
	}

	@Test
	void testIsCerfVolant() {
		assertFalse(triangle.isCerfVolant());
		assertFalse(convexe.isCerfVolant());
		assertFalse(trapeze1.isCerfVolant());
		assertFalse(trapeze2.isCerfVolant());
		assertTrue(losange1.isCerfVolant());
		assertTrue(losange2.isCerfVolant());
		assertFalse(rectangle1.isCerfVolant());
		assertFalse(rectangle2.isCerfVolant());
		assertTrue(carre1.isCerfVolant());
		assertTrue(carre2.isCerfVolant());
		assertTrue(carre3.isCerfVolant());
		assertTrue(cerfVolant1.isCerfVolant());
		assertTrue(cerfVolant2.isCerfVolant());
		assertFalse(deltoide1.isCerfVolant());
		assertFalse(deltoide2.isCerfVolant());
	}

	@Test
	void testIsDeltoide() {
		assertFalse(triangle.isDeltoide());
		assertFalse(convexe.isDeltoide());
		assertFalse(trapeze1.isDeltoide());
		assertFalse(trapeze2.isDeltoide());
		assertFalse(losange1.isDeltoide());
		assertFalse(losange2.isDeltoide());
		assertFalse(rectangle1.isDeltoide());
		assertFalse(rectangle2.isDeltoide());
		assertFalse(carre1.isDeltoide());
		assertFalse(carre2.isDeltoide());
		assertFalse(carre3.isDeltoide());
		assertFalse(cerfVolant1.isDeltoide());
		assertFalse(cerfVolant2.isDeltoide());
		assertTrue(deltoide1.isDeltoide());
		assertTrue(deltoide2.isDeltoide());

	}

	@Test
	void testIsLosange() {
		assertFalse(triangle.isLosange());
		assertFalse(convexe.isLosange());
		assertFalse(trapeze1.isLosange());
		assertFalse(trapeze2.isLosange());
		assertTrue(losange1.isLosange());
		assertTrue(losange2.isLosange());
		assertFalse(rectangle1.isLosange());
		assertFalse(rectangle2.isLosange());
		assertTrue(carre1.isLosange());
		assertTrue(carre2.isLosange());
		assertTrue(carre3.isLosange());

	}

	@Test
	void testIsRectangle() {
		assertFalse(triangle.isRectangle());
		assertFalse(convexe.isRectangle());
		assertFalse(trapeze1.isRectangle());
		assertFalse(trapeze2.isRectangle());
		assertFalse(losange1.isRectangle());
		assertFalse(losange2.isRectangle());
		assertTrue(rectangle1.isRectangle());
		assertTrue(rectangle2.isRectangle());
		assertTrue(carre1.isRectangle());
		assertTrue(carre2.isRectangle());
		assertTrue(carre3.isRectangle());

	}

	@Test
	void testIsCarre() {
		assertFalse(triangle.isCarre());
		assertFalse(convexe.isCarre());
		assertFalse(trapeze1.isCarre());
		assertFalse(trapeze2.isCarre());
		assertFalse(losange1.isCarre());
		assertFalse(losange2.isCarre());
		assertFalse(rectangle1.isCarre());
		assertFalse(rectangle2.isCarre());
		assertTrue(carre1.isCarre());
		assertTrue(carre2.isCarre());
		assertTrue(carre3.isCarre());
	}

}

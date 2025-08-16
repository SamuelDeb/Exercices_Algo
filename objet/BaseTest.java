package fr.fs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import fr.fs.outils.Base;

class BaseTest {

	@Test
	void testConvertBaseToDecimal() {
		assertEquals(10, Base.convertBaseToDecimal("1010", 2));
		assertEquals(255, Base.convertBaseToDecimal("11111111", 2));
		assertEquals(13, Base.convertBaseToDecimal("D", 16));
		assertEquals(255, Base.convertBaseToDecimal("FF", 16));
		assertEquals(35, Base.convertBaseToDecimal("Z", 36));
	}

	@Test
	void testConvertDecimalToBase() {
		assertEquals("1010", Base.convertDecimalToBase(10, 2));
		assertEquals("11111111", Base.convertDecimalToBase(255, 2));
		assertEquals("D", Base.convertDecimalToBase(13, 16));
		assertEquals("FE", Base.convertDecimalToBase(254, 16));
		assertEquals("FF", Base.convertDecimalToBase(255, 16));
		assertEquals("100011", Base.convertDecimalToBase(35, 2));
	}

	@Test
	void testConvertFromBaseToBase() {
		assertEquals("11111111", Base.convertFromBaseToBase("FF", 16, 2));
		assertEquals("FF", Base.convertFromBaseToBase("11111111", 2, 16));
		assertEquals("1010", Base.convertFromBaseToBase("A", 16, 2));
		assertEquals("A", Base.convertFromBaseToBase("1010", 2, 16));
		assertEquals("1101", Base.convertFromBaseToBase("D", 16, 2));
		assertEquals("D", Base.convertFromBaseToBase("1101", 2, 16));
		assertEquals("ITSOK", Base.convertFromBaseToBase("1E28874", 16, 36));
		assertEquals("20", Base.convertFromBaseToBase("10", 32, 16));
		assertEquals("40", Base.convertFromBaseToBase("20", 32, 16));
		assertEquals("40", Base.convertFromBaseToBase("10", 32, 8));
		assertEquals("100", Base.convertFromBaseToBase("20", 32, 8));
		assertEquals("1000", Base.convertFromBaseToBase("20", 32, 4));
		assertEquals("1000000", Base.convertFromBaseToBase("20", 32, 2));
		
	}
}

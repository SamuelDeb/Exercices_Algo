package fr.fs.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fr.fs.algo.EntierToLitteral;

class EntierToLitteralTest extends EntierToLitteral {
    @Test
    void testPowTen() {
	assertEquals(1, calculerE(0));
	assertEquals(10, calculerE(1));
	assertEquals(1000, calculerE(3));
	assertEquals(1000000, calculerE(6));
    }

    @Test
    void testLongToLitteralNorme90() {
    
	assertEquals("zéro", convertLongToLitteral(0,true));
	assertEquals("cinq", convertLongToLitteral(5,true));
	assertEquals("neuf", convertLongToLitteral(9,true));
	assertEquals("dix", convertLongToLitteral(10,true));
	assertEquals("onze", convertLongToLitteral(11,true));
	assertEquals("seize", convertLongToLitteral(16,true));
	assertEquals("dix-sept", convertLongToLitteral(17,true));
	assertEquals("vingt", convertLongToLitteral(20,true));
	assertEquals("vingt-et-un", convertLongToLitteral(21,true));
	assertEquals("vingt-deux", convertLongToLitteral(22,true));
	assertEquals("trente-et-un", convertLongToLitteral(31,true));
	assertEquals("quarante-et-un", convertLongToLitteral(41,true));
	assertEquals("cinquante-et-un", convertLongToLitteral(51,true));
	assertEquals("soixante-et-un", convertLongToLitteral(61,true));
	assertEquals("soixante-et-onze", convertLongToLitteral(71,true));
	assertEquals("quatre-vingts", convertLongToLitteral(80,true));
	assertEquals("quatre-vingt-un", convertLongToLitteral(81,true));
	assertEquals("quatre-vingt-dix", convertLongToLitteral(90,true));
	assertEquals("quatre-vingt-onze", convertLongToLitteral(91,true));
	assertEquals("quatre-vingt-dix-neuf", convertLongToLitteral(99,true));
	assertEquals("cent-un", convertLongToLitteral(101,true));
	assertEquals("cent-onze", convertLongToLitteral(111,true));
	assertEquals("cent-vingt", convertLongToLitteral(120,true));
	assertEquals("deux-cents", convertLongToLitteral(200,true));
	assertEquals("deux-cent-un", convertLongToLitteral(201,true));
	assertEquals("neuf-cent-quatre-vingt-dix-neuf", convertLongToLitteral(999,true));
	assertEquals("mille", convertLongToLitteral(1000,true));
	assertEquals("mille-un", convertLongToLitteral(1001,true));
	assertEquals("deux-mille", convertLongToLitteral(2000,true));
	assertEquals("deux-mille-un", convertLongToLitteral(2001,true));
	assertEquals("cinq-mille-huit-cent-quatre-vingts", convertLongToLitteral(5880,true));
	assertEquals("quatre-vingt-mille", convertLongToLitteral(80000,true));
	assertEquals("quatre-cent-mille", convertLongToLitteral(400000,true));
	assertEquals("neuf-cent-quatre-vingt-dix-neuf-mille-neuf-cent-quatre-vingt-dix-neuf", convertLongToLitteral(999999,true));
	assertEquals("un-million", convertLongToLitteral(1000000,true));
	assertEquals("un-million-dix-huit", convertLongToLitteral(1000018,true));
	assertEquals("un-million-dix-huit-mille-trois-cent-quatre-vingts", convertLongToLitteral(1018380,true));
	assertEquals("deux-millions-trois-cent-mille", convertLongToLitteral(2300000,true));
	assertEquals("deux-millions-trois-cent-quatre-vingt-mille-trois-cents", convertLongToLitteral(2380300,true));
	assertEquals("quatre-vingts-millions", convertLongToLitteral(80000000,true));
	assertEquals("quatre-cents-millions", convertLongToLitteral(400000000,true));	
	assertEquals(
		"neuf-cent-quatre-vingt-dix-neuf-millions-neuf-cent-quatre-vingt-dix-neuf-mille-neuf-cent-quatre-vingt-dix-neuf",
		convertLongToLitteral(999999999,true));
	assertEquals("un-milliard-deux-cents-millions-cinq-cent-dix-huit-mille-trois-cent-soixante-six",
		convertLongToLitteral(1200518366,true));
	assertEquals(
		"deux-milliards-cent-quarante-sept-millions-quatre-cent-quatre-vingt-trois-mille-six-cent-quarante-sept",
		convertLongToLitteral(2147483647,true));
	assertEquals("deux-cents-milliards", convertLongToLitteral(200000000000L,true));
	assertEquals(
		"neuf-trillions-deux-cent-vingt-trois-billiards-trois-cent-soixante-douze-billions-trente-six-milliards-huit-cent-cinquante-quatre-millions-sept-cent-soixante-quinze-mille-huit-cent-sept",
		convertLongToLitteral(9223372036854775807L,true));
    }

    @Test
    void testLongToLitteral() {
	assertEquals("zéro", convertLongToLitteral(0,false));
	assertEquals("cinq", convertLongToLitteral(5,false));
	assertEquals("neuf", convertLongToLitteral(9,false));
	assertEquals("dix", convertLongToLitteral(10,false));
	assertEquals("onze", convertLongToLitteral(11,false));
	assertEquals("seize", convertLongToLitteral(16,false));
	assertEquals("dix-sept", convertLongToLitteral(17,false));
	assertEquals("vingt", convertLongToLitteral(20,false));
	assertEquals("vingt et un", convertLongToLitteral(21,false));
	assertEquals("vingt-deux", convertLongToLitteral(22,false));
	assertEquals("trente et un", convertLongToLitteral(31,false));
	assertEquals("quarante et un", convertLongToLitteral(41,false));
	assertEquals("cinquante et un", convertLongToLitteral(51,false));
	assertEquals("soixante et un", convertLongToLitteral(61,false));
	assertEquals("soixante et onze", convertLongToLitteral(71,false));
	assertEquals("quatre-vingts", convertLongToLitteral(80,false));
	assertEquals("quatre-vingt-un", convertLongToLitteral(81,false));
	assertEquals("quatre-vingt-dix", convertLongToLitteral(90,false));
	assertEquals("quatre-vingt-onze", convertLongToLitteral(91,false));
	assertEquals("quatre-vingt-dix-neuf", convertLongToLitteral(99,false));
	assertEquals("cent un", convertLongToLitteral(101,false));
	assertEquals("cent onze", convertLongToLitteral(111,false));
	assertEquals("cent vingt", convertLongToLitteral(120,false));
	assertEquals("deux cents", convertLongToLitteral(200,false));
	assertEquals("deux cent un", convertLongToLitteral(201,false));
	assertEquals("neuf cent quatre-vingt-dix-neuf", convertLongToLitteral(999,false));
	assertEquals("mille", convertLongToLitteral(1000,false));
	assertEquals("mille un", convertLongToLitteral(1001,false));
	assertEquals("deux mille", convertLongToLitteral(2000,false));
	assertEquals("deux mille un", convertLongToLitteral(2001,false));
	assertEquals("cinq mille huit cent quatre-vingts", convertLongToLitteral(5880,false));
	assertEquals("quatre-vingt mille", convertLongToLitteral(80000,false));
	assertEquals("quatre cent mille", convertLongToLitteral(400000,false));
	assertEquals("neuf cent quatre-vingt-dix-neuf mille neuf cent quatre-vingt-dix-neuf", convertLongToLitteral(999999,false));
	assertEquals("un million", convertLongToLitteral(1000000,false));
	assertEquals("un million dix-huit", convertLongToLitteral(1000018,false));
	assertEquals("un million dix-huit mille trois cent quatre-vingts", convertLongToLitteral(1018380,false));
	assertEquals("deux millions trois cent mille", convertLongToLitteral(2300000,false));
	assertEquals("deux millions trois cent quatre-vingt mille trois cents", convertLongToLitteral(2380300,false));
	assertEquals("quatre-vingts millions", convertLongToLitteral(80000000,false));
	assertEquals("quatre cents millions", convertLongToLitteral(400000000,false));	
	assertEquals(
		"neuf cent quatre-vingt-dix-neuf millions neuf cent quatre-vingt-dix-neuf mille neuf cent quatre-vingt-dix-neuf",
		convertLongToLitteral(999999999,false));
	assertEquals("un milliard deux cents millions cinq cent dix-huit mille trois cent soixante-six",
		convertLongToLitteral(1200518366,false));
	assertEquals(
		"deux milliards cent quarante-sept millions quatre cent quatre-vingt-trois mille six cent quarante-sept",
		convertLongToLitteral(2147483647,false));
	assertEquals("deux cents milliards", convertLongToLitteral(200000000000L,false));
	assertEquals(
		"neuf trillions deux cent vingt-trois billiards trois cent soixante-douze billions trente-six milliards huit cent cinquante-quatre millions sept cent soixante-quinze mille huit cent sept",
		convertLongToLitteral(9223372036854775807L,false));
    }

    @Test
    void testLibellerCheque() {
	assertEquals("***zéro euro et zéro centime***", libellerCheque("0"));
	assertEquals("***zéro euro et un centime***", libellerCheque("0.01"));
	assertEquals("***zéro euro et dix centimes***", libellerCheque("0.1"));
	assertEquals("***un euro et quatre-vingts centimes***", libellerCheque("1.8"));
	assertEquals("***cinq euros et quatre-vingt-un centimes***", libellerCheque("5.81"));
	assertEquals("***neuf cent quatre-vingt-dix-neuf euros et quatre-vingt-dix-neuf centimes***", libellerCheque("999.99"));
	assertEquals("***un million d'euros et zéro centime***", libellerCheque("1000000"));
    }
}

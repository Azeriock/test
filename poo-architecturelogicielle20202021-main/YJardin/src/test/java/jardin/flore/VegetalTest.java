package jardin.flore;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VegetalTest {

	@Test
	void testGrandirGraineGerme() {
		// Arrange
		Tomate t = new Tomate();

		// Act
		t.grandir();
		Etat res = t.getEtat();

		// Assert
		assertEquals(Etat.GERME, res);

	}

	@Test
	void testGrandirGermeTige() {
		// Arrange
		Tomate t = new Tomate();

		// Act
		t.grandir();
		t.grandir();
		Etat res = t.getEtat();

		// Assert
		assertEquals(Etat.TIGE, res);

	}

}

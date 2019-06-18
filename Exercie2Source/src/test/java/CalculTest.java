import org.junit.Assert;
import org.junit.Test;

/** Tests unitaire pour la classe Calcul **/
public class CalculTest {
	@Test
	public void testConstructeur() {
		new Calcul();
	}

	@Test
	public void testSomme() {
		Assert.assertEquals(5, Calcul.somme(2, 3));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDivision() {
		Assert.assertEquals(4, Calcul.division(8, 2));
		Calcul.division(8, 0);
	}
	
	@Test
	public void testMaFonction() {
		Assert.assertEquals(2, Calcul.maFonction(24, 12));
		Assert.assertEquals(6, Calcul.maFonction(24, 6));
	}
}
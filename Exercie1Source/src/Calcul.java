import java.lang.invoke.ConstantCallSite;

/** Une classe. **/
public class Calcul {
	
	final static int ten = 10;

	/** Calcul la somme de deux nombres **/
	/**
	 * @param a
	 * @param b
	 * @return a+b
	 */
	public static int somme(final int a, final int b) {
		return a + b;
	}

	/**
	 * @param a
	 * @param b
	 * @return a/b si b>=10
	 */
	public static int maFonction(final int a, final int b) {
		if (b >= ten) {
			return a / b;
		}
		return b;
	}

	/**
	 * @return a / b si b != 0
	 * @throw IllegalArgumentException si b == 0
	 */
	/**
	 * @param a
	 * @param b
	 * @return
	 */
	public static int division(final int a, final int b) {
		if (b == 0) {
			throw new IllegalArgumentException("b ne doit pas etre 0");
		}
		return a / b;
	}
}
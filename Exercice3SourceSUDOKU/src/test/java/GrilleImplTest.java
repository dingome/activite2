import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import fr.upicardie.sudoku.app.GrilleImpl;

/** Tests unitaire pour la classe Grille Impl **/
public class GrilleImplTest {
	
	
	private GrilleImpl grilleImpl;

    @Before
    public void setup() {
       grilleImpl = new GrilleImpl(new char[][] {
           {'3', '0', '6', '5', '0', ' ', '4', '0', '0'},
           {'5', '2', '0', '0', '0', '0', '0', '0', '0'},
           {'0', '8', '7', '0', '0', '0', '0', '3', '1'},
           {'0', '0', '3', '0', '1', '0', '0', '8', '0'},
           {'9', '0', '0', '8', '6', '3', '0', '0', '5'},
           {'0', '5', '0', '0', '9', '0', '6', '0', '0'},
           {'1', '3', '0', '0', '0', '0', '2', '5', '0'},
           {'0', '0', '0', '0', '0', '0', '0', '7', '4'},
           {'0', '0', '5', '2', '0', '6', '3', '0', ' '}
       });
    }
	
	@Test
	public void testGetDimension() {
		Assert.assertEquals(9, grilleImpl.getDimension());
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testSetValue() {
	         grilleImpl.setValue(0, 1, '7');
	        grilleImpl.setValue(20, 40, 'x');
	  
	}
	
	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void testGetValue() {
	    
	        Assert.assertEquals('6', grilleImpl.getValue(30, 20));
	        Assert.assertEquals('6', grilleImpl.getValue(0, 2));
	}
	
	@Test
	public void testComplete() {      
	        Assert.assertEquals(false, grilleImpl.complete());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testPossible() {      
		grilleImpl.possible(20, 30, 'x');
		Assert.assertEquals(false, grilleImpl.possible(0, 1, '7'));
	}
	
}
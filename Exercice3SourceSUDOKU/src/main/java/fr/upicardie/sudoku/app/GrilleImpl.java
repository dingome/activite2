package fr.upicardie.sudoku.app;

public class GrilleImpl implements Grille {

	private char sudoku[][];
	
	public GrilleImpl( char sudoku[][] ) {
		this.sudoku = sudoku;
	}

	public int getDimension() {
		return this.sudoku.length;
	}

	 /**
	  * Affecte une valeur dans la grille
	  * 
	  * @param x       position x dans la grille
	  * @param y       position y dans la grille
	  * @param value
	  *            valeur a mettre dans la case
	  * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
	  * @throw IllegalArgumentException si la valeur est interdite aux vues des
	  *        autres valeurs de la grille
	  * @throw IllegalArgumentException si value n'est pas un caractere autorise
	  *        ('1',...,'9')
	  */
	public void setValue(int x, int y, char value) throws IllegalArgumentException {
		
		if ((x<0) && (x>8) || (y<0) && (y>8)) 
			throw new ArrayIndexOutOfBoundsException("x ou y sont hors bornes (0-8)");
		//test colonne
		for (int i = 0; i < getDimension(); i++)
			if (this.sudoku[i][y] == value)
				throw new IllegalArgumentException("la valeur est interdite aux vues des autres valeurs de la grille");
		//test ligne
		for (int j = 0; j < getDimension(); j++)
			if (this.sudoku[x][j] == value)
				throw new IllegalArgumentException("la valeur est interdite aux vues des autres valeurs de la grille");
		
		this.sudoku[x][y]=value;
	
	}

	 /**
	  * Recupere une valeur de la grille
	  * 
	  * @param x      position x dans la grille
	  * @param y      position y dans la grille
	  * @return valeur dans la case x,y
	  * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
	  */
	public char getValue(int x, int y) throws ArrayIndexOutOfBoundsException{
		
		if ((x<0) && (x>getDimension()-1) || (y<0) && (y>getDimension()-1)) 
			throw new ArrayIndexOutOfBoundsException("x ou y sont hors bornes (0-8)");  
		
		return this.sudoku[x][y];
	}

	 /**
	  * Test si une grille est terminee
	  * 
	  * @return true si la grille est complete
	  */
	public boolean complete() {
		
	           for (int x = 0; x < getDimension(); x++) {
	            for (int y = 0; y < getDimension(); y++) {
	             
	             if (this.sudoku[x][y] == ' ' ) {
	               return false; 
	              }
	            }
	           }
		
		return true;
	}

	 /**
	  * Test si une valeur est possible dans la grille par rapport a ce qu'elle
	  * contient deja
	  * 
	  * @param x     position x dans la grille
	  * @param y     position y dans la grille
	  * @param value
	  *            valeur a mettre dans la case
	  * @throw IllegalArgumentException si x ou y sont hors bornes (0-8)
	  * @throw IllegalArgumentException si value n'est pas un caractere autorise
	  *        ('1',...,'9',..)
	  */
	public boolean possible(int x, int y, char value) throws IllegalArgumentException {
			
		if ((x<0) && (x>8) || (y<0) && (y>8)) 
			throw new ArrayIndexOutOfBoundsException("x ou y sont hors bornes (0-8)");
		
		int trouve=0;
		for (int i = 0; i < possible.length; i++) {
			if (possible[i] == value) trouve=1;
		}	
		if (trouve==0) throw new IllegalArgumentException("value n'est pas un caractere autorise");
		
		int r = x - x % 3;
		int c = y - y % 3;
		for (int i = r; i < r + 3; i++)
			for (int j = c; j < c + 3; j++)
				if (this.sudoku[i][j] == value)
					return true;
		
		return false;
	}
	
}

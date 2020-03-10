public class CharGrid {
	private char[][] grid;

	/**
	 * Constructs a new CharGrid with the given grid.
	 * Does not make a copy.
	 * @param grid
	 */
	public CharGrid(char[][] grid) {
		this.grid = grid;
	}
	
	/**
	 * Returns the area for the given char in the grid.
	 * @param ch char
	 * @return area for given char
	 */
	public int charArea(char ch) {
		int n = grid.length ;
		int m = grid[0].length ;
		int x = n + 1 , y = m + 1 , X = -1 , Y = -1 ;
		for(int i = 0 ; i < n ; ++i) {
			for(int j = 0 ; j < m ; ++j) {
				if(grid[i][j] == ch) {
					x = Math.min(x , i) ;
					y = Math.min(y , j) ;
					X = Math.max(X , i) ;
					Y = Math.max(Y , j) ;
				}
			}
		}
		if(X == -1)
			return 0 ;
		return (X - x + 1) * (Y - y + 1) ;
	}
	
	/**
	 * Returns the count of '+' figures in the grid
	 * @return number of + in grid
	 */
	public int countPlus() {
		int n = grid.length ;
		int m = grid[0].length ;
		int ret = 0 ;
		for(int i = 1 ; i < n - 1 ; ++i) {
			for(int j = 1 ; j < m - 1 ; ++j) {
				int[] dx = {1 , -1 , 0 , 0} ;
				int[] dy = {0 , 0 , 1 , -1} ;
				boolean okay = true ;
				for(int dir = 0 ; dir < 4 ; ++dir) {
					if (grid[i][j] != grid[i + dx[dir]][j + dy[dir]]) {
						okay = false;
						break;
					}
				}
				if(okay)
					ret++ ;

			}
		}
		return ret;
	}
	
}

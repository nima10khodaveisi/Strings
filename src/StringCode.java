import java.util.HashSet;
import java.util.Set;

public class StringCode {

	/**
	 * Given a string, returns the length of the largest run.
	 * A a run is a series of adajcent chars that are the same.
	 * @param str
	 * @return The largest length of consecutive equal characters
	 */
	public static int maxCons(String str) {
		int ret = 1 ;
		for(int i = 0 ; i < str.length() ; ) {
			int pos = i ;
			while(pos < str.length() && str.charAt(pos) == str.charAt(i))
				pos++ ;
			if(ret < pos - i)
				ret = pos - i ;
			i = pos ;
		}
		return ret ;
	}

	
	/**
	 * Given a string, for each digit in the original string,
	 * replaces the digit with that many occurrences of the character
	 * following. So the string "a3tx2z" yields "attttxzzz".
	 * @param str
	 * @return blown up string
	 */
	public static String blowup(String str) {
		String ret = "" ;
		boolean done = false ;
		for(int i = 0 ; i < str.length() ; ++i) {
			char c = str.charAt(i) ;
			if('0' <= c && c <= '9') {
				for(int t = 0 ; t < c - '0' ;  ++t) {
					ret += str.charAt(i + 1) ;
				}
				done = true ;
			}
			else {
				if(!done)
					ret += str.charAt(i) ;
				else
					done = false ;
			}
		}
		return ret ;
	}
	
	/**
	 * Given 2 strings, consider all the substrings within them
	 * of length len. Returns true if there are any such substrings
	 * which appear in both strings.
	 */
	public static boolean isIntersect(String a, String b, int len) {
		int [][]dp = new int[a.length() + 1][b.length() + 1] ;
		int n = a.length() , m = b.length() ;
		for(int i = 0 ; i <= n ; ++i) {
			for(int j = 0 ; j <= m ; ++j) {
				dp[i][j] = 0 ;
			}
		}
		for(int i = 0 ; i <= n ; ++i) {
			for(int j = 0 ; j <= m ; ++j) {
				if(i + j == 0) continue ;
				if(i > 0 && j > 0) {
					if(a.charAt(i - 1) == b.charAt(j - 1)) {
						dp[i][j] = Math.max(dp[i][j] , dp[i - 1][j - 1] + 1) ;
					}
				}
				if(i > 0) {
					dp[i][j] = Math.max(dp[i][j] , dp[i - 1][j]) ;
				}
				if(j > 0) {
					dp[i][j] = Math.max(dp[i][j] , dp[i][j - 1]) ;
				}
			}
		}
		return dp[n][m] >= len ;
	}
}

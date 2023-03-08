package misc;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class WellFormedParenthesisCount {
	
	
	
	public static void main(String[] args) {
		
	   /* Given an input N, find out the well formed parenthesis count and return the combination
		*  
		*  If N = 2, then the following output is expected
		*
		*	Output = { "()()", "(())" };
		*
		*/
		
		Set<String> combinations = new HashSet<>();
		
		combination("", combinations, 4);
		
		System.out.println(combinations);
		
	}
	
	public static void combination(final String value, final Set<String> combinations, int n) {
		
		
		
		if (value.length() == n * 2 && isWellFormed(value)) {
			
			combinations.add(value);
			
			return;
			
		}
		
		
		if (value.length() == n * 2 ) {
			return;
		}
		
		
		combination(value.concat("("), combinations, n);
		combination(value.concat(")"), combinations, n);
		
		
	}
	
	private static boolean isWellFormed(final String item) {
		
		Stack<Character> st = new Stack<>();
		
		for (int i = 0; i < item.length(); i++) {
			
			if (item.charAt(i) == '(') {
				
				st.add(item.charAt(i));
				
			} else { // item.charAt(i) == ')'
				if (st.size() == 0) {
					return false;
				}
				char popped = st.pop();
				if (popped != '(' || item.charAt(i) != ')') {
					
					return false;
					
				}
				
			}
			
		}
		
		if (st.size() == 0)
			return true;
		else
			return false;
		
	}

}

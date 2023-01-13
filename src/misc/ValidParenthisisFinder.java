package misc;

import java.util.Stack;

public class ValidParenthisisFinder {
	
	private int findValidParenthesis(final String input) {
		int nums = 0;
		Stack<Character> stack = new Stack<>();
		
		for (int i = 0; i < input.length(); i++) {
			Character e = input.charAt(i);
			if(e.equals('{')) {
				stack.add(e);
			}
			if(e.equals('}') && stack.size() > 0) {
				Character tmp = stack.pop();
				if(tmp.equals('{')) {
					nums++;
				}
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		
		String codeWithWrongParenthesis = " function() } for(;;) { print('hello');  } {";
		
		System.out.println(new ValidParenthisisFinder().findValidParenthesis(codeWithWrongParenthesis));
		
		String codeWithCorrectParenthesis = " function() { for(;;) { print('hello');  } }";
		
		System.out.println(new ValidParenthisisFinder().findValidParenthesis(codeWithCorrectParenthesis));
		
		
	}

}

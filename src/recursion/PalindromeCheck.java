package recursion;

public class PalindromeCheck {
	
	public static Boolean isPalindrome(String input) {
		
		if(input == null)
			return Boolean.FALSE;
		
		if(input != null && (input.length() == 0 || input.length() == 1))
			return Boolean.TRUE;
		
		// If first char equals last char AND recurse with substring starting from 2nd char to second last char
	    return input.charAt(0) == input.charAt(input.length() - 1) && isPalindrome(input.substring(1, input.length() - 1));
		
	}

	
	
	public static void main(String[] args) {
		
		System.out.println("abcde -> " + isPalindrome("abcde"));
		System.out.println("abcdedcba -> " + isPalindrome("abcdedcba"));
		System.out.println("abcdedcbd -> " + isPalindrome("abcdedcbd"));
		System.out.println("a -> " + isPalindrome("a"));
		System.out.println("null -> " + isPalindrome(null));
		System.out.println("Empty String -> " + isPalindrome(""));
		
	}

}

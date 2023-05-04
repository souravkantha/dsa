package misc;

import java.util.Scanner;

public class PermutationsWithoutExtraSpace {
	
	public static void permutations(char [] arr, int fixedIndex) {
		
		
		if (fixedIndex == arr.length - 1) {
			
			print(arr);
			return ;
		}
		
		for (int i = fixedIndex; i < arr.length; i ++) {
			
			swap (arr, i, fixedIndex);
			
			permutations(arr, fixedIndex + 1);
			
			swap (arr, i, fixedIndex);
			
		}
		
		
	}
	
	private static void swap (char [] arr, int fromIndex, int toIndex) {
		
		char tmp = arr[fromIndex];
		arr[fromIndex] = arr[toIndex];
		arr[toIndex] = tmp;
		
		
	}
	
	private static void print (char [] arr) {
		
		for (char c : arr) {
			
			System.out.print(c);
			
		}
		
		System.out.println();
		
	}
	
	public static void main(String[] args) {
		
		System.out.print("Enter a String: ");
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		
		permutations(input.toCharArray(), 0);
		
		s.close();
		
	}

}

package search;

public class ModifiedBinarySearchIterative {
	
	// Given an element search if it exist in the input array, 
	// if does not exist, return which index it should be inserted
	
	public static int findIndex2BUsed(int [] input, int searchElement, int l, int h) {
		
		int index = Integer.MIN_VALUE;
		
		if(input.length > 0) {
			
			while(l <= h) {
				
				int mid = l + (h - l) / 2;
				
				
				if(input[mid] == searchElement) {
					
					index = mid;
					return index;
					
				} else if (input[mid] > searchElement) {
					
					
					if(mid != l && input[mid-1] < searchElement) {
						
						index = mid;
						return index;
						
					}
					if(mid == l) {
						
						index = -1;
						return index;
						
					}
					
					h = mid - 1;
					
				} else if (input[mid] < searchElement) {
					
					if(mid != h && input[mid+1] > searchElement) {
						
						index = mid + 1;
						return index;
						
					}
					if(mid == h) {
						
						index = input.length;
						return index;
						
					}
					
					l = mid + 1; 
					
				}
				
			}
			
		}
		
		
		return index;
		
	}
	
	public static void main(String[] args) {
		
		int [] input = {3, 5, 12, 23, 35, 41, 66, 100};
		
		//int [] input = {3, 5, 7};
		
		System.out.println(findIndex2BUsed(input, 140, 0, input.length - 1));
		
	}
}



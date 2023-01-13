package search;

public class BinarySearchVanillaIterative {
	
	public static int doBinarySearch(int [] input, int searchKey, int l, int h) {
		
		if(input.length != 0) {
			
			while(l <= h) {
			
			int mid = l + (h - l) / 2;
			
				if(input[mid] == searchKey) {
					return mid;
					
				} else if (input[mid] > searchKey) {
					
					h = mid - 1;
					
				} else if (input[mid] < searchKey) {
					
					l = mid + 1;
					
				}
			
			}
			
		}
		
		return -1;
		
	}
	
	public static void main(String[] args) {
		
		int [] arr = {3, 5, 10, 33, 50, 61};
		int low = 0;
		int high = arr.length - 1;
		
		int response = doBinarySearch(arr, 61, low, high);
		
		if(response == -1) {
			System.out.println("Not found");
		} else {
			System.out.println("Found at :" + response);
		}
		
	}

}

package sorting;

public class InsertionSort {
	
	/**
	 * Sort array in an increasing order
	 * {4, 2, 5, 1, 6, 0, 5, 3};
	 * @param arr
	 * @return
	 */
	public static int [] sort(int [] arr) {
		
		for(int i = 0; i < arr.length - 1; i++) {
			
			for(int j = i + 1; j > 0; j--) {
				
				if(arr[j] < arr[j - 1]) {
					
					 swap(arr, j, j - 1);
					//printArray(arr);
				}
				
			}
		}
		
		return arr;
	}
	
	private static void swap(int [] arr, int i, int j) {
		// TODO Auto-generated method stub
		
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
		
	}
	
	private static void printArray(int [] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print (arr[i] + " ");
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		
		int [] arr = {4, 2, 5, 1, 6, 0, 5, 3};
		
		int [] res = sort(arr);
		
		printArray(res);
	}

}

package sorting;

public class MergeTwoSortedArrays {
	
	
	/**
	 * 
	 * This is merge operation for any two types of already sorted Integer Arrays in O(length(arr1) + length(arr2))
	 * 
	 * Used in merge sort as a helper
	 * 
	 * @param arr1
	 * @param arr2
	 * @return
	 */
	public  int [] merge(int [] resultArr, int resultArrStartIndex, int [] arr1, int [] arr2) {
		
		if(resultArr == null)
			resultArr = new int[arr1.length + arr2.length];
		
		Integer arr1Pointer = 0;
		Integer arr2Pointer = 0; // both starts from index 0
		
		Integer mergedArrayPointer = resultArrStartIndex;
		
		while(arr1Pointer < arr1.length && arr2Pointer < arr2.length) {
			
			if(arr1[arr1Pointer] < arr2[arr2Pointer]) { // value in arr 1 at position arr1Pointer is lesser than
														// arr2 at position arr2Pointer 
				resultArr [mergedArrayPointer] =      // then copy arr1 val 
						arr1[arr1Pointer];
				
				mergedArrayPointer ++; arr1Pointer ++;  // increment to move on
				
			} else {									// else
				
				resultArr [mergedArrayPointer] =      // copy arr2 val (increasing order)
						arr2[arr2Pointer];
				
				mergedArrayPointer ++; arr2Pointer ++;  // increment to move on
				
			}
			
		}
		
		// In our sample data, both array length are not same, 
		// so check if there are any elements left in any of array
		
		// For array 1, copy remaining elements into result array
		while (arr1Pointer < arr1.length) {
			
			resultArr[mergedArrayPointer] = arr1[arr1Pointer];
			
			mergedArrayPointer ++; arr1Pointer ++;
		}
		
		// For array 2, copy remaining elements into result array
		while (arr2Pointer < arr2.length) {
			
			resultArr[mergedArrayPointer] = arr2[arr2Pointer];
			
			mergedArrayPointer ++; arr2Pointer ++;  
		}
		
		
		
		return resultArr;
		
	}
	
	
	/**
	 * Used for printing 
	 * 
	 * @param arr
	 */
	public void printArray(int [] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print (arr[i] + " ");
		}
		
		System.out.println();
	}
	
	
	
	/**
	 * Used for testing
	 * 
	 * @param arr
	 */
	private Boolean assertEquals(int [] actual, int [] expected) {
		
		if(actual.length != expected.length) 
			return Boolean.FALSE;
		
		for (int i = 0; i < actual.length; i++) {
			
			if(actual[i] != expected[i]) 
				return Boolean.FALSE;
			
		}
		
		return Boolean.TRUE;
	}
	
	
	
	/**
	 * Driver method 
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		int [] arr1 = {1, 2, 5, 6, 10};
		
		int [] arr2 = {0, 4, 7, 9, 14, 50, 60, 70, 80};
		
		MergeTwoSortedArrays intMerger = new MergeTwoSortedArrays();
		
		int []
				mergedArray = new int[arr1.length + arr2.length];
		
		int [] mergedIntArr = intMerger.merge(mergedArray, 0, arr1, arr2);
		
		intMerger.printArray(mergedIntArr);
		
		System.out.println(intMerger.assertEquals(mergedIntArr,new int []{0, 1, 2, 4, 5 ,6, 7 ,9, 10, 14, 50, 60, 70, 80 }));
		
		
	}
	

}

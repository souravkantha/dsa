package sorting;

public class MergeSortVanilla {
	
	
	MergeTwoSortedArrays merger = new MergeTwoSortedArrays();
	
	public int[] sort(int[] arr) {
		// TODO Auto-generated method stub
		mergeSortHelper(arr, 0, arr.length - 1);
		
		merger.printArray(arr);
		
		return arr;
	}
	
	 private void mergeSortHelper(int [] arr, int beg, int end) {
		
		if(beg < end) {
			
			int mid = beg + (end - beg) / 2;
			mergeSortHelper(arr, beg, mid);
			mergeSortHelper(arr, mid + 1, end);
			mergeArray(arr, beg , mid, end);
			
		}
		
	} 
	

	private void mergeArray(int[] arr, int beg, int mid, int end) {
		// Create two temporary arrays of size (mid - beg + 1) and (end - mid). Think why?
		
		int [] lArr = new int [(mid - beg + 1)]; // array to hold elements from beg to mid
		
		int [] rArr = new int [(end - mid)]; // same as above for mid + 1 to end
		
		// Fill left array from main array
		
		for (int i = 0, j = beg; i < lArr.length && j < arr.length; i++, j++) {
			lArr[i] = arr[j];
		}
		
		// Fill right array from main array
		
		for (int i = 0, j = mid + 1; i < rArr.length && j < arr.length; i++, j++) {
			rArr[i] = arr[j];
		}
		
		
		int indexForOrigArr = beg;
		
		merger.merge(arr, indexForOrigArr, lArr, rArr); // Remember MergeTwoArrays.java??
			
		
	}

	public static void main(String[] args) {
		
		int [] arr = {4, 2, 5, 0, -1, 100, 323, 7, 10};
		
		MergeSortVanilla sorter = new MergeSortVanilla();
		
		int [] res = sorter.sort(arr);
		
	}

	


}

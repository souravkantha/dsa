package sorting;

public class MergeSortVanilla {
	
	public static int[] sort(int[] arr) {
		// TODO Auto-generated method stub
		mergeSortHelper(arr, 0, arr.length - 1);
		
		return arr;
	}
	
	/* private static void mergeSortHelper(int [] arr, int l, int h) {
		
		if(l < h) {
			
			int mid = l + (h - l) / 2;
			mergeSortHelper(arr, l, mid);
			mergeSortHelper(arr, mid + 1, h);
			merge(arr, l , mid, h);
			
		}
		
	} */
	
	
	
	
	
	/*private static int[] merge(int[] arr, int start, int mid, int end) {
	
		int [] newarr = new int[(mid - start) + 1 + (end - mid)];
		
		int p = 0;
		
		int [] lArr = new int[(mid - start) + 1];
		int [] rArr = new int[(end - mid)];
		
		for(int m = 0; m < (mid - start) + 1 ; m++) {
			
			lArr[m] = arr[start + m];
			
		}
		
		for(int n = 0; n < (end - mid) ; n++) {
			
			rArr[n] = arr[mid + 1 + n];
			
		}
		
		int m, n = 0;
		
		while(m < (mid - start) + 1  && n < end - mid) {
			
			if(lArr[m] < rArr[n]) {
				
				newarr[p++] = larr[l++];
				
			} else {
				
				newarr[p++] = rarr[j++];
				
			}
			
		}
		
		
		while (l < j ) {
			
			newarr[p++] = larr[l];
			
		}
		
		while (j < h ) {
			
			newarr[p++] = rarr[j];
			
		}
		
		
		return newarr;
		
		
	} */

	private static void printArray(int [] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print (arr[i] + " ");
		}
		
		System.out.println();
	}

	public static void main(String[] args) {
		
		int [] arr = {4, 2, 5, 1, 6};
		
		int [] res = sort(arr);
		
		printArray(res);
	}

	


}

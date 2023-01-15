package sorting;

import heaps.BinaryHeap;

public class HeapSort {
	
	public void sortDesc(Integer [] input) {
		
		BinaryHeap heap = new BinaryHeap(input); // Remember Binary Heap?
		
		if(heap != null) {
			
			while(heap.getHeapSize() > 0) {
				
				System.out.print(heap.extractMax() + " ");
				
			}
			
		}
		
	}
	
	
	public static void main(String[] args) {
		
		Integer [] input = {1,2,3,4,5,6};
		
		HeapSort heap = new HeapSort();
		heap.sortDesc(input);
		
	}

}

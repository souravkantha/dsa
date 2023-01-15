package heaps;

public class BinaryHeap {
	
	Integer [] heap = null;
	Integer heapSize = 0;
	
	public BinaryHeap(Integer [] arr) { 
		
		if( arr != null) {
			this.heap = arr;
			heapSize = this.heap.length;
			buildMaxHeap();
		}
		
	}
	
	public Integer extractMax() {
		
		Integer max = null;
		
		if(heap != null && heapSize > 1) {
			 max = heap[0];
			 heap[0] = this.heap[heapSize - 1];
			 this.heap[heapSize - 1] = Integer.MIN_VALUE;
			 heapSize--;
			 maxHeapify(0);
		} else if(heap != null && heapSize == 1) {
			 max = heap[0];
			 this.heap[heapSize - 1] = Integer.MIN_VALUE;
			 heapSize--;
		}
		
		
		
		return max;
	}
	
	public Integer getHeapSize() {
		
		return this.heapSize;
	}
		
	
	public Integer getMax() {
		
		if(heap != null)
			return heap[0];
		else
			return null;
		
	}
	
	private void buildMaxHeap() {
		
		for(int i = (this.heap.length/2) - 1; i >= 0; i--)
			maxHeapify(i);
	}
	
	
	private void maxHeapify(Integer i) {
		
		int largest = i; // assume that given index is the largest
		
		if((i*2+1) >= 0 && (i*2+1) < this.heap.length && this.heap[i] <  this.heap[i*2+1]) { // compare i with left child
			
			largest = i*2+1; // then left child index is largest
		}
		
		if((i*2+2) >= 0 && (i*2+2) < this.heap.length && this.heap[largest] < this.heap[i*2+2]) { // compare largest with right child
			
			largest = i*2+2; // then right child index is largest
			
		}
		
		if(largest != i) { // if largest is not same as i, either left or right child is largest
			
			swap(largest, i); // swap the values
			maxHeapify(largest); // recurse max-heapify with new i as largest
		}
		
		
	}

	private void swap(Integer from, Integer to) {

		Integer temp = this.heap[from];
		
		this.heap[from] = this.heap[to];
		
		this.heap[to] = temp;
		
	}
	
	

}

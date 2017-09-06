package data_structure.tree;

import javax.management.RuntimeErrorException;

public class MaxHeap {
	
	//堆是完全二叉树，用数组来实现
	private int[] heap;
	//堆的最大容量
	private int size;
	//现在堆中拥有的元素个数
	private int n;
	
	public MaxHeap(int[] heap,int max) {
		size = max;
		n = heap.length;
		this.heap = new int[max];
		for(int i=0;i<n;i++) {
			this.heap[i] = heap[i];
		}
		buildHeap();
	}
	
	public int heapsize() {
		return n;
	}
	
	public boolean isLeaf(int pos) {
		return (pos>=n/2) && (pos<n);
	}
	
	public int leftChild(int pos) {
		return 2*pos+1;
	}
	
	public int rightChild(int pos) {
		return 2*pos+2;
	}
	
	public int parent(int pos) {
		return (pos-1)/2;
	}
	
	public boolean insert(int num) {
		if(n>=size)
			return false;
		
		int curr = n++;
		
		heap[curr] = num;
		
		//将新插入的元素与它的父节点的值比较，如果比父结点的值要大，则交换两个位置上的值
		//并更新curr为父结点的位置，再进行上述的比较，直到不需要交换为止
		while(curr!=0 && heap[curr]>heap[parent(curr)]) {
			swap(heap, curr, parent(curr));
			curr = parent(curr);
		}
		
		return true;
	}
	
	public int removeMax() {
		if(n==0)
			throw new RuntimeException("堆中没有元素");
		
		swap(heap, 0, --n);
		if(n!=0)
			shiftdown(0);
		
		return heap[n];
	}
	
	private void buildHeap() {
		for(int i=n/2-1;i>=0;i--) {
			shiftdown(i);
		}
	}
	
	private void shiftdown(int pos) {
		while(!isLeaf(pos)) {
			int j = leftChild(pos);
			int rc = rightChild(pos);
			
			//选出两个左右儿子中最大的一个
			if(rc<n && heap[j]<heap[rc])
				j = rc;
			
			//将左右儿子最大的一个与位置pos上的值比较，如果pos上的值较小，则交换两个位置上的值
			//并且将pos更新为j(原来左右儿子最大值的位置)，重复上面的步骤
			if(heap[j]>heap[pos]) {
				swap(heap, j, pos);
				pos = j;
			}
			else {
				break;
			}
		}
	}
	
	private void swap(int[] array,int x,int y) {
		int temp = array[x];
		array[x] = array[y];
		array[y] = temp;
	}
	
	public void print() {
		for(int i=0;i<n;i++) {
			System.out.print(heap[i]+" ");
		}
		System.out.println();
	}
	
	public static void main(String args[]) {
		MaxHeap maxHeap = new MaxHeap(new int[]{1,2,3,4,5}, 10);
		maxHeap.print();
		maxHeap.insert(10);
		maxHeap.print();
		maxHeap.insert(8);
		maxHeap.print();
		maxHeap.removeMax();
		maxHeap.print();
	}
	
	
}

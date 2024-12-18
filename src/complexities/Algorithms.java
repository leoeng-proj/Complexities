package complexities;

import java.util.Arrays;
import java.util.LinkedList;

public class Algorithms {

	public static void bubbleSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length - i - 1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	public static void insertionSort(int[] arr) {
		for(int i = 1; i < arr.length; i++) {
			int key = arr[i];
			int j = i - 1;
			while(j >= 0 && arr[j] > key) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = key;
		}
	}
	public static void selectionSort(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int min = i;
			for(int j = min+1; j < arr.length; j++) {
				if(arr[j] < arr[min]) {
					min = j;
				}
			}
			int temp = arr[i];
			arr[i] = arr[min];
			arr[min] = temp;
			
		}
	}
	public static void radixSort(int[] arr) {
		//works except for arrays like: [40, 30, 10, 70, 60, 50, 90]
		LinkedList<Integer>[] lists = new LinkedList[10];
		int k = largestLength(arr);
		int pow = 1;
		while(k >= 0) {
			for(int num : arr) {
				int idx = (int)((num % Math.pow(10, pow)) / Math.pow(10, pow - 1));
				if(lists[idx] == null) {
					lists[idx] = new LinkedList<Integer>();
				}
				lists[idx].add(num);
			}
			pow++;
			int i = 0;
			for(LinkedList<Integer> list : lists) {
				if(list != null && !list.isEmpty()) {
					for(Integer num : list) {
						arr[i++] = num;
					}
					list.clear();
				}
			}
			k--;
		}
	}
	private static int largestLength(int[] arr) {
		int max = arr[0];
		for(int a : arr) {
			if(a > max) {
				max = a;
			}
		}
		return (int) (Math.floor(Math.log10(max)) + 1);
	}
	public static void mergeSort(int[] arr) {
		recMergeSort(arr, new int[arr.length], 0, arr.length - 1);
	}
	private static void recMergeSort(int[] arr, int[] workspace, int left, int right) {
		if(left < right) {
			int mid = (left+right)/2;
			recMergeSort(arr, workspace, left, mid);
			recMergeSort(arr, workspace, mid+1, right);
			merge(arr, workspace, left, mid + 1, right);
		}
	}
	private static void merge(int[] arr, int[] workspace, int leftLowerBound, int rightLowerBound, int rightUpperBound) {
		int i = leftLowerBound;
		int j = rightLowerBound;
		int k = 0;
		while(i < rightLowerBound && j <= rightUpperBound) {
			if(arr[i] < arr[j]) {
				workspace[k++] = arr[i++];
			}
			else {
				workspace[k++] = arr[j++];
			}
		}
		while(i < rightLowerBound) {
			workspace[k++] = arr[i++];
		}
		while(j <= rightUpperBound) {
			workspace[k++] = arr[j++];
		}
		for(int l = 0; l < k; l++) {
			arr[leftLowerBound + l] = workspace[l];
		}
	}
	public static void quickSort(int[] arr) {
		quickSortRec(arr, 0, arr.length - 1);
	}
	private static void quickSortRec(int[] arr, int l, int r) {
		if(l < r) {
			int p = partition(arr, arr[r], l, r);
			quickSortRec(arr, l, p-1);
			quickSortRec(arr, p+1, r);
		}
	}
	private static int partition(int[] arr, int pivot, int l, int r) {
		while(l < r) {
			while(arr[l] < pivot) {
				l++;
			}
			while(arr[r] > pivot) {
				r--;
			}
			if(l < r) {
				swap(arr, l, r);
				if(arr[l] == arr[r]) {
					l++;
					r--;	
				}
			}
		}
//		System.out.println(Arrays.toString(arr));
		swap(arr, l, r);
		return l;
	}
	public static int partitionIt(int[] arr, int pivot, int l, int r) {
		int leftPtr = l - 1;
		int rightPtr = r + 1;
		while(true) {
			while(leftPtr < r && arr[++leftPtr] < pivot) {
				;
			}
			while(rightPtr > l && arr[--rightPtr] >= pivot) {
				;
			}
			if(leftPtr >= rightPtr) {
				break;
			}
			else {
				swap(arr, leftPtr, rightPtr);
			}
		}
		swap(arr, leftPtr, r);
		return leftPtr;
	}
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	public static void shellSort(int[] arr) {
		int h = 1;
		while(h < arr.length/3) {
			h = h*3 + 1;
		}
		while(h > 0) {
			for(int i = h; i < arr.length; i++) {
				int key = arr[i];
				int j = i;
				while(j > h - 1 && arr[j - h] > key) {
					arr[j] = arr[j - h];
					j-= h;
				}
				arr[j] = key;
			}
			h = (h - 1)/3;
		}
	}
}

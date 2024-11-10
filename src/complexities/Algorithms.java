package complexities;

import java.util.Arrays;

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
	public static void mergeSort(int[] arr) {
		recMergeSort(arr, new int[arr.length], 0, arr.length);
	}
	private static void recMergeSort(int[] arr, int[] workspace, int left, int right) {
		if(left == right) {
			return;
		}
		int mid = (left+right)/2;
		recMergeSort(arr, workspace, left, mid);
		recMergeSort(arr, workspace, mid+1, right);
		
		merge(arr, workspace, left, mid + 1, right);
	}
	private static void merge(int[] arr, int[] workspace, int leftLowerBound, int rightLowerBound, int rightUpperBound) {
		int i = leftLowerBound;
		int j = rightLowerBound;
		int k = 0;

		int nElems = rightUpperBound - leftLowerBound + 1;
		System.out.println(nElems +  " " + leftLowerBound + " " + rightLowerBound);
		while(i <= rightLowerBound - 1 && j < rightUpperBound) {
			if(arr[i] < arr[j]) {
				workspace[k++] = arr[i++];
			}
			else {
				workspace[k++] = arr[j++];
			}
		}
		while(i <= rightLowerBound - 1) {
			workspace[k++] = arr[i++];
		}
		while(j <= rightUpperBound) {
			workspace[k++] = arr[j++];
		}
		for(int l = 0; l < nElems; l++) {
			arr[leftLowerBound + l] = workspace[l];
		}
//		printArray(arr);
	}
	private static void printArray(int arr[]) {
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
}

	

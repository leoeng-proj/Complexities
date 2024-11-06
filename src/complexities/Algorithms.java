package complexities;

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
		
	}
	private static void merge(int[] c, int low, int high, int upper) {
		while(i < a.length && j < b.length) {
			if(a[i] < b[j]) {
				c[k++] = a[i++];
			}
			else {
				c[k++] = b[j++];
			}
		}
		while(i < a.length) {
			c[k++] = a[i++];
		}
		while(j < b.length) {
			c[k++] = b[j++];
		}
	}
}

	

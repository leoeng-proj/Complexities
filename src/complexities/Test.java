package complexities;

import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int[] array = new int[8];
		populateArray(array);
		printArray(array);
		Algorithms.radixSort(array);
		printArray(array);
	}
	public static void printArray(int arr[]) {
		for(int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	public static void populateArray(int arr[]) {
		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int)(Math.random()*100);
//			arr[i] = (int)(Math.random()*9) * 10;
		}
	}
}

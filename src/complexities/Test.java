package complexities;

import java.util.LinkedList;

public class Test {
	public static void main(String[] args) {
		int[] array = new int[8];
		populateArray(array);
		printArray(array);
		shellSort(array);
		printArray(array);
//		LinkedList<Integer> list = new LinkedList<>();
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
	public static void shellSort(int[] arr) {
		int h = 1;
		while(h < arr.length/3) {
			h = h*3+1;
		}
		while(h > 0) {
			for(int i = h; i < arr.length; i++) {
				int key = arr[i];
				int j = i;
				while(j > h-1 && arr[j-h] > key) {
					arr[j] = arr[j-h];
					j -= h;
				}
				arr[j] = key;
			}
			h = (h-1)/3;
		}
	}
}
	

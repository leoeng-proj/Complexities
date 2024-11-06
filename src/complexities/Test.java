package complexities;

public class Test {
	public static void main(String[] args) {
		int[] array = new int[10];
		populateArray(array);
		printArray(array);
		Algorithms.insertionSort(array);
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
		}
	}
}

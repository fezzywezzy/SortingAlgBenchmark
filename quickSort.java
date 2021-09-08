package ie.gmit.hdip;

//Source: http://me.dt.in.th/page/Quicksort/
public class quickSort implements theSort{

	public void sort(int arr[]) {
		quickS(arr, 0, arr.length - 1);
		
	}

	public static void quickS(int[] arr, int start, int end) {

		int partitionSplit = partition(arr, start, end);

		if (partitionSplit - 1 > start) {// call quicks recursively to sort sub array before pivot
			quickS(arr, start, partitionSplit - 1);
		}
		if (partitionSplit + 1 < end) {// call quicks recursively to sort sub array after pivot
			quickS(arr, partitionSplit + 1, end);
		}
	}

	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		// finding elements less than pivot and putting them at start
		for (int i = start; i < end; i++) {
			if (arr[i] < pivot) {
				int temp = arr[start];
				arr[start] = arr[i];
				arr[i] = temp;
				start++;
			}
		}
		// swapping start and pivot
		int temp = arr[start];
		arr[start] = pivot;
		arr[end] = temp;
		return start;

	}
}
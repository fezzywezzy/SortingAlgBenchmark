package ie.gmit.hdip;

public class SortingAlgorithms {
	// ***********************Bubble****************
	// ************************************************
	// ****************************************
	public void bubble(int[] arr) {
		int n = arr.length;
		for (int outer = n - 1; outer > 0; outer--) { // bubble up
			for (int inner = 0; inner < outer; inner++) { // going down
				if (arr[inner] > arr[inner + 1]) { // if one smaller than other
					// swap elements
					int temp = arr[inner];
					arr[inner] = arr[inner + 1];
					arr[inner + 1] = temp;
				}
			}
		}
	}

	// ***********************INSERTION SORT****************
	// ************************************************
	// ****************************************
	public void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int key = a[i]; // value to be inserted
			int j = i - 1; // move elements to right one position
			while (j >= 0 && a[j] > key) {// while loop to check if previous element greater than key
				a[j + 1] = a[j]; // moving to the right..
				j = j - 1;
			}
			a[j + 1] = key; // key inserted in new position
		}
	}

	// ***********************MERGE SORT****************
	// ************************************************
	// ****************************************
	public void split(int arr[]) {
		// Base case for recursion
		if (arr.length < 2) {
			return;
		}
		int mid = 0;
		// *Splitting array into two parts
		// deciding if odd or even length
		if (arr.length % 2 == 0) {
			mid = arr.length / 2;
		} else {
			mid = (arr.length - 1) / 2;
		}
		// Creating 2 arrays from the split
		int[] l = new int[mid];
		int[] r = new int[arr.length - mid];

		// *Filling in values for both arrays
		for (int i = 0; i < mid; i++) {
			l[i] = arr[i];
		}
		for (int i = mid; i < arr.length; i++) {
			r[i - mid] = arr[i];
		}
		// *Recursion call to continue the split
		split(l);
		split(r);
		// Calling the merging method
		merging(arr, l, r, mid, arr.length - mid);

	}

//*Merging method
	public static void merging(int[] arr, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;
		// sorting and merging recursively
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				arr[k++] = l[i++]; // copying sorted elements into arr

			} else {
				arr[k++] = r[j++]; // copying sorted elements into arr
			}
		}
		// copying remaining elements into arr
		while (i < left) {
			arr[k++] = l[i++];
		}
		while (j < right) {
			arr[k++] = r[j++];
		}
	}

	// Method to return result
	public int[] mergeSort(int arr[]) {
		split(arr);
		return arr;
	}
	// ***********************COUNT SORT****************
	// ************************************************
	// ****************************************

	public int[] countSort(int arr[], int k) {
		int n = arr.length;

		// The output character array that will have sorted array
		int output[] = new int[n];

		// Create a count array to store count of individual
		// characters and initialize count array as 0
		int count[] = new int[k + 1];
		for (int i = 0; i < k + 1; ++i)
			count[i] = 0;

		// store count of each character
		for (int i = 0; i < n; ++i)
			++count[arr[i]];

		// Change count[i] so that count[i] now contains actual
		// position of this character in output array
		for (int i = 1; i <= k; ++i)
			count[i] += count[i - 1];

		// Build the output character array
		// To make it stable we are operating in reverse order.
		for (int i = n - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			--count[arr[i]];

		}
	      for (int i = 0; i < n; ++i) {
	            arr[i] = output[i];
	    }

		return (arr);
	}
	// ***********************TIIIMMMMYYYSORT****************
	// ************************************************
	// ****************************************

	public void timSort(int[] arr) {
		int n = arr.length;
		int RUN = 32;
		// Sort individual subarrays of size RUN with Insertion Sort
		for (int i = 0; i < n; i += RUN) {
			insertionSort(arr);
		}

		// start merging from size RUN. It will merge
		// to form size 64, then 128, 256 etc
		for (int size = RUN; size < n; size = 2 * size) {

			// pick starting point of left sub array. We
			// are going to merge arr[left..left+size-1]
			// and arr[left+size, left+2*size-1]
			// After every merge, we increase left by 2*size
			// for (int left = 0; left < n; left += 2 * size)
			// {

			// find ending point of left sub array
			// mid+1 is starting point of right sub array
			// int mid = left + size - 1;
			// int right = Math.min((left + 2 * size - 1), (n - 1));

			// merge sub array arr[left.....mid] &
			// arr[mid+1....right]
			mergeSort(arr);
			// }
		}
	}

}

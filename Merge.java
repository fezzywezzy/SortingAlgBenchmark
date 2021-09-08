package ie.gmit.hdip;
//Source: https://www.geeksforgeeks.org/merge-sort/ (modified)
public class Merge implements theSort{
	// Method to return result
	public void sort(int arr[]) {
		split(arr);
		//return arr;
	}
	// *Split method
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
		sort(l);
		sort(r);
		// Calling the merging method
		merging(arr, l, r, mid, arr.length - mid);

	}

//*Merging method
	private void merging(int[] arr, int[] l, int[] r, int left, int right) {

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



}

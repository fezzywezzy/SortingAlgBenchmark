package ie.gmit.hdip;
//Source: https://www.geeksforgeeks.org/counting-sort/ (modified)
public class Count implements theSort {
	public void sort(int arr[]) {
		//Note here, we are aware the count sort range 
		//is between 0 and 100
		countingsort(arr, 100);
	}

	public int[] countingsort(int arr[], int k) {
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
		// printArray(count);
		// Change count[i] so that count[i] now contains actual
		// position of this character in output array
		for (int i = 1; i <= k; ++i)
			count[i] += count[i - 1];
		// printArray(count);
		// Build the output character array
		// To make it stable we are operating in reverse order.
		for (int i = n - 1; i >= 0; i--) {
			output[count[arr[i]] - 1] = arr[i];
			--count[arr[i]];
			// printArray(count);
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] = output[i];
		}
		return (arr);
	}

}
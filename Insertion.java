package ie.gmit.hdip;
//Source: D.Carr lecture notes
public class Insertion implements theSort {
	public void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int key = arr[i]; // value to be inserted
			int j = i - 1; // move elements to right one position
			//while loop to check if previous element greater than key
			while (j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j]; //moving to the right..
				j = j - 1; 
			}
			arr[j + 1] = key; // key inserted in new position
		}
	}

}

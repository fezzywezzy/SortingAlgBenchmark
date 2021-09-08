package ie.gmit.hdip;
//Source: D.Carr lecture notes
public class Bubble implements theSort{
	public void sort(int[] arr) {
		int n = arr.length;
		for (int outer = n - 1; outer > 0; outer--) { // counting down
			for (int inner = 0; inner < outer; inner++) { // "bubble up"
				if (arr[inner] > arr[inner + 1]) { // if one smaller than other
					// swap elements
					int temp = arr[inner];
					arr[inner] = arr[inner + 1];
					arr[inner + 1] = temp;
				}
			}
		}
	}

}

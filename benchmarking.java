package ie.gmit.hdip;


public class benchmarking {
	//This method measures the time to sort an array, returning a double of time
	public double runBenchmark(theSort s, int[][] arr) {
		// Copy 2d array,
		// from stack:
		// https://stackoverflow.com/questions/1686425/copy-a-2d-array-in-java
		//It is necessary to copy, as if the array is not copiied 
		//following sorting algorithms will  sort already sorted arrays!
		int[][] arrayCopy = new int[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			arrayCopy[i] = arr[i].clone();
		}
		//Measuring time to sort rows in 2D array, then divide by 10 for each row
		long startTime = System.nanoTime();
		for (int i = 0; i < arr.length; i++) {
			s.sort(arrayCopy[i]);
		}
		long endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		
		
		double elapsedMillis = (timeElapsed) / 1000000.000;
		double avg = elapsedMillis / arr.length;
		return avg;
	}
}
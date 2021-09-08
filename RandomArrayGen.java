package ie.gmit.hdip;
//Source: D.Carr Notes
public class RandomArrayGen {
	//This generates a random 1D array
	public static int[] randomArray(int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = (int) (Math.random() * 100);
		}
		return array;
	}
	//This will generate a random 2D array with 10 rows
	public int[][] random2D(int n) {
		int[][] arr = new int[10][n];
		for(int i = 0; i < arr.length; i++) {
			arr[i] = randomArray(n);
		} 
		return arr;
	}
	//Printing of a 1D array
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	//Printing a 2D array
	public static void printdblarray(int[][] arr) {
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println("");
			for (int j = 0; j < arr[i].length; j++){
				System.out.print(arr[i][j]+" ");
			}
		}
	}


		
}

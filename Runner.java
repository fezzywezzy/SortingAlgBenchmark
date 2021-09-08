package ie.gmit.hdip;


public class Runner {
	//Method to print 2D array with space formatting at %10s
	public static void print2darray(String[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.println("");
			for (int j = 0; j < arr[i].length; j++){
				System.out.printf("%10s", arr[i][j]+" ");
			}
		}
	}
	public static void main(String[] args) {
		//size of arrays to test
		int[] sizearray = {100,250,500,750,1000,1250,2500,3750,5000,
							6250,7500,8750,10000, 15000,30000,50000};
		//Creating a table of results in a 2d Array
		String [][] theresults = new String [6][17];
		//Loop to insert first column of table to describe 
		//array table and save time
		for(int i = 1; i <= sizearray.length; i++) {
			theresults[0][i] = Integer.toString(sizearray[i-1]);
			
		}
		//Putting description values in table of results
		theresults [0][0] = "Size";
		theresults [1][0] = "Bubble";
		theresults [2][0] = "Insertion";
		theresults [3][0] = "Merge";
		theresults [4][0] = "Counting";
		theresults [5][0] = "Quick";
	
	//Creating objects of benchmarking and RandomArrayGen
	benchmarking bm  = new benchmarking();	
	RandomArrayGen ra = new RandomArrayGen();
	//Creating array of algorithms
	theSort[] algorithms = new theSort[5];
	
	algorithms[0] = new Bubble();
	algorithms[1] = new Insertion();
	algorithms[2] = new Merge();
	algorithms[3] = new Count();
	algorithms[4] = new quickSort();
	//Filling a 2D array with random arrays
	for(int i =0; i<sizearray.length; i++) {
		int[][] test = ra.random2D(sizearray[i]);
		//Creating a loop so each algorithm acts on test array
		for(int j = 0; j < algorithms.length; j++) {
			double benchavg = bm.runBenchmark(algorithms[j], test);
			//Converting to String and at 3 decimal places
			String strbenchavg = String.format("%.3f",benchavg);
			//Appending to results array
			theresults[j+1][i+1] = strbenchavg;
		}
	}
	
	System.out.println("\n Benchmarking for Sorting Algorithms");
	print2darray(theresults);
	}

}

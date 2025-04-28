import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
	    double[] array = getArray(); 
		System.out.print("Sorting Array...\n\n");
	    array = mergeSort(array, 0, array.length-1);
		System.out.print("\nFinal ");
		print(array, 0, array.length);
	}
	
	public static double[] getArray(){
	    Scanner sc = new Scanner(System.in);
	    // Get an integer for length
	    System.out.println("Enter the length of the array: ");
	    int len = 0;
	    while(true){
    	    try {
    	   	    len = (int) sc.nextDouble();
    	   	    break;
    	    }
    	    catch(Exception e){
    	   	    System.out.println("ERROR: NOT AN INTEGER;\nEnter the length of the array: ");
    	   	    sc.next();
    	    }
	    }
	    // Get double elements of array
	    double[] array = new double[Math.abs(len)];
	    System.out.println("Enter your numbers in any order: ");
	    for (int i = 0; i<array.length; i++){
	        while(true){
        	    try {
        	        array[i] = sc.nextDouble();
        	   	    break;
        	    }
        	    catch(Exception e) { sc.next(); }
    	    }
	    }
	    
	    // Return array
	    return array;
	}
	
	public static double[] mergeSort(double[] arr, int low, int high){
	    // If there is more than one element
	    if (low < high){
	        int middle = (low+high)/2;
            // Sort the left
            mergeSort(arr, low, middle);
            // Sort the right
            mergeSort(arr, middle+1, high);
            // Merge
            arr = merge(arr, low, middle, high);
	    }
	    return arr;
	}
	
	private static double[] merge(double[] arr, int low, int middle, int high){
	    // Indices
	    int indexL = 0;
	    int indexR = middle-low+1;
	    
	    // Create temp array of only the unsorted part
        double[] tempArr = new double[high - low + 1];
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i]=arr[low+i];
        }
        
        for (int i = low; i<=high; i++){
            // If left index is past halfway, add remaining right indices
            if(indexL > middle-low){
                arr[i] = tempArr[indexR];
                indexR++;
            }
            // If right index is at end of array, add remaining left indices
            else if(indexR > high-low){
                arr[i] = tempArr[indexL];
                indexL++;
            }
            // If left index is greater than right index, add right index
            else if(tempArr[indexL] > tempArr[indexR]){
                arr[i] = tempArr[indexR];
                indexR++;
            }
            // If right index is greater than left index, add left index
            else if (tempArr[indexL] <= tempArr[indexR]){
                arr[i] = tempArr[indexL];
                indexL++;
            }
        }
        // Print unsorted
        print(tempArr, 0, tempArr.length);
        // Print sorted
        print(arr, low, high+1);
        // Return sorted array
        return arr;
	}
	
	public static void print(double[] arr, int start, int end){
	    // Print all elements but last one
	    System.out.print("Array: [");
	    int i;
		for (i = start; i<end-1; i++){
		    if (arr[i] == (int) arr[i]) { System.out.print((int)arr[i]+", "); }
		    else { System.out.print(arr[i]+", "); }
		}
		// Print last element
		if (arr[i] == (int) arr[i]) { System.out.print((int)arr[i]); }
	    else { System.out.print(arr[i]); }
		System.out.println(']');
	}
}

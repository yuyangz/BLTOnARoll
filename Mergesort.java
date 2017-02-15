/*
  Yuyang Zhang
  APCS2 pd01
  HW06 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
  2017-02-11
*/    

/*======================================
  class Mergesort
  Implements mergesort on array of ints.

  Summary of Algorithm: 
  This algorithm contains two parts, one where the two arrays are being sorted and
  another where the arrays are placed together. Given an array with n values, we must
  break the array down into n array in which they each have one value. This is done 
  repetively dividing the array by 2. This takes place in the sort method. After doing
  so, the arrays will be grouped into pairs of twos (generally), and placed together
  in ascending order by the merge method. Variables are used to keep track and see which
  values are being compared. This will continue until all the arrays combineback into 
  one sorted array. This is essentially done through recursion.
  ======================================*/

public class Mergesort {

   /******************************************************
     * int[] merge(int[],int[]) 
     * Merges two input arrays
     * Precond:  Input arrays are sorted in ascending order
     * Postcond: Input arrays unchanged, and 
     * output array sorted in ascending order.
     ******************************************************/
    private static int[] merge( int[] a, int[] b ) 
    {
	int[] c = new int[a.length + b.length];
	int val1 = 0;
	int val2 = 0;
	for (int x = 0; x < c.length; x += 1){
	    if (val1 == a.length){
		c[x] = b[val2];
		val2 += 1;
	    }
	    else if (val2 == b.length){
		c[x] = a[val1];
		val1 += 1;
	    }
	    else if (a[val1] > b[val2]){
		c[x] = b[val2];
		val2 += 1;
	    }
	    else{
		c[x] = a[val1];
		val1 += 1;		
	    }
	}	
	return c;
    }//end merge()


    /******************************************************
     * int[] sort(int[]) 
     * Sorts input array using mergesort algorithm
     * Returns sorted version of input array (ascending)
     ******************************************************/
    public static int[] sort( int[] arr ) 
    {
	int half1Length = arr.length / 2;
	int half2Length = arr.length - half1Length;
	int[] half1 = new int[half1Length];
	int[] half2 = new int[half2Length];
	if (arr.length == 1){
	    return arr;
	}
	else{
	    for (int x = 0; x < half1.length; x += 1){
		half1[x] = arr[x];
	    }
	    for (int x = 0; x < half2.length; x += 1){
		half2[x] = arr[half1Length];
		half1Length += 1;
	    }
	    half1 = sort(half1);
	    half2 = sort(half2);
	    return merge(half1, half2);
	}
    }//end sort()



    //-------------------HELPERS-------------------------
    //tester function for exploring how arrays are passed
    //usage: print array, mess(array), print array. Whaddayasee?
    public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
        a[i] = 0;
    }

    //helper method for displaying an array
    public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
        System.out.print( i + ",");
    System.out.println("]");
    }
    //---------------------------------------------------


    //main method for testing
    public static void main( String [] args ) {

   
    int[] arr0 = {0};
    int[] arr1 = {1};
    int[] arr2 = {1,2};
    int[] arr3 = {3,4};
    int[] arr4 = {1,2,3,4};
    int[] arr5 = {4,3,2,1};
    int[] arr6 = {9,42,17,63,0,512,23};
    int[] arr7 = {9,42,17,63,0,9,512,23,9};

    System.out.println("\nTesting mess-with-array method...");
    printArray( arr3 );
    mess(arr3);
    printArray( arr3 );

    System.out.println("\nMerging arr1 and arr0: ");
    printArray( merge(arr1,arr0) );

    System.out.println("\nMerging arr4 and arr6: ");
    printArray( merge(arr4,arr6) );

    System.out.println("\nSorting arr4-7...");
    printArray( sort( arr4 ) );
    printArray( sort( arr5 ) );
    printArray( sort( arr6 ) );
    printArray( sort( arr7 ) );
 
    }//end main()

}//end class MergeSort

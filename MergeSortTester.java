// Team BLTOnARoll -- Brian "Baiyun" Kwong, Yuyang Zhang, Datian Zhang
// APCS2 pd1
// HW07 -- What Does the Data Say?
// 2017-02-15

/*======================================
  class MergeSortTester

  ALGORITHM:
  If length of input array is greater than 1, split in half.
  To split in half, copy the first half of the input into a new array.
  Copy the second half into a third array.
  Apply the MergeSort algo on each of the halves.

  If length of input array is 1, we can safely assume it's sorted.
  Merge with another sorted array using Merge method.

  Merge method -- combines two sorted arrays, maintaining sorted state.
  Done by creating a new array. This array will be filled either by the elements in the
  first array or the second using a counter for each one. 

  Repeat Merge method until original array is returned, in sorted state.

  BIG-OH CLASSIFICATION OF ALGORITHM:
  O(n log n)

  Mean execution times for dataset of size n:
  Batch size: 10000
  n=1       time: ~220
  n=10      time: ~1448
  n=100     time: ~14210
  ...
  n=<huge>  time: ~153699

  ANALYSIS:
 While the results should represent a n log n graph, our time results are not exact to the graph.
 This may be due to certain outliers within the batch. As the number of items in the array begins
 to increase, the runtime is seen to slow down. Certain inaccurate data may be due to the nanotime 
 method rather than the sort method. In addition, Brian's results were seen to differ from those of
 Yuyang. This may have to do with the computers used.
  ======================================*/

import java.util.ArrayList;

public class MergeSortTester 
{
   
    /******************************
     * execution time analysis 
    We first create a helper function in which values are filled into an array. We created 4 different
    arrays of different sizes. We then ran each array 10000 times and through the use of nanoTime, we 
    were able to determine the apprpoximate runtime. The average of the 10000 runs will be used to represent
    each array. 
     ******************************/

    public static int[] filler(int[] arr){
	for (int x = 0 ; x < arr.length; x += 1){
	    arr[x] = (int)(Math.random()) * 10;
	}
	return arr;
    }

    public static long average(long[] arr){
	long sum = 0L;
	for (int x = 0; x < arr.length; x += 1){
	    sum += arr[x];
	}
	return sum / (arr.length-1);
    }
    
    public static void main( String[] args ) 
    {
	int[] test1 = new int[1];
	int[] test10 = new int[10];
	int[] test100 = new int[100];
	int[] testBig = new int [1000];  

	int batchSize = 10000;

	long[] test1Results = new long[batchSize];
	long[] test10Results = new long[batchSize];
	long[] test100Results = new long[batchSize];
	long[] testBigResults = new long[batchSize];

	for (int i = 0; i < batchSize; i++) {
	    // System.out.println( "Now running Batch Number " + i );

	    filler(test1);
	    filler(test10);
	    filler(test100);
	    filler(testBig);

	    long start = System.nanoTime();
	    Mergesort.sort(test1);
	    long time = System.nanoTime() - start;
	    // System.out.println( "Array Length 1: " + time );
	    test1Results[i] = time;

	    long start2 = System.nanoTime();
	    Mergesort.sort(test10);
	    long time2 = System.nanoTime() - start2;
	    // System.out.println( "Array Length 10: " + time2 );
	    test10Results[i] = time2;

	    long start3 = System.nanoTime();
	    Mergesort.sort(test100);
	    long time3 = System.nanoTime() - start3;
	    // System.out.println( "Array Length 100: " + time3 );
	    test100Results[i] = time3;

	    long start4 = System.nanoTime();
	    Mergesort.sort(testBig);
	    long time4 = System.nanoTime() - start4;
	    // System.out.println( "Array Length 1000: " + time4 );
	    testBigResults[i] = time4;

	}

	System.out.println("Averages");
	System.out.println( "Array Length 1: " + average( test1Results ) );
	System.out.println( "Array Length 10: " + average( test10Results ) );
	System.out.println( "Array Length 100: " + average( test100Results ) );
	System.out.println( "Array Length 1000: " + average( testBigResults ) );

			        
    }//end main

}//end class

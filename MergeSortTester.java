/*======================================
  class MergeSortTester

  ALGORITHM:
  <INSERT YOUR DISTILLATION OF ALGO HERE>

  BIG-OH CLASSIFICATION OF ALGORITHM:
  <INSERT YOUR EXECUTION TIME CATEGORIZATION OF MERGESORT HERE>

  Mean execution times for dataset of size n:
  Batch size: <# of times each dataset size was run>
  n=1       time: 
  n=10      time: 
  n=100     time: 
  ...
  n=<huge>  time: 

  ANALYSIS:
  <INSERT YOUR RESULTS ANALYSIS HERE>
  ======================================*/

public class MergeSortTester 
{
   
    /******************************
     * execution time analysis 
     * <INSERT YOUR DESCRIPTION HERE OF 
     *  YOUR APPARATUS FOR GENERATING EXECUTION 
     *  TIME DATA...>
     ******************************/

    public static int[] filler(int[] arr){
	for (int x = 0 ; x < arr.length; x += 1){
	    arr[x] = (int)(Math.random()) * 10;
	}
	return arr;
    }
    
    public static void main( String[] args ) 
    {
	int[] test1 = new int[1];
	int[] test10 = new int[10];
	int[] test100 = new int[100];
	int[] testBig = new int [1000];  

	filler(test1);
	filler(test10);
	filler(test100);
	filler(testBig);


	long start = System.nanoTime();
	Mergesort.sort(test1);
	long time = System.nanoTime() - start;
	System.out.println(time);


	long start2 = System.nanoTime();
	Mergesort.sort(test10);
	long time2 = System.nanoTime() - start2;
	System.out.println(time2);

	long start3 = System.nanoTime();
	Mergesort.sort(test100);
	long time3 = System.nanoTime() - start3;
	System.out.println(time3);

	long start4 = System.nanoTime();
	Mergesort.sort(testBig);
	long time4 = System.nanoTime() - start4;
	System.out.println(time4);

	
	
			        
}//end main

}//end class

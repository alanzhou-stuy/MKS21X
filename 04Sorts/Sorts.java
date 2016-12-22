import java.util.*;

public class Sorts{

  public static String name(){
      return "09.Zhou.Alan";
  }

    //max work, always N
  public static void selectionSort(int[] data){  
      if (data.length < 2) {
	  return;
      }
      int smallestNum = data[0];
      int temp = 0;
      for (int i = 0; i <  data.length - 1; i ++) {
	  for (int n = i; n < data.length ; n++) {
	      if (data[n] < smallestNum) {
		  temp = n;
		  smallestNum = data[n];
		  data[temp] = data[i];
		  data[i] = smallestNum;
	      }
	  }
	  smallestNum = data[i+1];
	  temp = data[i+1];
	  
      }
  }

    //has potential for les work, average list is n/2 insertions  
    public static void insertionSort(int[] data) {
	if (data.length < 2) {
	    return;
	}
	for(int t = 1; t < data.length; t++) {
	    int num = data[t];
	    int temp = 0;
	    if (data[t - 1] > num) {
		for (int i = t - 1; i > -1; i--) {
		    if (data[i] > num) {
			temp = data[i];
			data[i] = num;
			data[i + 1] = temp;
		    }
		}
	    }
	}
    }

    //swapping a lot and looks at each element twice
    public static void bubbleSort(int[] data){
	if (data.length < 2) {
	    return;
	}
	int swapped = 0;
	int temp = 0;
	for (int n = data.length - 1; n > 0 ; n--) {
	    for (int i = 0; i < n; i++) {
		if (data[i] > data[i + 1])  {
		    temp = data[i];
		    data[i] = data[i+1];
		    data[i+1] = temp;
		    swapped = 1;
		}
	    }
	    if (swapped == 0) {
		return;
	    }
	    swapped = 0;
	}
    }
    /*

    public static void main(String[] args) {
	int[]data2 = {10, 9, 2, 3, 0, 11, 0, 0, 0, 3, -3, -2, -1, 9, 12, 13};
	int[]data = {0,1,2,3,4,5,6,7,8,9};
	int[]data1 = {9,8,7,6,5,4,3,2,1,0};
	int[]data3 = {};
	selectionSort(data2);
	//insertionSort(data);
	//bubbleSort(data);
	String x = "{";
	for (int i = 0; i < data2.length; i++){
	    x += data2[i] + " ";
	}
	
	System.out.println(x + "}");
	
    }
    */
     public static int[] randomArray(int size, int max){
	int[] data= new int[size];
	Random num = new Random();
	for(int i=0; i<data.length; i++){
	    data[i]=num.nextInt(max);
	}
	return data;
    }
    public static String Test(String method, int[]initial){
	String sorted;
	long startTime = System.currentTimeMillis();
	int[] copy = new int[initial.length];
	System.arraycopy( initial, 0, copy, 0, initial.length );
	Arrays.sort(copy);
	Object[] Sorted = {copy};
	int[] ary = new int[initial.length];
	System.arraycopy( initial, 0, ary, 0, initial.length );
	switch(method){
	    case "selectionSort":Sorts.selectionSort(ary);
		break;
	    case "insertionSort":Sorts.insertionSort(ary);
		break;
	    case "bubbleSort":Sorts.bubbleSort(ary);
		break;
	    default: return "INVALID. CURENTLY THERE ARE ONLY:\nselectionSort, insertionSort, bubbleSort \nPlease try again.";
	}
	Object[] Applied = {ary};
	if (Arrays.deepEquals(Sorted, Applied)){
	    sorted="Did sort";
	}
	else{
	    sorted="Did not sort";
	}
	long endTime = System.currentTimeMillis();
	long time=endTime-startTime;


	return String.format("%s: %s and took time of %s ms", method, sorted, time);
}
    
    public static void main(String[] a){
	System.out.println(Test(a[0],randomArray(10000,1000)));
	
    }
}

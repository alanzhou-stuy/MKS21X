public class Sorts{

  public static String name(){
      return "09.Zhou.Alan";
  }

  public static void selectionSort(int[] data){  
      int smallestNum = data[0];
      int temp = data[0];
      for (int i = 0; i <  data.length - 1; i ++) {
	  for (int n = i; n < data.length ; n++) {
	      if (data[n] < smallestNum) {
		  temp = n;
		  smallestNum = data[n];
	      }
	  }
	  data[temp] = data[i];
	  data[i] = smallestNum;
	  smallestNum = data[i+1];
	  temp = data[i+1];
      }
  }

    public static void main(String[] args) {
	int[]data = {10, 9, 2, 3, 0, 11, 0, 0, 0, 3};
	selectionSort(data);
	String x = "{";
	for (int i = 0; i < data.length; i++){
	    x += data[i] + " ";
	}
	
	System.out.println(x + "}");
    }
}



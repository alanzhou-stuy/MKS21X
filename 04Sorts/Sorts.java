public class Sorts{

  public static String name(){
      return "09.Zhou.Alan";
  }

  public static void selectionSort(int[] data){  
      int smallestNum = data[0];
      int temp = 0;
      for (int i = 0; i <  data.length - 2; i ++) {
	  for (int n = 0; n < data.length - i; n++) {
	      if (data[n + i] < smallestNum) {
		  smallestNum = data[n + i];
		  temp = n;
	      }
	  }
	  data[temp] = data[i];
	  data[i] = smallestNum;   
      }
  }

    public static void main(String[] args) {
	int[]data = {10, 9, 2, 3, 0, 11};
	selectionSort(data);
	String x = "{";
	for (int i = 0; i < data.length; i++){
	    x += data[i] + " ";
	}
	
	System.out.println(x + "}");
    }
}



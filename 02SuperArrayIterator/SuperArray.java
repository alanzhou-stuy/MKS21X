public class SuperArray implement Iterable<String>{
    private String[] data;
    private int size;
    public SuperArray() {
    data = new String[10];
    size = 0;
   }
    public SuperArray(int initialCapacity) {
       if (initialCapacity < 0) {
       throw new IllegalArgumentException();
       }
    data = new String[initialCapacity];
    size = 0;
   }

  public int size(){
    return size;
  }
  public String get(int index) {
      if (index < 0 || index >= size()) {
	  throw new IndexOutOfBoundsException();
    }
      String x = "";
      for (int i = 0; i < size; i ++) {
	  if (i == index) {
	      x = data[i];
	  }
      }
      return x;
  }
    public boolean add (String n) {
	if (size < data.length) {
	    data[size] = n;
	    size ++;
	}
	else{
	    grow();
	    add(n);
	}
	return true;
    }
    private void grow() {
	String[] x = new String[data.length * 2];
	for (int i = 0; i < x.length; i++) {
	    x[i] = data[i];
	}
	data = x;
    }
    public String toString(){
	String x = "[";
	for (int i = 0; i < size; i++) {
	x += data[i];
	if(i != size - 1) {
        x += ",";
	}
    }
    x += "]";
    return x;
}
    
    public String toStringDebug(){
	String x  = "[";
    for (int i = 0; i < data.length; i++) {
	if (i < size) {
	    x += data[i];
	}
	if(i != size - 1) {
        x += ",";
	}
	if(i >= size) {
	    x += "_";
	}
    }
    x += "]";
    return x;
    }
    
    public void clear(){
    size = 0;
    }

    public boolean isEmpty() {
    return (size == 0);
    }
    public String set(int index, String element) {
    if (index < 0 || index >= size()){
        throw new IndexOutOfBoundsException();
    }
    String x = "";
    for (int i = 0; i < size; i++) {
    if (i == index) {
        x = data[i];
        data[i] = element;
        return x;
    }
    else { 
    }
    }
    return "Not in String";
    }
    
    public void add(int index, String element){
	if(index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	String x = element;
	String[] answer = new String[data.length];
	size += 1;
	for (int i = 0; i <= data.length; i++) {
	    if (i <  index) {
	        answer[i] = data[i];
	    }
	    if (i == index) {
		answer[i] = element;
	    }
	    if (i > index && i < size){
		answer[i] = data[i-1];
	    }
	    if ( i == size) {
	        answer[i] = data[i];
	    }
	}
	data = answer;
    }
    
    public String remove(int index){
	if (index < 0 || index >= size) {
	    throw new IndexOutOfBoundsException();
		}
	String x = "";
	x = data[index];
	for (int i = index; i <= size; i++) {
	    data[i] = data[i+1];
	    }
	size --;
	return x;
    }
    public String[] toArray() {
	String[] x = new String[data.length];
	for (int i = 0; i < size; i++) {
	    x[i] = data[i];
	}
	return x;
    }
    public int indexOf(String y){
	int x = -1;
	for (int i = 0; i < size; i++) {
	    if (y.compareTo(data[i]) == 0) {
		x = i;
		return x;
	    }
	    else {
		}
	}
	return x;
    }
    public int lastIndexOf(String y){
	int x = -1;
	for (int i = size - 1; i > 0; i--) {
	    if (y.compareTo(data[i]) == 0) {
		x = i;
		return x;
	    }
	    else {
		}
	}
	return x;
    }


    //iterator()
    public Iterator<String> iterator(){
	return new SuperArrayIterator(this);
    }
}

public abstract class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String callNumber;
    public LibraryBook (String author, String title, String isbn, String callnumber) {
        super();
	callNumber = callnumber;
    }

    public String getCallNumber() {
	String x = "";
	x += callNumber;
	return x;
    }

     public void setCallNumber(String callnumber) {
	callNumber = callnumber;
    }

    abstract void checkout(String patron, String due);
    
    abstract void returned();

    abstract String circulationStatus();

    public int compareTo(LibraryBook o) {
	if ((callNumber.compareTo( o.callNumber)) > 0) {
		return 1;
	    }
	else if ((callNumber.compareTo(o.callNumber)) < 0){
		return -1;
	    }
	    else {
		return 0;
	    }
    }
    

    public String toString() {
	String a = super.toString();
	    return a + ", " + callNumber;
    }
}


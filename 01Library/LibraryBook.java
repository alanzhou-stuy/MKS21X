public abstract Class LibraryBook extends Book implements Comparable<LibraryBook> {
    private String callNumber;
    public LibraryBook (String author, String title, String ISBN, String callNumber) {
	author = "";
	title = "";
	IBSN = "";
	callNumber = "";
    }

    public String getCallNumber() {
	String x = "";
	x += callNumber;
	return x;
    }

     public void setCallNumber(String callnumber) {
	callNumber = callnumber;
    }

     abstract void checkout(String patron, String due){
     }

     abstract void returned(){
     }

     abstract String circulationStatus(){
     }

}

public class  CirculatingBook extends LibraryBook {
    private String currentHolder;
    private String dueDate;
    
     public CirculatingBook (String author, String title, String isbn, String callnumber) {
	 super(author,title,isbn,callnumber);
	 currentHolder = "";
	 dueDate = "";
     }
    
    public String getCurrentHolder(){
	return currentHolder;
    }
    
    public String getDueDate() {
	return dueDate;
    }

    public void setCurrentHolder(String currentholder) {
	currentHolder = currentholder;
    }
    
    public void setDueDate(String duedate) {
	dueDate = duedate;
    }

    public void checkout(String patron, String due) {
	currentHolder = patron;
	dueDate = due;
    
    }

    public void returned() {
	currentHolder = "";
	dueDate = "";
    }
    
    public String circulationStatus() {
	if ((currentHolder.compareTo("")) != 0) {
	    return "currentHolder: " + currentHolder + "dueDate: "+ dueDate;
	}
	else {
	    return "Book available on shelves";
	}

    }
    public String toString() {
	String a = super.toString();
	return a + ", " + currentHolder + ", " + dueDate;

    }
}


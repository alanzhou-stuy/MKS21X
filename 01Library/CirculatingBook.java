public class  CirculatingBook extends LibraryBook {
    private String currentHolder;
    private String dueDate;
    
     public LibraryBook (String author, String title, String isbn, String callnumber) {
	 super(author,title,isbn,callnumber);	 
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

    public void checkout() {
    
    }

    public void returned() {
    
    }
    
    public String circulationStatus() {

    }
    
    public String toString() {

    }
}


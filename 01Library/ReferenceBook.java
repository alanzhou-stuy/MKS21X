public class ReferenceBook extends LibraryBook {
    private String Collection;
    public ReferenceBook (String author, String title, String isbn, String callnumber,String collection) {
	//author
	//title
	//isbn
	//callnumber
	Collection = collection;
    }
    
    public String getCollection() {
	String x = "";
	x += Collection;
	return x;
    }

     public void setCollection(String collection) {
	Collection = collection;
    }

    public void checkout() {
	System.out.println("cannot check out a reference book");
    }

    public void returned() {
	System.out.println("reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus() {
	System.out.println("non-circulating reference book");
    }

    public String toString() {
	//stuff with super() here
    }
    

}

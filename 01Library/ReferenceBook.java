public class ReferenceBook extends LibraryBook {
    private String Collection;
    public ReferenceBook (String author, String title, String isbn, String callnumber,String collection) {
        super(author, title, isbn, callnumber);
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

    public void checkout(String patron, String due) {
	System.out.println("cannot check out a reference book");
    }

    public void returned() {
	System.out.println("reference book could not have been checked out -- return impossible");
    }

    public String circulationStatus() {
	return "non-circulating reference book";
    }

    public String toString() {
        String a = super.toString();
	return a + ", " + Collection;
    }
    

}

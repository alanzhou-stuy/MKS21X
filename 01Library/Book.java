public class Book {
    private String Author;
    private String Title;
    private String ISBN;
    
    public Book() {
	Author = "";
	Title = "";
	ISBN = "";
    }
    
    public Book (String author, String title, String isbn) {
	Author = author;
	Title = title;
	ISBN = isbn;
    }

    public String getAuthor() {
	String x = "";
	x += Author;
	return x;
    }

    public String getTitle() {
	String x = "";
	x += Title;
	return x;
    }

    public String getISBN() {
	String x = "";
	x += ISBN;
	return x;
    }

    public void setAuthor(String author) {
	Author = author;
    }

    public void setTitle(String title) {
	Title = title;
    }

    public void setISBN(String isbn) {
	ISBN = isbn;
    }

    public String toString() {
	String a = "";
	return a + Author + ", " + Title + ", " + ISBN;
    }
}

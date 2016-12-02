public class SuperArrayIterator implements Iterator<String>  {

    import java.util.Iterator;

    //instance variables
    private int arrayLook;
    private int elementLook;
    private int start;
    private int end;

    //constructor
    public SuperArrayIterator (int start, int end){
	this.start = start;
	this.end = end;
	arrayLook = 0;
	elementLook = 0;
    }
    
    //methods
    public boolean hasNext() {

    }

    public E next() {

    }

    public void remove() {

    }

}


//iterator is a looping device, doign the looping
//iterable gives iterator- manufactors iterator

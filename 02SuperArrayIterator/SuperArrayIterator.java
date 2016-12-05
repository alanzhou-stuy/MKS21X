import java.util.Iterator;
public class SuperArrayIterator implements Iterator<String>  {

    //instance variables
    private SuperArray array;
    private int elementLook;

    //constructor
    public SuperArrayIterator (SuperArray x){
	array  = x;
	elementLook = 0;
    }
    
    //methods
    public boolean hasNext() {
	return elementLook < array.size();
    }

    public String next() {
	elementLook ++;
	return array.get(elementLook - 1);
	
    }

    public void remove() {
	throw new UnsupportedOperationException();
    }

}


//iterator is a looping device, doign the looping
//iterable gives iterator- manufactors iterator

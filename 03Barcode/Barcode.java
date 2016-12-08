public class Barcode implements Comparable<Barcode>{
   private String _zip;
   private int _checkDigit;

// constructors
//precondtion: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
  public Barcode(String zip) {
      for (int i = 0; i < 5; i++) {
	  if (zip.charAt(i) < '0' || zip.charAt(i) > '9') {
	      throw new IllegalArgumentException();
	  }
      }
      if (zip.length() != 5) {
	  throw new IllegalArgumentException();
      }
      
      _zip = zip;
      _checkDigit = checkSum() % 10;
  }

  
// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
      Barcode cloned;
      cloned = this;
      return cloned;
  }


// postcondition: computes and returns the check sum for _zip
    private int checkSum(){
	int sum = 0;
	for (int i = 0; i < 5; i++) {
	    sum += (_zip.charAt(i) - '0');
	}
	return sum;
    }

    public String formatNumber() {
	String x = "";
	String answer = "";
	for (int i = 0; i < 6; i++) {
	    switch((_zip + _checkDigit).charAt(i)) {
	    case '1':
		x = ":::||";
		break;
	    case '2':
		x = "::|:|";
		break;
	    case '3':
		x = "::||:";
		break;
	    case '4':
		x = ":|::|";
		break;
	    case '5':
		x = ":|:|:";
		break;
	    case '6':
		x = ":||::";
		break;
	    case '7':
		x = "|:::|";
		break;
	    case '8':
		x = "|::|:";
		break;
	    case '9':
		x = "|:|::";
		break;
	    case '0': 
		x = "||::::";
		break;
	    }
	    answer += x;
	}
	return answer;
    }
    
//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
      return  _zip + _checkDigit + "   " + "|" + this.formatNumber() + "|";
  }
  

// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){
      return (Integer.valueOf(_zip + _checkDigit)).compareTo(Integer.valueOf(other._zip + other._checkDigit));
  }
  


public static void main(String args[]){
	Barcode b = new Barcode("08451");
	Barcode c = new Barcode("99999");
	Barcode d = new Barcode("11111");
	System.out.println(b); //084518 |||:::|::|::|::|:|:|::::|||::|:|
	System.out.println(b.toString().compareTo("084518 |||:::|::|::|::|:|:|::::|||::|:|")); //0
	System.out.println(b.compareTo(b)); //0
	System.out.println(c.compareTo(b));
	System.out.println(d.compareTo(b));
}
}

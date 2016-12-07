public class Barcode implements Comparable<Barcode>{
   private String _zip;
   private int _checkDigit;

// constructors
//precondtion: _zip.length() = 5 and zip contains only digits.
//postcondition: throws a runtime exception zip is not the correct length
//               or zip contains a non digit
//               _zip and _checkDigit are initialized.
  public Barcode(String zip) {
      if (zip.length() != 5) {
	  throw new RuntimeException();
      }
      _zip = zip;
      _checkDigit = checkSum(zip) % 10;
  }

  
// postcondition: Creates a copy of a bar code.
  public Barcode clone(){
  }


// postcondition: computes and returns the check sum for _zip
  private int checkSum(){
      int sum;
      for (int i = 0; i < 5; i++) {
	  sum += (int)zip.charAt(i);
      }
      return sum;
  }

//postcondition: format zip + check digit + Barcode 
//ex. "084518  |||:::|::|::|::|:|:|::::|||::|:|"      
  public String toString(){
      String x;
      switch(num) {
      case 1:
	  x = ":::||"
      case 2:
	  x = "::|:|"
      case 3:
	  x = "::||:"
      case 4:
	  x = ":|::|" 
      case 5:
	  x = ":|:|:"
      case 6:
	  x = ":||::"
      case 7:
	  x = "|:::|"
      case 8:
	  x = "|::|:"
      case 9:
	  x = "|:|::"
      case 10: //0
	  x = "||::::"
      }
  }
  

// postcondition: compares the zip + checkdigit, in numerical order. 
  public int compareTo(Barcode other){
      return (_zip + _checkDigit).compareTo(other.clone());
  }
  
}

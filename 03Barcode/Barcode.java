import java.util.*;

public class Barcode implements Comparable<Barcode>{
   private String zip;
   private int checkDigit;

  public Barcode(String _zip) {
      if (_zip.length() != 5) {
	  throw new IllegalArgumentException();
      }
      for (int i = 0; i < 5; i++) {
	  if (_zip.charAt(i) < '0' || _zip.charAt(i) > '9') {
	      throw new IllegalArgumentException();
	  }
      }  
      zip = _zip;
      checkDigit = checkSum(zip) % 10;
  }
    
    private static int checkSum(String zip){
	int sum = 0;
	for (int i = 0; i < 5; i++) {
	    sum += (zip.charAt(i) - '0');
	}
	return sum;
    }

    public static String toCode(String zip) {
	String x = "";
	String answer = "";
	zip += checkSum(zip) % 10;
	for (int i = 0; i < 6; i++) {
	    switch(zip.charAt(i)) {
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
	return "|" + answer + "|";
    }

    public static String toZip(String code) {
	if (code.length() != 32) {
	    throw new IllegalArgumentException("Incorrect Length");
	}
	if (code.charAt(0) != '|' || code.charAt(31) != '|') {
	    throw new IllegalArgumentException("Sidebar is wrong");
	}
	for (int i = 0; i < 32; i++) {
	  if (code.charAt(i) != ':' && code.charAt(i) != '|') {
	      throw new IllegalArgumentException("Incorrect characters");
	  }
	}
        String _answer = "";
	String _temp = "";
	int y = 0;
	String answer = "";
	String subcode = code.substring(1,32);
	String temp = "";
	int n = 0;
	ArrayList<String> symbols = new ArrayList<String>(Arrays.asList("||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"));
       for (int i = 0; i < 30; i++) {
	    if (y != 4) {
		_temp += subcode.charAt(i);
		y++;
	    }
	    else {
	        for (int z = 0; z < 10; z++) {
		    if (_temp != symbols.get(z)) {
			throw new IllegalArgumentException("encoded ints are invalid");
		    }
		}
	    }
	}
       
	int sum = 0;
	for (int i = 0; i < 5; i++) {
	    sum += (int)code.charAt(i);
	}
	if (sum % 10 != (int)code.charAt(5)) {
	    throw new IllegalArgumentException("Check number is wrong");
	}
	
	for (int i = 0; i < 30; i++) {
	    if (n != 4) {
		temp += subcode.charAt(i);
		n++;
	    }
	    else {
		answer += symbols.indexOf(temp);
		temp = "";
		n = 0;
	    }
	}
	return answer;	
    
    }
    
  public String toString(){
      return  zip + checkDigit + "   " + toCode(zip); 
  }
  
  public int compareTo(Barcode other){
      return (zip + checkDigit % 10).compareTo(other.zip + checkDigit % 10);
  }
   
}

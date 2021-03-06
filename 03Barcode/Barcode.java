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
	String[] code1 = {"||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"};
	String x = "";
	for (int i = 1; i < 27; i+= 5) {
	    boolean y = false;
	    for (int n = 0; n < 10 ; n++) {
		if (code.substring(i, i + 5).equals(code1[n])) {
		    x+= n;
		    y = true;
		}
	    }
		if ( y == false) {
		    throw new IllegalArgumentException("Encode ints are invalid");
		}
	}
	int forCheckSum = 0;
	for (int i = 0; i < 10; i++) {
	    if (code.substring(26,31).equals(code1[i])) {
		forCheckSum = i;
	    }
	}
	if((checkSum(code.substring(1,6)) % 10) != (forCheckSum % 10)) {
		throw new IllegalArgumentException("Checksum is invalid");
	    }
	return x.substring(0,5);
    }
    
  public String toString(){
      return  zip + checkDigit + "   " + toCode(zip); 
  }
  
  public int compareTo(Barcode other){
      return (zip + checkDigit % 10).compareTo(other.zip + checkDigit % 10);
  }
   
}

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
      checkDigit = checkSum() % 10;
  }
    
    private int checkSum(){
	int sum = 0;
	for (int i = 0; i < 5; i++) {
	    sum += (zip.charAt(i) - '0');
	}
	return sum;
    }

    private static String toCode(String zip) {
	String x = "";
	String answer = "";
	for (int i = 0; i < 5; i++) {
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
	if (code.charAt(1) != '|' || code.charAt(32) != '|') {
	    throw new IllegalArgumentException("Sidebar is wrong");
	}
	for (int i = 0; i < 32; i++) {
	  if (code.charAt(i) < '0' || code.charAt(i) > '9') {
	      throw new IllegalArgumentException("Incorrect characters");
	  }
	}
        int sum = 0;
	for (int i = 0; i < 5; i++) {
	    sum += (int)code.charAt(i);
	}
	if (sum != (int)code.charAt(5)) {
	    throw new IllegalArgumentException("Check number is wrong");
	}
	String answer = "";
	String subcode = code.substring(1,32);
	String temp = "";
	int n = 0;
	ArrayList<String> symbols = new ArrayList<String>(Arrays.asList("||:::", ":::||", "::|:|", "::||:", ":|::|", ":|:|:", ":||::", "|:::|", "|::|:", "|:|::"));
	for (int i = 0; i < 30; i++) {
	    if (n != 4) {
		temp += code.charAt(i);
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
      return zip.compareTo(other.zip);
  }
    public static void main(String args[]){
Barcode b = new Barcode("08451");
Barcode c = new Barcode("99999");
Barcode d = new Barcode("01111");
System.out.println(b); //084518 |||:::|::|::|::|:|:|::::|||::|:|
    }
}

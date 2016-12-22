public class Driver{

    public static void main(String args[]){
	Barcode b = new Barcode("25543");
	Barcode c = new Barcode("97934");
	Barcode d = new Barcode("00000");
	System.out.println(c); //979342  ||:|::|:::||:|::::||::|::|::|:||
	System.out.println(b); //255439   |::|:|:|:|::|:|::|::|::||:|:|::|
	
	System.out.println(b.compareTo(b)); //0
	System.out.println((new Barcode("11426")).compareTo(new Barcode("11426"))); //0
	System.out.println(c.compareTo(b)); //some positive
	System.out.println(d.compareTo(b)); //some negative
	/*length
	  Barcode e = new Barcode("123456");
	  System.out.println(e);
	*/
	System.out.println(b.toZip("||:|::|:::||:|::::||::|::|::|:||"));
	System.out.println(c.toCode("979341"));
	/*length
	  Barcode e = new Barcode("1234");
	  System.out.println(e);
	*/
	/*type
	  Barcode e= new Barcode("12.45");
	  System.out.println(e);
	*/
    }

}

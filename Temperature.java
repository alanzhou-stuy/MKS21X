public class Temperature {
    public static double CtoF (double temp){
	return temp * 1.8 + 32;
    }

    public static double FtoC (double temp) {
	return ((temp - 32) * (5 / 9));
    }

}

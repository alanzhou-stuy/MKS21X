public class SlidingPuzzle {
    private int side;
    private int[][]values;
    public SlidingPuzzle (int sideLength) {
	side = sideLength;
	values = new int [side][side];
	initialize();
    }
    public boolean isDone() {

    }

    public void initialize() {
	ArrayList<Integer> temp = new ArrayList<Integer>();
	for (int j = 0; j< side*side; j++) 
	    temp.add(new Integer(j));
	for (int r = 0;r < side; r++) {
	    for (int c = 0; c < side; c++) {
		int randIndex = (int)(Math.random() * temp.size());
		values [r][c] = temp.get(randIndex);
		temp.remove(randIndex);
	    }
    }
}

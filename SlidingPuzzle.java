public class SlidingPuzzle {
    private int side;
    private int[][]values;
    public SlidingPuzzle (int sideLength) {
	side = sideLength;
	values = new int [side][side];
	initialize();
    }
    public boolean isDone() {
	int n = 1;
	booelan x = true;
	for (int i = 0 ; i < side; i++) {
	    for (int y = 0; y < side; y++ ) {
		if (values[i][y] == n){
		    n++;
		}
		else if ((values[i][y] == 0) && x = true){
		    x = false;
		}
		else {
		    return false;
		}
	    }
	}
	return true;
    }

    public boolean isDone2(){
		int previous = values[0][0];
		for(int r = 0; r < side; r++){
			for(int c = 0; c < side; c++){
				if(values[r][c] != 0 && values[r][c] == previous+1){
					previous = values[r][c];
				} else if(values[r][c] != 0 && values[r][c] != previous){
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean isDone3(){
		int previous = values[0][0];
		for(int i = 0; i < side * side; i++){
			if(values[i/side][i%side] != 0 && values[i/side][i%side] == previous+1){
				previous = values[i/side][i%side];
			} else if (values[i/side][i%side] != 0 && values[i/side][i%side] != previous){
				return false;
			}
		}
		return true;
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

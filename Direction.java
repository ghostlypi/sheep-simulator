
public abstract class Direction {
	public static final int N = 0;
	public static final int NE = 1;
	public static final int E = 2;
	public static final int SE = 3;
	public static final int S = 4;
	public static final int SW = 5;
	public static final int W = 6;
	public static final int NW = 7;
	
	public static int randDir() {
		int x = (int) (Math.random()*8);
		if(x == 0)
			return Direction.N;
		else if (x == 1)
			return Direction.NE;
		else if (x == 2)
			return Direction.E;
		else if (x == 3)
			return Direction.SE;
		else if (x == 4)
			return Direction.S;
		else if (x == 5)
			return Direction.SW;
		else if (x == 6)
			return Direction.W;
		else
			return Direction.NW;
	}
	
}


public class Location {
	int x, y;
	public Location(int x, int y) {
		this.x =x;
		this.y =y;
	}
	
	public Location() {
		this(0,0);
	}
	
	public boolean isValid(Environment env) {
		if(env.getMinLoc().getX() <= x &&env.getMinLoc().getY() <= y && env.getMaxLoc().getX() >= x && env.getMaxLoc().getY() >= y) {
			return true;
		}
		return false;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
		
	private String convertToLetter(int x) {
		if(x / 26 == 0) {
			char c = (char)(65+x);
			return c+"";
		}
		
		return convertToLetter(x/26)+(char)(65+(x%26));
	}
	
	public String toString() {
		return convertToLetter(this.x)+""+this.y;
	}
}

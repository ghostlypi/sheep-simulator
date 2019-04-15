
public abstract class Tile extends Letterer implements Character{
	
	private Location loc;
	private String ID;
	private String type;
	public static final String GRASS = "GRASS";
	public static final String FENCE = "FENCE";
	public static final String DIRT = "DIRT";
	private int count = 0;
	
	public Tile(Location loc, String type) {
		count += 10;
		this.loc = loc;
		this.type = type;
		this.ID = "TIL"+super.convertToLetter((int)(Math.random()*10+count))+Math.random()*10000+type;
	}
	
	public Location getLoc() {
		return loc;
	}
	
	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public String getName() {
		return getType();
	}

	public String getID() {
		return ID;
	}

	public String getType() {
		return type;
	}
	
	public abstract String toString();

}

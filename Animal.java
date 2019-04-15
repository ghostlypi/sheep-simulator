
public abstract class Animal extends Letterer implements Character{
	
	private Location loc;
	private String name;
	private String ID;
	private String type;
	public static final String SHEEP = "SHEEP";
	public static final String WOLF = "WOLF";
	public static final String OBS = "NULL";
	private int count = 0;
	
	public Animal(Location loc, String name, String type) {
		count += 10;
		this.loc = loc;
		this.name = name;
		this.type = type;
		this.ID = "ANI"+super.convertToLetter((int)(Math.random()*10+count))+Math.random()*10000+type;
	}
	
	public Location getLoc() {
		return loc;
	}
	
	public void setLoc(Location loc) {
		this.loc = loc;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getID() {
		return ID;
	}

	public String getType() {
		return type;
	}
	
	public abstract Location move(int dis, int dir);
	
	public String toString() {
		return this.ID + " ----- " + this.name + " - " + this.type + " - "+this.loc.toString();
	}

}

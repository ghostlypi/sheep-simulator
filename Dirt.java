
public class Dirt extends Tile{
	
	public Dirt(Location loc) {
		super(loc,Tile.DIRT);
	}
	
	public String toString() {
		return super.getID() + " ----- " + super.getType() + " - "+ super.getLoc().toString();
	}
}

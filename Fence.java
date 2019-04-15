
public class Fence extends Tile{
	
	public Fence(Location loc) {
		super(loc,Tile.FENCE);
	}
	
	public String toString() {
		return super.getID() + " ----- " + super.getType() + " - "+ super.getLoc().toString();
	}
}

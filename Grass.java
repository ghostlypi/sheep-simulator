
public class Grass extends Tile{
	
	public Grass(Location loc) {
		super(loc,Tile.GRASS);
	}
	
	public String toString() {
		return super.getID() + " ----- " + super.getType() + " - "+ super.getLoc().toString();
	}
}

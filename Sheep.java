
public class Sheep extends Animal{
	
	public Sheep(String name, Location loc) {
		super(loc, name, Animal.SHEEP);
	}
	
	public Location move(int dis, int dir) {
		if(dir % 2 == 1) {
			dir--;
		}
		
		Location loc;
		
		if (dir == 0) {
			loc = new Location(super.getLoc().getX()-dis,super.getLoc().getY());
		}else if (dir == 2) {
			loc = new Location(super.getLoc().getX(),super.getLoc().getY()+dis);
		}else if (dir == 4) {
			loc = new Location(super.getLoc().getX()+dis,super.getLoc().getY());
		}else if (dir == 6) {
			loc = new Location(super.getLoc().getX(),super.getLoc().getY()-dis);
		}else {
			throw new IndexOutOfBoundsException("Direction not found");
		}
		
		return loc;
	}
}

public class Wolf extends Animal {
	public Wolf(String name, Location loc) {
		super(loc, name, Animal.WOLF);
	}
	
	public Location move(int dis, int dir) {
		Location loc;
		if (dir == 0) {
			loc = new Location(super.getLoc().getX()-dis, super.getLoc().getY());
		} else if (dir == 1) {
			loc = new Location(super.getLoc().getX()-((dis*dis)/2), super.getLoc().getY()+((dis*dis)/2));
		}else if (dir == 2) {
			loc = new Location(super.getLoc().getX(), super.getLoc().getY()+dis);
		}else if (dir == 3) {
			loc = new Location(super.getLoc().getX()+((dis*dis)/2), super.getLoc().getY()+((dis*dis)/2));
		}else if (dir == 4) {
			loc = new Location(super.getLoc().getX()+dis, super.getLoc().getY());
		}else if (dir == 5) {
			loc = new Location(super.getLoc().getX()+((dis*dis)/2), super.getLoc().getY()-((dis*dis)/2));
		}else if (dir == 6) {
			loc = new Location(super.getLoc().getX(), super.getLoc().getY()-dis);
		}else if (dir == 7) {
			loc = new Location(super.getLoc().getX()-((dis*dis)/2), super.getLoc().getY()-((dis*dis)/2));
		}else {
			throw new IndexOutOfBoundsException("Direction not found");
		}
		return loc;
	}
}

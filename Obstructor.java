
public class Obstructor extends Animal{
	public Obstructor(Location loc) {
		super(loc, "Obstructor", Animal.OBS);
	}
	
	public Location move(int dis, int dir) {
		throw new RuntimeException("This Animal Cannot move, and does not Exist, try referring to a different Animal Block.");
	}
}

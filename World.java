import java.util.ArrayList;
public class World {
	private Environment til;
	private Environment ani;
	private String[][] world;
	private ArrayList<Location> aniLocs;
	public int size;
	public int numAni;
	
	public World(int rows, int cols) {
		size = rows*cols;
		til = new Environment(new Location(0,0), new Location(rows,cols));
		ani = new Environment(new Location(0,0), new Location(rows,cols));
		world = new String[rows][cols];
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				til.addCharacter(new Grass(new Location(i,j)));
			}
		}
		numAni = ani.numChars;
		aniLocs = new ArrayList<>();
		update();
	}
	
	public Location[] getAniLocs() {
		Location[] aniLocs = new Location[this.aniLocs.size()];
		for(int i = 0; i < aniLocs.length; i++) {
			aniLocs[i] = this.aniLocs.get(i);
		}
		return aniLocs;
	}
	
	public World() {
		this(10,10);
	}
	
	public void update() {
		numAni = ani.numChars;
		aniLocs = new ArrayList<>();
		for(int i = 0; i < world.length; i++) {
			for(int j = 0; j < world[i].length; j++) {
				Character c = til.getCharacter(new Location(i,j));
				if(c.getType() == Tile.GRASS) {
					world[i][j] = "G";
				}else if(c.getType() == Tile.DIRT) {
					world[i][j] = "D";
				}else if(c.getType() == Tile.FENCE) {
					world[i][j] = "F";
				}else{
					til.removeCharacter(new Location(i,j));
				}
			}
		}
		for(int i = 0; i < world.length; i++) {
			for(int j = 0; j < world[i].length; j++) {
				Character c = ani.getCharacter(new Location(i,j));
				if(c == null) {
					continue;
				}else if(c.getType() == Animal.SHEEP) {
					world[i][j] = "S";
					aniLocs.add(c.getLoc());
				}else if(c.getType() == Animal.WOLF) {
					world[i][j] = "W";
					aniLocs.add(c.getLoc());
				}else if(c.getType() == Animal.OBS) {
					world[i][j] = "F";
				}else{
					ani.removeCharacter(new Location(i,j));
				}
			}
		}
	}
	
	public void desertify(Location loc) {
		if(til.getCharacter(loc).getType() == Tile.GRASS)
			til.setCharacter(loc, new Dirt(loc), 13);
	}
	
	public void restore() {		
		int x = (int)(Math.random()*(til.getMaxLoc().getX()-til.getMinLoc().getX()));
		int y = (int)(Math.random()*(til.getMaxLoc().getY()-til.getMinLoc().getY()));
		if(til.getCharacter(new Location(x,y)).getType() == Tile.DIRT)
			til.setCharacter(new Location(x,y), new Grass(new Location(x,y)), 13);
	}
	
	public Environment getAnimals() {
		return ani;
	}
	
	public Environment getTiles() {
		return til;
	}
	
	public String[][] getWorldState(){
		return world;
	}
	
	public void addAnimal(String str) {
		if(str == Animal.SHEEP) {
			ani.addCharacter(new Sheep("Bill", new Location()));
		}else if(str == Animal.WOLF) {
			ani.addCharacter(new Wolf("Bob", new Location()));
		}
	}
	
	public void addFence(Location loc) {
		til.setCharacter(loc, new Fence(loc),13);
		ani.setCharacter(loc, new Obstructor(loc),13);
	}
	
	public void moveAnimal(Location from, Location to) {
		ani.setCharacter(to, ani.removeCharacter(from), 13);
	}
	
	public void eat(Location loc) {
		for(int i = 0; i < 8; i++) {
			Location l;
			if ( i == 0) {
				l = new Location(loc.getX()-1, loc.getY());
			} else if (i == 1) {
				l = new Location(loc.getX()-((1*1)/2), loc.getY()+((1*1)/2));
			}else if (i == 2) {
				l = new Location(loc.getX(), loc.getY()+1);
			}else if (i == 3) {
				l = new Location(loc.getX()+((1*1)/2), loc.getY()+((1*1)/2));
			}else if (i == 4) {
				l = new Location(loc.getX()+1, loc.getY());
			}else if (i == 5) {
				l = new Location(loc.getX()+((1*1)/2), loc.getY()-((1*1)/2));
			}else if (i == 6) {
				l = new Location(loc.getX(), loc.getY()-1);
			}else if (i == 7) {
				l = new Location(loc.getX()-((1*1)/2), loc.getY()-((1*1)/2));
			}else {
				throw new IndexOutOfBoundsException("Overloop error. Enter ^C to exit.");
			}
			if(ani.getMinLoc().getX() < l.getX() && ani.getMinLoc().getY()< l.getY() && ani.getMaxLoc().getX() > l.getX() && ani.getMaxLoc().getY() > l.getY()) {
				if (ani.getCharacter(l) != null && ani.getCharacter(l).getType() == Animal.SHEEP) {
					die(l);
				}
			}
		}
	}
	
	public Character die(Location loc) {
		return ani.removeCharacter(loc);
	}
	
	public String toString() {
		update();
		String out = "";
		for(int i = 0; i < world.length; i++) {
			for(int j = 0; j < world[i].length; j++) {
				out += world[i][j] + " ";
			}
			out = out.substring(0,out.length()-1) + "\n";
		}
		return out;
	}

}

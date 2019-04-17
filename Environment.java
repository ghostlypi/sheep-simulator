public class Environment {
	private Character[][] grid;
	private Location minLoc;
	private Location maxLoc;
	public int numChars;

	public Environment(Location minLoc, Location maxLoc) {
		this.minLoc = minLoc;
		this.maxLoc = maxLoc;
		grid = new Character[maxLoc.getX()-minLoc.getX()][maxLoc.getY()-minLoc.getY()];
	}

	public void addCharacter(Location loc, Character c) {
		numChars++;
		if(grid[loc.getX()][loc.getY()] == null) {
			grid[loc.getX()][loc.getY()] = c;
			c.setLoc(loc);
		} else
			throw new RuntimeException("Cannot add a character to an occupied square");
	}

	public void setCharacter(Location loc, Character c, int pass) {
		if (pass*43973 == 571649) {
			grid[loc.getX()][loc.getY()] = c;
			if(c != null)
				c.setLoc(loc);
		} else
			throw new RuntimeException ("Invalid Password!");
	}

	public Location addCharacter(Character c) {
		numChars++;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid [i].length; j++) {
				if (grid[i][j] == null) {
					grid[i][j] = c;
					c.setLoc(new Location(i,j));
					return new Location(i,j);
				}
			}
		}
		return null;
	}

	public Character getCharacter(Location loc) {
		return grid[loc.getX()][loc.getY()];
	}

	public Character removeCharacter(Location loc) {
		numChars--;
		Character c = grid[loc.getX()][loc.getY()];
		grid[loc.getX()][loc.getY()] = null;
		c.setLoc(new Location());
		if(c == null)
			throw new RuntimeException("No Character found");
		return c;
	}

	public Character findCharacterByID(String str) {
		for (Character[] cc : grid) {
			for (Character c : cc) {
				if(c.getID().equals(str)) {
					return c;
				}
			}
		}
		throw new IndexOutOfBoundsException("ID not found");
	}

	public boolean isEmpty(Location loc) {
		if(loc.getX() > minLoc.getX() && loc.getY() > minLoc.getY() && loc.getX() < maxLoc.getX() && loc.getY()<maxLoc.getY() && grid[loc.getX()][loc.getY()] == null) {
			return true;
		}
		return false;
	}

	public Location getMinLoc() {
		return minLoc;
	}

	public Location getMaxLoc() {
		return maxLoc;
	}

	public String toString() {
		String out = "";
		for(Character[] cc: grid) {
			for(Character c : cc) {
				out += c.toString() + ", ";
			}
			out = out.substring(0,out.length()-2);
			out += "\n";
		}
		return out;
	}
}

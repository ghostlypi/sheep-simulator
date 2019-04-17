import java.util.Scanner;

public class GameTextClient {
	private World world;
	private int maxAni;
	private int numAni;

	public GameTextClient() {
		world = new World();
		maxAni = world.size/2;
		numAni = 0;
	}

	public Character[] checkAnimals() {
		numAni = world.numAni;
		if (numAni > maxAni) {
			Character[] carr = new Character[numAni-maxAni];
			if(numAni > maxAni)	{
				for(int i = 0; i < numAni-maxAni; i++) {
					carr[i] = world.die(world.getAniLocs()[i]);
				}
			}
			return carr;
		}
		return null;
	}

	public boolean canMove(Location loc) {
		Environment e = world.getAnimals();
		return e.isEmpty(loc);
	}

	public void populate() {
		for(int i = 0; i < maxAni; i++) {
			if (i % 5 == 0)
				world.addAnimal(Animal.WOLF);
			else
				world.addAnimal(Animal.SHEEP);
		}
	}

	public void act() {
		Location [] locs = world.getAniLocs();
		Environment e = world.getAnimals();
		for(int i = 0; i < locs.length; i++) {
			Animal a = (Animal) e.getCharacter(locs[i]);
			Location l = a.move(1,Direction.randDir());
			if (canMove(l))
				world.moveAnimal(locs[i], l);
		}
		predeat();
		herbeat();
		world.restore();
	}

	public void predeat() {
		Location [] locs = world.getAniLocs();
		Environment e = world.getAnimals();
		for(int i = 0; i < locs.length; i++) {
			Animal a = (Animal) e.getCharacter(locs[i]);
			if(a != null && a.getType() == Animal.WOLF) {
				world.eat(a.getLoc());
			}
		}
	}

	public void herbeat() {
		Location [] locs = world.getAniLocs();
		Environment e = world.getAnimals();
		for(int i = 0; i < locs.length; i++) {
			Animal a = (Animal) e.getCharacter(locs[i]);
			if(a != null && a.getType() == Animal.SHEEP) {
				world.desertify(a.getLoc());
			}
		}
	}

	public void automatedActions() {
		world.addAnimal(Animal.SHEEP);
		world.update();
		checkAnimals();
		world.update();
		act();
	}

	public void playerActions() {
		world.update();
		addFence();
	}

	public void actionsMannager() {
		automatedActions();
		playerActions();
	}

	public void initRandPos() {
		int end = (int) (Math.random()*1000);
		for(int i = 0; i < end; i++)
			automatedActions();
	}

	public void addFence() {
		Scanner sc = new Scanner(System.in);
		System.out.println(this);
		System.out.println("Enter x position:");
	    int x = sc.nextInt();
	    System.out.println("Enter y position:");
	    int y = sc.nextInt();
	    if(x > 0 && y > 0)
	    	world.addFence(new Location(x-1,y-1));
			else if(x < 0 && y < 0){
				x = x*-1-1;
				y = y*-1-1;
				world.rmFence(new Location(x,y));
			}else if((x == -1 && y == 1) || (x == -1 && y == 1)){
				System.out.println("Ending Game ...");
				System.exit(0);
			}else
				return;
	}

	public String toString() {
		return world.toString();
	}

	public static void main(String[] args) {
		GameTextClient g = new GameTextClient();
		g.populate();
		g.initRandPos();
		System.out.println("To exit, enter -1 and 1");
		System.out.println(g);
		while(true) {
			g.actionsMannager();
			System.out.println(g);
		}
	}



}

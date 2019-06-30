package game;

public class SnakePart {
	public int x;
	public int y;
	public SnakePart nextPart;
	
	public SnakePart(int x, int y, SnakePart nextPart) {
		this.x = x;
		this.y = y;
		this.nextPart = nextPart;
	}
	
	public SnakePart(int x, int y) {
		this(x,y,null);
	}
	
	@Override
	public boolean equals(Object o) {
		if(!(o instanceof SnakePart)) {
			return false;
		}
		
		SnakePart snakePart = (SnakePart) o;
		
		return snakePart.x == x && snakePart.y == y;
	}
}

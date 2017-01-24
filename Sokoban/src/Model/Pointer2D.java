package Model;

public class Pointer2D {
	private int x;
	private int y;
	
	public Pointer2D(int x,int y) {
		this.x=x;
		this.y=y;	
	}
	public Pointer2D(Pointer2D p) {
		this.x=p.x;
		this.y=p.y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
	public void setPoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

}

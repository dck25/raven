package raven.math;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("Obstacle")
public class Obstacle extends Wall2D {

	public Boolean active;
	
	public Obstacle() {
		this.active = true;
	}
	
	public boolean isObstacle(){
		return true;
	}

	public Obstacle(Vector2D a, Vector2D b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}

	public Obstacle(Vector2D a, Vector2D b, Vector2D n) {
		super(a, b, n);
		// TODO Auto-generated constructor stub
	}

}
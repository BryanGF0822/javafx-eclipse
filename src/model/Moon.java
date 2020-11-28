package model;

public class Moon {
	
	public static final int STEP_MOVE = 1;
	private double x;
	private double r;
	private double max;
	
	public Moon(double xx, double rr) {
		x = xx;
		r = rr;
	}
	
	public double getX() {
		return x;
	}
	
	public void setMax(double mx) {
		max = mx;
	}
	
	public double getMax() {
		return max;
	}
	
	
	public void move1(boolean dr) {
		if(dr) {
			x += STEP_MOVE;
			if(x > max + r) {
				x = 0 - r;
			}
		} else {
			x -= STEP_MOVE;
			if(x < 0 - r) {
				x = max + r;
			}
		}
	}
	
}

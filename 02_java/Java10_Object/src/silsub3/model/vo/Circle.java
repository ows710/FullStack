package silsub3.model.vo;

public class Circle {
	public double PI = 3.14;
	private int radius;
	
	public Circle() {}

	public double getPI() {
		return PI;
	}

	public void setPI(double pI) {
		PI = pI;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void incrementRadius() {
		this.radius += 1;
		System.out.println("원의 둘레 : "+(2*PI*radius)+", 원의 넓이 : "+(PI*radius*radius));
	}
}

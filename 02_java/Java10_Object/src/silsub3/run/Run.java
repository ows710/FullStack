package silsub3.run;

import silsub3.model.vo.Circle;

public class Run {

	public static void main(String[] args) {
		Circle c = new Circle();
		System.out.println("원의 둘레 : "+(2*c.getPI()*c.getRadius())+", 원의 넓이 : "+(c.getPI()*c.getRadius()*c.getRadius()));

		c.incrementRadius();
	}

}

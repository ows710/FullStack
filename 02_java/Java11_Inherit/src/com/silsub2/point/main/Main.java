package com.silsub2.point.main;

import com.silsub2.point.model.vo.Circle;
import com.silsub2.point.model.vo.Rectangle;

public class Main {

	public static void main(String[] args) {
		Circle cir1 = new Circle(1,2,2);
		Circle cir2 = new Circle(2,1,3);
		Circle cir3 = new Circle(2,2,4);
		
		Rectangle rec1 = new Rectangle(1,2,1,2);
		Rectangle rec2 = new Rectangle(2,1,2,3);
		Rectangle rec3 = new Rectangle(2,2,3,4);
		
		cir1.draw();
		cir2.draw();
		cir3.draw();
		
		rec1.draw();
		rec2.draw();
		rec3.draw();

	}

}

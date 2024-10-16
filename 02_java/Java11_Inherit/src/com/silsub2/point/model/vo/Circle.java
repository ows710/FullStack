package com.silsub2.point.model.vo;

public class Circle extends Point {
	private int radius;
	
	public Circle() {}

	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}
	
	@Override
	public void draw() {
		super.draw();
		System.out.printf("원 면적 : %.1f, 원 둘레 : %.1f\n", (Math.PI * this.radius * this.radius), (2 * Math.PI * this.radius));
	}
	
	
}

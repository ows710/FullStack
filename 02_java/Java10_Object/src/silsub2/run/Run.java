package silsub2.run;

import silsub2.model.vo.Product;

public class Run {
	public static void main(String[] args) {
		Product p = new Product();
		p.setpName(null);
		p.setPrice(0);
		p.setBrand(null);
		
		System.out.println(p.information());
	}

}

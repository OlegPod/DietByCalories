import java.io.IOException;
import java.util.*;
import java.util.regex.*;
public class Container {
	
	private class Product {
		Product(String name, float carbs, float fats, float protein) {
			this.name = name;
			this.carbs = carbs;
			this.fats = fats;
			this.protein = protein;
		}
		final String name;
		final float carbs;
		final float fats;
		final float protein;
		
		public String toString() {
			return this.name + " " + this.carbs + " " + this.fats + " " + this.protein;
		}
	}
	LinkedList<Product> richInCarbs = new LinkedList<Product>();
	LinkedList<Product> richInFats = new LinkedList<Product>();
	LinkedList<Product> richInProtein = new LinkedList<Product>();
	LinkedList<Product> other = new LinkedList<Product>();
	
	private void sort() throws IOException {
		Matcher nameMatcher = Pattern.compile("([A-Z][a-z]+\\s*)+").matcher("");
		Matcher nutrientMatcher = Pattern.compile("\\d+\\.?\\d+").matcher("");
		String holdName = null;
		float holdCarbs = 0;
		float holdFats = 0;
		float holdProtein = 0;
		int count = 0;
		
		for(String line : Reader.read("src//Products.txt")) {
			nameMatcher.reset(line);
			nutrientMatcher.reset(line);
			while(nameMatcher.find()) {
			holdName = nameMatcher.group();
			}
			
			while(nutrientMatcher.find()) {
				count++;
				switch(count) {
				case 1: holdCarbs = Float.parseFloat(nutrientMatcher.group());
				case 2: holdFats = Float.parseFloat(nutrientMatcher.group());
				case 3: holdProtein = Float.parseFloat(nutrientMatcher.group());
				default : break;
				}
				if(count == 3) {
					count = 0;
					if(holdCarbs > 80)
						richInCarbs.add(new Product(holdName, holdCarbs, holdFats, holdProtein));
					else if(holdFats > 80)
						richInFats.add(new Product(holdName, holdCarbs, holdFats, holdProtein));
					else if(holdProtein > 80)
						richInProtein.add(new Product(holdName, holdCarbs, holdFats, holdProtein));
					else
						other.add(new Product(holdName, holdCarbs, holdFats, holdProtein));
					
				}
					
			}
		}
	}
	public static void main(String[] args) throws IOException {
		Container c = new Container();
		c.sort();
		System.out.println("carbs-------------");
		for(Product p : c.richInCarbs)
			System.out.println(p);
		System.out.println("fats-------------");
		for(Product p : c.richInFats)
			System.out.println(p);
		System.out.println("protein-------------");
		for(Product p : c.richInProtein)
			System.out.println(p);
		System.out.println("other-------------");
		for(Product p : c.other)
			System.out.println(p);
	}

}

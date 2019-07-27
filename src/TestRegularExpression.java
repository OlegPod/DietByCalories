
import java.util.regex.*;


public class TestRegularExpression {
	
	static String[] input = {"White Rice Longgrain: carbs:332, fats:5.5, protein:27.2", "([A-Z][a-z]+\\s*)+", "\\d+\\.?\\d+"};

	public static void main(String[] args) {
	Test.main(input);

	}

}
class Test {
	public static void main(String[] args) {
		if(args.length < 2) {
			System.out.println("Usage: Test regular expression"+
					"\n charSequence + regularExpression+");
			System.exit(0);
		}
		System.out.println("Input string: \"" + args[0] + "\"");
		for(String arg : args) {
			System.out.println("Regular expression: \"" + arg + "\"");
			Matcher m = Pattern.compile(arg).matcher(args[0]);
			while(m.find()) {
				System.out.println("Matching \"" + m.group() + "\" at pisotions " +
									m.start() + "-" + (m.end() - 1));
				for(int i = 0; i < m.groupCount(); i++) {
					System.out.println("Matching group \"" + m.group(i) + "\"" + " at positions " 
										+ m.start(i) + "-" + (m.end(i) - 1));
				}
			}
		}

	}
}

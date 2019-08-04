package service;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sorter {

    public void sort() throws IOException {
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
                        richInCarbs.add(new Container.Product(holdName, holdCarbs, holdFats, holdProtein));
                    else if(holdFats > 80)
                        richInFats.add(new Container.Product(holdName, holdCarbs, holdFats, holdProtein));
                    else if(holdProtein > 80)
                        richInProtein.add(new Container.Product(holdName, holdCarbs, holdFats, holdProtein));
                    else
                        other.add(new Container.Product(holdName, holdCarbs, holdFats, holdProtein));

                }

            }
        }
    }

}

//Neal Logan
package netgen;

import java.util.ArrayList;

public class Filter {

    //Filters out everything but spaces, letters
    //Trims and converts letters to lower-case
    public static String removeNonpermittedCharacters(String input) {
        return input.replaceAll("[^a-zA-Z ]", " ").toLowerCase().trim();
    }

    //Filters out everything but spaces, letters
    //Trims and converts to lower-case
    public static ArrayList<String> removeNonpermittedCharacters(ArrayList<String> input) {
        ArrayList<String> output = new ArrayList<>();
        for (String line : input) {
            output.add(Filter.removeNonpermittedCharacters(line));
        }
        return output;
    }
    
    
    
    
}

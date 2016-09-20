//Neal Logan
package netgen;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Neal
 */
public class IO {
    
    //Reads a file & returns each line in the file as a string
    public static String readFileAsString(String fileName) {
        return concatenateAll(readFileAsLines(fileName));
    }
    
    //Reads a file and returns its lines in an arraylist
    public static ArrayList<String> readFileAsLines(String fileName) {
        ArrayList<String> lines = new ArrayList<>();
        Scanner inFile = null;

        try {
            System.out.println(new File("").getAbsolutePath());
            System.out.println(fileName);
            inFile = new Scanner(new FileReader(fileName));
        } catch (Exception e) {
            System.out.println("Failed to open input file. Exiting.");
            System.exit(-1);
        }

        while (inFile.hasNextLine()) {
            lines.add(inFile.nextLine());
        }
        return lines;
    }
    
    //Combines the lines of the lines of the arraylist into a single String, separated by newline characters
    //TODO: throw exception if too many chars in strings?
    //Must have a total of less than about 2^30 characters
    public static String concatenateAll(ArrayList<String> lines) {
        String condensed = "";
        for (String line : lines) {
            condensed += ("\n" + line);
        }
        return condensed;
    }

    //Takes the lines of a .dl file and returns a weighted edgelist
    public static HashMap<SemanticPair, Double> importWeightedEdgelist(ArrayList<String> input) {
        
        HashMap<SemanticPair, Double> edges = new HashMap<>();
        
        for(int i = 4; i < input.size(); i++) {
            String[] line = input.get(i).split("\\s");
            edges.put(new SemanticPair(line[0], line[1]), Double.parseDouble(line[2]));
        }
        return edges;
    }
    
}

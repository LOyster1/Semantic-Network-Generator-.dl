//Neal Logan
package netgen;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Main {

    
    public static void textToWeightedEdgelist(String inputFileName, String outputFileName, int windowSize) {
        
        //Read input file
        String text = IO.readFileAsString(inputFileName);
        
        //Clean text
        String cleanText = Filter.removeNonpermittedCharacters(text);
        
        //Tokenize
        ArrayList<String> tokens = Tokenizer.split(cleanText, "\\s+");
        
        //Generate network
        Network network = Network.generateNetworkBySlidingWindow(tokens, windowSize);
        
        //Write network to .dl output file
        network.writeEdgelist(outputFileName);
    }
    
    
    
    
    public static void main(String[] args) {
        
        
    	String test= "dog321gy20991230.csv";
    	//Grabs date from String in YYYYMMDD format
    	String fileDate="^[a-zA-Z0-9*]+((([0-1][0-9]{3})|([2][0][0-9]{2}))(([0][1-9])|([1][0-2]))(([0][1-9])|([1-2][0-9])|([3][0-1]))+).*";
    	Pattern p=Pattern.compile(fileDate);
    	Matcher m = p.matcher(test);
    	

    	if (m.find()) {
    	    System.out.println(m.group(1));
    	}
    	else
    	{
    		System.out.println("invalid date");
    	}
    	
    	for(int i=0; i<args.length;i++)
    	{
    		String input=args[i];
    		String[] tokens = input.split("\\.(?=[^\\.]+$)");///Eliminate input extension for use in output name.
    		String output=tokens[0];
    		//Input file name & suffix, output file name, window size
    		Main.textToWeightedEdgelist(input, output, 3);
    		
    	}
    	//Main.textToWeightedEdgelist("src/input.txt", "output", 3);
        
    }
    
}

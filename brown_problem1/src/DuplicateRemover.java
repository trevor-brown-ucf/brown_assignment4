import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.Set;
import java.util.LinkedHashSet;

public class DuplicateRemover {								// "Problem 1 shall contain a public class called DuplicateRemover"
	Set<String> uniqueWords;
    void remove(String dataFile) {							// "DuplicateRemover shall contain a method called remove"   	
        Scanner input=null;
        try {
            uniqueWords = new LinkedHashSet<>(); 			// "Given the path to a text file, the remove method shall determine the unique words contained in dataFIle and store those unique words in the associated DuplicateRemover object"
            input = new Scanner(new File(dataFile));
            System.out.println("Starting to read file and get unique words.");
            while(input.hasNextLine()) {
                String line=input.nextLine();
                String[] words=line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" "); // removing punctuation, converting to lowercase, then splitting
                for(int i=0; i<words.length; i++) {		
                    String str=words[i];				
                    uniqueWords.add(str);
                }
            }
            System.out.print("Unique words: ");
            for(String s:uniqueWords) {
            	System.out.printf("'%s' ", s);
            }
            System.out.println("\nDone getting uniqueWords.");
        }
        catch(Exception e) 	{								// "The remove method shall terminate the program and alert the user with a user-friendly message when an exceptional IO event occurs"       
            System.out.println("Error opening file "+dataFile);
            System.exit(0);
        }
        if(input!=null)										// "The remove method shall clean up any and all resources allocated during method execution"
            input.close();
    }
    
    void write(String outputFile){ 							// "DuplicateRemover shall contain a method called write"
    	System.out.println("Starting to write to " +outputFile);
        FileWriter output=null;
        try {
            output = new FileWriter(outputFile); 			// "Given the path to a text file, the write method shall print the current collection of unique words to outputFile"
            for(String s:uniqueWords)
                output.write(s+"\n");
            System.out.println("Done writing to outputFile, closing.");
            output.close();									// "The write method shall clean up any and all resources allocated during method execution"
        }
        catch(Exception e) {								// "The write method shall terminate the program and alert the user with a user-friendly message when an exceptional IO event occurs"
            System.out.println("Error writing to "+outputFile);
            System.exit(0);
        }
    }
}

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class DuplicateCounter {									// "Problem 2 shall contain a public class called DuplicateCounter"
	private Map<String, Integer> wordCounter;
 
	public DuplicateCounter(){
       wordCounter = new HashMap<String,Integer>();
	}
  
	public void count(String dataFile) { 						// "DuplicateCounter shall contain a method called count"
		Scanner input = null;
		try {													// "Given the path to a text file, the count method shall determine the number of occurrences of each word contained in dataFIle and store each unique word and its count in the associated DuplicateCounter object"
			System.out.println("Starting to read file and get unique words for counting.");
			input = new Scanner(new File(dataFile ));
			input.useDelimiter("([0-9]|[.,!?:;'\"-]|\\s)+");	// Trying a different method than the previous problem to extract words
			while(input.hasNext()) {
				String word = input.next().toLowerCase();
				Integer count = wordCounter.get(word);
				if(count == null)
					count = 1;
				else
					count = count + 1;
				wordCounter.put(word, count);
			}
			System.out.print("Unique words: ");
			for(String s:wordCounter.keySet()) {
				System.out.printf("'%s' ", s);
			}
			System.out.println("\nGot and counted unique words.");
		} 
		catch (Exception e) {									// "The count method shall terminate the program and alert the user when an exceptional IO event occurs"
			System.out.println("Error opening file "+dataFile);
			System.exit(0);
		}      
		if(input!=null)											// "The count method shall clean up any and all resources allocated during method execution"
			input.close();
	}
  
	void write(String outputFile){								// "DuplicateCounter shall contain a method called write"
		System.out.println("Starting to write to " +outputFile);
		FileWriter output=null;
		try {
			output = new FileWriter(outputFile);				// "Given the path to a text file, the write method shall print the current collection of unique words and their counts to outputFile"
			for(String s:wordCounter.keySet())
				output.write(s + "\t" + wordCounter.get(s) + "\n");
			System.out.println("Done writing to outputFile, closing.");
			output.close(); 									// "The write method shall clean up any and all resources allocated during method execution"
		} 
		catch(Exception e) { 									// "The write method shall terminate the program and alert the user when an exceptional IO event occurs"
			System.out.println("Error writing to "+outputFile);
			System.exit(0);
		}
	}
}

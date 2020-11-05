package movies.importer;

import java.util.ArrayList;

/**
 * An extension of the abstract class Processor that imports and normalizes
 * the movie data that was created during the import.
 * @author Trevor McCubbin
 */
public class ValidatorKaggle extends Processor{
	
	/** 
	 * Constructor method to create a new Kaggle Normalizer
	 * @param source A String representing the source directory
	 * @param destination A String representing the destination directory
	 */
	public ValidatorKaggle(String src, String dest) {
		super(src, dest, false);
	}
	
	/**
	 * Method that processed the imported file from its raw form into it's reduced form
	 * @param input An ArrayList<String> representing the input from the reduced kaggle file
	 * @return Returns an ArrayList<String> of the normalized form of the kaggle file 
	 */
	public ArrayList<String> process(ArrayList<String> input) {
		ArrayList<String> normalized = new ArrayList<String>();
		for (int i = 0; i < input.size(); i++) {
			try {
				String[] column = input.get(i).split("\t");
				// splits the runtime column by spaces into a String array
				String[] runtime = column[2].split("\\s+");
				// release Year / title / runtime / source
				String entry = column[0] + "\t" + column[1].toLowerCase() + "\t" + runtime[0] + "\t" + "kaggle";
				normalized.add(entry);
			}
			catch(ArrayIndexOutOfBoundsException e) {
				System.out.println("Something broke and you now have an array out of bounds exception");
			}
		}
		return normalized;
	}
}
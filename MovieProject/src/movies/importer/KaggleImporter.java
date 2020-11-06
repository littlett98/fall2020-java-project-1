package movies.importer;

import java.util.*;
/**
 * An extension of the abstract class Processor that imports and formats the kaggle file.
 * @author Trevor McCubbin
 */
public class KaggleImporter extends Processor {
	
	/** Constructor method to create a new KaggleImporter
	 * @param source A String representing the source directory
	 * @param destination A String representing the destination directory
	 */
	public KaggleImporter(String source, String destination) {
		super(source, destination, true);
	}
	
	/**
	 * Method that processed the imported file from its raw form into it's reduced form
	 * @param kaggle An ArrayList<String> representing the input from the kaggle file
	 * @return Returns an ArrayList<String> of the reduced form of the kaggle file 
	 */
	public ArrayList<String> process(ArrayList<String> kaggle) {
		ArrayList<String> newList = new ArrayList<String>();
		for (int i = 0; i < kaggle.size(); i++) {
			String[] column = kaggle.get(i).split("\t");
			if (!(column.length < 19)) {
				// release Year / title / runtime / source
				String entry = column[20] + "\t" + column[15] + "\t" + column[13] + "\t" + "kaggle";
				newList.add(entry);
			}
		}
	return newList;
	}
}
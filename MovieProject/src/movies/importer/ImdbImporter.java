/**
 * This class has been written by
 * @author Jessie Rambeloson
 */

package movies.importer;

import java.util.ArrayList;

public class ImdbImporter extends Processor{
	
	/**
	 * @param src represents the source folder
	 * @param dest represents the output folder
	 */
	public ImdbImporter(String src, String dest) {
		super(src, dest, true);
	}
	
	/**
	 * a method that will format IdbmsSmallFile.txt with a Movie format
	 * @input input is an ArrayList containing the file's original lines
	 * @return will return an ArrayList containing the original lines with
	 * Movie formatting
	 */
	public ArrayList<String> process(ArrayList<String> input){
		ArrayList<String> processed = new ArrayList<String>();
		
		for (int i = 0; i < input.size(); i++) {
			String[] info = input.get(i).split("\t");
			if (info.length == 22) {
				//Format: releaseDate, title, runTime and source
				Movie movie = new Movie(info[3], info[1], info[6], "imdb");
				processed.add(movie.toString());
			}
		}
		return processed;
	}
}

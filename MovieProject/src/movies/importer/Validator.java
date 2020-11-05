/**
 * This class has been written by
 * @author Jessie Rambeloson
 */

package movies.importer;

import java.util.ArrayList;

public class Validator extends Processor{
	
	/**
	 * @param src represents the source folder
	 * @param dest represents the output folder
	 */
	public Validator(String src, String dest) {
		super(src, dest, false);
	}
	
	/**
	 * method that will remove any movies containing empty fields
	 * @input input an ArrayList representing movies processed through
	 * ImdbImporter
	 * @return returns an ArrayList with movies containing all fields
	 */
	public ArrayList<String> process(ArrayList<String> input){
		
		ArrayList<String> noInvalidMovies = new ArrayList<String>();
		
		for (int i = 0; i < input.size(); i++) {
			noInvalidMovies.add(input.get(i));
			String[] movie = noInvalidMovies.get(i).split("\t");
			for (int j = 0; j < movie.length - 1; j++) {
				if (movie[j].isEmpty()) {
					noInvalidMovies.remove(i);
				}
			}
		}
		
		/*throws a NumberFormatException if the release year/runtime
		 *cannot be converted to in
		*/
		try {
			int release;
			int runtime;
			for (int i = 0; i < noInvalidMovies.size(); i++) {
				String[] movie = noInvalidMovies.get(i).split("\t");
				release = Integer.parseInt(movie[0]);
				runtime = Integer.parseInt(movie[2]);
			}
		}
		catch (NumberFormatException e){
			System.out.println("The release year or the runtime could not be converted to a number.");
		}
		return noInvalidMovies;
	}
}

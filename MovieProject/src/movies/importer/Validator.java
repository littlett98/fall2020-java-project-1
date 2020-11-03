package movies.importer;

import java.util.ArrayList;

public class Validator extends Processor{
	
	public Validator(String src, String dest) {
		super(src, dest, false);
	}
	
	public ArrayList<String> processC3P0(ArrayList<String> input) {
		ArrayList<String> normalized = new ArrayList<String>();
		for (int i = 0; i < input.size(); i++) {
			String[] column = input.get(i).split("\\t");
			String[] runtime = column[3].split("\\s+");
				// release Year / title / runtime / source
				String entry = column[1] + "\\t" + column[2].toLowerCase() + "\\t" + runtime[0] + "\\t" + "kaggle";
				normalized.add(entry);
		}
		return normalized;
	}
	
	public ArrayList<String> process(ArrayList<String> input){
		
		ArrayList<String> noInvalidMovies = new ArrayList<String>();
		
		for (int i = 0; i < input.size(); i++) {
			noInvalidMovies.add(input.get(i));
			String[] movie = noInvalidMovies.get(i).split("\t");
			for (int j = 0; j < movie.length; j++) {
				if (movie[j] == "") {
					noInvalidMovies.remove(i);
				}
			}
		}
		
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

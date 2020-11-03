package movies.importer;

import java.util.ArrayList;

public class Validator extends Processor{
	
	public Validator(String src, String dest) {
		super(src, dest, false);
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

package movies.importer;

import java.util.ArrayList;

public class Deduper extends Processor{
	
	public Deduper(String src, String dest) {
		super(src, dest, false);
	}
	
	public ArrayList<String> process(ArrayList<String> input){
		
		ArrayList<String> noDuplicates = new ArrayList<String>();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		ArrayList<Movie> mergedMovies = new ArrayList<Movie>();
		
		//Creates an ArrayList of movies from the input to find duplicates
		for (int i = 0; i < input.size(); i++) {
			String[] line = input.get(i).split("\t");
			Movie m = new Movie(line[3], line[1], line[6], "src");
			movies.add(m);
		}
		
		//Find duplicated movies
		for (int i = 0; i < movies.size(); i++) {
			for (int j = i + 1; j < movies.size(); j++) {
				if (movies.get(i).equals(movies.get(j))) {
					String release = movies.get(i).getReleaseYear();
					String title = movies.get(i).getName();
					String runtime = movies.get(i).getRuntime();
					String src;
					if (movies.get(i).getSource().equals(movies.get(j).getSource())) {
						src = movies.get(i).getSource();
					}
					else {
						src = movies.get(i).getSource() + ";" + movies.get(j).getSource();
					}
					Movie merge = new Movie(release, title, runtime, src);
					if (!(mergedMovies.contains(merge))) {
						mergedMovies.add(merge);
					}
				}
			}
		}
		
		return noDuplicates;
	}
}

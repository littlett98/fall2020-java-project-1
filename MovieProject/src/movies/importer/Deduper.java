package movies.importer;

import java.util.ArrayList;

public class Deduper extends Processor{
	
	/** Constructor method to create a new Deduper
	 * @param src A String representing the source directory
	 * @param dest A String representing the destination directory
	 * @author Jessie Rambeloson
	 */
	public Deduper(String src, String dest) {
		super(src, dest, false);
	}
	
	/**
	 * This method compares values within the input array to find any duplicates within them and remove the duplicates.
	 * @input contains the files' lines in the correct movie format
	 * @return will return the input without duplicates
	 * @author Jessie Rambeloson
	 * @author Trevor McCubbin
	 * Was written mostly by Jessie. Trevor made a few edits.
	 */
	public ArrayList<String> process(ArrayList<String> input){
		
		//ArrayList<String> noDuplicates = new ArrayList<String>();
		ArrayList<Movie> movies = new ArrayList<Movie>();
		
		//Creates an ArrayList of movies from the input to find duplicates
		for (int i = 0; i < input.size(); i++) {
			String[] line = input.get(i).split("\t");
			Movie m = new Movie(line[0], line[1], line[2], line[3]);
			movies.add(m);
		}
		
		//Find duplicated movies
		for (int i = 0; i < movies.size(); i++) {
			if (i<input.size()) {
			for (int j = i + 1; j < movies.size()-1; j++) {
				if (j < input.size()) {
				//create a merged movie when duplicated movie is found
				if (movies.get(i).equals(movies.get(j))) {
					String release = movies.get(i).getReleaseYear();
					String title = movies.get(i).getName();
					String runtime = movies.get(j).getRuntime();
					String src;
					
					//if the sources are similar, keep the source once
					//if not, combine the sources
					if (movies.get(i).getSource().equals(movies.get(j).getSource())) {
						src = movies.get(i).getSource();
					}
					else {
						src = movies.get(i).getSource() + ";" + movies.get(j).getSource();
					}
					
					Movie merge = new Movie(release, title, runtime, src);
					input.remove(j);		//remove duplicate from the input ArrayList
					
					String[] inputMovie = input.get(i).split("\t");
					inputMovie[2] = merge.getRuntime();
					inputMovie[3] = merge.getSource();
					
					String newMovie = inputMovie[0];
					for (int a = 1; a < inputMovie.length; a++) {
						newMovie += "\t" + inputMovie[a];
					}
					input.set(i, newMovie);		//replace duplicated movie with merged movie
				}}}
			}
		}
		return input;
	}
}

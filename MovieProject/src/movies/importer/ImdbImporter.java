package movies.importer;

import java.util.ArrayList;

public class ImdbImporter extends Processor{
	
	public ImdbImporter(String src, String dest) {
		super(src, dest, true);
	}
	
	public ArrayList<String> process(ArrayList<String> input){
		ArrayList<String> processed = new ArrayList<String>();
		
		for (int i = 0; i < input.size(); i++) {
			String[] info = input.get(i).split("\t");
			if (info.length == 22) {
				Movie movie = new Movie(info[3], info[1], info[6], "imdb");
				processed.add(movie.toString());
			}
		}
		return processed;
	}
}

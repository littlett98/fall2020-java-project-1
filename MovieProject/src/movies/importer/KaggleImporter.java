package movies.importer;

import java.util.*;

public class KaggleImporter extends Processor {

	public KaggleImporter(String source, String destination) {
		super(source, destination, true);
	}
	
	public ArrayList<String> process(ArrayList<String> kaggle) {
		ArrayList<String> newList = new ArrayList<String>();
		for (int i = 0; i < kaggle.size(); i++) {
			String[] line = kaggle.get(i).split("\\t");
			if (!(line.length < 16)) {
				String entry = line[12] + "\\t" + line[15] + "\\t" + line[13] + "\\t" + "kaggle";
				newList.add(entry);
			}
		}
		return newList;
	}
	
}
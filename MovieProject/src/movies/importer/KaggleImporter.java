package movies.importer;

import java.util.*;

public class KaggleImporter extends Processor {

	public KaggleImporter(String source, String destination) {
		super(source, destination, true);
	}
	
	public ArrayList<String> process(ArrayList<String> kaggle) {
		ArrayList<String> newList = new ArrayList<String>();
		for (int i = 0; i < kaggle.size(); i++) {
			String[] column = kaggle.get(i).split("\\t");
			if (!(column.length < 16)) {
				// release Year / title / runtime / source
				String entry = column[12] + "\\t" + column[15] + "\\t" + column[13] + "\\t" + "kaggle";
				newList.add(entry);
			}
		}
		return newList;
	}
	
}
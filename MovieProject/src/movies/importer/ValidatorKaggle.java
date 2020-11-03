package movies.importer;

import java.util.ArrayList;

public class ValidatorKaggle extends Processor{
	
	public ValidatorKaggle(String src, String dest) {
		super(src, dest, false);
	}
	
	public ArrayList<String> process(ArrayList<String> input) {
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
}
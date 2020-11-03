package movies.importer;

import java.io.IOException;

public class ImportPipeline {
	
	public static void main(String[] args) {
		Processor[] processorArray = new Processor[5];
		processorArray[0] = (Processor) new KaggleImporter("src", "output");
		processorArray[1] = (Processor) new ImdbImporter("src", "output");
		processorArray[2] = (Processor) new ValidatorKaggle("src", "output");
		processorArray[3] = (Processor) new ValidatorImdb("src", "output");
		processorArray[4] = (Processor) new Deduper("src", "output");
	}
	
	public static void processAll(Processor[] processorArray) throws IOException {
		for (int i = 0; i < processorArray.length; i++) {
			processorArray[i].execute();
		}
	}
	
}

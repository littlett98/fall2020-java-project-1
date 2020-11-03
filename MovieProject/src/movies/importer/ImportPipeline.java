package movies.importer;

import java.io.IOException;

public class ImportPipeline {
	
	public static void main(String[] args) {
		KaggleImporter Kaggle = new KaggleImporter("source", "output");
		ImdbImporter Imdb = new ImdbImporter("source","output");
		Processor[] processorArray = new Processor[] {
		    	//load feeds of both files
		        new Processor() { public void execute() throws IOException { Kaggle.execute(); } },
		        new Processor() { public void execute() throws IOException { Imdb.execute(); } },
		        //normalize the files
		        new Processor() { public void execute() throws IOException { goSouth(); } },
		        // validate the files
		        new Processor() { public void execute() throws IOException { goEast(); } },
		        // dedupe the files
		        new Processor() { public void execute() throws IOException { goWest(); } },
		    };
	}
	
	public static void processAll(Processor[] processorArray) throws IOException {
		for (int i = 0; i < processorArray.length; i++) {
			execute(processorArray, i);
		}
	}
	
	static interface Processor {
        void execute() throws IOException;
    }
	
	public static void execute(Processor[] processorArray, int index) throws IOException {
        processorArray[index].execute();
    }
	
}

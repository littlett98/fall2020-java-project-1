package movies.importer;

import java.io.IOException;

public class ImportPipeline {

	/**
	 * Main method for the project.
	 * Creates all the sources for the files to process and all the objects needed for processing.
	 * @param args
	 * @throws IOException
	 * @author Jessie Rambeloson
	 * @author Trevor McCubbin
	 */
	public static void main(String[] args) throws IOException{
		
		//Folder that will contain ImdbSmallFile.txt only
		String imdb_source = "C:\\Users\\mccub\\Documents\\420-310 (Java 3)\\java-project-1\\MovieProject\\files\\imdb_file";
		//Folder that will contain KaggleSmallFile.txt only
		String kaggle_source = "C:\\Users\\mccub\\Documents\\420-310 (Java 3)\\java-project-1\\MovieProject\\files\\kaggle_file";
		//Folder that will contain processed txt files & preparing to be validated
		String processed = "C:\\Users\\mccub\\Documents\\420-310 (Java 3)\\java-project-1\\MovieProject\\files\\processed_files";
		//Folder that will contain both files combined without duplicates and empty fields
		String normalized = "C:\\Users\\mccub\\Documents\\420-310 (Java 3)\\java-project-1\\MovieProject\\files\\normalized_file";
		//Folder that will contain validated files and will combine them before going through deduper
		String validated = "C:\\Users\\mccub\\Documents\\420-310 (Java 3)\\java-project-1\\MovieProject\\files\\validated_files";
		//Folder that will contain both files combined without duplicates and empty fields
		String deduped = "C:\\Users\\mccub\\Documents\\420-310 (Java 3)\\java-project-1\\MovieProject\\files\\final_file";
		
		//Creating all the necessary processors
		ImdbImporter imdb = new ImdbImporter(imdb_source, processed);
		KaggleImporter kaggle = new KaggleImporter(kaggle_source, processed);
		ValidatorKaggle normalizer= new ValidatorKaggle(processed, normalized);
		Validator validator = new Validator(normalized, validated);
		Deduper deduper = new Deduper(validated, deduped);
		
		/*
		 * Store all the processors into an array in the order of execution
		 * ImdbImporter will first process its imdb file and will validate it immediately
		 * before sending it to dest2 to wait for deduper
		 * KaggleImporter will do the same thing after Imdb is done processing
		 * will join imdb in dest2 to be combined
		 * Deduper will remove any duplicates
		 */
		Processor[] processors = {imdb, kaggle, normalizer,  validator, deduper};
		processAll(processors);
	}
	
	/**
	 * This method runs through the process method in each class in the correct order 
	 * @param processors An array of processors representing the methods needed to be executed
	 * @throws IOException
	 * @author Jessie Rambeloson
	 */
	public static void processAll(Processor[] processors) throws IOException{
		for (int i = 0; i < processors.length; i++) {
			processors[i].execute();
		}
	}
}

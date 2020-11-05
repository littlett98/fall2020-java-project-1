package movies.importer;

import java.io.IOException;

public class ImportPipeline {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException{
		
		//Folder that will contain ImdbSmallFile.txt only
		String imdb_source = "C:\\Users\\Jessie\\Documents\\Dawson\\Computer Science\\java310\\Project 1\\java-project-1\\MovieProject\\files\\imdb_file";
		//Folder that will contain KaggleSmallFile.txt only
		String kaggle_source = "C:\\Users\\Jessie\\Documents\\Dawson\\Computer Science\\java310\\Project 1\\java-project-1\\MovieProject\\files\\kaggle_file";
		//Folder that will contain processed txt files & preparing to be validated
		String processed = "C:\\Users\\Jessie\\Documents\\Dawson\\Computer Science\\java310\\Project 1\\java-project-1\\MovieProject\\files\\processed_files";
		//Folder that will contain validated files and will combine them before going through deduper
		String validated = "C:\\Users\\Jessie\\Documents\\Dawson\\Computer Science\\java310\\Project 1\\java-project-1\\MovieProject\\files\\validated_files";
		//Folder that will contain both files combined without duplicates and empty fields
		String deduped = "C:\\Users\\Jessie\\Documents\\Dawson\\Computer Science\\java310\\Project 1\\java-project-1\\MovieProject\\files\\final_file";
		
		//Creating all the necessary processors
		ImdbImporter imdb = new ImdbImporter(imdb_source, processed);
		Validator imdb_v = new Validator(processed, validated);
		KaggleImporter kaggle = new KaggleImporter(kaggle_source, processed);
		ValidatorKaggle kaggle_v = new ValidatorKaggle(processed, validated);
		Deduper deduper = new Deduper(validated, deduped);
		
		/*
		 * Store all the processors into an array in the order of execution
		 * ImdbImporter will first process its imdb file and will validate it immediately
		 * before sending it to dest2 to wait for deduper
		 * KaggleImporter will do the same thing after Imdb is done processing
		 * will join imdb in dest2 to be combined
		 * Deduper will remove any duplicates
		 */
		Processor[] processors = {imdb, imdb_v, kaggle, kaggle_v, deduper};
		processAll(processors);
	}
	
	/**
	 * @param processors
	 * @throws IOException
	 */
	public static void processAll(Processor[] processors) throws IOException{
		for (int i = 0; i < processors.length; i++) {
			processors[i].execute();
		}
	}
}

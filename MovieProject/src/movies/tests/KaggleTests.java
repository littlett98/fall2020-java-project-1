package movies.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import movies.importer.KaggleImporter;

class KaggleTests {

	@Test
	void testKaggleImporter() {
		KaggleImporter k = new KaggleImporter("../../../../KaggleSmallFile.txt", "../../../../output/");
		
		
	}

}

/**
 * This class has been written by
 * @author Jessie Rambeloson
 */
package movies.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import movies.importer.Validator;

class ValidatorTest {

	@Test
	void testProcess() {
		ArrayList<String> movies = new ArrayList<String>();
		String m1 = "1998\tMulan\t88\timdb";
		String m2 = "2001\tSpirited Away\t125\timdb";
		String m3 = "2010\t\t15\timdb";		//m3 should be removed after being validated
		movies.add(m1);
		movies.add(m2);
		movies.add(m3);
		
		Validator validate = new Validator("source", "destination");
		movies = validate.process(movies);
	}
	
	@Test
	void testNumbersProcess() {
		ArrayList<String> movies = new ArrayList<String>();
		String m1 = "1998\tMulan\t88\timdb";
		String m2 = "hello\tSpirited Away\t125\timdb";		//should throw a NumberFormatException
		String m3 = "2010\t\t15\timdb";
		movies.add(m1);
		movies.add(m2);
		movies.add(m3);
		
		Validator validate = new Validator("source", "destination");
		movies = validate.process(movies);
	}

}

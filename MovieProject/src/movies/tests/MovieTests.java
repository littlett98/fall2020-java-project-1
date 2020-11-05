package movies.tests;

import static org.junit.jupiter.api.Assertions.*;
import movies.importer.Movie;

import org.junit.jupiter.api.Test;

class MovieTests {

	/** Tests all the get methods within the Movie class
	 * @author Trevor McCubbin
	 * 
	 */
	@Test
	void testGetMethods() {
		Movie m = new Movie("1994", "The Lion King", "1h 58m", "The Internet");
		assertEquals("1994", m.getReleaseYear());
		assertEquals("The Lion King", m.getName());
		assertEquals("1h 58m", m.getRuntime());
		assertEquals("The Internet", m.getSource());
	}
	
	/** Tests that the toString method returns the desired String in the correct format
	 * @author Trevor McCubbin
	 * 
	 */
	@Test
	void testToStringMethod() {
		Movie m = new Movie("1994", "The Lion King", "1h 58m", "The Internet");
		assertEquals("1994	The Lion King	1h 58m	The Internet", m.toString());
	}

}

package movies.tests;

import static org.junit.jupiter.api.Assertions.*;
import movies.importer.Movie;

import org.junit.jupiter.api.Test;

/**
 * All tests related to the movie class
 * @author Trevor McCubbin
 *
 */
class MovieTests {

	/** Tests all the get methods within the Movie class
	 * 
	 */
	@Test
	void testGetMethods() {
		Movie m = new Movie("1994", "The Lion King", "158", "The Internet");
		assertEquals("1994", m.getReleaseYear());
		assertEquals("The Lion King", m.getName());
		assertEquals("158", m.getRuntime());
		assertEquals("The Internet", m.getSource());
	}
	
	/** Tests that the toString method returns the desired String in the correct format
	 * 
	 */
	@Test
	void testToStringMethod() {
		Movie m = new Movie("1994", "The Lion King", "158", "The Internet");
		assertEquals("1994	The Lion King	158	The Internet", m.toString());
	}
	
	/** Tests the equal method by seeing if it can identify the identical Lion Kings
	 * vs the new Lion King.
	 * 
	 */
	@Test
	void testEquals() {
		Movie m = new Movie("1994", "The Lion King", "158", "The Internet");
		Movie m2 = new Movie("1994", "The Lion King", "158", "The Internet");
		Movie m3 = new Movie("2019", "The Lion King", "118", "The Internet");
		assertEquals(true,m.equals(m2));
		assertEquals(false, m.equals(m3));
	}
	
	/** Tests the equal method casts an object into a movie
	 * 
	 */
	@Test
	void testEqualsCast() {
		Object m = new Object();
		assertEquals(true,m.equals(m));
	}

}
